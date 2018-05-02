package options.reportes.kardex;

import WriteFiles.Excel.ColumTypes;
import WriteFiles.Excel.WriteExcel;
import SQL.ExecuteSql;
import Utils.Dialogs;

public class RpteInconsitencias extends javax.swing.JDialog {

    public RpteInconsitencias(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setTitle("Rpte Inconsitencias Kardex");
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
            Object[][] data = ExecuteSql.executeQuery("SELECT "
                    + "EM.CODIGO_EXT INCONSISTENCIA, "
                    + "(SELECT ARCHIVO FROM EXT_E_MATRICULAS WHERE CODIGO_EXT = EM.CODIGO_EXT) RECAUDO, "
                    + "COALESCE(ES.APELLIDOS,ES1.APELLIDOS) APELLIDOS, "
                    + "COALESCE(ES.NOMBRES,ES1.NOMBRES) NOMBRES, "
                    + "EM.IDENTIFICACION, "
                    + "EM.IDENTIFICACION_ORIGINAL, "
                    + "EM.VALOR, "
                    + "(SELECT FECHA_REGISTRO FROM EXT_E_MATRICULAS WHERE CODIGO_EXT = EM.CODIGO_EXT) FECHA_REGISTRO "
                    + "FROM EXT_MATRICULAS EM "
                    + "LEFT JOIN RE_ESTUDIANTE ES ON ES.COD_EST = EM.IDENTIFICACION "
                    + "LEFT JOIN RE_ESTUDIANTE ES1 ON ES1.IDENTIFICACION = EM.IDENTIFICACION_ORIGINAL "
                    + "WHERE EM.CODIGO_EXT IN (SELECT CODIGO_EXT FROM EXT_E_MATRICULAS WHERE CODIGO_EXT<0 AND NUM_COMP <0 AND EXT_E_MATRICULAS.AFECTADO = 0) "
                    + "ORDER BY FECHA_REGISTRO");
            WriteExcel w = new WriteExcel();
            w.write("inconstmp", "Inconsitencias", new ColumTypes[]{
                new ColumTypes(ColumTypes.TYPE_NUMBER, "INCONSISTENCIA", null),
                new ColumTypes(ColumTypes.TYPE_TEXT, "RECAUDO", null),
                new ColumTypes(ColumTypes.TYPE_TEXT, "APELLIDOS", null),
                new ColumTypes(ColumTypes.TYPE_TEXT, "NOMBRES", null),
                new ColumTypes(ColumTypes.TYPE_TEXT, "IDENTIFICACION", null),
                new ColumTypes(ColumTypes.TYPE_TEXT, "IDENTIFICACION ORIGINAL", null),
                new ColumTypes(ColumTypes.TYPE_DECIMAL, "VALOR", "0"),
                new ColumTypes(ColumTypes.TYPE_DATE, "FECHA REGISTRO", "")
            }, data);
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_okButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
