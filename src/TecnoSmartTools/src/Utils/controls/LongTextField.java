package Utils.controls;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LongTextField extends PlaceholderText {

    public LongTextField() {
        setDocument(new PlainDocument(){
            @Override
            public void insertString(int i, String string, AttributeSet as) throws BadLocationException {
                string = string.replaceAll("[^0-9]", "");
                super.insertString(i, string, as);
            }
        });
    }

    public Long getValue() {
        if (getText().length() == 0) {
            return null;
        }
        return new Long(getText());
    }

    public void setValue(Long num) {
        if(num != null){
            setText(num.toString());
        }else{
            setText("");
        }
        
    }
}


