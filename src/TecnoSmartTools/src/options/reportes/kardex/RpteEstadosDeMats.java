package options.reportes.kardex;

import WriteFiles.Excel.ColumTypes;
import WriteFiles.Excel.WriteExcel;
import SQL.ExecuteSql;
import Utils.Dialogs;

public class RpteEstadosDeMats extends javax.swing.JDialog {

    public RpteEstadosDeMats(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setTitle("Rpte. Estados De Matriculas Por Progrograma y Periodo");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtProg = new javax.swing.JTextField();
        txtPer = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        okButton.setText("Generar");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Programa:");

        jLabel2.setText("Periodo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPer)
                            .addComponent(txtProg))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtProg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        try {
            if (txtProg.getText().trim().isEmpty()) {
                throw new Exception("Ingrese el programa");
            }
            if (txtPer.getText().trim().isEmpty()) {
                throw new Exception("Ingrese el periodo");
            }
            Object[][] data = ExecuteSql.executeQuery("SELECT "
                    + "P.NOM_PROG ,"
                    + "M.COD_PER ,"
                    + "E.COD_EST ,"
                    + "E.APELLIDOS ,"
                    + "E.NOMBRES ,"
                    + "E.EMAIL ,"
                    + "E.TELEFONO ,"
                    + "M.SEMESTRE , "
                    + "decode(m.estado,'M','Matriculado','No Legaliza Academicamente') ,  "
                    + "decode(cA.estado,'C','Legalizado Financieramente','T','Legalizado Financieramente','A','Pagado no Legalizado Financieramente','P','No a pagado') "
                    + "FROM RE_MATRICULA M "
                    + "INNER JOIN RE_PROGRAMA P ON M.COD_ZONPRO = P.COD_PROG "
                    + "INNER JOIN CA_CREDITO CA ON CA.NUM_MAT = M.NUM_MAT "
                    + "INNER JOIN RE_ESTUDIANTE E ON E.COD_EST = M.COD_EST "
                    + "WHERE M.COD_PER = " + txtPer.getText().trim() + " "
                    + "AND M.COD_ZONPRO = " + txtProg.getText().trim() + " "
                    + "ORDER BY M.SEMESTRE ASC");
            WriteExcel w = new WriteExcel();
            w.write("prog", "Estados De Matriculas Prog: " + txtProg.getText().trim(), new ColumTypes[]{
                new ColumTypes(ColumTypes.TYPE_TEXT, "Programa", null),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Periodo", null),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Código", null),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Apellidos", null),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Nombres", null),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Correo", null),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Teléfono", null),
                new ColumTypes(ColumTypes.TYPE_NUMBER, "Semestre", null),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Estado Matricula", null),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Estado Crédito", null)
            }, data);
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_okButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField txtPer;
    private javax.swing.JTextField txtProg;
    // End of variables declaration//GEN-END:variables
}
