package Utils.controls;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JLabel;

public class JDottedSeparator extends JLabel {

    private Dimension dim = new Dimension(10, 25);

    public JDottedSeparator() {

        setMaximumSize(dim);
        setMinimumSize(dim);
        setPreferredSize(dim);
    }
    
    @Override
    public void paint(Graphics g) {
        int c = (getWidth() / 2) - 2;

        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(getBackground().brighter());
        for (int i = 4; i < getHeight() - 8; i += 4) {
            g.fillRect(c + 1, 3 + i, 2, 2);
        }


        for (int i = 4; i < getHeight() - 8; i += 4) {
            g.setColor(mixColors(getBackground(), 0.8f, Color.black));
            g.fillRect(c, 2 + i, 2, 2);
            g.setColor(mixColors(getBackground(), 0.7f, Color.black));
            g.fillRect(c + 1, 3 + i, 1, 1);
        }
    }

    private Color mixColors(Color c1, float p1, Color c2) {
        int r = (int) ((c1.getRed() * p1) + (c2.getRed() * (1 - p1)));
        int g = (int) ((c1.getGreen() * p1) + (c2.getGreen() * (1 - p1)));
        int b = (int) ((c1.getBlue() * p1) + (c2.getBlue() * (1 - p1)));
        return new Color(r, g, b);
    }
}
