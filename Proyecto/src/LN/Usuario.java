package LN;


public class Usuario extends Partida {

	String contrasenya;
	

	
	public Usuario(String nombre, String contrasenya, int punt, String fecha){
		super(punt, fecha, nombre);
		this.contrasenya = contrasenya;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
}
