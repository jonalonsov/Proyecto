package LN;

import java.util.Date;

public class Maquina extends Partida{

	String nombre; 
	
	public Maquina(int punt, String fecha, String nombre){
		super(punt, fecha, nombre);
		this.nombre = "Trivial";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
