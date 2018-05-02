/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.util.Scanner;

/**
 *
 * @author TECNOSMART10
 */
public class Areas {
    
    
    
    
    public static void main(String[] Args){
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("Programa para calcular el Area De  Las Figuras");
        
            System.out.println("Area del Circulo");
            System.out.println("Radio");
            int radio =entrada.nextInt();
            double res;
    
         res=Math.pow(radio, 2);
         double p=res*Math.PI;
        System.out.println("El area delCiruclo es: "+p);
        
        
        
        
        
        
    }
}
