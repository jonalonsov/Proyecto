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
						
			gc.comenzarCasillas1();
			
			arrayCasilla = gc.casillasList1();

			int pos_x = casilla1.getPos_x();
			int pos_x2 = arrayCasilla.get(2).getPos_x();
			
			
			assertEquals(pos_x , pos_x2);
			
		}
		
		
		@Test
		public void testgetPos_y1() {
			
			
			gc.comenzarCasillas1();
			
			arrayCasilla = gc.casillasList1();

			int pos_y = casilla1.getPos_y();
			int pos_y2 = arrayCasilla.get(2).getPos_y();
						
			assertEquals(pos_y , pos_y2);
			
		}
		
		@Test
		public void testgetPunt() {
			
			gc.comenzarCasillas1();
			
			arrayCasilla = gc.casillasList1();

			int valor = casilla2.getValor();
			int valor2 = arrayCasilla.get(0).getValor();
			arrayCasilla.clear();
			
			
			assertEquals(valor , valor2);
			
		}
		
		@Test
		public void testgetPos_x2() {
						
			gc.comenzarCasillas2();
			
			arrayCasilla = gc.casillasList2();

			int pos_x = casilla2.getPos_x();
			int pos_x2 = arrayCasilla.get(0).getPos_x();
			
			
			assertEquals(pos_x , pos_x2);
			
		}
		
		@Test
		public void testgetPos_y2() {
			
			gc.comenzarCasillas2();
			
			arrayCasilla = gc.casillasList2();

			int pos_y = casilla2.getPos_y();
			int pos_y2 = arrayCasilla.get(0).getPos_y();
			arrayCasilla.clear();
			
			
			assertEquals(pos_y , pos_y2);
			
		}
		
		@Test
		public void testcasillasList2() {
			
			
			
			gc.comenzarCasillas2();
			
			arrayCasilla = gc.casillasList2();

//			int pos_x = casilla2.getPos_x();
//			int pos_x2 = arrayCasilla.get(0).getPos_x();
						
			//comprobamos si el color por ejemplo es igual para saber si recibimos el array guardado
			assertEquals(arrayCasilla.get(0).getColor() , casilla2.getColor());
			
		}
		
		

}
