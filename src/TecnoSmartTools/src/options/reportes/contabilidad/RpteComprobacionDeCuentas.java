package options.reportes.contabilidad;

import WriteFiles.Excel.ColumTypes;
import WriteFiles.Excel.WriteExcel;
import SQL.ExecuteSql;
import Utils.Dialogs;
import WriteFiles.Excel.SheetExcel;
import WriteFiles.Excel.TableExcel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RpteComprobacionDeCuentas extends javax.swing.JDialog {

    public RpteComprobacionDeCuentas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setTitle("Rpte Comprobacion de Cuentas");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodCuenta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        spnBegDate = new Utils.controls.DateSppiner();
        spnEndDate = new Utils.controls.DateSppiner();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        okButton.setText("Generar");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Centro de Costo:");

        jLabel3.setText("Fecha Final:");

        jLabel2.setText("Fecha Inicial:");

        jLabel1.setText("Cuenta:");

        jLabel6.setText("0");

        jLabel5.setText("Varias Cuentas deben ser separadas por coma \",\"");

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
                            .addComponent(spnBegDate, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(spnEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
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
                throw new Exception("Escriba el numero de la cuenta");
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String d1 = sdf.format(spnBegDate.getDate());
            String d2 = sdf.format(spnEndDate.getDate());
            String[] cuentas = txtCodCuenta.getText().trim().split(",");
            ColumTypes[] cols = new ColumTypes[]{
                new ColumTypes(ColumTypes.TYPE_DATE, "Fecha", null),
                new ColumTypes(ColumTypes.TYPE_NUMBER, "Comprobante", null),
                new ColumTypes(ColumTypes.TYPE_NUMBER, "Tipo Cmp", null),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Detalle", null),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Tipo", null),
                new ColumTypes(ColumTypes.TYPE_NUMBER, "Valor", null)
            };
            List<TableExcel> tbls = new ArrayList<>();

            for (String cuenta : cuentas) {
                Object[][] data = ExecuteSql.executeQuery("SELECT "
                        + "RS.FECHA,RS.BALANCE_O,RS.AUXILIAR,RS.BALANCE_O-(RS.BC_MES_MENOS_UNO+(DECODE(PC.TIPO,'D',RS.AUXILIAR*-1,RS.AUXILIAR))) "
                        + "FROM("
                        + "SELECT B.COD_CUENTA,B.FECHA, SUM(B.VALOR) BALANCE_O, "
                        + "      ("
                        + "        SELECT B2.VALOR  "
                        + "        FROM BALANCE B2  "
                        + "        WHERE B2.CENTRO_COSTO = 0 "
                        + "        AND B2.COD_CUENTA = B.COD_CUENTA "
                        + "        AND B2.FECHA = ADD_MONTHS(B.FECHA,-1) "
                        + "      ) BC_MES_MENOS_UNO, "
                        + "      ( "
                        + "        SELECT "
                        + "        SUM(DECODE(D.TIPO,'C',D.VALOR,D.VALOR*-1)) "
                        + "        FROM E_COMPROBANTE E "
                        + "        INNER JOIN D_COMPROBANTE D ON E.TIPO_COMP = D.TIPO_COMP AND E.NUM_COMP = D.NUM_COMP "
                        + "        WHERE D.COD_CUENTA = B.COD_CUENTA  "
                        + "        AND E.ESTADO = 'A' "
                        + "        AND E.FECHA BETWEEN '01/'||EXTRACT(MONTH FROM (B.FECHA)) ||'/'||EXTRACT(YEAR FROM (B.FECHA)) AND B.FECHA "
                        + "      ) AUXILIAR "
                        + "FROM BALANCE B "
                        + "WHERE B.FECHA BETWEEN '" + d1 + "' AND '" + d2 + "'  "
                        + "AND B.COD_CUENTA = '" + cuenta + "' "
                        + "AND B.CENTRO_COSTO = 0 "
                        + "GROUP BY B.COD_CUENTA,B.FECHA) RS "
                        + "INNER JOIN PLAN_CUENTAS PC ON PC.COD_CUENTA = RS.COD_CUENTA");
                tbls.add(new TableExcel(cols, data));
            }
            List<SheetExcel> shets = new ArrayList<>();
            shets.add(new SheetExcel("Verifica_Cuentas", tbls));
            new WriteExcel().write("tmpVerif", shets);
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_okButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton okButton;
    private Utils.controls.DateSppiner spnBegDate;
    private Utils.controls.DateSppiner spnEndDate;
    private javax.swing.JTextField txtCodCuenta;
    // End of variables declaration//GEN-END:variables
}
