import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JFrame;

import LD.BasesDeDatos;
import LN.GestorJugador;
import LN.Instrucciones;
import LP.TablaRanking;
import LP.logIn;
import LP.principio;
import LP.tablero;



public class Main {

	public static void main(String[] args) {

		BasesDeDatos.initBD("nuestrosDatos.bd");  //  --- REGISTRASEN BARRUN JARRI DITUT
//		BasesDeDatos.crearTablaBDUsuario();
//		GestorJugador jugador = new GestorJugador("ainhoa", "bai", null);
//		jugador.anyadirUnaFila(BasesDeDatos.getStatement(), "ainhoa", "bai");
		
//		TablaRanking t = new TablaRanking("ainhoa");
//		t.Ordenar();
						
		//menu de log in y registrarse
		principio frame = new principio();
		frame.setVisible(true);
		

	}
		
		
}
