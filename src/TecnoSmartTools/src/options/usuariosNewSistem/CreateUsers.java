package options.usuariosNewSistem;

import SQL.ExecuteSql;
import java.util.Arrays;
import java.util.List;

public class CreateUsers {

    public static Integer id_rol = 21;

    public static void main(String[] args) {
        System.out.println("" + authenticate("1085277921"));
    }

    public static String authenticate(String doc) {
        String passwordSha = Encriptadora.getStringMessageDigest(doc, Encriptadora.SHA256);
        return passwordSha;
    }

    /**
     * j_spring_security_check
     */
     /**
    private void saveUsers() {
       
         
        List<String> blackList = Arrays.asList("87219232", "98395797", "1085250475", "59814365", "12749474");
        String[] USRS = new String[]{ /*
            "59814301,ybasante@umariana.edu.co",
            "12989035,jquijano@umariana.edu.co",
            "80094540,auriascos@umariana.edu.co",
            "12975478,saer@umariana.edu.co",
            "37007234,yyepez@umariana.edu.co",
            "87219232,alopez@umariana.edu.co",
            "98395797,amunoz@umariana.edu.co",
            "75081147,jfmunoz@umariana.edu.co",
            "12958984,rediaz@umariana.edu.co",
            "98398533,fparra@umariana.edu.co",
            "87065358,afmartinez@umariana.edu.co",
            "59178081,elopez@umariana.edu.co",
            "1085250475,ahramirez@umariana.edu.co",
            "79554868,dijurado@umariana.edu.co",
            "59830949,clchaves@umariana.edu.co",
            "12990927,cenriquez@umariana.edu.co",
            "12752729,sjojoa@umariana.edu.co",
            "12750621,pquiroz@umariana.edu.co",
            "11433632,hrosero@umariana.edu.co",
            "36952701,mauraguerrero@umariana.edu.co",
            "27080837,cchavez@umariana.edu.co",
            "27395930,lhernandez@umariana.edu.co",
            "5213436,rcaicedo@umariana.edu.co",
            "98398901,jjpaz@umariana.edu.co",
            "59814365,mapantoja@umariana.edu.co",
            "1085255249,dflorez@umariana.edu.co",
            "87700128,htrejo@umariana.edu.co",
            "27088880,larteaga@umariana.edu.co",
            "12978543,barturo@umariana.edu.co",
            "91297359,drodriguez@umariana.edu.co",
            "59815325,ldelgado@umariana.edu.co",
            "36951282,crgomez@umariana.edu.co",
            "12749474,ccriollo@umariana.edu.co"};
//        for (String row : USRS) {
//            String doc = row.split(",")[0];
//            String usr = row.split(",")[1];
//            String clave = Encriptadora.getStringMessageDigest(doc, Encriptadora.SHA256);
//            System.out.println("User:" + usr + " Doc:" + doc + " Pass:" + clave);
//            if (!blackList.contains(doc)) {
//                try {
//                    Object[][] dataIdPersona = ExecuteSql.executeQuery("SELECT ID_PERSONA FROM TS_SEGURIDAD.RELACION_PERSONA_TIPO_PERSONA WHERE NUMERO_DOCUMENTO = " + doc);
//                    Integer idPersona = Integer.valueOf(dataIdPersona[0][0].toString());
//                    if (idPersona == null) {
//                        throw new Exception("Persona no encontrada : " + doc);
//                    }
//                    Object[][] data = ExecuteSql.executeQuery("SELECT TS_SEGURIDAD.ID_USUARIOS_SEQ.NEXTVAL FROM DUAL");
//                    Integer idUsuarios = Integer.valueOf(data[0][0].toString());
//
//                    String insert = "Insert into TS_SEGURIDAD.USUARIOS (ID_USUARIOS,ID_PERSONA,NOMBRE_USUARIO,CLAVE,ESTADO,ID_ROL) "
//                            + "values "
//                            + "('" + idUsuarios + "','" + idPersona + "','" + usr + "','" + clave + "','A','" + id_rol + "')";
//                    boolean ok = ExecuteSql.insert(insert);
//                    if (!ok) {
//                        System.out.println("\"" + doc + "," + usr + "\",");
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
       
        
//    }
**/
}
