package TestProyecto;

import static org.junit.Assert.*;

import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LN.Usuario;

public class UsuarioTest {

	Usuario u;
	
	
	@Before
	public void setUp() throws Exception {
	
		u = new Usuario("dada", "dada", 15, "2016/01/09");
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
