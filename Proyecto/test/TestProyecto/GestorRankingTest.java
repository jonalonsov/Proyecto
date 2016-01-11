package TestProyecto;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LD.BasesDeDatos;
import LN.GestorJugador;
import LN.GestorRanking;
import LN.Partida;

public class GestorRankingTest {

	GestorRanking gr;
	ArrayList<Partida> partida;
	
	@Before
	public void setUp() throws Exception {

		gr = new GestorRanking();
		partida = new ArrayList<Partida>();
		BasesDeDatos.initBD("test.bd");
		BasesDeDatos.crearTablaBDPartida();
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void AnyadirFilaATablaPartidaTest() {
		//NULL POINTER EXCEPTION
		gr.anyadirFilaATablaPartida(BasesDeDatos.getStatement(), "aaaa", 15, "2016/01/10");
		gr.anyadirFilaATablaPartida(BasesDeDatos.getStatement(), "eeee", 20, "2016/01/05");
		gr.anyadirFilaATablaPartida(BasesDeDatos.getStatement(), "iiii", 10, "2016/01/12");
		
		int num1 = gr.cogerInfoDeTablaPartida(BasesDeDatos.getStatement(), "aaaa").size() + 1;
		
		gr.anyadirFilaATablaPartida(BasesDeDatos.getStatement(), "oooo", 15, "2016/01/15");
		
		int num2 = gr.cogerInfoDeTablaPartida(BasesDeDatos.getStatement(), "oooo").size();
		
		assertEquals(num1, num2);
		
	}
	
	@Test
	public void CogerInfoDeTablaPartidaTest() {
		//NULL POINTER EXCEPTION
		String nombre = "uuuu";
		String nombre2 = "";
		gr.anyadirFilaATablaPartida(BasesDeDatos.getStatement(), nombre, 17, "2016/01/10");
		
	
		partida = gr.cogerInfoDeTablaPartida(BasesDeDatos.getStatement(), nombre);
		
		for (int i=0; i< partida.size(); i++){
			if(partida.get(i).getNombre() == nombre){
				nombre2 = nombre;
			}
		}
		assertEquals(nombre, nombre2);
		
	}
	

}
