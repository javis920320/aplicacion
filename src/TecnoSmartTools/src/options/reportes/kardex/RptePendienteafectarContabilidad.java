package options.reportes.kardex;

import WriteFiles.Excel.ColumTypes;
import WriteFiles.Excel.WriteExcel;
import SQL.ExecuteSql;
import Utils.Dialogs;

public class RptePendienteafectarContabilidad extends javax.swing.JDialog {

    public RptePendienteafectarContabilidad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setTitle("Rpte Recaudos e inconsistencias sin afectar a contabilidad");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        okButton.setText("Generar");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        try {
            Object[][] data = ExecuteSql.executeQuery("SELECT ET.CODIGO_EXT,ET.NUM_PROD "
                    + "FROM EXT_MAT_CA_TRANSACCION ET "
                    + "INNER JOIN CA_TRANSACCION CA ON CA.NUM_PROD = ET.NUM_PROD "
                    + "WHERE ET.NUM_COMP = -1");
            WriteExcel w = new WriteExcel();
            w.write("inconstmp", "Recaudo sin afectar", new ColumTypes[]{
                new ColumTypes(ColumTypes.TYPE_NUMBER, "CodRecaudo", null),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Credito", null)
            }, data);
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_okButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
