package Utils.controls;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class IntegerTextField extends PlaceholderText {

    public IntegerTextField() {
        setDocument(new PlainDocument() {

            @Override
            public void insertString(int i, String string, AttributeSet as) throws BadLocationException {
                string = string.replaceAll("[^0-9]", "");
                super.insertString(i, string, as);
            }
        });
    }

    public Integer getValue() throws Exception {
        if (getText().isEmpty()) {
            return null;
        }
        try {
            return new Integer(getText());
        } catch (Exception ex) {
            throw new Exception("No es un número válido.");
        }
    }

    public void setValue(Integer num) {
        if (num != null) {
            setText(num.toString());
        } else {
            setText("");
        }
    }
}
