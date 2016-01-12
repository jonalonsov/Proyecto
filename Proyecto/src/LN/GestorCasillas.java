package LN;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestorCasillas {
	
	ArrayList<Casilla> ListaCasillas1;
	ArrayList<Casilla> ListaCasillas2;
	
	public void comenzarCasillas1(){
		
		ListaCasillas1= new ArrayList<Casilla>();
		
		Casilla casilla1= new Casilla(210, 130, "rojo", 1);
		Casilla casilla2 = new Casilla(210, 210, "azul", 5);
		Casilla casilla3 = new Casilla(210, 295, "verde", 3);
		Casilla casilla4 = new Casilla(210, 375, "amarilo", 7);
		Casilla casilla5 = new Casilla(300, 375, "verde", 3);
		Casilla casilla6 = new Casilla(390, 375, "rojo", 1);
		Casilla casilla7 = new Casilla(390, 295, "azul", 5);
		Casilla casilla8 = new Casilla(390, 210, "amarillo", 7);
		Casilla casilla9 = new Casilla(390, 130, "verde", 3);
		Casilla casilla10 = new Casilla(480, 130, "azul", 5);
		Casilla casilla11 = new Casilla(635, 130, "morado", 15);
			
		
		//hau ez da beharrezkoa, pruebak iteko da. HASIERA
		ListaCasillas1.add(casilla1);
		ListaCasillas1.add(casilla2);
		ListaCasillas1.add(casilla3);
		ListaCasillas1.add(casilla4);
		ListaCasillas1.add(casilla5);
		ListaCasillas1.add(casilla6);
		ListaCasillas1.add(casilla7);
		ListaCasillas1.add(casilla8);
		ListaCasillas1.add(casilla9);
		ListaCasillas1.add(casilla10);
		//BUKAERA
		
		
		try {
			FileOutputStream fout = new FileOutputStream ("casillas1.dat");
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
			oos.writeObject(casilla11);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void comenzarCasillas2(){
		
		ListaCasillas2= new ArrayList<Casilla>();
		
		Casilla casilla1= new Casilla(1055, 130, "rojo", 1);
		Casilla casilla2 = new Casilla(1055, 210, "azul", 1);
		Casilla casilla3 = new Casilla(1055, 295, "verde", 1);
		Casilla casilla4 = new Casilla(1055, 375, "amarilo", 1);
		Casilla casilla5 = new Casilla(965, 375, "verde", 1);
		Casilla casilla6 = new Casilla(875, 375, "rojo", 1);
		Casilla casilla7 = new Casilla(875, 295, "azul", 1);
		Casilla casilla8 = new Casilla(875, 210, "amarillo", 1);
		Casilla casilla9 = new Casilla(875, 130, "verde", 1);
		Casilla casilla10 = new Casilla(780, 130, "azul", 1);
		Casilla casilla11 = new Casilla(635, 130, "morado", 10);
			
		
		//hau ez da beharrezkoa, pruebak iteko da. HASIERA
		ListaCasillas2.add(casilla1);
		ListaCasillas2.add(casilla2);
		ListaCasillas2.add(casilla3);
		ListaCasillas2.add(casilla4);
		ListaCasillas2.add(casilla5);
		ListaCasillas2.add(casilla6);
		ListaCasillas2.add(casilla7);
		ListaCasillas2.add(casilla8);
		ListaCasillas2.add(casilla9);
		ListaCasillas2.add(casilla10);
		//BUKAERA
		
		
		try {
			FileOutputStream fout2 = new FileOutputStream ("casillas2.dat");
			ObjectOutputStream oos2 = new ObjectOutputStream(fout2);
			oos2.writeObject(casilla1);
			oos2.writeObject(casilla2);
			oos2.writeObject(casilla3);
			oos2.writeObject(casilla4);
			oos2.writeObject(casilla5);
			oos2.writeObject(casilla6);
			oos2.writeObject(casilla7);
			oos2.writeObject(casilla8);
			oos2.writeObject(casilla9);
			oos2.writeObject(casilla10);
			oos2.writeObject(casilla11);
			oos2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	
	public ArrayList<Casilla> casillasList1() {
		
	
		ArrayList<Casilla> listCasilla = new ArrayList<Casilla>();
		ObjectInputStream ois = null;		
			try {
				ois = new ObjectInputStream( new FileInputStream("casillas1.dat") );
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
				
	
	public ArrayList<Casilla> casillasList2() {
		
		
		ArrayList<Casilla> listCasilla = new ArrayList<Casilla>();
		ObjectInputStream ois2 = null;		
			try {
				ois2 = new ObjectInputStream( new FileInputStream("casillas2.dat") );
				while (true) {
					// Lectura hasta final de fichero (excepci�n)
					// Tb a veces se graba un null al final y se usa ese null para acabar
					Casilla u = (Casilla) ois2.readObject();
					listCasilla.add( u );
				}
			} catch (EOFException e) {  // FileNotFound, IO, EOF, classcast
				// Ok - final de bucle
			} catch (Exception e) {  // FileNotFound, IO, EOF, classcast
				e.printStackTrace();
			} finally {
				if (ois2!=null)
					try {
						ois2.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		
		return listCasilla;
		
	}
	
	public int getPos_x1(int numero) {
		
		ListaCasillas1 = casillasList1();
		
		
		
		return ListaCasillas1.get(numero).getPos_x();
		
		
	}
	
	public int getPos_y1(int numero) {
		
		ListaCasillas1 = casillasList1();
		return ListaCasillas1.get(numero).getPos_y();
		
	}
	
	public int getPos_x2(int numero) {
		
		ListaCasillas2 = casillasList2();
		return ListaCasillas2.get(numero).getPos_x();
	}
	
	public int getPos_y2(int numero) {
		
		ListaCasillas2 = casillasList2();
		return ListaCasillas2.get(numero).getPos_y();
		
	}
	
	public int getPunt(int numero){
		
		ListaCasillas1 = casillasList1();
		return ListaCasillas1.get(numero).getValor();
		
		
	}
	
	
}
