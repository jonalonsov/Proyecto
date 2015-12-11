import java.awt.EventQueue;

import javax.swing.JFrame;

import LD.BasesDeDatos;
import LN.GestorJugador;
import LP.logIn;
import LP.principio;
import LP.tablero;



public class Main {

	public static void main(String[] args) {

//		BasesDeDatos.initBD("nuestrosDatos.bd");  //  --- REGISTRASEN BARRUN JARRI DITUT
//		BasesDeDatos.crearTablaBDUsuario();
//		GestorJugador jugador = new GestorJugador("ainhoa", "bai", null);
//		jugador.anyadirUnaFila(BasesDeDatos.getStatement(), "ainhoa", "bai");
		
		principio frame = new principio();
		frame.setVisible(true);

		
		//de prueba
		tablero tablero = new tablero();
		tablero.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		tablero.setVisible(true);
		
		
		
	}
		
		
}
