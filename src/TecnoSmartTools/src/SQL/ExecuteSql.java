package SQL;

import Utils.Dialogs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

public class ExecuteSql {

    public static Connection getConnection() {
        Connection con = null;
        Preferences pref = Preferences.userRoot().node("TecnosmartTools");
        try {
            if (pref.get("ip", "").isEmpty()) {
                throw new Exception("Faltan datos de conexión");
            }
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@" + pref.get("ip", "") + ":" + pref.get("puerto", "") + ":" + pref.get("db", "") + "", pref.get("usuario", ""), pref.get("pass", ""));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            Dialogs.errorDialog(null, e1);
            e1.printStackTrace();
        }
        return con;
    }

    /**
     * Ejecutar una consulta y retornar una matriz de filas y columnas iguales a
     * las de la consulta
     *
     * @param query
     * @return
     */
    public static Object[][] executeQuery(String query) throws Exception {
        Object[][] data = null;
        Connection con = null;
        try {
            con = getConnection();
            Statement st = con.createStatement();
            System.out.println("" + query);
            ResultSet rs = st.executeQuery(query.replaceAll("\n", " "));
            List<Object[]> rows = new ArrayList<>();
            while (rs.next()) {
                Object[] row = new Object[rs.getMetaData().getColumnCount()];
                for (int i = 0; i < row.length; i++) {
                    Object object = rs.getObject(i + 1);
                    row[i] = object;
                }
                rows.add(row);
            }
            data = rows.toArray(new Object[0][]);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        } finally {
            autoCloss(con);
        }
        return data;
    }

    public static boolean insert(String query) throws Exception {
        Connection con = getConnection();
        Statement st = con.createStatement();
        st.executeUpdate(query);
        return true;
    }

    public static boolean update(String query) throws Exception {
        Connection con = getConnection();
        Statement st = con.createStatement();
        st.executeUpdate(query);
        return true;
    }

    public static boolean delete(String query) throws Exception {
        Connection con = getConnection();
        Statement st = con.createStatement();
        st.executeUpdate(query);
        return true;
    }

    private static void autoCloss(AutoCloseable obj) {
        try {
            if (obj != null) {
                obj.close();
            }
        } catch (Exception e) {
        }
    }
}
