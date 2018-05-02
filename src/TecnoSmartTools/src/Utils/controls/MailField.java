package Utils.controls;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class MailField extends PlaceholderText {

    public MailField() {
        setDocument(new PlainDocument() {
            @Override
            public void remove(int offs, int len) throws BadLocationException {
                super.remove(offs, len);
                if (!isValidMail()) {
                    setForeground(Color.red);
                } else {
                    setForeground(Color.black);
                }
            }

            @Override
            public void insertString(int i, String string, AttributeSet as) throws BadLocationException {
                string = string.replaceAll("[ ]+", "").toLowerCase();
                super.insertString(i, string, as);
                if (!isValidMail()) {
                    setForeground(Color.red);
                } else {
                    setForeground(Color.black);
                }
            }
        });
    }

    public static boolean validateMail(String mail) {
        Pattern pat = Pattern.compile("([\\.\\w\\-\\_]+@[\\.\\w\\-\\_]+(\\.\\w+)+[,]*)+");
        Matcher mat = pat.matcher(mail);
        return mat.matches();

    }

    public boolean isValidMail() {
        return validateMail(getText());
    }
}
