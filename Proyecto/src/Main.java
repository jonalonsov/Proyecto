import java.awt.EventQueue;

import LD.BasesDeDatos;
import LP.logIn;
import LP.principio;
import LP.tablero;



public class Main {

	public static void main(String[] args) {

		BasesDeDatos.initBD("nuestrosDatos");
		BasesDeDatos.crearTablaBDUsuario();
		
		principio frame = new principio();
		frame.setVisible(true);

		
		//de prueba
		tablero tablero = new tablero();
		tablero.setVisible(true);
		
		
	}
		
		
}
