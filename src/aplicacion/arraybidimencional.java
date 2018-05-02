/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

/**
 *
 * @author TECNOSMART10
 */
public class arraybidimencional {
    
    
    public static void main(String [] args){
        
        
        
         int arreglo[][]= new int[5][5];
         
         
         arreglo[0][0]=10;
         arreglo[0][1]=20;
         arreglo[0][2]=30;
         arreglo[0][3]=40;
         arreglo[0][4]=50;
         
         arreglo[1][0]=60;
         arreglo[1][1]=70;
         arreglo[1][2]=80;
         arreglo[1][3]=90;
         arreglo[1][4]=100;
        
          arreglo[2][0]=120;
         arreglo[2][1]=130;
         arreglo[2][2]=140;
         arreglo[2][3]=150;
         arreglo[2][4]=160;
         
         
          arreglo[3][0]=170;
         arreglo[3][1]=180;
         arreglo[3][2]=190;
         arreglo[3][3]=200;
         arreglo[3][4]=210;
         
         
         arreglo[4][0]=220;
         arreglo[4][1]=230;
         arreglo[4][2]=240;
         arreglo[4][3]=250;
         arreglo[4][4]=260;
         
         
         for (int i = 0; i < 4; i++) {
             
             System.out.println();
             for (int j = 0; j < 4; j++) {
                 
                 System.out.print(arreglo[i][j]+" ");
                 
             }
            
        }
    }
    
}
