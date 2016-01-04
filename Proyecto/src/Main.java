import java.awt.EventQueue;

import javax.swing.JFrame;

import LD.BasesDeDatos;
import LN.GestorJugador;
import LN.Instrucciones;
import LP.logIn;
import LP.principio;
import LP.tablero;



public class Main {

	public static void main(String[] args) {

		BasesDeDatos.initBD("nuestrosDatos.bd");  //  --- REGISTRASEN BARRUN JARRI DITUT
//		BasesDeDatos.crearTablaBDUsuario();
//		GestorJugador jugador = new GestorJugador("ainhoa", "bai", null);
//		jugador.anyadirUnaFila(BasesDeDatos.getStatement(), "ainhoa", "bai");
		
						
		//menu de log in y registrarse
		principio frame = new principio();
		frame.setVisible(true);
		
		
	}
		
		
}
