
 
package aplicacion;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author TECNOSMART10
 */
public class hielo {
    
    static void jugar(){
        
        
        int  valor ;
        boolean p=false;
        Random i = new Random();
        
        
        valor=i.nextInt(10);
        Scanner q = new Scanner(System.in);
           int x=0; 
        while (valor!=x) {
            
            System.out.println("Ingresa un dato");
            x= q.nextInt();
            
            System.out.println(x+ " No es Igual al valor");
       
            
        }
        System.out.println("Ganaste");
  

       
        
        
        
    }
    
    
  
    public static void main(String[] args) {
    jugar();
    }
    
}
