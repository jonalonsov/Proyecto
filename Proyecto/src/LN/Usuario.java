package LN;

import java.util.Date;

public class Usuario extends Partida{
	
	String nombre;
	String contrasenya;

	public Usuario(String nombre, String contrasenya, int punt, String fecha){
		super(punt, fecha);
		this.nombre = nombre;
		this.contrasenya = contrasenya;
	}

	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
}
