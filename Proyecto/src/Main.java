

import LD.BasesDeDatos;
import LP.principio;


public class Main {

	public static void main(String[] args) {

		BasesDeDatos.initBD("nuestrosDatos.bd");

		//menu de log in y registrarse
		principio frame = new principio();
		frame.setVisible(true);
		

	}
		
		
}
