
import Utils.Dialogs;
import java.awt.BorderLayout;
import java.awt.Image;
import java.util.prefs.Preferences;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import options.Kardex.DificilCobro.pnlDifCobro;
import options.Kardex.pnlRecaudos;
import options.admisiones.pnlAdmisionesIngCivil;
import options.cfg.FrmCfg;
import options.contabilidad.polizas.pnlPolizas;
import options.elecciones.pnlMonitoreoElecciones;
import options.reportes.contabilidad.RpteAuxiliar;
import options.reportes.contabilidad.RpteComprobacionDeCuentas;
import options.reportes.kardex.RpteEstadosDeMats;
import options.reportes.kardex.RpteInconsitencias;
import options.reportes.kardex.RpteMenorCuantiaCreditos;
import options.reportes.kardex.RpteMenorCuantiaReintegros;
import options.reportes.kardex.RptePendienteafectarContabilidad;
import options.reportes.matriculas.RpteInscritos;
import options.reportesCnaCicle2017.PnlReportesEstudiantesAutoEvaluacion;
import options.reportesCnaCicle2017.PnlReportesFormaContrata;
import options.reportesCnaCicle2017.PnlReportesNivelEducacionProfes;

/**
 * @author Christian Onofre
 */
public class FrmMain extends javax.swing.JFrame implements TreeSelectionListener {

    public FrmMain() {
        initComponents();
        Preferences.userRoot().node("TecnosmartTools");
        crearArbol();
        setBackg();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();
        pnlContainer = new javax.swing.JPanel();
        lblBackground = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuRpteConta = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        rpt_auxiliar = new javax.swing.JMenuItem();
        rpte_comprobacion_cuentas = new javax.swing.JMenuItem();
        menuRpteKardex = new javax.swing.JMenu();
        rpt_inconsistencias = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        rpt_menor_cuantia_reintegros = new javax.swing.JMenuItem();
        rpt_menor_cuantia_credito = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuCfg = new javax.swing.JMenu();
        cfg = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(tree);

        pnlContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlContainer.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pnlContainer.add(lblBackground, gridBagConstraints);

        menuRpteConta.setText("Reportes");

        jMenu2.setText("Contabilidad");

        rpt_auxiliar.setText("Rpt Auxiliar");
        rpt_auxiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rpt_auxiliarActionPerformed(evt);
            }
        });
        jMenu2.add(rpt_auxiliar);

        rpte_comprobacion_cuentas.setText("Rpte Comprobación de Cuentas");
        rpte_comprobacion_cuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rpte_comprobacion_cuentasActionPerformed(evt);
            }
        });
        jMenu2.add(rpte_comprobacion_cuentas);

        menuRpteConta.add(jMenu2);

        menuRpteKardex.setText("Kardex");

        rpt_inconsistencias.setText("Rpt Inconsitencias en Recaudos");
        rpt_inconsistencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rpt_inconsistenciasActionPerformed(evt);
            }
        });
        menuRpteKardex.add(rpt_inconsistencias);

        jMenu1.setText("Menor Cuantia");

        rpt_menor_cuantia_reintegros.setText("Rpte Menor Cuantia Reintegros");
        rpt_menor_cuantia_reintegros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rpt_menor_cuantia_reintegrosActionPerformed(evt);
            }
        });
        jMenu1.add(rpt_menor_cuantia_reintegros);

        rpt_menor_cuantia_credito.setText("Rpte Menor Cuantia Creditos");
        rpt_menor_cuantia_credito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rpt_menor_cuantia_creditoActionPerformed(evt);
            }
        });
        jMenu1.add(rpt_menor_cuantia_credito);

        menuRpteKardex.add(jMenu1);

        jMenuItem1.setText("Rpte Recaudos e inconsistencias sin afectar a contabilidad");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuRpteKardex.add(jMenuItem1);

        menuRpteConta.add(menuRpteKardex);

        jMenu3.setText("Inscripciones");

        jMenuItem2.setText("Rpte. Estados Matriculas por Periodo y Programa");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Rpte. Inscritos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        menuRpteConta.add(jMenu3);

        jMenuBar1.add(menuRpteConta);

        menuCfg.setText("Sistema");
        menuCfg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCfgActionPerformed(evt);
            }
        });

        cfg.setText("Configuración");
        cfg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cfgActionPerformed(evt);
            }
        });
        menuCfg.add(cfg);

        jMenuBar1.add(menuCfg);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                    .addComponent(pnlContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rpt_auxiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rpt_auxiliarActionPerformed
        try {
            new RpteAuxiliar(this, true).setVisible(true);
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_rpt_auxiliarActionPerformed

    private void rpt_inconsistenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rpt_inconsistenciasActionPerformed
        try {
            new RpteInconsitencias(this, true).setVisible(true);
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_rpt_inconsistenciasActionPerformed

    private void rpt_menor_cuantia_creditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rpt_menor_cuantia_creditoActionPerformed
        try {
            new RpteMenorCuantiaCreditos(this, true).setVisible(true);
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_rpt_menor_cuantia_creditoActionPerformed

    private void rpt_menor_cuantia_reintegrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rpt_menor_cuantia_reintegrosActionPerformed
        try {
            new RpteMenorCuantiaReintegros(this, true).setVisible(true);
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_rpt_menor_cuantia_reintegrosActionPerformed

    private void cfgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cfgActionPerformed
        try {
            new FrmCfg(this, true).setVisible(true);
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_cfgActionPerformed

    private void menuCfgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCfgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCfgActionPerformed

    private void rpte_comprobacion_cuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rpte_comprobacion_cuentasActionPerformed
        try {
            new RpteComprobacionDeCuentas(this, true).setVisible(true);
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_rpte_comprobacion_cuentasActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            new RptePendienteafectarContabilidad(this, true).setVisible(true);
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            new RpteEstadosDeMats(this, true).setVisible(true);
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            new RpteInscritos(this, true).setVisible(true);
        } catch (Exception e) {
            Dialogs.errorDialog(this, e);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FrmMain frm = new FrmMain();
                frm.setLocationRelativeTo(null);
                frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frm.setTitle("TecnoSmart Tools");
                frm.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cfg;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JMenu menuCfg;
    private javax.swing.JMenu menuRpteConta;
    private javax.swing.JMenu menuRpteKardex;
    private javax.swing.JPanel pnlContainer;
    private javax.swing.JMenuItem rpt_auxiliar;
    private javax.swing.JMenuItem rpt_inconsistencias;
    private javax.swing.JMenuItem rpt_menor_cuantia_credito;
    private javax.swing.JMenuItem rpt_menor_cuantia_reintegros;
    private javax.swing.JMenuItem rpte_comprobacion_cuentas;
    private javax.swing.JTree tree;
    // End of variables declaration//GEN-END:variables
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        String optSelected = tree.getSelectionPath().getLastPathComponent().toString();
        pnlContainer.setName("20");
        pnlContainer.setLayout(new BorderLayout());
        pnlContainer.removeAll();
        switch (optSelected) {
            case "Genera Polizas":
                pnlContainer.add(new pnlPolizas());
                break;
            case "Recaudos Duplicadios":
                pnlContainer.add(new pnlRecaudos());
                break;
            case "Dificil Cobro Revivido":
                pnlContainer.add(new pnlDifCobro());
                break;
            case "Monitoreo Elecciones":
                pnlContainer.add(new pnlMonitoreoElecciones());
                break;
            case "Admisiones Civil":
                pnlContainer.add(new pnlAdmisionesIngCivil());
                break;
            case "CNA Reportes Profes Nivel Edu":
                pnlContainer.add(new PnlReportesNivelEducacionProfes());
                break;
            case "CNA Reportes Estudiantes":
                pnlContainer.add(new PnlReportesEstudiantesAutoEvaluacion());
                break;
            case "CNA Reportes Profes Forma Contratacion":
                pnlContainer.add(new PnlReportesFormaContrata());
                break;

            default:
                pnlContainer.updateUI();
                break;
        }
        pnlContainer.revalidate();
        pnlContainer.repaint();
    }

    private void crearArbol() {
        DefaultMutableTreeNode folderRoot = new DefaultMutableTreeNode("TecnoSmart Tools");
        DefaultTreeModel modelo = new DefaultTreeModel(folderRoot);
        tree.setModel(modelo);
        tree.getSelectionModel().addTreeSelectionListener(this);

        DefaultMutableTreeNode folderConta = new DefaultMutableTreeNode("Contabilidad");
        modelo.insertNodeInto(folderConta, folderRoot, 0);
        modelo.insertNodeInto(new DefaultMutableTreeNode("Genera Polizas"), folderConta, 0);

        DefaultMutableTreeNode folderKardex = new DefaultMutableTreeNode("Kardex");
        modelo.insertNodeInto(folderKardex, folderRoot, 0);
        modelo.insertNodeInto(new DefaultMutableTreeNode("Recaudos Duplicadios"), folderKardex, 0);
        modelo.insertNodeInto(new DefaultMutableTreeNode("Dificil Cobro Revivido"), folderKardex, 0);

        DefaultMutableTreeNode folderElecciones = new DefaultMutableTreeNode("Elecciones");
        modelo.insertNodeInto(folderElecciones, folderRoot, 0);
        modelo.insertNodeInto(new DefaultMutableTreeNode("Monitoreo Elecciones"), folderElecciones, 0);
        //-----------
        DefaultMutableTreeNode folderAdmisiones = new DefaultMutableTreeNode("Admisiones");
        modelo.insertNodeInto(folderAdmisiones, folderRoot, 0);
        modelo.insertNodeInto(new DefaultMutableTreeNode("Admisiones Civil"), folderAdmisiones, 0);

        DefaultMutableTreeNode folderCna = new DefaultMutableTreeNode("CNA");
        modelo.insertNodeInto(folderCna, folderRoot, 0);
        modelo.insertNodeInto(new DefaultMutableTreeNode("CNA Reportes Profes Nivel Edu"), folderCna, 0);
        modelo.insertNodeInto(new DefaultMutableTreeNode("CNA Reportes Estudiantes"), folderCna, 0);
        modelo.insertNodeInto(new DefaultMutableTreeNode("CNA Reportes Profes Forma Contratacion"), folderCna, 0);
    }

    private void setBackg() {
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/icons/TecnoSmart_logo.png")); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(800, 400, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);
        lblBackground.setHorizontalAlignment(SwingConstants.CENTER);
        lblBackground.setIcon(imageIcon);
    }
}
