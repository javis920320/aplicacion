package options.reportes.contabilidad;

import WriteFiles.Excel.ColumTypes;
import WriteFiles.Excel.WriteExcel;
import SQL.ExecuteSql;
import Utils.Dialogs;
import java.text.SimpleDateFormat;

public class RpteAuxiliar extends javax.swing.JDialog {

    public RpteAuxiliar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setTitle("Rpte Auxiliar");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        txtCentroCosto = new javax.swing.JTextField();
        chkTodos = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodCuenta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        spnBegDate = new Utils.controls.DateSppiner();
        spnEndDate = new Utils.controls.DateSppiner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel5.setText("Si son varias cuentas separelas con coma \",\"");

        okButton.setText("Generar");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        chkTodos.setSelected(true);
        chkTodos.setText("Todos");

        jLabel4.setText("Centro de Costo:");

        jLabel3.setText("Fecha Final:");

        jLabel2.setText("Fecha Inicial:");

        jLabel1.setText("Cuenta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(okButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodCuenta)
                            .addComponent(spnBegDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spnEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 140, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCentroCosto)
                            .addComponent(chkTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnBegDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chkTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(txtCentroCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        try {
            if (txtCodCuenta.getText().trim().isEmpty()) {
                throw new Exception("Escriba el numero de la cuenta o cuentas separadas por coma");
            }
            if (!chkTodos.isSelected() && txtCentroCosto.getText().trim().isEmpty()) {
                throw new Exception("Escriba un centro de costo");
            }
            String cuentas = txtCodCuenta.getText().trim();
            String centroCosto = txtCentroCosto.getText().trim();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String d1 = sdf.format(spnBegDate.getDate());
            String d2 = sdf.format(spnEndDate.getDate());
            Object[][] data = ExecuteSql.executeQuery("SELECT "
                    + "E.FECHA, "
                    + "E.NUM_COMP, "
                    + "E.TIPO_COMP, "
                    + "D.DETALLE, "
                    + "D.TIPO, "
                    + "D.VALOR "
                    + "FROM E_COMPROBANTE E "
                    + "INNER JOIN D_COMPROBANTE D ON E.TIPO_COMP = D.TIPO_COMP AND E.NUM_COMP = D.NUM_COMP "
                    + "WHERE D.COD_CUENTA IN (" + cuentas + ") AND E.FECHA >='" + d1 + "' AND E.FECHA <='" + d2 + "' "
                    + "AND E.ESTADO = 'A' "
                    + (!chkTodos.isSelected() && !txtCentroCosto.getText().trim().isEmpty() ? " AND D.CENTRO_COSTO IN (" + centroCosto + ") " : " ")
                    + "ORDER BY FECHA,D.NUM_COMP");
            WriteExcel w = new WriteExcel();
            w.write("auxtmp", "Auxiliar", new ColumTypes[]{
                new ColumTypes(ColumTypes.TYPE_DATE, "Fecha", null),
                new ColumTypes(ColumTypes.TYPE_NUMBER, "Comprobante", null),
                new ColumTypes(ColumTypes.TYPE_NUMBER, "Tipo Cmp", null),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Detalle", null),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Tipo", null),
                new ColumTypes(ColumTypes.TYPE_NUMBER, "Valor", null)
            }, data);
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_okButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton okButton;
    private Utils.controls.DateSppiner spnBegDate;
    private Utils.controls.DateSppiner spnEndDate;
    private javax.swing.JTextField txtCentroCosto;
    private javax.swing.JTextField txtCodCuenta;
    // End of variables declaration//GEN-END:variables
}
