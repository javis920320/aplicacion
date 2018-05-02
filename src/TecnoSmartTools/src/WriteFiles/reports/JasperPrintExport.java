package WriteFiles.reports;

import SQL.ExecuteSql;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import options.reportesCnaCicle2017.Report;

public class JasperPrintExport {

    public static String TYPE_XLS = "XLS";
    public static String TYPE_PDF = "PDF";

    public static void export(String pathReport, String fileName, String reportType, HashMap<String, Object> parameters) throws Exception {
        File fileReport = new File(pathReport + fileName);
        if (!fileReport.exists()) {
            throw new Exception("El archivo " + fileName + " NO existe en " + pathReport);
        }
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fileReport);
        JasperPrint printer = JasperFillManager.fillReport(jasperReport, parameters, ExecuteSql.getConnection());
        File file = File.createTempFile("tmp", "." + reportType.toLowerCase());
        try (OutputStream os = new FileOutputStream(file)) {
            if (reportType.equals(JasperPrintExport.TYPE_XLS)) {
                generateXLSOutput(printer, os);
            } else if (reportType.equals(JasperPrintExport.TYPE_PDF)) {
                generatePDFOutputProtected(printer, os);
            } else {
                generatePDFOutputProtected(printer, os);
            }
        }
        Desktop.getDesktop().open(file);
    }

    public static void export(String pathReport, String fileName, String nombreFinal, String pathFinal, String reportType, HashMap<String, Object> parameters) throws Exception {
        export(pathReport, fileName, nombreFinal, pathFinal, reportType, parameters, null);
    }

    public static void export(String pathReport, String fileName, String nombreFinal, String pathFinal, String reportType, HashMap<String, Object> parameters, Class cls) throws Exception {
        File fileReport = new File(pathReport + fileName);
        if (!fileReport.exists()) {
            throw new Exception("El archivo " + fileName + " NO existe en " + pathReport);
        }
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fileReport);
        JasperPrint printer;
        if (cls != null) {
            Report<?> classData = (Report<?>) cls.newInstance();
            List<?> lstData = classData.getAllDataFromList(parameters);
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstData);
            jasperReport = (JasperReport) JRLoader.loadObject(fileReport);
            try {
                printer = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            try {
                printer = JasperFillManager.fillReport(jasperReport, parameters, ExecuteSql.getConnection());
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }

        File filePdf = new File(pathFinal + nombreFinal + ".pdf");
        File fileXls = new File(pathFinal + nombreFinal + ".xls");
        try (OutputStream ospdf = new FileOutputStream(filePdf)) {
            generatePDFOutputProtected(printer, ospdf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (OutputStream osxls = new FileOutputStream(fileXls)) {
            generateXLSOutput(printer, osxls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ///////////
    }

    private static void generatePDFOutputProtected(JasperPrint jasperPrint, OutputStream os) throws Exception {
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(os));
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        configuration.set128BitKey(true);
        configuration.setEncrypted(false);
        configuration.setPermissions(2052);
        exporter.setConfiguration(configuration);
        exporter.exportReport();
    }

    private static void generateXLSOutput(JasperPrint jasperPrint, OutputStream os) throws Exception {
        SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
        configuration.setDetectCellType(true);
        configuration.setOnePagePerSheet(false);
        configuration.setRemoveEmptySpaceBetweenRows(true);
        configuration.setRemoveEmptySpaceBetweenColumns(true);
        configuration.setWhitePageBackground(true);
        configuration.setIgnoreGraphics(false);
        configuration.setCollapseRowSpan(true);
        configuration.setIgnoreCellBorder(true);
        configuration.setFontSizeFixEnabled(true);
        configuration.setMaxRowsPerSheet(0);

        configuration.setIgnoreCellBackground(true);
        configuration.setImageBorderFixEnabled(true);
        configuration.setWhitePageBackground(false);

        JRXlsExporter exporterXLS = new JRXlsExporter();
        exporterXLS.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporterXLS.setExporterOutput(new SimpleOutputStreamExporterOutput(os));
        exporterXLS.setConfiguration(configuration);
        exporterXLS.exportReport();
    }

//    public static void main(String[] args) {
//        try {
//
//            HashMap<String, Object> parameters = new HashMap<>();
//            parameters.put("FECHAINICIO", "01/01/2016");
//            parameters.put("CODZONPRO", "10");
//            JasperPrintExport.export("./src/jasper/", "rpt_inscritos.jasper", JasperPrintExport.TYPE_PDF, parameters);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
