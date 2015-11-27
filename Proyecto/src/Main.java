import java.awt.EventQueue;

import LD.BasesDeDatos;
import LP.logIn;
import LP.principio;



public class Main {

	public static void main(String[] args) {

		BasesDeDatos.initBD("nuestrosDatos");
		
		principio frame = new principio();
		frame.setVisible(true);

	}
		
		
}
