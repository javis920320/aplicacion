package options.reportesCnaCicle2017;

import SQL.ExecuteSql;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RptProfesFormContrata implements Report, Serializable {

    /**
     * @autor Christian ⁪Onofre [eonofre@umariana.edu.co]
     * @fecha 29/06/2017
     */
    static final long serialVersionUID = -605790748343736158L;
    static final String INDEFINIDO = "INDEFINIDO";
    static final String SEMESTRAL = "SEMESTRAL";
    static final String ANUAL = "ANUAL";
    static final String VARIOS_ANIOS = "VARIOS_ANIOS";

    private Integer YEAR;
    private Integer PERIODO;
    private Integer TERMINO_INDEFINIDO = 0;
    private Integer TF_VARIOS_YEARS;
    private Integer TF_12_MESES;
    private Integer TF_10_11_MESES;
    private Integer TF_5_6_MESES;
    private Integer PS_VARIOS_YEARS;
    private Integer PS_12_MESES;
    private Integer PS_10_11_MESES;
    private Integer PS_5_6_MESES;
    private Integer OTRAS_ESPECIFICACIONES;
    private Integer TOTAL;

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

    public Integer getTERMINO_INDEFINIDO() {
        return TERMINO_INDEFINIDO;
    }

    public void setTERMINO_INDEFINIDO(Integer TERMINO_INDEFINIDO) {
        this.TERMINO_INDEFINIDO = TERMINO_INDEFINIDO;
    }

    public Integer getTF_VARIOS_YEARS() {
        return TF_VARIOS_YEARS;
    }

    public void setTF_VARIOS_YEARS(Integer TF_VARIOS_YEARS) {
        this.TF_VARIOS_YEARS = TF_VARIOS_YEARS;
    }

    public Integer getTF_12_MESES() {
        return TF_12_MESES;
    }

    public void setTF_12_MESES(Integer TF_12_MESES) {
        this.TF_12_MESES = TF_12_MESES;
    }

    public Integer getTF_10_11_MESES() {
        return TF_10_11_MESES;
    }

    public void setTF_10_11_MESES(Integer TF_10_11_MESES) {
        this.TF_10_11_MESES = TF_10_11_MESES;
    }

    public Integer getTF_5_6_MESES() {
        return TF_5_6_MESES;
    }

    public void setTF_5_6_MESES(Integer TF_5_6_MESES) {
        this.TF_5_6_MESES = TF_5_6_MESES;
    }

    public Integer getPS_VARIOS_YEARS() {
        return PS_VARIOS_YEARS;
    }

    public void setPS_VARIOS_YEARS(Integer PS_VARIOS_YEARS) {
        this.PS_VARIOS_YEARS = PS_VARIOS_YEARS;
    }

    public Integer getPS_12_MESES() {
        return PS_12_MESES;
    }

    public void setPS_12_MESES(Integer PS_12_MESES) {
        this.PS_12_MESES = PS_12_MESES;
    }

    public Integer getPS_10_11_MESES() {
        return PS_10_11_MESES;
    }

    public void setPS_10_11_MESES(Integer PS_10_11_MESES) {
        this.PS_10_11_MESES = PS_10_11_MESES;
    }

    public Integer getPS_5_6_MESES() {
        return PS_5_6_MESES;
    }

    public void setPS_5_6_MESES(Integer PS_5_6_MESES) {
        this.PS_5_6_MESES = PS_5_6_MESES;
    }

    public Integer getOTRAS_ESPECIFICACIONES() {
        return OTRAS_ESPECIFICACIONES;
    }

    public void setOTRAS_ESPECIFICACIONES(Integer OTRAS_ESPECIFICACIONES) {
        this.OTRAS_ESPECIFICACIONES = OTRAS_ESPECIFICACIONES;
    }

    public Integer getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(Integer TOTAL) {
        this.TOTAL = TOTAL;
    }

    @Override
    public List getAllDataFromList(HashMap params) throws Exception {
        int yearBegP = (Integer) (params.get("YEAR_BEG"));
        int yearEndP = (Integer) (params.get("YEAR_END"));
        String programa = (String) params.get("PROGRAMA");
        List<RptProfesFormContrata> data = new ArrayList<>();
        for (; yearEndP >= yearBegP; yearEndP--) {
            RptProfesFormContrata rp1 = getDataFromPeriodo(6, yearEndP, programa);
            RptProfesFormContrata rp2 = getDataFromPeriodo(12, yearEndP, programa);
            data.add(rp2);
            data.add(rp1);
        }

        return data;
    }

    private RptProfesFormContrata getDataFromPeriodo(int periodo, int year, String programa) throws Exception {
        Object[][] data;
        data = ExecuteSql.executeQuery("SELECT    "
                + "TOTAL.PERIODO,   "
                + "TOTAL.TIPO_CONTRATO,   "
                + "COUNT(*)    "
                + "FROM (   "
                + "SELECT L.PERIODO,   "
                + "CASE   "
                + "  WHEN L.F_FINAL IS NULL THEN 'INDEFINIDO'   "
                + "  WHEN (L.F_FINAL-F_INICIAL)<=180 THEN 'SEMESTRAL'   "
                + "  WHEN (L.F_FINAL-F_INICIAL)>=180 AND (L.F_FINAL-F_INICIAL)<=360 THEN 'ANUAL'   "
                + "  WHEN (L.F_FINAL-F_INICIAL)>360 THEN 'VARIOS_ANIOS'   "
                + "  ELSE 'SEMESTRAL'   "
                + "END TIPO_CONTRATO   "
                + "FROM (   "
                + "SELECT PERIODO,SEMESTRE,CATEGORIA,MAXIMO_NIVEL_EDU,IDENTIFICACION,NOMBRE,NOM_CENTRO,CENTRO_COSTO,COD_SNIESS, F_INICIAL, F_FINAL FROM    "
                + "(   "
                + "     "
                + "  SELECT    "
                + "    " + year + " PERIODO,   "
                + "    CASE WHEN " + periodo + "=6 THEN 1 ELSE 2 END SEMESTRE,    "
                + "    RC.CATEGORIA,   "
                + "    DECODE(RH_MAX_CATEGORIA_ESTUDIO(RC.COD_FUNC),7,'DOCTORADO',6,'MAESTRIA',5,'ESPECIALIZACION',4,'PREGRADO',3,'TECNOLOGIA','OTRO') AS MAXIMO_NIVEL_EDU,   "
                + "    RC.IDENTIFICACION,   "
                + "    RC.PRIMER_AP||' '||RC.SEGUNDO_AP||' '||RC.NOMBRES NOMBRE,   "
                + "    CC.NOM_CENTRO,   "
                + "    CC.CENTRO_COSTO,   "
                + "       "
                + "    CASE WHEN    "
                + "      (   "
                + "        SELECT RP.COD_SNIES   "
                + "        FROM RE_PROGRAMA RP INNER JOIN PROGRAMAS P ON P.COD_ZONPRO=RP.COD_PROG   "
                + "              INNER JOIN CENTRO_COSTO CCC ON CCC.CENTRO_COSTO=P.CENTRO_COSTO   "
                + "        WHERE RP.COD_SNIES IS NOT NULL   "
                + "        AND P.CENTRO_COSTO=CC.CENTRO_COSTO     "
                + "        AND RP.COD_PROG=(SELECT MAX(RP.COD_PROG)   "
                + "        FROM RE_PROGRAMA RP INNER JOIN PROGRAMAS P ON P.COD_ZONPRO=RP.COD_PROG   "
                + "              INNER JOIN CENTRO_COSTO CCCC ON CCCC.CENTRO_COSTO=P.CENTRO_COSTO   "
                + "        WHERE RP.COD_SNIES IS NOT NULL   "
                + "        AND P.CENTRO_COSTO=CC.CENTRO_COSTO)   "
                + "      ) IS NOT NULL THEN    "
                + "      (   "
                + "        SELECT RP.COD_SNIES   "
                + "        FROM RE_PROGRAMA RP INNER JOIN PROGRAMAS P ON P.COD_ZONPRO=RP.COD_PROG   "
                + "              INNER JOIN CENTRO_COSTO CCC ON CCC.CENTRO_COSTO=P.CENTRO_COSTO   "
                + "        WHERE RP.COD_SNIES IS NOT NULL   "
                + "        AND P.CENTRO_COSTO=CC.CENTRO_COSTO     "
                + "        AND RP.COD_PROG=(SELECT MAX(RP.COD_PROG)   "
                + "        FROM RE_PROGRAMA RP INNER JOIN PROGRAMAS P ON P.COD_ZONPRO=RP.COD_PROG   "
                + "              INNER JOIN CENTRO_COSTO CCCC ON CCCC.CENTRO_COSTO=P.CENTRO_COSTO   "
                + "        WHERE RP.COD_SNIES IS NOT NULL   "
                + "        AND P.CENTRO_COSTO=CC.CENTRO_COSTO)   "
                + "      )   "
                + "      ELSE   "
                + "      (   "
                + "        SELECT RZ.COD_SNIES FROM RE_ZON_PRO RZ INNER JOIN RE_PROGRAMA RP ON RZ.COD_PROG=RP.COD_PROG   "
                + "        WHERE RZ.CENTRO_COSTO=CC.CENTRO_COSTO   "
                + "        AND ROWNUM=1   "
                + "      ) END COD_SNIESS,   "
                + "      RC.F_INICIAL, RC.F_FINAL   "
                + "     "
               + "  FROM RH_CONTRATO RC   "
                + "    INNER JOIN CENTRO_COSTO CC ON CC.CENTRO_COSTO=RC.CENTRO_COSTO  "
              
                //  + "    INNER JOIN RH_CONTR_CC_PUESTO RCCT ON RCCT.COD_CONTRATO = RC.COD_CONTRATO  "
                //+ "    INNER JOIN CENTRO_COSTO CC ON CC.CENTRO_COSTO=RCCT.CENTRO_COSTO  "
              
                
                
                + "    INNER JOIN RH_FUNCIONARIO RF ON RC.COD_FUNC=RF.COD_FUNC  "
                + "    INNER JOIN RH_TIPO_CONTRATO RT ON RC.COD_TCONTRATO=RT.COD_TCONTRATO  "
                + "       "
                + "  WHERE    "
                + "      (   "
                + "        (   "
                + "          EXTRACT(YEAR FROM TO_DATE(RC.F_INICIAL, 'DD/MM/RR'))=" + year + "   "
                + "          AND    "
                + "            (   "
                + "               (" + periodo + " = 6 AND EXTRACT(MONTH FROM TO_DATE(RC.F_INICIAL, 'DD/MM/RR')) BETWEEN 1 AND 6) OR    "
                + "              (" + periodo + " = 12 AND EXTRACT(MONTH FROM TO_DATE(RC.F_INICIAL, 'DD/MM/RR')) BETWEEN 7 AND 12)   "
                + "            )       "
                + "        )         "
                + "        OR    "
                + "          (   "
                + "            EXTRACT(YEAR FROM TO_DATE(RC.F_INICIAL, 'DD/MM/RR'))=" + year + " AND EXTRACT(MONTH FROM TO_DATE(RC.F_INICIAL, 'DD/MM/RR')) BETWEEN 1 AND 6 AND (RC.F_FINAL IS NULL OR F_RETIRO IS NULL)   "
                + "          )       "
                + "        OR   "
                + "        (EXTRACT(YEAR FROM TO_DATE(RC.F_INICIAL, 'DD/MM/RR'))<" + year + "-1 AND (RC.F_FINAL IS NULL OR F_RETIRO IS NULL))         "
                + "      OR (EXTRACT(YEAR FROM TO_DATE(RC.F_INICIAL, 'DD/MM/RR'))<" + year + " AND (RC.F_FINAL IS NULL OR F_RETIRO IS NULL))   "
                + "      )   "
                + "      AND RC.COD_CONTRATO NOT IN (SELECT COD_CONTRATO FROM RECURSOSH.RH_CONTRATO_ANULADO)   "
                + "      AND EXTRACT(MONTH FROM TO_DATE(RC.F_INICIAL, 'DD/MM/RR'))<=" + periodo + "   "
                + "      AND RC.CATEGORIA IN ('DC','DM','HC')    "
                + "      ORDER BY NOM_CENTRO   "
                + ")       "
                + "  WHERE COD_SNIESS=" + programa + "                    "
                + "  GROUP BY PERIODO,SEMESTRE,CATEGORIA,MAXIMO_NIVEL_EDU,IDENTIFICACION,NOMBRE,NOM_CENTRO,CENTRO_COSTO,COD_SNIESS,F_INICIAL, F_FINAL   "
                + ") L) TOTAL GROUP BY TOTAL.PERIODO,TOTAL.TIPO_CONTRATO   ");
        RptProfesFormContrata rp = new RptProfesFormContrata();
        rp.setYEAR(year);
        rp.setPERIODO(periodo == 6 ? 1 : 2);
        rp.setTF_VARIOS_YEARS(0);
        rp.setTERMINO_INDEFINIDO(0);
        rp.setTF_VARIOS_YEARS(0);
        rp.setTF_12_MESES(0);
        rp.setTF_10_11_MESES(0);
        rp.setTF_5_6_MESES(0);
        rp.setOTRAS_ESPECIFICACIONES(0);
        rp.setTOTAL(0);
        for (Object[] row : data) {
            String peri = row[0] != null ? row[0].toString() : "";
            String fContratacion = row[1] != null ? row[1].toString() : "";
            Integer cantidad = row[2] != null ? Integer.valueOf(row[2].toString()) : 0;
            switch (fContratacion) {
                case INDEFINIDO:
                    rp.setTERMINO_INDEFINIDO(cantidad);
                    break;
                case SEMESTRAL:
                    rp.setTF_5_6_MESES(cantidad);
                    break;
                case ANUAL:
                    rp.setTF_12_MESES(cantidad);
                    break;
                case VARIOS_ANIOS:
                    rp.setTF_VARIOS_YEARS(cantidad);
                    break;
                default:
                    throw new Exception("Tipo de experiencia desconocida " + fContratacion);
            }
        }
        rp.setTOTAL(rp.getTF_VARIOS_YEARS() + rp.getTF_12_MESES() + rp.getTERMINO_INDEFINIDO() + rp.getTF_5_6_MESES());
        return rp;
    }
}
