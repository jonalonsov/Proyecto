package TestProyecto;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LD.BasesDeDatos;
import LN.GestorJugador;
import LN.GestorRanking;
import LN.Partida;

public class GestorRankingTest extends TestCase {

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
		
		gr.anyadirFilaATablaPartida(BasesDeDatos.getStatement(), "eider", 15, "2016/01/10");
		gr.anyadirFilaATablaPartida(BasesDeDatos.getStatement(), "aitor", 20, "2016/01/05");
		gr.anyadirFilaATablaPartida(BasesDeDatos.getStatement(), "maddi", 10, "2016/01/12");
		
		int num1 = gr.cogerInfoDeTablaPartida(BasesDeDatos.getStatement(), "eider").size() + 1;
		
		gr.anyadirFilaATablaPartida(BasesDeDatos.getStatement(), "oier", 15, "2016/01/15");
		
		int num2 = gr.cogerInfoDeTablaPartida(BasesDeDatos.getStatement(), "oier").size();
		
		assertEquals(num1, num2, 4);
		
	}
	
	@Test
	public void CogerInfoDeTablaPartidaTest() {
		
		String nombre = "amaia";
		String nombre2 = "";
		
		gr.anyadirFilaATablaPartida(BasesDeDatos.getStatement(), nombre, 17, "2016/01/30");
	
		partida = gr.cogerInfoDeTablaPartida(BasesDeDatos.getStatement(), nombre);
		
		for (int i=0; i < partida.size(); i++){
			if(partida.get(i).getFecha() == "2016/01/30"){
				nombre2 = "amaia";
			}
		}
		
		assertEquals(nombre2, nombre, "amaia");
		
	}


	

}
