package options.reportes.kardex;

import WriteFiles.Excel.ColumTypes;
import WriteFiles.Excel.WriteExcel;
import SQL.ExecuteSql;
import Utils.Dialogs;

public class RpteMenorCuantiaReintegros extends javax.swing.JDialog {

    public RpteMenorCuantiaReintegros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setTitle("Rpte Menor Cuantia Reintegros");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtVamMax = new Utils.controls.IntegerTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        okButton.setText("Generar");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Valor Maximo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVamMax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtVamMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        try {
            if (txtVamMax.getValue() == null || txtVamMax.getValue() < 0) {
                throw new Exception("Ingrese un valor maximo");
            }
            Object[][] data = ExecuteSql.executeQuery("SELECT "
                    + "TO_NUMBER(E.COD_EST),"
                    + "E.APELLIDOS,"
                    + "E.NOMBRES, "
                    + "SUM(DC.SALDO) "
                    + "FROM RE_ESTUDIANTE E "
                    + "INNER JOIN DOCUMENTOS DC ON E.IDENTIFICACION=DC.IDEN_BENEF AND DC.SALDO<>0 "
                    + "GROUP BY E.COD_EST,E.APELLIDOS,E.NOMBRES HAVING SUM(DC.SALDO) <= " + txtVamMax.getText() + " "
                    + "ORDER BY SUM(DC.SALDO) ASC");
            WriteExcel w = new WriteExcel();
            w.write("menorCuantiaReintegros", "Menor Cuantia Reintegros", new ColumTypes[]{
                new ColumTypes(ColumTypes.TYPE_TEXT, "CÓDIGO", null),
                new ColumTypes(ColumTypes.TYPE_TEXT, "APELLIDOS", null),
                new ColumTypes(ColumTypes.TYPE_TEXT, "NOMBRES", null),
                new ColumTypes(ColumTypes.TYPE_DECIMAL, "SALDO", null)
            }, data);
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_okButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton okButton;
    private Utils.controls.IntegerTextField txtVamMax;
    // End of variables declaration//GEN-END:variables
}
