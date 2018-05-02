package options.admisiones;

import SQL.ExecuteSql;
import Utils.Dialogs;
import WriteFiles.Excel.ColumTypes;
import WriteFiles.Excel.WriteExcel;
import java.util.ArrayList;
import java.util.List;

public class pnlAdmisionesIngCivil extends javax.swing.JPanel {

    public pnlAdmisionesIngCivil() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlGeneral = new javax.swing.JPanel();
        btnListar = new javax.swing.JButton();
        btnPaso1Xls = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblTotalInscritos = new javax.swing.JLabel();
        tblLstGral = new Utils.tblControls.pnlTabla();
        pnlIcfes = new javax.swing.JPanel();
        lblTotalIcfes = new javax.swing.JLabel();
        tblMejorIcfes = new Utils.tblControls.pnlTabla();
        jLabel6 = new javax.swing.JLabel();
        btnIcfes = new javax.swing.JButton();
        btnExcelPaso2 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnRegistraNoAdmitidos = new javax.swing.JButton();
        pnlCurso = new javax.swing.JPanel();
        btnListarCursos = new javax.swing.JButton();
        btnGenerarCursos = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnRegistrarAdmitidos = new javax.swing.JButton();
        tblMejorCurso = new Utils.tblControls.pnlTabla();
        tblTotalMcurso = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPeriodo = new Utils.controls.IntegerTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNumestudiantesIcfes = new Utils.controls.IntegerTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNCursos = new Utils.controls.IntegerTextField();
        jLabel8 = new javax.swing.JLabel();
        lblCupos = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblOpcionales = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCCCivil = new javax.swing.JTextField();
        txtPrograma = new javax.swing.JTextField();

        pnlGeneral.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado General"));
        pnlGeneral.setLayout(new java.awt.GridBagLayout());

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlGeneral.add(btnListar, gridBagConstraints);

        btnPaso1Xls.setText("Generar Excel");
        btnPaso1Xls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaso1XlsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pnlGeneral.add(btnPaso1Xls, gridBagConstraints);

        jLabel5.setText("Total Inscritos:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlGeneral.add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlGeneral.add(lblTotalInscritos, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pnlGeneral.add(tblLstGral, gridBagConstraints);

        pnlIcfes.setBorder(javax.swing.BorderFactory.createTitledBorder("Mejores Icfes"));
        pnlIcfes.setPreferredSize(new java.awt.Dimension(468, 503));
        pnlIcfes.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlIcfes.add(lblTotalIcfes, gridBagConstraints);

        tblMejorIcfes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblMejorIcfesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pnlIcfes.add(tblMejorIcfes, gridBagConstraints);

        jLabel6.setText("Total Icfes:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlIcfes.add(jLabel6, gridBagConstraints);

        btnIcfes.setText("Listar");
        btnIcfes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIcfesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlIcfes.add(btnIcfes, gridBagConstraints);

        btnExcelPaso2.setText("Generar Excel");
        btnExcelPaso2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelPaso2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        pnlIcfes.add(btnExcelPaso2, gridBagConstraints);

        jButton2.setText("Generar listado No Admitidos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlIcfes.add(jButton2, gridBagConstraints);

        btnRegistraNoAdmitidos.setText("Registrar No Admitidos");
        btnRegistraNoAdmitidos.setMaximumSize(new java.awt.Dimension(171, 23));
        btnRegistraNoAdmitidos.setMinimumSize(new java.awt.Dimension(171, 23));
        btnRegistraNoAdmitidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistraNoAdmitidosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlIcfes.add(btnRegistraNoAdmitidos, gridBagConstraints);

        pnlCurso.setBorder(javax.swing.BorderFactory.createTitledBorder("Mejores Cursos"));
        pnlCurso.setMinimumSize(new java.awt.Dimension(468, 503));
        pnlCurso.setLayout(new java.awt.GridBagLayout());

        btnListarCursos.setText("Listar");
        btnListarCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarCursosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlCurso.add(btnListarCursos, gridBagConstraints);

        btnGenerarCursos.setText("Generar Excel");
        btnGenerarCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarCursosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pnlCurso.add(btnGenerarCursos, gridBagConstraints);

        jLabel7.setText("Total Curso:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        pnlCurso.add(jLabel7, gridBagConstraints);

        btnRegistrarAdmitidos.setText("Registrar Admitidos");
        btnRegistrarAdmitidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAdmitidosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        pnlCurso.add(btnRegistrarAdmitidos, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pnlCurso.add(tblMejorCurso, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        pnlCurso.add(tblTotalMcurso, gridBagConstraints);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Parametros"));

        jLabel1.setText("Periodo:");

        txtPeriodo.setText("217");
        txtPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPeriodoActionPerformed(evt);
            }
        });

        jLabel3.setText("Programa:");

        jLabel2.setText("No Estudiantes Icfes:");

        txtNumestudiantesIcfes.setText("100");

        jLabel4.setText("No Estudiantes Curso:");

        jLabel8.setText("CUPOS:");

        lblCupos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setText("OPCIONALES:");

        lblOpcionales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setText("CC Director Civil:");

        txtPrograma.setText("531");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumestudiantesIcfes, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCupos, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOpcionales, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCCCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(txtPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3)
                .addComponent(jLabel2)
                .addComponent(txtNumestudiantesIcfes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel4)
                .addComponent(txtNCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel8)
                .addComponent(lblCupos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblOpcionales, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel10)
                .addComponent(txtCCCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlIcfes, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnlGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlIcfes, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                    .addComponent(pnlCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        try {
            if (txtPeriodo.getValue() == null || txtPeriodo.getValue() == 0 || txtPeriodo.getValue() < 99) {
                throw new Exception("Ingrese un periodo valido");
            }

//--LISTADO ESTUDIANTES CON ICFES Y CURSO DE PRESELECCION
            Object[][] data = ExecuteSql.executeQuery("SELECT e.cod_est, e.apellidos||' '|| e.nombres nom,  "
                    + "DECODE(TRIM(TO_CHAR(sistemas.pkgadmisiones.promedioicfes(e.cod_est, z.cod_zonpro),'999,999.99')),'.00','0.0',"
                    + "nvl(TRIM(TO_CHAR(sistemas.pkgadmisiones.promedioicfes(e.cod_est, z.cod_zonpro),'999,999.99')),'0.0')) ICFES, "
                    + "("
                    + "    select d.puntaje "
                    + "    from SISTEMAS.RE_PRESELECCION p, SISTEMAS.RE_DET_PRESELECCION d  "
                    + "    where to_char(P.COD_INS) = Z.COD_INS "
                    + "    and D.CODPRESELECCION = P.CODPRESELECCION  "
                    + "    and D.COD_POL_CRIT = " + 418 + " "//11
                    + ") CURSO_PRESELECCION, "//--CURSO DE PRESELECCION
                    + "z.cod_ins  "
                    + "FROM SISTEMAS.re_estudiante e, SISTEMAS.re_admin_zonpro z  "
                    + "WHERE e.cod_est = z.cod_est  "
                    + "and z.cod_per=" + txtPeriodo.getValue() + "    "//--periodo
                    + "AND z.cod_zonpro=" + txtPrograma.getText() + " "//--programa 
                    + "and z.estado = 1      "//--estado
                    + "and Z.ACTIV = 1 "
                    + "ORDER BY TO_NUMBER(NVL(sistemas.pkgadmisiones.promedioicfes(e.cod_est, z.cod_zonpro),0)) desc");
            tblLstGral.update(new ColumTypes[]{
                new ColumTypes(ColumTypes.TYPE_TEXT, "Codigo", ""),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Nombres", ""),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Icfes", ""),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Preseleccion", ""),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Ins", "")
            }, data);
            lblTotalInscritos.setText(data.length + "");
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnIcfesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIcfesActionPerformed
        try {
            if (txtPeriodo.getValue() == null || txtPeriodo.getValue() == 0 || txtPeriodo.getValue() < 99) {
                throw new Exception("Ingrese un periodo valido");
            }
            if (txtNumestudiantesIcfes.getValue() == null || txtNumestudiantesIcfes.getValue() < 0) {
                throw new Exception("Ingrese un valor valido para numero de estudiantes ICFES");
            }
            //--LISTADO ESTUDIANTES CON ICFES Y CURSO DE PRESELECCION
            Object[][] data = ExecuteSql.executeQuery("SELECT COD_EST,NOM,ICFES,CURSO_PRESELECCION,COD_INS FROM  "
                    + "( "
                    + "  SELECT e.cod_est, e.apellidos||' '|| e.nombres nom,  "
                    + "  DECODE(TRIM(TO_CHAR(sistemas.pkgadmisiones.promedioicfes(e.cod_est, z.cod_zonpro),'999,999.99')),'.00','0.0', "
                    + "  nvl(TRIM(TO_CHAR(sistemas.pkgadmisiones.promedioicfes(e.cod_est, z.cod_zonpro),'999,999.99')),'0.0')) ICFES,  "
                    + "  ( "
                    + "      select d.puntaje  "
                    + "      from SISTEMAS.RE_PRESELECCION p, SISTEMAS.RE_DET_PRESELECCION d   "
                    + "      where to_char(P.COD_INS) = Z.COD_INS  "
                    + "      and D.CODPRESELECCION = P.CODPRESELECCION   "
                    + "      and D.COD_POL_CRIT =11 "
                    + "  ) CURSO_PRESELECCION,  "
                    + "  z.cod_ins   "
                    + "  FROM SISTEMAS.re_estudiante e, SISTEMAS.re_admin_zonpro z   "
                    + "  WHERE e.cod_est = z.cod_est   "
                    + "  and z.cod_per=" + txtPeriodo.getValue() + " "
                    + "  AND z.cod_zonpro=" + txtPrograma.getText() + " "
                    + "  and z.estado = 1       "
                    + "  and Z.ACTIV = 1  "
                    + "  ORDER BY TO_NUMBER(NVL(sistemas.pkgadmisiones.promedioicfes(e.cod_est, z.cod_zonpro),0)) desc "
                    + ")WHERE ROWNUM<=" + txtNumestudiantesIcfes.getValue());
            tblMejorIcfes.update(new ColumTypes[]{
                new ColumTypes(ColumTypes.TYPE_TEXT, "Codigo", ""),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Nombres", ""),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Icfes", ""),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Preseleccion", ""),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Ins", "")

            }, data);
            lblTotalIcfes.setText(data.length + "");
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_btnIcfesActionPerformed

    private void btnPaso1XlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaso1XlsActionPerformed
        try {
            ColumTypes[] cs = tblLstGral.getColumns();
            Object[][] dat = tblLstGral.getData();
            new WriteExcel().write("Datos", "Etudiantes Listado", cs, dat);
        } catch (Exception e) {
            e.printStackTrace();
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_btnPaso1XlsActionPerformed

    private void btnExcelPaso2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelPaso2ActionPerformed
        try {
            new WriteExcel().write("Datos", "Etudiantes Icfes", tblMejorIcfes.getColumns(), tblMejorIcfes.getData());
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_btnExcelPaso2ActionPerformed

    private void btnListarCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarCursosActionPerformed
        try {
            if (txtPeriodo.getValue() == null || txtPeriodo.getValue() == 0 || txtPeriodo.getValue() < 99) {
                throw new Exception("Ingrese un periodo valido");
            }
            if (txtNCursos.getValue() == null || txtNCursos.getValue() < 0) {
                throw new Exception("Ingrese un valor valido para numero de Filtrar estudiantes curso");
            }
            Object[][] data = ExecuteSql.executeQuery("SELECT COD_EST,NOM,ICFES,CURSO_PRESELECCION,COD_INS FROM  "
                    + "( "
                    + "  SELECT e.cod_est, e.apellidos||' '|| e.nombres nom,  "
                    + "  DECODE(TRIM(TO_CHAR(sistemas.pkgadmisiones.promedioicfes(e.cod_est, z.cod_zonpro),'999,999.99')),'.00','0.0', "
                    + "  nvl(TRIM(TO_CHAR(sistemas.pkgadmisiones.promedioicfes(e.cod_est, z.cod_zonpro),'999,999.99')),'0.0')) ICFES,  "
                    + "  ( "
                    + "      select d.puntaje  "
                    + "      from SISTEMAS.RE_PRESELECCION p, SISTEMAS.RE_DET_PRESELECCION d   "
                    + "      where to_char(P.COD_INS) = Z.COD_INS  "
                    + "      and D.CODPRESELECCION = P.CODPRESELECCION   "
                    + "      and D.COD_POL_CRIT =11 "
                    + "  ) CURSO_PRESELECCION,  "
                    + "  z.cod_ins   "
                    + "  FROM SISTEMAS.re_estudiante e, SISTEMAS.re_admin_zonpro z   "
                    + "  WHERE e.cod_est = z.cod_est   "
                    + "  and z.cod_per=" + txtPeriodo.getValue() + " "
                    + "  AND z.cod_zonpro=" + txtPrograma.getText() + " "
                    + "  and z.estado = 1       "
                    + "  and Z.ACTIV = 1  "
                    + "  ORDER BY CURSO_PRESELECCION desc "
                    + ")WHERE ROWNUM<=" + txtNCursos.getValue());
            tblMejorCurso.update(new ColumTypes[]{
                new ColumTypes(ColumTypes.TYPE_TEXT, "Codigo", ""),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Nombres", ""),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Icfes", ""),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Preseleccion", ""),
                new ColumTypes(ColumTypes.TYPE_TEXT, "Ins", "")
            }, data);
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_btnListarCursosActionPerformed

    private void btnGenerarCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarCursosActionPerformed
        try {
            new WriteExcel().write("Curso", "Etudiantes Curso", tblMejorCurso.getColumns(), tblMejorCurso.getData());
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }

    }//GEN-LAST:event_btnGenerarCursosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            Object[][] dataTblGeneral = tblLstGral.getData();
            Object[][] dataIcfes = tblMejorIcfes.getData();
            List<Object[]> dataNoAdmitidos = new ArrayList<>();
            for (Object[] rowGral : dataTblGeneral) {
                String codInsGral = rowGral[4].toString();
                boolean exist = false;
                for (Object[] rowIcf : dataIcfes) {
                    String codInsIcf = rowIcf[4].toString();
                    exist = codInsGral.equals(codInsIcf) ? true : exist;
                }
                if (!exist) {
                    dataNoAdmitidos.add(rowGral);
                }
            }
            new WriteExcel().write("No Admitidos", "Etudiantes No Admitidos", tblMejorIcfes.getColumns(), dataNoAdmitidos.toArray(new Object[0][]));
        } catch (Exception e) {

            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnRegistraNoAdmitidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistraNoAdmitidosActionPerformed
        try {
            if (Dialogs.okCancel(this, "Se registraran los 'NO ADMITIDOS' y los demas pasaran a 'En Proceso' ¿Continuar?")) {
                Object[][] dataTblGeneral = tblLstGral.getData();
                Object[][] dataIcfes = tblMejorIcfes.getData();
                List<Object[]> dataNoAdmitidos = new ArrayList<>();
                for (Object[] rowGral : dataTblGeneral) {
                    String codInsGral = rowGral[4].toString();
                    boolean exist = false;
                    for (Object[] rowIcf : dataIcfes) {
                        String codInsIcf = rowIcf[4].toString();
                        exist = codInsGral.equals(codInsIcf) ? true : exist;
                    }
                    if (!exist) {
                        dataNoAdmitidos.add(rowGral);
                    }
                }
                String codInssNoAdmitidos = "";//5 no admitido
                for (Object[] dataNoAdmitido : dataNoAdmitidos) {
                    String codIns = dataNoAdmitido[4].toString();
                    codInssNoAdmitidos += codIns + ",";
                }
                String codInssEnProceso = "";
                for (Object[] dataIcfe : dataIcfes) {//6 en proceso
                    String codIns = dataIcfe[4].toString();
                    codInssEnProceso += codIns + ",";
                }
                ExecuteSql.update("UPDATE RE_ADMIN_ZONPRO SET ESTADO = 5 WHERE COD_INS IN (" + codInssNoAdmitidos.substring(0, codInssNoAdmitidos.length() - 1) + ")");
                ExecuteSql.update("UPDATE RE_ADMIN_ZONPRO SET ESTADO = 6 WHERE COD_INS IN (" + codInssEnProceso.substring(0, codInssEnProceso.length() - 1) + ")");
            }
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_btnRegistraNoAdmitidosActionPerformed

    private void btnRegistrarAdmitidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAdmitidosActionPerformed
        try {
            if (Dialogs.okCancel(this, "Se registraran los 'ADMITIDOS' ¿Continuar? Para los opcionles hacer el proceso desde la plataforma.")) {
                Object[][] dataAdmitidos = tblMejorCurso.getData();
                String codInsAdmitidos = "";//2 Admitido
                for (Object[] rowGral : dataAdmitidos) {
                    String codInsGral = rowGral[4].toString();
                    codInsAdmitidos += codInsGral + ",";
                }
                ExecuteSql.update("UPDATE RE_ADMIN_ZONPRO SET ESTADO = 2 WHERE COD_INS IN (" + codInsAdmitidos.substring(0, codInsAdmitidos.length() - 1) + ")");

                for (Object[] rowGral : dataAdmitidos) {
                    String codEst = rowGral[0].toString();
                    String nomEst = rowGral[1].toString();
                    String Icfes = rowGral[2].toString();
                    String cursoPresel = rowGral[3].toString();
                    String codInsGral = rowGral[4].toString();
                    //codigo de preseleccion para los admitidos
                    String codPresel = ExecuteSql.executeQuery("select sistemas.seq_preseleccion.nextval from dual")[0][0].toString();
                    String codPreselHistorico = ExecuteSql.executeQuery("SELECT MAX(CODIGOCONSECUTIVO)+1 FROM SISTEMAS.RE_PRESELECCION_HISTORICO")[0][0].toString();

                    String sqlInsertRePreselCurso = "INSERT INTO SISTEMAS.RE_PRESELECCION VALUES('" + codPresel + "', '" + codEst + "',  '" + codInsGral + "', '" + txtPrograma.getText() + "', " + cursoPresel + ",sysdate,'" + txtCCCivil.getText() + "')";
                    String sqlInsertRePreselIcfes = "INSERT INTO SISTEMAS.RE_PRESELECCION VALUES('" + codPresel + "', '" + codEst + "',  '" + codInsGral + "', '" + txtPrograma.getText() + "', " + Icfes + ", sysdate, '" + txtCCCivil.getText() + "')";
                    ExecuteSql.insert(sqlInsertRePreselCurso);
                    ExecuteSql.insert(sqlInsertRePreselIcfes);
                    //HISTORICO DE PRESELECCION
                    ExecuteSql.insert("INSERT INTO SISTEMAS.RE_PRESELECCION_HISTORICO VALUES('" + codPresel + "', '" + codEst + "', '" + codInsGral + "', '" + txtPrograma.getText() + "', " + cursoPresel + ", sysdate, '" + txtCCCivil.getText() + "', '" + sqlInsertRePreselCurso + "', '" + codPreselHistorico + "')");
                    ExecuteSql.insert("INSERT INTO SISTEMAS.RE_PRESELECCION_HISTORICO VALUES('" + codPresel + "', '" + codEst + "', '" + codInsGral + "', '" + txtPrograma.getText() + "', " + Icfes + ", sysdate, '" + txtCCCivil.getText() + "', '" + sqlInsertRePreselIcfes + "', '" + codPreselHistorico + "')");
                }
            }
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_btnRegistrarAdmitidosActionPerformed

    private void txtPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPeriodoActionPerformed
        try {
            Object[][] cps = ExecuteSql.executeQuery("SELECT TOTAL_CUPOS,TOTAL_OPCIONALES FROM RE_CUPO_ADMISION WHERE COD_PER = " + txtPeriodo.getValue() + " AND COD_ZONPRO = " + txtPrograma.getText() + "");
            if (cps == null || cps.length == 0) {
                throw new Exception("No estan parametrizados los cupos en registro y control");
            }
            lblCupos.setText("" + cps[0][0]);
            lblOpcionales.setText("" + cps[0][1]);
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_txtPeriodoActionPerformed

    private void tblMejorIcfesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblMejorIcfesActionPerformed
        System.out.println(" xxxxxxxxxxxxxxxx");
    }//GEN-LAST:event_tblMejorIcfesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcelPaso2;
    private javax.swing.JButton btnGenerarCursos;
    private javax.swing.JButton btnIcfes;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnListarCursos;
    private javax.swing.JButton btnPaso1Xls;
    private javax.swing.JButton btnRegistraNoAdmitidos;
    private javax.swing.JButton btnRegistrarAdmitidos;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCupos;
    private javax.swing.JLabel lblOpcionales;
    private javax.swing.JLabel lblTotalIcfes;
    private javax.swing.JLabel lblTotalInscritos;
    private javax.swing.JPanel pnlCurso;
    private javax.swing.JPanel pnlGeneral;
    private javax.swing.JPanel pnlIcfes;
    private Utils.tblControls.pnlTabla tblLstGral;
    private Utils.tblControls.pnlTabla tblMejorCurso;
    private Utils.tblControls.pnlTabla tblMejorIcfes;
    private javax.swing.JLabel tblTotalMcurso;
    private javax.swing.JTextField txtCCCivil;
    private Utils.controls.IntegerTextField txtNCursos;
    private Utils.controls.IntegerTextField txtNumestudiantesIcfes;
    private Utils.controls.IntegerTextField txtPeriodo;
    private javax.swing.JTextField txtPrograma;
    // End of variables declaration//GEN-END:variables
}
