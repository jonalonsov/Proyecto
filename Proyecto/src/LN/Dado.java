package LN;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import LP.tablero;

public class Dado extends JLabel{
	
//       Random cara = new Random();
//       int numero = cara.nextInt(5)+1;
//       
//       
//    public Dado(){
//    		   
//	    if (numero == 1){
//	    	   System.out.println(1);
//	    	   try {
//	    		   
//	    		   setIcon(new ImageIcon(tablero.class.getResource("/imagenes/1.png")));
//	   		} catch (Exception e) {
//	   			System.err.println( "Error en carga de recurso: dado.png no encontrado" );
//	   			e.printStackTrace();
//	   		}
//	    	   
//	    	
//	    	   
//	       }
//	       
//	       if (numero == 2){
//	    	   System.out.println(2);
//	    	   try {
//	    		   setIcon(new ImageIcon(tablero.class.getResource("/imagenes/2.png")));
//	      		} catch (Exception e) {
//	      			System.err.println( "Error en carga de recurso: dado.png no encontrado" );
//	      			e.printStackTrace();
//	      		}
//	    	   
//	    	  
//	    	   
//	       }
//	
//	       if (numero == 3){
//	    	   System.out.println(3);
//	    	   try {
//	    		   setIcon(new ImageIcon(tablero.class.getResource("/imagenes/3.png")));
//	      		} catch (Exception e) {
//	      			System.err.println( "Error en carga de recurso: dado.png no encontrado" );
//	      			e.printStackTrace();
//	      		}
//		   
//	    	
//	       }
//	
//	       if (numero == 4){
//	    	   System.out.println(4);
//	    	   try {
//	    		   setIcon(new ImageIcon(tablero.class.getResource("/imagenes/4.png")));
//	      		} catch (Exception e) {
//	      			System.err.println( "Error en carga de recurso: dado.png no encontrado" );
//	      			e.printStackTrace();
//	      		}
//	    	   
//	    	   		   
//	       }
//	
//	       if (numero == 5){
//	    	   System.out.println(5);
//	    	   try {
//	    		   setIcon(new ImageIcon(tablero.class.getResource("/imagenes/5.png")));
//	      		} catch (Exception e) {
//	      			System.err.println( "Error en carga de recurso: dado.png no encontrado" );
//	      			e.printStackTrace();
//	      		}
//	    	   
//	    			   
//	       }
//	
//	       if (numero == 6){
//	    	   System.out.println(6);
//	    	   try {
//	    		   setIcon(new ImageIcon(tablero.class.getResource("/imagenes/6.png")));
//	      		} catch (Exception e) {
//	      			System.err.println( "Error en carga de recurso: dado.png no encontrado" );
//	      			e.printStackTrace();
//	      		}
//	    	   
//	    	   		   
//	       }
//	       
//	       
//       }

    
    public int tirarDado(){
    	
    	Random caras = new Random();
        int numeros = caras.nextInt(6)+1;
        
	    if (numeros == 1){
	    	   System.out.println(1);
	    	   try {
	    		   
	    		   setIcon(new ImageIcon(tablero.class.getResource("/imagenes/1.png")));
	   		} catch (Exception e) {
	   			System.err.println( "Error en carga de recurso: dado.png no encontrado" );
	   			e.printStackTrace();
	   		}
	    	   
	    	return 1;
	    	   
	    }
	       
	       if (numeros == 2){
	    	   System.out.println(2);
	    	   try {
	    		   setIcon(new ImageIcon(tablero.class.getResource("/imagenes/2.png")));
	      		} catch (Exception e) {
	      			System.err.println( "Error en carga de recurso: dado.png no encontrado" );
	      			e.printStackTrace();
	      		}
	    	   
	    	  return 2;
	    	   
	       }
	
	       if (numeros == 3){
	    	   System.out.println(3);
	    	   try {
	    		   setIcon(new ImageIcon(tablero.class.getResource("/imagenes/3.png")));
	      		} catch (Exception e) {
	      			System.err.println( "Error en carga de recurso: dado.png no encontrado" );
	      			e.printStackTrace();
	      		}
		   return 3;
	    	
	       }
	
	       if (numeros == 4){
	    	   System.out.println(4);
	    	   try {
	    		   setIcon(new ImageIcon(tablero.class.getResource("/imagenes/4.png")));
	      		} catch (Exception e) {
	      			System.err.println( "Error en carga de recurso: dado.png no encontrado" );
	      			e.printStackTrace();
	      		}
	    	   
	    	   return 4;    	   		   
	       }
	
	       if (numeros == 5){
	    	   System.out.println(5);
	    	   try {
	    		   setIcon(new ImageIcon(tablero.class.getResource("/imagenes/5.png")));
	      		} catch (Exception e) {
	      			System.err.println( "Error en carga de recurso: dado.png no encontrado" );
	      			e.printStackTrace();
	      		}
	    	   
	    	   return 5;
	    	   
	    			   
	       }
	
	       if (numeros == 6){
	    	   System.out.println(6);
	    	   try {
	    		   setIcon(new ImageIcon(tablero.class.getResource("/imagenes/6.png")));
	      		} catch (Exception e) {
	      			System.err.println( "Error en carga de recurso: dado.png no encontrado" );
	      			e.printStackTrace();
	      		}
	    	   
	    	   return 6;
	       }
	       
	       
    return 0;
    
    }
}