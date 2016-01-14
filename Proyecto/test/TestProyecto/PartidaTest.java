package TestProyecto;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LN.Partida;
import LN.Usuario;

public class PartidaTest extends TestCase{

	Partida u;
	
	
	@Before
	public void setUp() throws Exception {
	
		u = new Usuario("ainhoa", "ainhoa", 15, "2016/01/09");
	}
	
	@After
	public void tearDown() throws Exception {
	}
	

	@Test
	public void testGetPuntuacion() {
		int t = u.getPunt();
		
		assertEquals(15, t);
		
	}
	
	
	@Test
	public void testGetValor() {
		String obj = (String) u.getValor(2);
		String fecha = "2016/01/09";
		
		assertEquals(fecha, obj);
		
	}
	
}
