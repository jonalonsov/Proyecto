package LN;

import java.util.Date;

public class Partida {

	int punt;
	String fecha;
	
	public Partida(int punt, String fecha){
		this.punt = punt;
		this.fecha = fecha;
	}

	public int getPunt() {
		return punt;
	}

	public void setPunt(int punt) {
		this.punt = punt;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
