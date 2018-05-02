package Utils.controls;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JTextField;
import javax.swing.text.Document;

public class PlaceholderText extends JTextField {

    private String placeHolderText = "";

    public PlaceholderText() {
        super();
    }

    public PlaceholderText(Document doc, String text, int columns) {
        super(doc, text, columns);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (getText().isEmpty()) {
            if (!placeHolderText.isEmpty()) {
                g.setColor(Color.gray);
                int y = (int) ((getHeight() + 8) / 2d);
                g.drawString(getPlaceHolderText(), Math.max(getMargin().left, 3), y);
            }
        }
    }

    public String getPlaceHolderText() {
        return placeHolderText;
    }

    public void setPlaceHolderText(String placeHolderText) {
        this.placeHolderText = placeHolderText;
    }
}
