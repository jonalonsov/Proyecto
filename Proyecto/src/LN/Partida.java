package LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Partida implements DatoParaTabla, Comparable<Object> {

	int punt;
	String fecha;
	String nombre;
	
	public static String[] nombresAtributos = new String[] {"Nombre_del_Jugador", "Puntuacion", "Fecha"};
	public static boolean[] atributosEditables = new boolean[] {false, false, false };
	
	public Partida(int punt, String fecha, String nombre){
		this.punt = punt;
		this.fecha = fecha;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPunt() {
		return punt;
	}

	public void setPunt(int punt) {
		this.punt = punt;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	public boolean chequearYaEnTabla( Statement st, String nombre ) {
		//SELECT
			try {

				String sentSQL = "select * from PARTIDA where (nombreUsuario = '" + nombre + "')";
				System.out.println( sentSQL ); 
				
				ResultSet rs = st.executeQuery( sentSQL );
				
				if (rs.next()) {
					rs.close();
					return true;
				}
				return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	

	@Override
	public int getNumColumnas() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Object getValor(int col) {
		// TODO Auto-generated method stub
		switch (col) {
	    	case 0: { return getNombre(); }
	    	case 1: { return this.getPunt(); }
	    	case 2: { return this.getFecha(); }
		}
		return null;
	}

	@Override
	public void setValor(Object value, int col) {
		// TODO Auto-generated method stub
		try {
	    	switch (col) {
		    	case 0: { this.setNombre((String) value); break; }
		    	case 1: { this.setPunt( (Integer) value);  break; }
		    	case 2: { this.setFecha((String) value); break; }
	    	}
    	} catch (Exception e) {
    		// Error en conversi�n. Intentando asignar un tipo incorrecto
    		e.printStackTrace();
    	}
	}

	@Override
	public int compareTo(Object o) {
		
		Partida a = (Partida)o;
		
		if(this.punt < a.getPunt()) 
			return  1;
		
		if(this.punt > a.getPunt()) 
			return -1;
		
		
		return 0;
	}

}
