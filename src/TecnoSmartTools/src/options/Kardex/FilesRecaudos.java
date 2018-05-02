package options.Kardex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Cristian Onofre 31/08/2016
 */
public class FilesRecaudos {

    /**
     * Retorna una lista con todos los archivos en una ruta especifica que
     * contenga las extenciones de recaudos .mr5,.csv,.txt,y extencion vacia
     *
     * @param path
     * @return
     * @throws java.lang.Exception
     */
    public static List<File> getFilesInDirectories(String path) throws Exception {
        File root = new File(path);
        if (root.exists()) {
            File[] list = root.listFiles();
            List<File> files = new ArrayList<>();
            readFiles(list, files);
            return files;
        } else {
            throw new Exception("La ruta especificada no es valida");
        }
    }

    /**
     * Lee todos los archivos dentro de una carpeta de manera recursiva esto
     * quiere decir que va abriendo las carpetas contenidas solo leee los
     * arvhivos .mr5 .csv .txt o que no tengan extencion
     *
     * @param fs
     * @param files
     */
    private static void readFiles(File[] fs, List<File> files) {
        for (File file : fs) {
            if (file.isDirectory()) {
                File[] lstF = file.listFiles();
                readFiles(lstF, files);
            } else if (file.exists()) {
                if (file.getName().toLowerCase().contains(".mr5") || file.getName().toLowerCase().contains(".csv") || file.getName().toLowerCase().contains(".txt") || !file.getName().contains(".")) {
                    files.add(file);
                }
            }
        }
    }

    /**
     * Busca Creditos Duplicados en archivos de Davivienda
     *
     * @param f
     * @param yearFind
     * @return
     * @throws Exception
     */
    public static String findDuplicateDavivienda(File f, Integer yearFind) throws Exception {
        String everything = readFile(f);
        String str = null;
        if (everything != null) {
            if (everything.substring(12, 20).contains("" + yearFind)) {//año del recaudo
                String[] rowF = everything.split("\r\n");
                List<Row> fileRows = new ArrayList<>();
                for (String row : rowF) {
                    if (!row.trim().isEmpty() && row.trim().length() == 94) {
                        Row r = new Row();
                        r.credito = row.substring(44, 50);
                        r.oficina = row.substring(83, 88);
                        r.consec = row.substring(91, 100);
                        fileRows.add(r);
                    }
                }

                List<String> rowsDup = new ArrayList<>();
                for (int i = 0; i < fileRows.size(); i++) {
                    Row x = fileRows.get(i);
                    for (int j = 0; j < fileRows.size(); j++) {
                        if (i != j) {
                            Row x1 = fileRows.get(j);
                            if (x.credito.equals(x1.credito)) {
                                String strAddd = "" + x.credito + "\t\t " + "" + x.oficina + "\t\t" + x.consec;
                                if (rowsDup.isEmpty()) {
                                    rowsDup.add(strAddd);
                                } else {
                                    boolean ad = true;
                                    for (int k = 0; k < rowsDup.size(); k++) {
                                        String get = rowsDup.get(k);
                                        if (get.equals(strAddd)) {
                                            ad = false;
                                        }
                                    }
                                    if (ad) {
                                        rowsDup.add(strAddd);
                                    }
                                }
                            }
                        }
                    }
                }
                if (rowsDup.size() > 0) {//buscar en la fila
                    str = "  Archivo:\t" + f.getName() + "\n  ";
                    str += "Fecha:\t" + new SimpleDateFormat("dd-MMMM-yyyy").format(new SimpleDateFormat("yyyyMMdd").parse(everything.substring(12, 20))).toUpperCase() + "\r\n";
                    str += "  Crédito\t\tOficina\r\n";
                    for (int i = 0; i < rowsDup.size(); i++) {
                        str += "  " + rowsDup.get(i).substring(0, rowsDup.get(i).length() - 9) + "\t\r\n";
                    }
                    str += "  Total En Archivo:    " + rowsDup.size() + "\n";
                    str += "-------------------------------------------------------------------------------------------------------------\n";
                }
            }
        }
        return str;
    }

    /**
     * Retorna un string con el contenido de un archivo
     *
     * @param f
     * @return
     * @throws Exception
     */
    public static String readFile(File f) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(f));
        StringBuilder sb = new StringBuilder("");
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        return sb.toString().isEmpty() ? null : sb.toString();
    }

    /**
     * Cuenta cuantas veces se repite find en un string str
     *
     * @param str
     * @param find
     * @return
     */
    public static int countWordInString(String str, String find) {
        Pattern p = Pattern.compile(find);
        Matcher m = p.matcher(str);
        int count = 0;
        while (m.find()) {
            count += 1;
        }
        return count;
    }

    static class Row {

        public String credito;
        public String oficina;
        public String consec;
        public boolean duplicate = false;
    }
}
