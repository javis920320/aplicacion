
package aplicacion;

/**
 *
 * @author TECNOSMART10
 */

import java.util.Scanner;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Aplicacion {

   
     
        
    
    public static void main(String[] args) {
        
     try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/creaciones","root","");
            JOptionPane.showMessageDialog(null,"Conexion exitosa");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en la conexión de la base de datos verifica el servidor");
        }
        
        
    }
    
}
