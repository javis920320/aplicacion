package options.contabilidad.polizas;

import WriteFiles.Excel.ColumTypes;
import WriteFiles.Excel.SheetExcel;
import WriteFiles.Excel.TableExcel;
import WriteFiles.Excel.WriteExcel;
import SQL.ExecuteSql;
import Utils.Dialogs;
import WriteFiles.Plain.WritePlain;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;

public class pnlPolizas extends javax.swing.JPanel {

    Preferences pref;

    public pnlPolizas() {
        initComponents();
        pref = Preferences.userRoot().node("TecnosmartTools");
        Date d = new Date();
        txt_nom_sql.setText("Contabilidad - Estudiantes Poliza - " + new SimpleDateFormat("ddMMyyyy").format(d) + ".sql");
        txt_nom_xls.setText("901-ReporteEstudiantesPoliza-" + new SimpleDateFormat("ddMMMMyyyy").format(d) + ".xls");

        txtPatSql.setText(pref.get("pathSql", ""));
        txtPatXls.setText(pref.get("pathXls", ""));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pgBar = new javax.swing.JProgressBar();
        btnCrearEnvio = new javax.swing.JButton();
        lblNuevoEnvio = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblPathSvnGuardarSql = new javax.swing.JLabel();
        txt_nom_sql = new Utils.controls.PlaceholderText();
        txtPatSql = new Utils.controls.PlaceholderText();
        btnPathSql = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblPathSvnGuardarXls = new javax.swing.JLabel();
        txt_nom_xls = new Utils.controls.PlaceholderText();
        txtPatXls = new Utils.controls.PlaceholderText();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        btnCrearEnvio.setText("Crear Envío y Generar Reportes");
        btnCrearEnvio.setPreferredSize(new java.awt.Dimension(128, 25));
        btnCrearEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearEnvioActionPerformed(evt);
            }
        });

        lblNuevoEnvio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Nombre Archivo SQL:");
        jLabel1.setPreferredSize(new java.awt.Dimension(125, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 6);
        jPanel1.add(jLabel1, gridBagConstraints);

        lblPathSvnGuardarSql.setText("Path Svn Guardar Sql:");
        lblPathSvnGuardarSql.setPreferredSize(new java.awt.Dimension(125, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 10);
        jPanel1.add(lblPathSvnGuardarSql, gridBagConstraints);

        txt_nom_sql.setPreferredSize(new java.awt.Dimension(125, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(txt_nom_sql, gridBagConstraints);

        txtPatSql.setEditable(false);
        txtPatSql.setPlaceHolderText("C:/../..");
        txtPatSql.setPreferredSize(new java.awt.Dimension(125, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel1.add(txtPatSql, gridBagConstraints);

        btnPathSql.setText("...");
        btnPathSql.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPathSqlActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel1.add(btnPathSql, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Nombre Archivo XLS:");
        jLabel2.setPreferredSize(new java.awt.Dimension(125, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 1, 5, 11);
        jPanel2.add(jLabel2, gridBagConstraints);

        lblPathSvnGuardarXls.setText("Path Svn Guardar xls:");
        lblPathSvnGuardarXls.setPreferredSize(new java.awt.Dimension(125, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 10);
        jPanel2.add(lblPathSvnGuardarXls, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel2.add(txt_nom_xls, gridBagConstraints);

        txtPatXls.setEditable(false);
        txtPatXls.setPlaceHolderText("C:/../..");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel2.add(txtPatXls, gridBagConstraints);

        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        jPanel2.add(jButton2, gridBagConstraints);

        jLabel3.setText("svnSoporte\\Documentos\\Base de Conocimientos\\Soluciones Documentadas\\Contabilidad\\Polizas");

        jLabel4.setText("svnSoporte\\Documentos\\Informes Universidad Mariana\\Polizas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCrearEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNuevoEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pgBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCrearEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNuevoEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pgBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearEnvioActionPerformed
        pgBar.setIndeterminate(true);
        try {
            if (txtPatSql.getText() == null || txtPatSql.getText().trim().isEmpty()) {
                throw new Exception("Ingrese el PATH para Guardar el Sql");
            }
            if (txtPatXls.getText() == null || txtPatXls.getText().trim().isEmpty()) {
                throw new Exception("Ingrese el PATH para Guardar el xls");
            }
            pref.put("pathSql", txtPatSql.getText());
            pref.put("pathXls", txtPatXls.getText());
            boolean insertNewEnvio = ExecuteSql.insert("INSERT INTO SISTEMAS.SE_ENVIO "
                    + "(cod_envio, fec_crea, fec_envio, detalle, estado) "
                    + "SELECT (NVL(MAX(se.cod_envio), 0) + 1),  SYSDATE, SYSDATE, 'EN PROCESO', 0 FROM SISTEMAS.SE_ENVIO SE");
            if (insertNewEnvio) {
                String codEnvio = ExecuteSql.executeQuery("SELECT MAX(COD_ENVIO) FROM SISTEMAS.SE_ENVIO")[0][0].toString();
                lblNuevoEnvio.setText(codEnvio);
                ExecuteSql.update("INSERT INTO sistemas.se_estudiantes(cod_envio, num_mat, cod_zonpro,  "//insert de polizas
                        + "identificacion, tipo_iden, nombres, "
                        + "apellidos, fec_inicia, fec_termina, "
                        + "periodicidad, estado) "
                        + "SELECT '" + codEnvio + "' AS envio, m.num_mat, m.cod_zonpro, "
                        + "e.identificacion, e.tipo_iden, UPPER(TRIM(e.nombres)), "
                        + "UPPER(TRIM(e.apellidos)), per.inicia, per.termina, "
                        + "(CASE WHEN MONTHS_BETWEEN(per.termina, per.inicia)>=7 THEN 'ANUAL' ELSE 'SEMESTRAL' END) AS periodicidad, 'P' As estado "
                        + "FROM re_matricula m "
                        + "INNER JOIN ca_credito cr ON cr.num_mat = m.num_mat "
                        + "INNER JOIN re_estudiante e ON e.cod_est = m.cod_est "
                        + "INNER JOIN re_periodo per ON per.cod_per = m.cod_per "
                        + "LEFT JOIN sistemas.se_estudiantes ee ON ee.num_mat = m.num_mat "
                        + "LEFT JOIN sistemas.se_envio se ON se.cod_envio = ee.cod_envio "
                        + "LEFT JOIN sistemas.se_estudiantes_no en ON en.num_mat = m.num_mat "
                        + "WHERE TO_CHAR(SYSDATE + 2, 'YYYYMMDD') < TO_CHAR(per.termina, 'YYYYMMDD') "
                        + "AND (m.estado = 'M' OR (m.estado IN('E', 'G', 'P', 'S', 'X') AND cr.estado IN('T', 'C'))) "
                        + "AND cr.COD_CREDI IN(6,11,9) "
                        + "AND (ee.num_mat IS NULL OR se.estado = -1 OR (se.estado = 1 AND ee.estado = 'N')) "
                        + "AND en.num_mat IS NULL ");
                ExecuteSql.update("UPDATE sistemas.se_estudiantes ee SET ee.estado = 'E' WHERE ee.cod_envio = '" + codEnvio + "' AND ee.estado = 'P' ");
                Dialogs.infoDialog(this, "Insert de polizas listo....");
                try {
                    ExecuteSql.update("UPDATE sistemas.se_envio se SET se.estado = 1, fec_envio = SYSDATE, detalle = 'PROCESO COMPLETADO CON EXITO' WHERE se.cod_envio = '" + codEnvio + "' AND se.estado = 0");
                    generateReportExcel(codEnvio, txtPatXls.getText() + txt_nom_xls.getText());
                    generatePlainSql(codEnvio, txtPatSql.getText() + txt_nom_sql.getText());
                    Dialogs.infoDialog(this, "Reportes Generados con exíto");
                } catch (Exception e) {
                    Dialogs.errorDialog(this, e);
                }
            } else {
                throw new Exception("Error Insertando Envío");
            }
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        } finally {
            pgBar.setIndeterminate(false);
        }
    }//GEN-LAST:event_btnCrearEnvioActionPerformed

    private void btnPathSqlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPathSqlActionPerformed
        txtPatSql.setText(getPath());
    }//GEN-LAST:event_btnPathSqlActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtPatXls.setText(getPath());
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String[] args) {
        try {
            generateReportExcel("1060", "D://test1.xls");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("");
        }
    }
    
    private static void generateReportExcel(String codEnvio, String path) throws Exception {
        Object[][] dataSemestral = ExecuteSql.executeQuery("SELECT ee.apellidos, ee.nombres, e.sexo AS sexo_A, "
                + "DECODE(ee.tipo_iden, 'C','C.C.', 'T','T.I',ee.tipo_iden) AS tipo_ident, "
                + "TO_NUMBER(ee.identificacion), "
                + "pro.nom_prog, "
                + "m.semestre AS semestre_A, ee.fec_inicia, ee.fec_termina, "
                + "ee.periodicidad, ROUND(MONTHS_BETWEEN(ee.fec_termina, ee.fec_inicia), 2) AS duracion_meses, DECODE(pro.jornada, 'D', 'DIURNO', 'N', 'NOCTURNO', pro.jornada) AS jornada, "
                + "zn.nombre AS zona, "
                + "PER.COD_PER, "//AUMENTA POR SOLICITUD DE CONTABILIDAD CRIASTINA VARGAS Y VICERECTORIA 
                + "PER.NOM_PER, "//AUMENTA POR SOLICITUD DE CONTABILIDAD CRIASTINA VARGAS Y VICERECTORIA
                + "DECODE(M.ESTADO,'M','MATRICULADO','E','MATRICULADO CURSO ESPECIAL','R','RETIRADO','P','PREMATRICULADO','S','PREMATRICULADO CURSO ESPECIAL') ESTADO_MATRICULA "//AUMENTA POR SOLICITUD DE CONTABILIDAD CRIASTINA VARGAS Y VICERECTORIA
                + "FROM sistemas.se_estudiantes ee "
                + "INNER JOIN re_matricula m ON m.num_mat = ee.num_mat "
                + "INNER JOIN RE_PERIODO PER ON PER.COD_PER = M.COD_PER "//AUMENTA POR SOLICITUD DE CONTABILIDAD CRIASTINA VARGAS Y VICERECTORIA
                + "INNER JOIN re_estudiante e ON e.cod_est = m.cod_est "
                + "INNER JOIN re_zon_pro zp ON zp.cod_zonpro = ee.cod_zonpro "
                + "INNER JOIN re_programa pro ON pro.cod_prog = zp.cod_prog "
                + "INNER JOIN re_zona zn ON zn.cod_zona = zp.cod_zona "
                + "WHERE ee.cod_envio = '" + codEnvio + "' AND ee.estado = 'E' "
                + "AND ee.PERIODICIDAD = 'SEMESTRAL' "
                + "ORDER BY ee.periodicidad DESC, pro.nom_prog, ee.cod_zonpro, ee.apellidos, ee.nombres ");

        Object[][] dataAnual = ExecuteSql.executeQuery("SELECT ee.apellidos, ee.nombres, e.sexo AS sexo_A, "
                + "DECODE(ee.tipo_iden, 'C','C.C.', 'T','T.I',ee.tipo_iden) AS tipo_ident, "
                + "TO_NUMBER(ee.identificacion), pro.nom_prog, "
                + "m.semestre AS semestre_A, ee.fec_inicia, ee.fec_termina, "
                + "ee.periodicidad, ROUND(MONTHS_BETWEEN(ee.fec_termina, ee.fec_inicia), 2) AS duracion_meses, "
                + "DECODE(pro.jornada, 'D', 'DIURNO', 'N', 'NOCTURNO', pro.jornada) AS jornada, "
                + "zn.nombre AS zona, "
                + "PER.COD_PER, "//AUMENTA POR SOLICITUD DE CONTABILIDAD CRIASTINA VARGAS Y VICERECTORIA 
                + "PER.NOM_PER, "//AUMENTA POR SOLICITUD DE CONTABILIDAD CRIASTINA VARGAS Y VICERECTORIA
                + "DECODE(M.ESTADO,'M','MATRICULADO','E','MATRICULADO CURSO ESPECIAL','R','RETIRADO','P','PREMATRICULADO','S','PREMATRICULADO CURSO ESPECIAL') ESTADO_MATRICULA "//AUMENTA POR SOLICITUD DE CONTABILIDAD CRIASTINA VARGAS Y VICERECTORIA
                + "FROM sistemas.se_estudiantes ee "
                + "INNER JOIN re_matricula m ON m.num_mat = ee.num_mat "
                + "INNER JOIN RE_PERIODO PER ON PER.COD_PER = M.COD_PER "//AUMENTA POR SOLICITUD DE CONTABILIDAD CRIASTINA VARGAS Y VICERECTORIA
                + "INNER JOIN re_estudiante e ON e.cod_est = m.cod_est "
                + "INNER JOIN re_zon_pro zp ON zp.cod_zonpro = ee.cod_zonpro "
                + "INNER JOIN re_programa pro ON pro.cod_prog = zp.cod_prog "
                + "INNER JOIN re_zona zn ON zn.cod_zona = zp.cod_zona "
                + "WHERE ee.cod_envio = '" + codEnvio + "' AND ee.estado = 'E' "
                + "AND ee.PERIODICIDAD = 'ANUAL' "
                + "ORDER BY ee.periodicidad DESC, pro.nom_prog, ee.cod_zonpro, ee.apellidos, ee.nombres ");

        Object[][] dataEstMasDeUnaMatricual = ExecuteSql.executeQuery("SELECT ee.apellidos, ee.nombres, "
                + "DECODE(ee.tipo_iden, 'C','C.C.', 'T','T.I',ee.tipo_iden) AS tipo_ident, "
                + "TO_NUMBER(ee.identificacion) "
                + "FROM sistemas.se_estudiantes ee "
                + "WHERE ee.cod_envio = '" + codEnvio + "' AND ee.estado = 'E' "
                + "GROUP BY ee.apellidos, ee.nombres, ee.tipo_iden, ee.identificacion "
                + "HAVING COUNT(1) > 1 "
                + "ORDER BY ee.apellidos, ee.nombres, DECODE(ee.tipo_iden, 'C','C.C.', 'T','T.I',ee.tipo_iden), ee.identificacion ");//ESTUDIANTES CON MAS DE UNA CARRERA EN EL ENVIO

        Object[][] dataEstReportadosAntes = ExecuteSql.executeQuery("SELECT ee.apellidos, ee.nombres, "//ESTUDIANTES REPORTADOS ANTES - QUE AUN ESTAN VIGENTES
                + "DECODE(ee.tipo_iden, 'C','C.C.', 'T','T.I',ee.tipo_iden) AS tipo_ident, "
                + "TO_NUMBER(ee.identificacion), "
                + "pro.nom_prog AS programa_anterior "
                + "FROM sistemas.se_estudiantes ee "
                + "INNER JOIN sistemas.se_envio eh ON eh.cod_envio = ee.cod_envio "
                + "INNER JOIN sistemas.se_estudiantes ea ON ea.identificacion = ee.identificacion "
                + "INNER JOIN sistemas.se_envio sa ON sa.cod_envio = ea.cod_envio "
                + "INNER JOIN re_zon_pro zp ON zp.cod_zonpro = ea.cod_zonpro "
                + "INNER JOIN re_programa pro ON pro.cod_prog = zp.cod_prog "
                + "INNER JOIN re_zon_pro zp_a ON zp_a.cod_zonpro = ee.cod_zonpro "
                + "INNER JOIN re_programa pro_a ON pro_a.cod_prog = zp_a.cod_prog "
                + "WHERE ee.cod_envio = '" + codEnvio + "' AND ee.estado = 'E' AND eh.estado = 1 "
                + "AND TO_CHAR(eh.fec_envio + 2, 'YYYYMMDD') < TO_CHAR(ea.fec_termina, 'YYYYMMDD') "
                + "AND NOT(ea.cod_envio = ee.cod_envio) AND ea.estado = 'E' "
                + "AND sa.estado = 1 AND sa.fec_envio <= eh.fec_envio "
                + "GROUP BY ee.apellidos, ee.nombres, ee.tipo_iden, ee.identificacion, "
                + "pro.nom_prog, ea.fec_inicia, ea.fec_termina, "
                + "pro_a.nom_prog, ee.fec_inicia, ee.fec_termina "
                + "ORDER BY ee.apellidos, ee.nombres, DECODE(ee.tipo_iden, 'C','C.C.', 'T','T.I',ee.tipo_iden), ee.identificacion ");

        List<SheetExcel> sheets = new ArrayList<>();
        ColumTypes[] cls = new ColumTypes[]{
            new ColumTypes(ColumTypes.TYPE_TEXT, "APELLIDOS", null),
            new ColumTypes(ColumTypes.TYPE_TEXT, "NOMBRES", null),
            new ColumTypes(ColumTypes.TYPE_TEXT, "SEXO_A", null),
            new ColumTypes(ColumTypes.TYPE_TEXT, "TIPO_IDENT", null),
            new ColumTypes(ColumTypes.TYPE_NUMBER, "IDENTIFICACION", null, Long.class),
            new ColumTypes(ColumTypes.TYPE_TEXT, "NOM_PROG", null),
            new ColumTypes(ColumTypes.TYPE_NUMBER, "SEMESTRE_A", null),
            new ColumTypes(ColumTypes.TYPE_DATE, "FEC_INICIA", null),
            new ColumTypes(ColumTypes.TYPE_DATE, "FEC_TERMINA", null),
            new ColumTypes(ColumTypes.TYPE_TEXT, "PERIODICIDAD", null),
            new ColumTypes(ColumTypes.TYPE_DECIMAL, "DURACION_MESES", null),
            new ColumTypes(ColumTypes.TYPE_TEXT, "JORNADA", null),
            new ColumTypes(ColumTypes.TYPE_TEXT, "ZONA", null),
            new ColumTypes(ColumTypes.TYPE_NUMBER, "COD PERIODO", null),
            new ColumTypes(ColumTypes.TYPE_TEXT, "NOMBRE PERIODO", null),
            new ColumTypes(ColumTypes.TYPE_TEXT, "ESTADO MATRICULA", null)
        };
        sheets.add(new SheetExcel("SEMESTRAL", new TableExcel(cls, dataSemestral)));
        sheets.add(new SheetExcel("ANUAL", new TableExcel(cls, dataAnual)));

        List<TableExcel> tbls = new ArrayList<>();
        /*DATOS TOTALES*/
        Object[][] dataTotales = new Object[3][2];
        dataTotales[0][0] = "SEMESTRAL";
        dataTotales[0][1] = dataSemestral.length;
        dataTotales[1][0] = "ANUAL";
        dataTotales[1][1] = dataAnual.length;
        dataTotales[2][0] = "TOTAL";
        dataTotales[2][1] = dataSemestral.length + dataAnual.length;
        tbls.add(new TableExcel(new ColumTypes[]{
            new ColumTypes(ColumTypes.TYPE_TEXT, "Reporte", null),
            new ColumTypes(ColumTypes.TYPE_NUMBER, "Estudiantes", null)
        }, dataTotales));
        /*DATOS TOTALES*/
 /*ESTUDIANTES CON MAS DE UNA CARRERA EN EL ENVIO*/
        tbls.add(new TableExcel(new ColumTypes[]{
            new ColumTypes(ColumTypes.TYPE_TEXT, "APELLIDOS", null),
            new ColumTypes(ColumTypes.TYPE_TEXT, "NOMBRES", null),
            new ColumTypes(ColumTypes.TYPE_TEXT, "TIPO_IDENT", null),
            new ColumTypes(ColumTypes.TYPE_NUMBER, "IDENTIFICACION", null, Long.class)
        }, dataEstMasDeUnaMatricual != null ? dataEstMasDeUnaMatricual : new Object[0][]));
        /*ESTUDIANTES CON MAS DE UNA CARRERA EN EL ENVIO*/
 /*ESTUDIANTES REPORTADOS ANTES - QUE AUN ESTAN VIGENTES*/
        tbls.add(new TableExcel(new ColumTypes[]{
            new ColumTypes(ColumTypes.TYPE_TEXT, "APELLIDOS", null),
            new ColumTypes(ColumTypes.TYPE_TEXT, "NOMBRES", null),
            new ColumTypes(ColumTypes.TYPE_TEXT, "TIPO_IDENT", null),
            new ColumTypes(ColumTypes.TYPE_NUMBER, "IDENTIFICACION", null, Long.class),
            new ColumTypes(ColumTypes.TYPE_TEXT, "PROGRAMA ANTERIOR", null)
        }, dataEstReportadosAntes != null ? dataEstReportadosAntes : new Object[0][]));
        /*ESTUDIANTES REPORTADOS ANTES - QUE AUN ESTAN VIGENTES*/
        sheets.add(new SheetExcel("NOTAS", tbls));
        new WriteExcel().write(path, "rpte_polizas", sheets);
    }

    private void generatePlainSql(String codEnvio, String path) {
        try {
            String text = "--------------------------------------------------------------------------------------------------------------------------------------------\n"
                    + "-------------------------ENVIO DE POLIZAS-----------------------------\n"
                    + "----------------------" + new SimpleDateFormat("dd/MM/yyyy").format(new Date()) + " TecnoSmartTools----------------------\n"
                    + "------------------------TRABAJAR EN SYSADM----------------------------\n"
                    + "----------------------------------------------------------------------\n"
                    + "\n"
                    + "\n"
                    + "----------------------CREAR ENVIO DE ESTUDIANTES---------------------------------\n"
                    + "SELECT * FROM SISTEMAS.SE_ENVIO ORDER BY COD_ENVIO DESC;\n"
                    + "\n"
                    + "INSERT INTO SISTEMAS.SE_ENVIO (cod_envio, fec_crea, fec_envio, detalle, estado) SELECT (NVL(MAX(se.cod_envio), 0) + 1),  SYSDATE, SYSDATE, 'EN PROCESO', 0 FROM SISTEMAS.SE_ENVIO SE;\n"
                    + "COMMIT;\n"
                    + "\n"
                    + "---REGISTRAR ESTUDIANTES PENDIENTES\n"
                    + "--COD_CREDI 6 MATRICULA REGULAR\n"
                    + "--COD_CREDI 11 50% DE LA MATRICULA\n"
                    + "--COD_CREDI 9 EGRESADO\n"
                    + "\n"
                    + "\n"
                    + "INSERT INTO sistemas.se_estudiantes(cod_envio, num_mat, cod_zonpro, \n"
                    + "identificacion, tipo_iden, nombres, \n"
                    + "apellidos, fec_inicia, fec_termina, \n"
                    + "periodicidad, estado)\n"
                    + "SELECT '" + codEnvio + "' AS envio, m.num_mat, m.cod_zonpro, \n"
                    + "e.identificacion, e.tipo_iden, UPPER(TRIM(e.nombres)), \n"
                    + "UPPER(TRIM(e.apellidos)), per.inicia, per.termina, \n"
                    + "(CASE WHEN MONTHS_BETWEEN(per.termina, per.inicia)>=7 THEN 'ANUAL' ELSE 'SEMESTRAL' END) AS periodicidad, 'P' As estado \n"
                    + "FROM re_matricula m \n"
                    + "INNER JOIN ca_credito cr ON cr.num_mat = m.num_mat -- Actualizacion de credito\n"
                    + "INNER JOIN re_estudiante e ON e.cod_est = m.cod_est \n"
                    + "INNER JOIN re_periodo per ON per.cod_per = m.cod_per \n"
                    + "LEFT JOIN sistemas.se_estudiantes ee ON ee.num_mat = m.num_mat \n"
                    + "LEFT JOIN sistemas.se_envio se ON se.cod_envio = ee.cod_envio \n"
                    + "LEFT JOIN sistemas.se_estudiantes_no en ON en.num_mat = m.num_mat \n"
                    + "WHERE TO_CHAR(SYSDATE + 2, 'YYYYMMDD') < TO_CHAR(per.termina, 'YYYYMMDD') -- PARA PERIODOS QUE VENCEN MINIMO DENTRO DE DOS DIAS\n"
                    + "AND (m.estado = 'M' OR (m.estado IN('E', 'G', 'P', 'S', 'X') AND cr.estado IN('T', 'C'))) \n"
                    + "AND cr.COD_CREDI IN(6,11,9)\n"
                    + "AND (ee.num_mat IS NULL OR se.estado = -1 OR (se.estado = 1 AND ee.estado = 'N')) \n"
                    + "AND en.num_mat IS NULL \n"
                    + "--AND NOT(per.cod_per = 215)\n"
                    + ";\n"
                    + "\n"
                    + "COMMIT;\n"
                    + "\n"
                    + "---Actualizar estado de envío\n"
                    + "\n"
                    + "UPDATE sistemas.se_estudiantes ee \n"
                    + "SET ee.estado = 'E' \n"
                    + "WHERE ee.cod_envio = '" + codEnvio + "' AND ee.estado = 'P' \n"
                    + ";\n"
                    + "COMMIT;\n"
                    + "---Actualizar estado de envío\n"
                    + "UPDATE sistemas.se_envio se \n"
                    + "SET se.estado = 1, fec_envio = SYSDATE, detalle = 'PROCESO COMPLETADO CON EXITO' \n"
                    + "WHERE se.cod_envio = '" + codEnvio + "' AND se.estado = 0 \n"
                    + ";\n"
                    + "COMMIT;\n"
                    + "\n"
                    + "\n"
                    + "----------------------------------------------------------------------------------------------\n"
                    + "---------------------------ENVIO CON TABLA ALMACENADA-----------------------------------------\n"
                    + "----------------------------------------------------------------------------------------------\n"
                    + "\n"
                    + "--OBSERVACION ENVIO " + codEnvio + " SE REPITEN\n"
                    + "SELECT ee.apellidos, ee.nombres, e.sexo AS sexo_A, \n"
                    + "DECODE(ee.tipo_iden, 'C','C.C.', 'T','T.I',ee.tipo_iden) AS tipo_ident, ee.identificacion, pro.nom_prog, \n"
                    + "m.semestre AS semestre_A, ee.fec_inicia, ee.fec_termina, \n"
                    + "ee.periodicidad, ROUND(MONTHS_BETWEEN(ee.fec_termina, ee.fec_inicia), 2) AS duracion_meses, DECODE(pro.jornada, 'D', 'DIURNO', 'N', 'NOCTURNO', pro.jornada) AS jornada, \n"
                    + "zn.nombre AS zona\n"
                    + "FROM sistemas.se_estudiantes ee \n"
                    + "INNER JOIN re_matricula m ON m.num_mat = ee.num_mat \n"
                    + "INNER JOIN re_estudiante e ON e.cod_est = m.cod_est \n"
                    + "INNER JOIN re_zon_pro zp ON zp.cod_zonpro = ee.cod_zonpro \n"
                    + "INNER JOIN re_programa pro ON pro.cod_prog = zp.cod_prog \n"
                    + "INNER JOIN re_zona zn ON zn.cod_zona = zp.cod_zona \n"
                    + "WHERE ee.cod_envio = '" + codEnvio + "' AND ee.estado = 'E' \n"
                    + "ORDER BY ee.periodicidad DESC, pro.nom_prog, ee.cod_zonpro, ee.apellidos, ee.nombres \n"
                    + "--ORDER BY periodicidad DESC, TO_CHAR(ee.fec_inicia, 'YYYYMMDD'), m.cod_per, pro.nom_prog, ee.cod_zonpro \n"
                    + ";\n"
                    + "\n"
                    + "----------------------------------------------------------------------------------------------\n"
                    + "---------------------------ESTUDIANTES CON MAS DE UNA CARRERA EN EL ENVIO---------------------\n"
                    + "----------------------------------------------------------------------------------------------\n"
                    + "\n"
                    + "SELECT ee.apellidos, ee.nombres, DECODE(ee.tipo_iden, 'C','C.C.', 'T','T.I',ee.tipo_iden) AS tipo_ident, ee.identificacion \n"
                    + "FROM sistemas.se_estudiantes ee \n"
                    + "WHERE ee.cod_envio = '" + codEnvio + "' AND ee.estado = 'E' \n"
                    + "GROUP BY ee.apellidos, ee.nombres, ee.tipo_iden, ee.identificacion \n"
                    + "HAVING COUNT(1) > 1 \n"
                    + "ORDER BY ee.apellidos, ee.nombres, DECODE(ee.tipo_iden, 'C','C.C.', 'T','T.I',ee.tipo_iden), ee.identificacion \n"
                    + ";\n"
                    + "\n"
                    + "----------------------------------------------------------------------------------------------\n"
                    + "---------------------ESTUDIANTES REPORTADOS ANTES - QUE AUN ESTAN VIGENTES--------------------\n"
                    + "----------------------------------------------------------------------------------------------\n"
                    + "\n"
                    + "SELECT ee.apellidos, ee.nombres, DECODE(ee.tipo_iden, 'C','C.C.', 'T','T.I',ee.tipo_iden) AS tipo_ident, ee.identificacion, \n"
                    + "pro.nom_prog AS programa_anterior, ea.fec_inicia AS inicio_anterior, ea.fec_termina AS final_anterior, \n"
                    + "pro_a.nom_prog AS programa_nuevo, ee.fec_inicia inicio_nuevo, ee.fec_termina AS final_nuevo \n"
                    + "FROM sistemas.se_estudiantes ee \n"
                    + "INNER JOIN sistemas.se_envio eh ON eh.cod_envio = ee.cod_envio \n"
                    + "INNER JOIN sistemas.se_estudiantes ea ON ea.identificacion = ee.identificacion \n"
                    + "INNER JOIN sistemas.se_envio sa ON sa.cod_envio = ea.cod_envio \n"
                    + "INNER JOIN re_zon_pro zp ON zp.cod_zonpro = ea.cod_zonpro \n"
                    + "INNER JOIN re_programa pro ON pro.cod_prog = zp.cod_prog \n"
                    + "INNER JOIN re_zon_pro zp_a ON zp_a.cod_zonpro = ee.cod_zonpro -- Envio Actual\n"
                    + "INNER JOIN re_programa pro_a ON pro_a.cod_prog = zp_a.cod_prog -- Envio Actual\n"
                    + "WHERE ee.cod_envio = '" + codEnvio + "' AND ee.estado = 'E' AND eh.estado = 1 \n"
                    + "--AND TO_CHAR(SYSDATE + 2, 'YYYYMMDD') < TO_CHAR(ea.fec_termina, 'YYYYMMDD')\n"
                    + "AND TO_CHAR(eh.fec_envio + 2, 'YYYYMMDD') < TO_CHAR(ea.fec_termina, 'YYYYMMDD')\n"
                    + "AND NOT(ea.cod_envio = ee.cod_envio) AND ea.estado = 'E' \n"
                    + "AND sa.estado = 1 AND sa.fec_envio <= eh.fec_envio \n"
                    + "GROUP BY ee.apellidos, ee.nombres, ee.tipo_iden, ee.identificacion, \n"
                    + "pro.nom_prog, ea.fec_inicia, ea.fec_termina, \n"
                    + "pro_a.nom_prog, ee.fec_inicia, ee.fec_termina \n"
                    + "---HAVING COUNT(1) > 1 \n"
                    + "ORDER BY ee.apellidos, ee.nombres, DECODE(ee.tipo_iden, 'C','C.C.', 'T','T.I',ee.tipo_iden), ee.identificacion \n"
                    + ";\n";
            new WritePlain().write(txtPatSql.getText() + txt_nom_sql.getText(), text);
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }

    private String getPath() {
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.showSaveDialog(null);
        return f.getSelectedFile() != null ? f.getSelectedFile() + "\\" : "";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearEnvio;
    private javax.swing.JButton btnPathSql;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblNuevoEnvio;
    private javax.swing.JLabel lblPathSvnGuardarSql;
    private javax.swing.JLabel lblPathSvnGuardarXls;
    private javax.swing.JProgressBar pgBar;
    private Utils.controls.PlaceholderText txtPatSql;
    private Utils.controls.PlaceholderText txtPatXls;
    private Utils.controls.PlaceholderText txt_nom_sql;
    private Utils.controls.PlaceholderText txt_nom_xls;
    // End of variables declaration//GEN-END:variables
}
