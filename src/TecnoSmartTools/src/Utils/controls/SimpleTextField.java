package Utils.controls;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class SimpleTextField extends PlaceholderText implements FocusListener, MouseListener {

    private static String[] special = new String[]{"\\\\", "\"", "'"};
    private int maxLenght = 2048;

    public SimpleTextField() {
        setDocument(new PlainDocument() {
            @Override
            public void insertString(int i, String string, AttributeSet as) throws BadLocationException {
                string = string.replaceAll("[?#]", "");
                int len = SimpleTextField.this.getText().length();

                if (string.length() + len < maxLenght) {
                    super.insertString(i, string, as);
                } else {
                    super.insertString(i, string.substring(0, maxLenght - len), as);
                }
            }
        });
        this.addFocusListener(SimpleTextField.this);
        this.addMouseListener(SimpleTextField.this);
    }

    @Override
    public String getText() {
        return scape(super.getText());
    }

    @Override
    public void setText(String str) {
        super.setText(str);
        setCaretPosition(0);
    }

    @Override
    public void focusGained(FocusEvent e) {
        super.grabFocus();
        setCaretPosition(0);
    }

    @Override
    public void focusLost(FocusEvent e) {
        setText(super.getText());
    }

    public boolean hasText() {
        return (super.getText().trim()).isEmpty();
    }

    private static String scape(String str) {
        for (String sc : special) {
            str = str.replaceAll(sc, "\\\\" + sc);
        }
        return str;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() > 2) {
            this.selectAll();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public int getMaxLenght() {
        return maxLenght;
    }

    public void setMaxLenght(int maxLenght) {
        this.maxLenght = maxLenght;
    }
}
