package TestProyecto;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LN.Casilla;
import LN.GestorCasillas;


public class GestorCasillasTest extends TestCase{
	
	Casilla casilla1;
	Casilla casilla2;
	GestorCasillas gc;
	ArrayList<Casilla> arrayCasilla;
			
		
		@Before
		public void setUp() throws Exception {
			
			casilla1 = new Casilla(210, 295, "verde", 3);
			casilla2 = new Casilla(1055, 130, "rojo", 1);
			gc = new GestorCasillas();
			arrayCasilla = new ArrayList<Casilla>();
			
		}
		
		@After
		public void tearDown() throws Exception {
		}
		

		@Test
		public void testgetPos_x1() {
						
			assertEquals(210, casilla1.getPos_x());
			
		}
		
		
		@Test
		public void testgetPos_y1() {
			
			
			assertEquals(210, casilla1.getPos_x());
			
		}
		
		@Test
		public void testgetPunt() {
			
			assertEquals(3, casilla1.getValor());
			
		}
		
		@Test
		public void testgetPos_x2() {
						
			assertEquals(1055, casilla2.getPos_x());
			
		}
		
		@Test
		public void testgetPos_y2() {
			
			assertEquals(130, casilla2.getPos_y());
			
		}
		
		@Test
		public void testcasillasList2() {
			
			
			
			gc.comenzarCasillas2();
			
			arrayCasilla = gc.casillasList2();

			int pos_x = casilla2.getPos_x();
			int pos_x2 = arrayCasilla.get(1).getPos_x();
			
			
			assertEquals(pos_x , pos_x2);
			
		}
		
		

}
