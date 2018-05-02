package options.reportesCnaCicle2017;

import SQL.ExecuteSql;
import Utils.Dialogs;
import WriteFiles.reports.JasperPrintExport;
import java.io.File;
import java.util.HashMap;
import javax.swing.SwingWorker;

public class PnlReportesFormaContrata extends javax.swing.JPanel {

    SwingWorker sw;

    public PnlReportesFormaContrata() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCodProgs = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        txtYearBeg = new Utils.controls.IntegerTextField();
        txtYearEnd = new Utils.controls.IntegerTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPath = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        pgBar = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblArchiv = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        pnlG = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtTerminados = new javax.swing.JTextArea();
        okButton1 = new javax.swing.JButton();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html><p>Codigos</br> Programas</br> Separados</br> por, </p></html>");

        txtCodProgs.setColumns(20);
        txtCodProgs.setRows(5);
        txtCodProgs.setText("13301,2826,3632,53076,102527,102788,104657,1396,4715,101855,102201,103046,104732,54310,54309,4042,1392,15774,5150,103087,90426,1395,5180,101282,101529,102024,10420,53827,3690,90846,101682,101495,15460,103302,104536,10583,10424,2445,2632,1394,10402,101366,105836,53740,7234,6220,54909,90645,15775,8470,4960,10423,54999,101528,102733\n");
        jScrollPane1.setViewportView(txtCodProgs);

        jLabel2.setText("Año Inicial:");

        txtYearBeg.setText("2012");

        txtYearEnd.setText("2017");

        jLabel3.setText("Año Final:");

        jLabel4.setText("Ruta:");

        txtPath.setText("C:\\\\Users\\\\umariana\\\\Desktop\\\\Reportes Cna Diciembre 2017\\\\Contratacion\\\\");

            okButton.setText("Generar");
            okButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    okButtonActionPerformed(evt);
                }
            });

            jLabel5.setText("Procesados:");

            lblArchiv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblArchiv.setText("0");

            jLabel6.setText("de");

            lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTotal.setText("0");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblArchiv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblArchiv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
            );

            pnlG.setBorder(javax.swing.BorderFactory.createTitledBorder("Generados"));

            txtTerminados.setColumns(20);
            txtTerminados.setRows(5);
            jScrollPane2.setViewportView(txtTerminados);

            javax.swing.GroupLayout pnlGLayout = new javax.swing.GroupLayout(pnlG);
            pnlG.setLayout(pnlGLayout);
            pnlGLayout.setHorizontalGroup(
                pnlGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlGLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2)
                    .addContainerGap())
            );
            pnlGLayout.setVerticalGroup(
                pnlGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
            );

            okButton1.setText("Cancelar");
            okButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    okButton1ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pgBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPath, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
                                .addComponent(txtYearEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtYearBeg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1)))
                        .addComponent(okButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jLabel1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtYearBeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtYearEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPath)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(okButton)
                    .addGap(5, 5, 5)
                    .addComponent(okButton1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(pgBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(pnlG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
        }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        try {
            pgBar.setIndeterminate(true);
            final String pathReoprte = "./src/jasper/";
            final String reporte = "rp_cna_profe_form_contrat.jasper";
            sw = new SwingWorker<Boolean, Boolean>() {
                @Override
                protected Boolean doInBackground() throws Exception {
                    int yearBegP = txtYearBeg.getValue();
                    int yearEndP = txtYearEnd.getValue();

                    String[] codsProgs = txtCodProgs.getText().replaceAll(" ", "").split(",");
                    lblTotal.setText("" + codsProgs.length);
                    for (int i = 0; i < codsProgs.length; i++) {
                        String infoText = txtTerminados.getText();
                        String codSnies = codsProgs[i].trim();
                        Object[][] data = ExecuteSql.executeQuery("SELECT RP.NOM_PROG,F.NOM_FACUL FROM RE_ZON_PRO ZP "
                                + "INNER JOIN RE_ZONA Z ON Z.COD_ZONA = ZP.COD_ZONA "
                                + "INNER JOIN RE_PROGRAMA RP ON RP.COD_PROG = ZP.COD_PROG "
                                + "INNER JOIN RE_FACULTAD F ON F.COD_FACUL = RP.COD_FACUL "
                                + "WHERE ZP.COD_SNIES =" + codSnies);
                        String nomPro = data[0][0].toString();
                        String facultad = data[0][1].toString();
                        String nomArchivo = codSnies + " " + nomPro;

                        File dir = new File(txtPath.getText() + "\\" + codSnies);
                        dir.mkdir();
                        String nDirPat = dir.getAbsolutePath() + "\\";

                        infoText += "\n" + "Directorio: " + nDirPat + "\n";
                        HashMap<String, Object> parameters = new HashMap<>();
                        parameters.put("PROGRAMA", codSnies);
                        parameters.put("YEAR_BEG", yearBegP);
                        parameters.put("YEAR_END", yearEndP);
                        parameters.put("NOM_PROGRAMA", nomPro);
                        parameters.put("P_FACULTAD", facultad);

                        try {
                            JasperPrintExport.export(pathReoprte, reporte, nomArchivo, nDirPat, null, parameters, RptProfesFormContrata.class);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        infoText += nomArchivo + ".pdf";
                        infoText += nomArchivo + ".xls";
                        txtTerminados.setText(infoText + "\n");
                        lblArchiv.setText((i + 1) + " ");
                    }
                    Dialogs.infoDialog(PnlReportesFormaContrata.this, "Generacion de archivos Terminada....");
                    pgBar.setIndeterminate(false);

                    return true;
                }
            };
            sw.execute();
        } catch (Exception e) {
            pgBar.setIndeterminate(false);
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void okButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButton1ActionPerformed
        if (sw != null) {
            sw.cancel(true);
            pgBar.setIndeterminate(false);
        }
    }//GEN-LAST:event_okButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblArchiv;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JButton okButton;
    private javax.swing.JButton okButton1;
    private javax.swing.JProgressBar pgBar;
    private javax.swing.JPanel pnlG;
    private javax.swing.JTextArea txtCodProgs;
    private javax.swing.JTextField txtPath;
    private javax.swing.JTextArea txtTerminados;
    private Utils.controls.IntegerTextField txtYearBeg;
    private Utils.controls.IntegerTextField txtYearEnd;
    // End of variables declaration//GEN-END:variables
}
