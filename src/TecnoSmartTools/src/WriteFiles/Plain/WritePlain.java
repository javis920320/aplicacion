package WriteFiles.Plain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class WritePlain {

    /**
     * Escribe un texto plano donde se indique segun el path,el path debe tener
     * la extencion el otro parametro es el texto que se quiere escribir
     *
     * @param path
     * @param text
     * @throws Exception
     */
    public void write(String path, String text) throws Exception {
        File statText = new File(path);
        try (FileOutputStream is = new FileOutputStream(statText); OutputStreamWriter osw = new OutputStreamWriter(is)) {
            try (Writer w = new BufferedWriter(osw)) {
                w.write(text);
            }
        }
    }
}
