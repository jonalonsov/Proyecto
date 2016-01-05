package LN;

public class Usuario extends Jugador{
	
	String contrasenya;

	public Usuario(int numJug, String nombre, String contrasenya){
		super(nombre, numJug);
		this.contrasenya = contrasenya;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
}
