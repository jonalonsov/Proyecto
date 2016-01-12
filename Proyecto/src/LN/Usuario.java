package LN;


public class Usuario extends Partida {

	String contrasenya;
	
	public static String[] nombresAtributos = new String[] {"Nombre_de_Usuario", "Puntuacion", "Fecha"};
	public static boolean[] atributosEditables = new boolean[] {false, false, false };
	
	public Usuario(String nombre, String contrasenya, int punt, String fecha){
		super(punt, fecha, nombre);
		this.contrasenya = contrasenya;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
//	@Override
//	public int getNumColumnas() {
//		// TODO Auto-generated method stub
//		return 3;
//	}
//
//	@Override
//	public Object getValor(int col) {
//		// TODO Auto-generated method stub
//		switch (col) {
//	    	case 0: { return getNombre(); }
//	    	case 1: { return this.getPunt(); }
//	    	case 2: { return this.getFecha(); }
//		}
//		return null;
//	}
//
//	@Override
//	public void setValor(Object value, int col) {
//		// TODO Auto-generated method stub
//		try {
//	    	switch (col) {
//		    	case 0: { this.setNombre((String) value); break; }
//		    	case 1: { this.setPunt( (Integer) value);  break; }
//		    	case 2: { this.setFecha((String) value); break; }
//	    	}
//    	} catch (Exception e) {
//    		// Error en conversi�n. Intentando asignar un tipo incorrecto
//    		e.printStackTrace();
//    	}
//	}
	
	

	

//@Override
//public int compareTo(Partida o) {
//	// TODO Auto-generated method stub
//	
//	if(this.punt>o.getPunt())return  1;
//	if(this.punt>o.getPunt())return -1;
//	
//	return 0;
//}
	
}
