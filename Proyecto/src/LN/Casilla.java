package LN;

public class Casilla {

	int num_casilla;
	String color;
	int valor; // Las casillas valdran 1 o 2, dependiendo de la dificultad
	
	public Casilla(int num_casilla, String color, int valor){
		num_casilla = this.num_casilla;
		color = this.color;
		valor = this.valor;
	}

	public int getNum_casilla() {
		return num_casilla;
	}

	public void setNum_casilla(int num_casilla) {
		this.num_casilla = num_casilla;
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
