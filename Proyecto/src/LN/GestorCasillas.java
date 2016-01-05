package LN;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestorCasillas {
	
	ArrayList<Casilla> ListaCasillas;
	
	public void comenzarCasillas(){
		
		ListaCasillas= new ArrayList<Casilla>();
		
		Casilla casilla1= new Casilla(200, 130, "rojo", 1);
		Casilla casilla2 = new Casilla(300, 100, "azul", 1);
		Casilla casilla3 = new Casilla(400, 190, "verde", 1);
		Casilla casilla4 = new Casilla(300, 90, "amarilo", 1);
		Casilla casilla5 = new Casilla(200, 130, "verde", 1);
		Casilla casilla6 = new Casilla(200, 130, "rojo", 1);
		Casilla casilla7 = new Casilla(200, 130, "azul", 1);
		Casilla casilla8 = new Casilla(200, 130, "amarillo", 1);
		Casilla casilla9 = new Casilla(200, 130, "verde", 1);
		Casilla casilla10 = new Casilla(200, 130, "azul", 1);
			
		//hau ez da beharrezkoa, pruebak iteko da. HASIERA
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
		//BUKAERA
		
		System.out.println(casilla1.getColor());
		
		
		try {
			FileOutputStream fout = new FileOutputStream ("casillas.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(casilla1);
			oos.writeObject(casilla2);
			oos.writeObject(casilla3);
			oos.writeObject(casilla4);
			oos.writeObject(casilla5);
			oos.writeObject(casilla6);
			oos.writeObject(casilla7);
			oos.writeObject(casilla8);
			oos.writeObject(casilla9);
			oos.writeObject(casilla10);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Casilla> casillasList() {
		
	
		ArrayList<Casilla> listCasilla = new ArrayList<Casilla>();
		ObjectInputStream ois = null;		
			try {
				ois = new ObjectInputStream( new FileInputStream("casillas.dat") );
				while (true) {
					// Lectura hasta final de fichero (excepci�n)
					// Tb a veces se graba un null al final y se usa ese null para acabar
					Casilla u = (Casilla) ois.readObject();
					listCasilla.add( u );
				}
			} catch (EOFException e) {  // FileNotFound, IO, EOF, classcast
				// Ok - final de bucle
			} catch (Exception e) {  // FileNotFound, IO, EOF, classcast
				e.printStackTrace();
			} finally {
				if (ois!=null)
					try {
						ois.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		
		return listCasilla;
		
	}
				
	
	public int getPos_x(int numero) {
		
		ListaCasillas = casillasList();
		
		
		
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
		
		ListaCasillas = casillasList();
		return ListaCasillas.get(numero).getPos_y();
		
	}
	
	
	
}
