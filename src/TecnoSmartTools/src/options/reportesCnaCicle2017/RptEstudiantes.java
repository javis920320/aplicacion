/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package options.reportesCnaCicle2017;

import SQL.ExecuteSql;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author umariana
 */
public class RptEstudiantes implements Report<RptEstudiantes> {

    @Override
    public List<RptEstudiantes> getAllDataFromList(HashMap<String, Object> params) throws Exception {
        Integer anoIni = (Integer) params.get("anoIni");
        Integer anoFin = (Integer) params.get("anoFin");
        String codSnies = (String) params.get("codsSnies");
        String[] codsProgs = codSnies.replaceAll(" ", "").split(",");
        for (int i = 0; i < codsProgs.length; i++) {

        }
        Object[][] data = ExecuteSql.executeQuery("SELECT q2per.anio ins_annio "
                + "     , q2per.semestre ins_semestre "
                + "     , q2per.pro pro_consecutivo_ins "
                + "     , (SELECT USER_UMARIANA_MEN.PKG_CNA_CARGUE.num_Inscritos(q2per.anio,q2per.semestre,q2per.pro) FROM DUAL) cont_Incritos "
                + "     , (SELECT USER_UMARIANA_MEN.PKG_CNA_CARGUE.num_Admitidos(q2per.anio,q2per.semestre,q2per.pro) FROM DUAL) cont_Admitidos "
                + "     , (SELECT USER_UMARIANA_MEN.PKG_CNA_CARGUE.num_TotalMatriculados(q2per.anio,q2per.semestre,q2per.pro) FROM DUAL) cont_Matriculados "
                + "     , (SELECT USER_UMARIANA_MEN.PKG_CNA_CARGUE.num_Primiparos(q2per.anio,q2per.semestre,q2per.pro) FROM DUAL) cont_Primiparos "
                + "     , (SELECT USER_UMARIANA_MEN.PKG_CNA_CARGUE.num_Graduados(q2per.anio,q2per.semestre,q2per.pro) FROM DUAL) cont_Graduados "
                + "     , nvl((SELECT USER_UMARIANA_MEN.PKG_CNA_CARGUE.ESTUDIANTESRETIRADOS_NEW(q2per.anio,q2per.semestre,q2per.pro) FROM DUAL),0) retirados "
                + "     , nvl((SELECT USER_UMARIANA_MEN.PKG_CNA_CARGUE.NUM_EGRESADOS(q2per.anio,q2per.semestre,q2per.pro) FROM DUAL),0) cont_egresados "
                + "     , nvl((SELECT USER_UMARIANA_MEN.PKG_CNA_CARGUE.PORCENTAJEDESERCION(q2per.anio,q2per.semestre,q2per.pro) FROM DUAL),0) tasa_desercion "
                + "     , nvl((SELECT USER_UMARIANA_MEN.PKG_CNA_CARGUE.num_culminancarrera_new(q2per.anio,q2per.semestre,q2per.pro) FROM DUAL),0) culminan_carrera "
                + "FROM ( "
                + "    SELECT q1per.anio, q1per.semestre, " + codSnies + " pro, 0 con "
                + "    FROM ( "
                + "        SELECT DISTINCT TO_NUMBER(TO_CHAR(pe.INICIA,'yyyy')) anio "
                + "             , DECODE(TO_NUMBER(TO_CHAR(pe.INICIA,'mm')),1,'01',2,'01',3,'01',4,'01',5,'01',6,'01','02') semestre "
                + "        FROM RE_PERIODO pe "
                + "    )q1per "
                + "    WHERE q1per.anio >= " + anoIni + " "
                + "    and q1per.anio <= " + anoFin + " "
                + ") q2per "
                + "WHERE q2per.pro = " + codSnies + " "
                + "and q2per.anio >= " + anoIni + " "
                + "and q2per.anio <= " + anoFin + " "
                + "ORDER BY q2per.anio DESC, q2per.semestre DESC");

        List<RptEstudiantes> lstData = new ArrayList<>();
        return lstData;

    }

}
