package LN;

import java.io.Serializable;

public class Casilla implements Serializable {

	int pos_x;
	int pos_y;
	String color;
	int valor; // Las casillas valdran 1 o 2, dependiendo de la dificultad
	
	public Casilla(int pos_x, int pos_y, String color, int valor){
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		this.color = color;
		this.valor = valor;
	}

	public int getPos_x() {
		return pos_x;
	}

	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
	}

	public int getPos_y() {
		return pos_y;
	}

	public void setPos_y(int pos_y) {
		this.pos_y = pos_y;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	

	
	
}
