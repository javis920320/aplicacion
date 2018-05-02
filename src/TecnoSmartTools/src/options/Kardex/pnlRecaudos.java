package options.Kardex;

import java.io.File;
import java.util.List;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class pnlRecaudos extends javax.swing.JPanel {

    Preferences prefs;

    public pnlRecaudos() {
        initComponents();
        prefs = Preferences.userNodeForPackage(getClass());
        txtPath.setText(prefs.get("path", ""));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPath = new javax.swing.JLabel();
        txtPath = new javax.swing.JTextField();
        btnPath = new javax.swing.JButton();
        chkDavivienda = new javax.swing.JRadioButton();
        chkBBVA = new javax.swing.JRadioButton();
        chkCorbanca = new javax.swing.JRadioButton();
        lblDate = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        lblFormat = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        lblFind = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        pgBar = new javax.swing.JProgressBar();

        lblPath.setText("Path Recaudos:");

        btnPath.setText("Ruta");
        btnPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPathActionPerformed(evt);
            }
        });

        chkDavivienda.setSelected(true);
        chkDavivienda.setText("Davivienda");

        chkBBVA.setText("BBVA");

        chkCorbanca.setText("Corbanca");

        lblDate.setText("Fecha Recaudos:");

        txtYear.setText("2016");

        lblFormat.setText("YYYY, YYYYMMDD");

        lblType.setText("Tipo:");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Busqueda", "Duplicados" }));

        lblFind.setText("Texto Buscar:");

        btnBuscar.setText("Ejecutar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPath, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(lblFind, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPath)
                            .addComponent(txtFind)
                            .addComponent(cmbTipo, 0, 592, Short.MAX_VALUE)
                            .addComponent(txtYear, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFormat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkDavivienda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkBBVA, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkCorbanca)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pgBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPath, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkDavivienda)
                    .addComponent(chkBBVA)
                    .addComponent(chkCorbanca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDate)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblType)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFind)
                    .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pgBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPathActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Seleccione Directorio");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            txtPath.setText(chooser.getSelectedFile() + "\\");
            prefs.put("path", chooser.getSelectedFile() + "\\");
        }
    }//GEN-LAST:event_btnPathActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        new SwingWorker<Object, Object>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                pgBar.setIndeterminate(true);

                switch (cmbTipo.getSelectedItem().toString()) {

                    case "Busqueda": {
                        if (txtFind.getText().trim().isEmpty()) {
                            throw new Exception("Ingrese Parametro de Busqueda");
                        }
                        List<File> files = FilesRecaudos.getFilesInDirectories(txtPath.getText());
                        StringBuilder sbr = new StringBuilder("");
                        for (int i = 0; i < files.size(); i++) {
                            File f = files.get(i);
                            String contentFile = FilesRecaudos.readFile(f);
                            if (chkBBVA.isSelected()) {
                                throw new Exception("No implementado bbva");
                            } else if (chkCorbanca.isSelected()) {
                                throw new Exception("No implementado corbanca");
                            } else if (chkDavivienda.isSelected()) {
                                if ((contentFile != null && contentFile.substring(12, 20).contains(txtYear.getText()))) {//año del recaudo //buscar en el string el contenido de txtFind.getText()
                                    if (contentFile.contains(txtFind.getText().trim())) {
                                        sbr.append(contentFile.substring(12, 20)).append(" - ").append(f.getName()).append(" - ").append(f.getAbsolutePath());
                                        sbr.append("\n");
                                    }
                                }
                            }
                        }
                        txtResultado.setText(sbr.toString().isEmpty() ? "No se hallaron resultados" : sbr.toString());
                        break;
                    }
                    case "Duplicados": {
                        List<File> files = FilesRecaudos.getFilesInDirectories(txtPath.getText());
                        String rta = "";
                        for (int i = 0; i < files.size(); i++) {
                            if (chkDavivienda.isSelected()) {
                                String s = FilesRecaudos.findDuplicateDavivienda(files.get(i), Integer.valueOf(txtYear.getText()));
                                if (s != null) {
                                    rta += s;
                                }
                            } else if (chkBBVA.isSelected()) {
                                throw new Exception("No implementado bbva");
                            } else if (chkCorbanca.isSelected()) {
                                throw new Exception("No implementado corbanca");
                            }
                        }
                        txtResultado.setText(rta + " \nTotal Archivos:" + FilesRecaudos.countWordInString(rta, "Archivo"));
                        break;
                    }
                    default:
                        throw new Exception("Opción no valida " + cmbTipo.getSelectedItem().toString());
                }

                return null;
            }

            @Override
            protected void done() {
                super.done(); //To change body of generated methods, choose Tools | Templates.
                pgBar.setIndeterminate(false);
            }
        }.execute();
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnPath;
    private javax.swing.JRadioButton chkBBVA;
    private javax.swing.JRadioButton chkCorbanca;
    private javax.swing.JRadioButton chkDavivienda;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblFind;
    private javax.swing.JLabel lblFormat;
    private javax.swing.JLabel lblPath;
    private javax.swing.JLabel lblType;
    private javax.swing.JProgressBar pgBar;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtPath;
    private javax.swing.JTextArea txtResultado;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
