package LN;

import java.util.ArrayList;

public class GestorCasillas {
	
	ArrayList<Casilla> ListaCasillas; 
	
	Casilla casilla1;
	Casilla casilla2;
	Casilla casilla3;
	Casilla casilla4;
	Casilla casilla5;
	Casilla casilla6;
	Casilla casilla7;
	Casilla casilla8;
	Casilla casilla9;
	Casilla casilla10;
	
	public GestorCasillas(){
		ListaCasillas = new ArrayList<Casilla>();
		
		casilla1 = new Casilla(200, 130, "rojo", 1);
		casilla2 = new Casilla(300, 100, "azul", 1);
		casilla3 = new Casilla(400, 190, "verde", 1);
		casilla4 = new Casilla(300, 90, "amarilo", 1);
		casilla5 = new Casilla(200, 130, "verde", 1);
		casilla6 = new Casilla(200, 130, "rojo", 1);
		casilla7 = new Casilla(200, 130, "azul", 1);
		casilla8 = new Casilla(200, 130, "amarillo", 1);
		casilla9 = new Casilla(200, 130, "verde", 1);
		casilla10 = new Casilla(200, 130, "azul", 1);
		
		
		ListaCasillas.add(casilla1);
		ListaCasillas.add(casilla2);
		ListaCasillas.add(casilla3);
		ListaCasillas.add(casilla4);
		ListaCasillas.add(casilla5);
		ListaCasillas.add(casilla6);
		ListaCasillas.add(casilla7);
		ListaCasillas.add(casilla8);
		ListaCasillas.add(casilla9);
		ListaCasillas.add(casilla10);
	}
	
				
	
	public int getPos_x(int numero) {
				
		return ListaCasillas.get(numero).getPos_x();
		
				
//		if(numero==0){
//			return 210;
//		}
//		if(numero==1){
//			return 200;
//		}
//		if(numero==2){
//			return 190;
//		}
//		
//		if(numero==3){
//			return 210;
//		}
//		
//		if(numero==4){
//			return 180;
//		}
//		
//		if(numero==5){
//			return 120;
//		}
//		return 123123123;
		
		
	}
	
	public int getPos_y(int numero) {
		
		return ListaCasillas.get(numero).getPos_y();
		
	}
	
	
	
}
