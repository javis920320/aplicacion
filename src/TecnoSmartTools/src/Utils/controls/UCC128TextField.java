package Utils.controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class UCC128TextField extends PlaceholderText {

    private Integer cut = null;

    public UCC128TextField() {
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent evt) {
            }

            @Override
            public void keyPressed(KeyEvent evt) {                
                if (evt.getKeyCode() == KeyEvent.VK_ALT && cut == null) {
                    cut = getText().length();
                }

                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    evt.consume();
                    if (cut != null) {
                        setText(getText().substring(20, cut));
                        cut = null;
                    }                    
                    fireActionPerformed();                    
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

    }
}
