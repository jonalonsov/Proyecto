package LN;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Dado extends JLabel{
	
       Random cara = new Random();
       int numero = cara.nextInt(5)+1;
       
       
    public Dado(){
    		   
	    if (numero == 1){
	    	   
	    	   try {
	   			setIcon( new ImageIcon( Dado.class.getResource( "1.png" ).toURI().toURL() ) );
	   		} catch (Exception e) {
	   			System.err.println( "Error en carga de recurso: dado.png no encontrado" );
	   			e.printStackTrace();
	   		}
	    	   
	       }
	       
	       if (numero == 2){
	    	   
	    	   try {
	      			setIcon( new ImageIcon( Dado.class.getResource( "2.png" ).toURI().toURL() ) );
	      		} catch (Exception e) {
	      			System.err.println( "Error en carga de recurso: dado.png no encontrado" );
	      			e.printStackTrace();
	      		}
	    	   
	       }
	
	       if (numero == 3){
	    	   
	    	   try {
	      			setIcon( new ImageIcon( Dado.class.getResource( "3.png" ).toURI().toURL() ) );
	      		} catch (Exception e) {
	      			System.err.println( "Error en carga de recurso: dado.png no encontrado" );
	      			e.printStackTrace();
	      		}
		   
	       }
	
	       if (numero == 4){
	    	   
	    	   try {
	      			setIcon( new ImageIcon( Dado.class.getResource( "4.png" ).toURI().toURL() ) );
	      		} catch (Exception e) {
	      			System.err.println( "Error en carga de recurso: dado.png no encontrado" );
	      			e.printStackTrace();
	      		}
		   
	       }
	
	       if (numero == 5){
	    	   
	    	   try {
	      			setIcon( new ImageIcon( Dado.class.getResource( "5.png" ).toURI().toURL() ) );
	      		} catch (Exception e) {
	      			System.err.println( "Error en carga de recurso: dado.png no encontrado" );
	      			e.printStackTrace();
	      		}
		   
	       }
	
	       if (numero == 6){
	    	   
	    	   try {
	      			setIcon( new ImageIcon( Dado.class.getResource( "6.png" ).toURI().toURL() ) );
	      		} catch (Exception e) {
	      			System.err.println( "Error en carga de recurso: dado.png no encontrado" );
	      			e.printStackTrace();
	      		}
		   
	       }
       }
}