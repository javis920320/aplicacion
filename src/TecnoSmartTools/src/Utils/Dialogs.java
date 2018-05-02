package Utils;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Dialogs {

    public static void errorDialog(Component parent, Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(parent, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void infoDialog(Component parent, String msg) {
        JOptionPane.showMessageDialog(parent, msg, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean okCancel(Component parent, String msg) {
        int reply = JOptionPane.showConfirmDialog(parent, msg, "Pregutna", JOptionPane.YES_NO_OPTION);
        return reply == JOptionPane.YES_OPTION;
    }
}
