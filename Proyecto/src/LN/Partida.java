package LN;

import java.util.Date;

public class Partida {

	int punt;
	Date fecha;
	
	public Partida(int punt, Date fecha){
		punt = this.punt;
		fecha = this.fecha;
	}

	public int getPunt() {
		return punt;
	}

	public void setPunt(int punt) {
		this.punt = punt;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
