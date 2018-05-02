package options.reportesCnaCicle2017;

import SQL.ExecuteSql;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RptProfesNivelEdu implements Report, Serializable {

    /**
     * @autor Christian ⁪Onofre [eonofre@umariana.edu.co]
     * @fecha 29/06/2017
     */
    private static final String DOCTORADO = "DOCTORADO";
    private static final String ESPECIALIZACION = "ESPECIALIZACION";
    private static final String MAESTRIA = "MAESTRIA";
    static final String OTRO = "OTRO";
    private static final String PREGRADO = "PREGRADO";
    static final String PRIMARIO = "PRIMARIO";
    static final String SECUNDARIO = "SECUNDARIO";
    private static final String TECNOLOGIA = "TECNOLOGIA";

    private Integer YEAR;
    private Integer PERIODO;
    private String DEDICACION;
    private Integer TOTAL;
    private Integer DOCTORES;
    private Integer MAGISTERES;
    private Integer ESPECIALISTAS;
    private Integer PROFESIONALES;
    private Integer TECNOLOGOS;
    private Integer TECNICOS;
    private Integer SIN_CLASIFICAR;

    public Integer getYEAR() {
        return YEAR;
    }

    public void setYEAR(Integer YEAR) {
        this.YEAR = YEAR;
    }

    public Integer getPERIODO() {
        return PERIODO;
    }

    public void setPERIODO(Integer PERIODO) {
        this.PERIODO = PERIODO;
    }

    public String getDEDICACION() {
        return DEDICACION;
    }

    public void setDEDICACION(String DEDICACION) {
        this.DEDICACION = DEDICACION;
    }

    public Integer getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(Integer TOTAL) {
        this.TOTAL = TOTAL;
    }

    public Integer getDOCTORES() {
        return DOCTORES;
    }

    public void setDOCTORES(Integer DOCTORES) {
        this.DOCTORES = DOCTORES;
    }

    public Integer getMAGISTERES() {
        return MAGISTERES;
    }

    public void setMAGISTERES(Integer MAGISTERES) {
        this.MAGISTERES = MAGISTERES;
    }

    public Integer getESPECIALISTAS() {
        return ESPECIALISTAS;
    }

    public void setESPECIALISTAS(Integer ESPECIALISTAS) {
        this.ESPECIALISTAS = ESPECIALISTAS;
    }

    public Integer getPROFESIONALES() {
        return PROFESIONALES;
    }

    public void setPROFESIONALES(Integer PROFESIONALES) {
        this.PROFESIONALES = PROFESIONALES;
    }

    public Integer getTECNOLOGOS() {
        return TECNOLOGOS;
    }

    public void setTECNOLOGOS(Integer TECNOLOGOS) {
        this.TECNOLOGOS = TECNOLOGOS;
    }

    public Integer getTECNICOS() {
        return TECNICOS;
    }

    public void setTECNICOS(Integer TECNICOS) {
        this.TECNICOS = TECNICOS;
    }

    public Integer getSIN_CLASIFICAR() {
        return SIN_CLASIFICAR;
    }

    public void setSIN_CLASIFICAR(Integer SIN_CLASIFICAR) {
        this.SIN_CLASIFICAR = SIN_CLASIFICAR;
    }

    @Override
    public List getAllDataFromList(HashMap params) throws Exception {
        int yearBegP = (Integer) params.get("YEAR_BEG");
        int yearEndP = (Integer) params.get("YEAR_END");
        String programa = (String) params.get("PROGRAMA");
        List<RptProfesNivelEdu> data = new ArrayList<>();
        for (; yearEndP >= yearBegP; yearEndP--) {
            RptProfesNivelEdu rp2_TC = getDataFromPeriodo(12, yearEndP, programa, "DC");
            RptProfesNivelEdu rp2_MT = getDataFromPeriodo(12, yearEndP, programa, "DM");
            RptProfesNivelEdu rp2_HC = getDataFromPeriodo(12, yearEndP, programa, "HC");
            data.add(rp2_TC);
            data.add(rp2_MT);
            data.add(rp2_HC);
            RptProfesNivelEdu rp1_TC = getDataFromPeriodo(6, yearEndP, programa, "DC");
            RptProfesNivelEdu rp1_MT = getDataFromPeriodo(6, yearEndP, programa, "DM");
            RptProfesNivelEdu rp1_HC = getDataFromPeriodo(6, yearEndP, programa, "HC");
            data.add(rp1_TC);
            data.add(rp1_MT);
            data.add(rp1_HC);
        }
        return data;
    }

    private RptProfesNivelEdu getDataFromPeriodo(int periodo, int year, String programa, String dedicacion) throws Exception {
        Object[][] data;
        data = ExecuteSql.executeQuery("SELECT "
                 + "MAXIMO_NIVEL_EDU, "
                + "CATEGORIA, "
                + "COUNT(*) "
                + "FROM(  "
                + "SELECT PERIODO,SEMESTRE,CATEGORIA,MAXIMO_NIVEL_EDU,IDENTIFICACION,NOMBRE,NOM_CENTRO,CENTRO_COSTO,COD_SNIESS   "
                + "FROM   "
                + "(  "
                + "  SELECT   "
                + "    " + year + " PERIODO,  "
                + "    CASE WHEN " + periodo + "=6 THEN 1 ELSE 2 END SEMESTRE,  "
                + "    RC.CATEGORIA,  "
                + "    DECODE(RH_MAX_CATEGORIA_ESTUDIO(RC.COD_FUNC),7,'DOCTORADO',6,'MAESTRIA',5,'ESPECIALIZACION',4,'PREGRADO',3,'TECNOLOGIA','OTRO') AS MAXIMO_NIVEL_EDU,  "
                + "    RC.IDENTIFICACION,  "
                + "    RC.PRIMER_AP||' '||RC.SEGUNDO_AP||' '||RC.NOMBRES NOMBRE,  "
                + "    CC.NOM_CENTRO,  "
                + "    CC.CENTRO_COSTO,  "
                + "      "
                + "    CASE WHEN   "
                + "      (  "
                + "        SELECT RP.COD_SNIES  "
                + "        FROM RE_PROGRAMA RP INNER JOIN PROGRAMAS P ON P.COD_ZONPRO=RP.COD_PROG  "
                + "              INNER JOIN CENTRO_COSTO CCC ON CCC.CENTRO_COSTO=P.CENTRO_COSTO  "
                + "        WHERE RP.COD_SNIES IS NOT NULL  "
                + "        AND P.CENTRO_COSTO=CC.CENTRO_COSTO    "
                + "        AND RP.COD_PROG=(SELECT MAX(RP.COD_PROG)  "
                + "        FROM RE_PROGRAMA RP INNER JOIN PROGRAMAS P ON P.COD_ZONPRO=RP.COD_PROG  "
                + "              INNER JOIN CENTRO_COSTO CCCC ON CCCC.CENTRO_COSTO=P.CENTRO_COSTO  "
                + "        WHERE RP.COD_SNIES IS NOT NULL  "
                + "        AND P.CENTRO_COSTO=CC.CENTRO_COSTO)  "
                + "      ) IS NOT NULL THEN   "
                + "      (  "
                + "        SELECT RP.COD_SNIES  "
                + "        FROM RE_PROGRAMA RP INNER JOIN PROGRAMAS P ON P.COD_ZONPRO=RP.COD_PROG  "
                + "              INNER JOIN CENTRO_COSTO CCC ON CCC.CENTRO_COSTO=P.CENTRO_COSTO  "
                + "        WHERE RP.COD_SNIES IS NOT NULL  "
                + "        AND P.CENTRO_COSTO=CC.CENTRO_COSTO    "
                + "        AND RP.COD_PROG=(SELECT MAX(RP.COD_PROG)  "
                + "        FROM RE_PROGRAMA RP INNER JOIN PROGRAMAS P ON P.COD_ZONPRO=RP.COD_PROG  "
                + "              INNER JOIN CENTRO_COSTO CCCC ON CCCC.CENTRO_COSTO=P.CENTRO_COSTO  "
                + "        WHERE RP.COD_SNIES IS NOT NULL  "
                + "        AND P.CENTRO_COSTO=CC.CENTRO_COSTO)  "
                + "      )  "
                + "      ELSE  "
                + "      (  "
                + "        SELECT RZ.COD_SNIES FROM RE_ZON_PRO RZ INNER JOIN RE_PROGRAMA RP ON RZ.COD_PROG=RP.COD_PROG  "
                + "        WHERE RZ.CENTRO_COSTO=CC.CENTRO_COSTO  "
                + "        AND ROWNUM=1  "
                + "      ) END COD_SNIESS  "
                + "  FROM RH_CONTRATO RC   "
                + "    INNER JOIN CENTRO_COSTO CC ON CC.CENTRO_COSTO=RC.CENTRO_COSTO  "
              
                //  + "    INNER JOIN RH_CONTR_CC_PUESTO RCCT ON RCCT.COD_CONTRATO = RC.COD_CONTRATO  "
                //+ "    INNER JOIN CENTRO_COSTO CC ON CC.CENTRO_COSTO=RCCT.CENTRO_COSTO  "
              
                
                
                + "    INNER JOIN RH_FUNCIONARIO RF ON RC.COD_FUNC=RF.COD_FUNC  "
                + "    INNER JOIN RH_TIPO_CONTRATO RT ON RC.COD_TCONTRATO=RT.COD_TCONTRATO  "
                + "  WHERE   "
                + "      (  "
                + "        (  "
                + "          EXTRACT(YEAR FROM TO_DATE(RC.F_INICIAL, 'DD/MM/RR'))=" + year + "   "
                + "          AND   "
                + "            (  "
                + "               (" + periodo + " = 6 AND EXTRACT(MONTH FROM TO_DATE(RC.F_INICIAL, 'DD/MM/RR')) BETWEEN 1 AND 6) OR   "
                + "              (" + periodo + " = 12 AND EXTRACT(MONTH FROM TO_DATE(RC.F_INICIAL, 'DD/MM/RR')) BETWEEN 7 AND 12)  "
                + "            )      "
                + "        )        "
                + "        OR   "
                + "          (  "
                + "            EXTRACT(YEAR FROM TO_DATE(RC.F_INICIAL, 'DD/MM/RR'))=" + year + " AND EXTRACT(MONTH FROM TO_DATE(RC.F_INICIAL, 'DD/MM/RR')) BETWEEN 1 AND 6 AND (RC.F_FINAL IS NULL OR F_RETIRO IS NULL)  "
                + "          )      "
                + "        OR  "
                + "        (EXTRACT(YEAR FROM TO_DATE(RC.F_INICIAL, 'DD/MM/RR'))<" + year + "-1 AND (RC.F_FINAL IS NULL OR F_RETIRO IS NULL))        "
                + "      OR (EXTRACT(YEAR FROM TO_DATE(RC.F_INICIAL, 'DD/MM/RR'))<" + year + " AND (RC.F_FINAL IS NULL OR F_RETIRO IS NULL))  "
                + "      )  "
                + "      AND RC.COD_CONTRATO NOT IN (SELECT COD_CONTRATO FROM RECURSOSH.RH_CONTRATO_ANULADO)  "
                + "      AND EXTRACT(MONTH FROM TO_DATE(RC.F_INICIAL, 'DD/MM/RR'))<=" + periodo + "  "
                + "      AND RC.CATEGORIA IN ('DC','DM','HC')  "
                + "      ORDER BY NOM_CENTRO  "
                + ")      "
                + "  GROUP BY PERIODO,SEMESTRE,CATEGORIA,MAXIMO_NIVEL_EDU,IDENTIFICACION,NOMBRE,NOM_CENTRO,CENTRO_COSTO,COD_SNIESS  "
                + ") L WHERE L.COD_SNIESS = " + programa + "  "
                + "AND L.CATEGORIA IN('" + dedicacion + "') "
                + "GROUP BY CATEGORIA,MAXIMO_NIVEL_EDU,SEMESTRE");

        RptProfesNivelEdu rp = new RptProfesNivelEdu();
        rp.setYEAR(year);
        rp.setPERIODO(periodo == 6 ? 1 : 2);
        rp.setTOTAL(0);
        rp.setDOCTORES(0);
        rp.setMAGISTERES(0);
        rp.setESPECIALISTAS(0);
        rp.setPROFESIONALES(0);
        rp.setTECNOLOGOS(0);
        rp.setSIN_CLASIFICAR(0);

        for (Object[] row : data) {
            String MAXTITULO = row[0] != null ? row[0].toString() : "";
            // String dataDedicacion = row[1] != null ? row[1].toString() : "";
            Integer CANTIDAD = row[2] != null ? Integer.valueOf(row[2].toString()) : 0;
            switch (MAXTITULO) {
                case DOCTORADO:
                    rp.setDOCTORES(CANTIDAD);
                    break;
                case MAESTRIA:
                    rp.setMAGISTERES(CANTIDAD);
                    break;
                case ESPECIALIZACION:
                    rp.setESPECIALISTAS(CANTIDAD);
                    break;
                case PREGRADO:
                    rp.setPROFESIONALES(CANTIDAD);
                    break;
                case TECNOLOGIA:
                    rp.setTECNOLOGOS(CANTIDAD);
                    break;
                default:
                    rp.setSIN_CLASIFICAR(CANTIDAD);
                    break;
            }
        }
        rp.setTECNICOS(0);
        rp.setTOTAL(rp.getDOCTORES() + rp.getMAGISTERES() + rp.getESPECIALISTAS() + rp.getPROFESIONALES() + rp.getTECNOLOGOS() + rp.getSIN_CLASIFICAR());
        rp.setDEDICACION(dedicacion.equals("DC") ? "TIEMPO COMPLETO" : dedicacion.equals("HC") ? "HORA CATEDRA" : "MEDIO TIEMPO");
        return rp;
    }
}
