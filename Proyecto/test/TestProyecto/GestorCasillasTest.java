package TestProyecto;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LN.Casilla;
import LN.GestorCasillas;


public class GestorCasillasTest {
	
	Casilla casilla1;
	Casilla casilla2;
			
		
		@Before
		public void setUp() throws Exception {
			
			casilla1 = new Casilla(210, 295, "verde", 3);
			casilla2 = new Casilla(1055, 130, "rojo", 1);
			
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
		public void testArraySize() {
			
			GestorCasillas gc = new GestorCasillas();
			ArrayList<Casilla> arrayCasilla = new ArrayList<Casilla>();
			
			gc.comenzarCasillas1();
			
			arrayCasilla = gc.casillasList1();
			
			int k1 = gc.casillasList1().size()+1;
			
			arrayCasilla.add(casilla1);
			int k2 = arrayCasilla.size();
			
			assertEquals(k1,k2);
			
		}

}
