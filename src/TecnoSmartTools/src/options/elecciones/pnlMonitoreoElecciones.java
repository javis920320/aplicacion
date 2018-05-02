package options.elecciones;

import SQL.ExecuteSql;
import Utils.Dialogs;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.prefs.Preferences;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class pnlMonitoreoElecciones extends javax.swing.JPanel {

    Preferences pref;
    Timer t;

    final PopupMenu popup = new PopupMenu();
    final TrayIcon trayIcon = new TrayIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/try.png")).getImage(), "tray icon");
    final SystemTray tray = SystemTray.getSystemTray();

    final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    public pnlMonitoreoElecciones() {
        initComponents();
        MenuItem exitItem = new MenuItem("Cerrar Alicación");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        popup.add(exitItem);
        trayIcon.setPopupMenu(popup);
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }

        t = new javax.swing.Timer(50000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Object[][] data = ExecuteSql.executeQuery("SELECT " + txtCantidadEsperada.getValue() + " POSIBLES_VOTANTES, "
                            + "COUNT(*) VOTOS_REGISTRADOS, "
                            + "ROUND((COUNT(*)/" + txtCantidadEsperada.getValue() + ")*100,2)||'% DE VOTANTES' "
                            + "FROM ELECCION_VOTACION WHERE ELECCION IN (" + txtCodEleccion.getValue() + ")");
                    if (data != null && data.length > 0) {
                        Integer posiblesvotantes = txtCantidadEsperada.getValue();
                        Integer votosRegistrados = Integer.valueOf(data[0][1].toString());
                        String porcentaje = data[0][2].toString();
                        txtMonitor.setText(txtMonitor.getText() + "\n PosiblesVotantes: " + posiblesvotantes + " Votos Registrados: " + votosRegistrados + " Porcentaje: " + porcentaje + "   Dt->: " + sdf.format(new Date()) + "\n");
                        showNotification("Elecciones", "PosiblesVotantes: " + posiblesvotantes + "\nVotos Registrados: " + votosRegistrados + "\nPorcentaje: " + porcentaje + "\nDt->: " + sdf.format(new Date()));
                    }
                } catch (Exception e1) {
                    Dialogs.errorDialog(pnlMonitoreoElecciones.this, e1);
                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        txtCodEleccion = new Utils.controls.IntegerTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCantidadEsperada = new Utils.controls.IntegerTextField();
        btnEmpezar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMonitor = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        jLabel5.setText("Codígo Eleccion:");

        jLabel1.setText("Cantidad Esperada de Votantes:");

        btnEmpezar.setText("Monitorear");
        btnEmpezar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpezarActionPerformed(evt);
            }
        });

        txtMonitor.setColumns(20);
        txtMonitor.setRows(5);
        jScrollPane1.setViewportView(txtMonitor);

        jButton1.setText("Parar Monitoreo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnEmpezar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCantidadEsperada, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 642, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCodEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCantidadEsperada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addComponent(btnEmpezar)
                .addGap(1, 1, 1)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmpezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpezarActionPerformed
        try {
            if (txtCodEleccion.getValue() == null || txtCodEleccion.getValue() < 0) {
                throw new Exception("Ingrese codigo de la eleccion");
            }
            if (txtCantidadEsperada.getValue() == null || txtCantidadEsperada.getValue() < 0) {
                throw new Exception("Ingrese cantidad Esperada de Votantes");
            }

            if (t.isRunning()) {
                t.stop();
            } else {
                t.start();
            }
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_btnEmpezarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        t.stop();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void showNotification(String title, String msg) {
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        trayIcon.displayMessage(title, msg, TrayIcon.MessageType.INFO);

    }

    //Obtain the image URL
    protected static Image createImage(String path, String description) {
        URL imageURL = pnlMonitoreoElecciones.class.getResource(path);
        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmpezar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private Utils.controls.IntegerTextField txtCantidadEsperada;
    private Utils.controls.IntegerTextField txtCodEleccion;
    private javax.swing.JTextArea txtMonitor;
    // End of variables declaration//GEN-END:variables

}
