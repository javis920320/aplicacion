package Utils.controls;

import java.math.BigInteger;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class BigIntegerField extends PlaceholderText {

    public BigIntegerField() {
        setDocument(new PlainDocument(){
            @Override
            public void insertString(int i, String string, AttributeSet as) throws BadLocationException {
                string = string.replaceAll("[^0-9]", "");
                super.insertString(i, string, as);
            }
        });
    }

    public BigInteger getValue() {
        if (getText().length() == 0) {
            return null;
        }
        return new BigInteger(getText());
    }

    public void setValue(BigInteger num) {
        if(num != null){
            setText(num.toString());
        }else{
            setText("");
        }
        
    }
}


