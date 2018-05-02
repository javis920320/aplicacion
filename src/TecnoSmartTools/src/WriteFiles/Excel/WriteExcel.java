package WriteFiles.Excel;

import java.awt.Desktop;
import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class WriteExcel {

    public void write(String tmpFileName, List<SheetExcel> sheets) throws Exception {
        this.write(null, tmpFileName, sheets);
    }

    /**
     * Escribe un excel con n hojas dependiendo de la lista que se le envie.
     *
     * @param path
     * @param tmpFileName
     * @param sheets
     * @throws Exception
     */
    public void write(String path, String tmpFileName, List<SheetExcel> sheets) throws Exception {
        File file;
        if (path == null) {
            file = File.createTempFile(tmpFileName, ".xls");
        } else {
            file = new File(path);
        }

        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));
        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        for (int i = 0; i < sheets.size(); i++) {
            SheetExcel get = sheets.get(i);
            workbook.createSheet(get.sheetName, i);
            WritableSheet excelSheet = workbook.getSheet(i);
            for (int j = 0; j < get.tables.size(); j++) {
                TableExcel tbl = get.tables.get(j);
                boolean containSHeader = tbl.sHeader != null && tbl.sHeader.length > 0;
                int nextRow = 0;
                if (containSHeader && j == 0) {
                    nextRow = j;
                } else if (containSHeader && j != 0) {
                    nextRow = nextRow + 2;
                }
                if (j == 0) {
                    if (containSHeader) {
                        createSuperHeader(excelSheet, tbl.sHeader, null, nextRow);
                        nextRow++;
                    }
                    createHeaders(excelSheet, tbl.headers, nextRow);
                    writeData(excelSheet, tbl.headers, tbl.data, nextRow);
                } else {
                    for (int k = 0; k != j; k++) {
                        nextRow += (get.tables.get(k).sHeader != null && get.tables.get(k).sHeader.length > 0 ? 1 : 0);
                        nextRow += get.tables.get(k).data.length + 1;
                    }
                    if (containSHeader) {
                        createSuperHeader(excelSheet, tbl.sHeader, null, nextRow);
                        nextRow++;
                    }
                    createHeaders(excelSheet, tbl.headers, nextRow);
                    writeData(excelSheet, tbl.headers, tbl.data, nextRow);
                }
            }
        }
        workbook.write();
        workbook.close();
        Desktop.getDesktop().open(file);
    }

    private void createSuperHeader(WritableSheet sheet, SuperHeader[] sHeaders, Colour c, int nextRow) throws WriteException {
        WritableCellFormat st = new WritableCellFormat(new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE));
        st.setWrap(true);
        if (c != null) {
            st.setBackground(c);
        }
        for (SuperHeader sHeader : sHeaders) {
            if (sHeader != null) {
                sheet.mergeCells(sHeader.columSpan1, nextRow, sHeader.columSpan2, nextRow);
                sheet.addCell(new Label(sHeader.columSpan2 - 1, nextRow, sHeader.text, st));
            }
        }
    }

    /**
     * Escribe el excel y lo abre
     *
     * @param tmpFileName
     * @param sheetName
     * @param headers
     * @param data
     * @throws Exception
     */
    public void write(String tmpFileName, String sheetName, ColumTypes[] headers, Object[][] data) throws Exception {
        List<SheetExcel> sheets = new ArrayList<>(1);
        sheets.add(new SheetExcel(sheetName, new TableExcel(headers, data)));
        this.write(tmpFileName, sheets);
    }

    private void createHeaders(WritableSheet sheet, ColumTypes[] headers, int nextRow) throws WriteException {
        this.createHeaders(sheet, headers, null, nextRow);
    }

    private void createHeaders(WritableSheet sheet, ColumTypes[] headers, Colour c, int nextRow) throws WriteException {
        WritableCellFormat st = new WritableCellFormat(new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE));
        st.setWrap(true);
        if (c != null) {
            st.setBackground(c);
        }
        for (int i = 0; i < headers.length; i++) {
            sheet.addCell(new Label(i, nextRow, headers[i].title.toString(), st));
        }
    }

    private void writeData(WritableSheet sheet, ColumTypes[] headers, Object[][] data, int nextRow) throws Exception {
        SimpleDateFormat sdfD = new SimpleDateFormat();
        WritableCellFormat wcf = new WritableCellFormat();
        for (int i = 0; i < data.length; i++) {
            Object[] row = data[i];
            for (int j = 0; j < row.length; j++) {
                ColumTypes header = headers[j];
                int writingRow = nextRow + i + 1;
                if (header.type == ColumTypes.TYPE_NUMBER) {
                    if (header.classType != null) {
                        if (header.classType == BigDecimal.class) {
                            sheet.addCell(new Number(j, writingRow, ((BigDecimal) row[j]).longValue()));
                        } else if (header.classType == Integer.class) {
                            sheet.addCell(new Number(j, writingRow, Integer.valueOf(row[j].toString().trim())));
                        } else if (header.classType == Long.class) {
                            sheet.addCell(new Number(j, writingRow, Long.valueOf(row[j].toString().trim())));
                        } else {
                            sheet.addCell(new Number(j, writingRow, Long.valueOf(row[j].toString().trim())));
                        }
                    } else {
                        Long val = new Long(0);
                        if (row[j] == null) {
                            val = new Long(0);
                        } else if (row[j] instanceof String) {
                            val = Long.valueOf(row[j].toString().trim());
                        } else if (row[j] instanceof Long) {
                            val = (Long) row[j];
                        } else if (row[j] instanceof Integer) {
                            val = ((Integer) row[j]).longValue();
                        } else if (row[j] instanceof BigDecimal) {
                            val = ((BigDecimal) row[j]).longValue();
                        }
                        sheet.addCell(new Number(j, writingRow, val));
                    }
                } else if (header.type == ColumTypes.TYPE_DATE) {
                    sdfD.applyPattern(header.formatDateExtra != null ? header.formatDateExtra : "dd/MM/yyyy");
                    sheet.addCell(new Label(j, writingRow, sdfD.format(row[j] != null ? (java.util.Date) row[j] : null)));
                } else if (header.type == ColumTypes.TYPE_DATE_TIME) {
                    sdfD.applyPattern(header.formatDateExtra != null ? header.formatDateExtra : "dd/MM/yyyy hh:mm:ss");
                    sheet.addCell(new Label(j, writingRow, sdfD.format(row[j] != null ? (java.util.Date) row[j] : null)));
                } else if (header.type == ColumTypes.TYPE_TEXT) {
                    sheet.addCell(new Label(j, writingRow, (row[j] != null ? row[j].toString() : "")));
                } else if (header.type == ColumTypes.TYPE_DECIMAL) {
                    //new WritableCellFormat(new NumberFormat((header.formatDateExtra != null ? header.formatDateExtra : "#0.00")
                    sheet.addCell(new Number(j, writingRow, (row[j] != null ? Double.parseDouble(row[j].toString()) : 0.0)));
                } else {
                    sheet.addCell(new Label(j, writingRow, (row[j] != null ? row[j].toString() : "")));
                }
            }
        }
    }
}
