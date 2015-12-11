package LN;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import LD.BasesDeDatos;

public class GestorJugador {

	File file;
	String contrasenya;
	String nombre;
		
	public GestorJugador(String nombre, String contrasenya, File file){
		this.nombre = nombre;
		this.contrasenya = contrasenya;
		this.file = file;
		
	}
		

	public boolean existeTabla(){
		boolean b=false;
		try{
//		    Class.forName("org.gjt.mm.mysql.Driver").newInstance();
//		    String url = "jdbc:mysql://localhost/almacenamiento";
//		    String DB_USER =   "user";          
//		    String DB_PASSWD = "pass";
//								 
//		    Connection c1= DriverManager.getConnection(url, DB_USER, DB_PASSWD);
//				    
		    Statement stat = BasesDeDatos.getStatement();
		    ResultSet rs1=stat.executeQuery("select * from usuario");
				
		    if(rs1.next()){
		    	b=true;
		    }
		        return(b);
		    }    	
		     catch (Exception e){	
			return b;
		    }
	}

	public int contar(){
		Statement s = BasesDeDatos.getStatement();
		try {
			ResultSet contar = s.executeQuery("select count(*) as num from USUARIO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return contar();
	}
	
	
//    USUARIO!!    //
	
	/** Comprueba si un usuario ya esta en la tabla USUARIO de BD,considerando la trayectoria completa del disco como informacion clave.
	 * @param st	Sentencia ya abierta de base de datos
	 * @return	true si el usuario ya esta en la tabla, false en caso contrario
	 */
	public boolean chequearYaEnTabla( Statement st, String nombre ) {
		//SELECT
			try {

				String sentSQL = "select * from USUARIO where (nombre = '" + nombre + "')";
				System.out.println( sentSQL ); 
				
				ResultSet rs = st.executeQuery( "select * from USUARIO where (nombre = '" + nombre + "')" );
				
				if (rs.next()) {  // Normalmente se recorre con un while, pero aqui solo hay que ver si ya existe
					rs.close();
					return true;
				}
				return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	public boolean anyadirUnaFila( Statement st, String nombre, String contrasenya ) {
		//INSERT

			// Insercion normal
			try {
				String sentSQL = "insert into USUARIO values(" +
								"'" + nombre + "', " +
								"'" + contrasenya + "')"; 
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
				ResultSet num = st.executeQuery("select count(*) from USUARIO");  //  --> NULL POINTER EXCEPTION
				System.out.println(num);
				int val=0;
				while (num.next())
					val = st.executeUpdate( sentSQL );  //  --> NULL POINTER EXCEPTION
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
	/** Añade un usuario a la tabla USUARIO de BD, 
	 * que debe estar abierta y tener el formato y los nombres de campos apropiados: (int numJuego, Sting nombre, String contrasenya)
	 * Usa la sentencia INSERT de SQL.
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al usuario)
	 * @return	true si la inserción es correcta, false en caso contrario
	 */
	public boolean anyadirFilaATablauUsuario( Statement st, String nombre ) {
	//INSERT

		if (chequearYaEnTabla(st, nombre)) {  // Si esta ya en la tabla
			return modificarFilaEnTablaUsuario(st);
		}
		// Insercion normal
		try {
			String sentSQL = "insert into USUARIO values(" +
							"'" + nombre + "', " +
							"'" + contrasenya + "')";
			System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
			int val = st.executeUpdate( sentSQL );
			if (val!=1) return false;  // Se tiene que añadir 1 - error si no
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/** Modifica los datos de un usuario en la tabla USUARIO de BD, 
	 * que debe estar abierta y tener el formato y los nombres de campos apropiados:(int numJuego, Sting nombre, String contrasenya)
	 * Usa la sentencia UPDATE de SQL.
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al usuario)
	 * @return	true si la modificacion es correcta, false en caso contrario
	 */
	public boolean modificarFilaEnTablaUsuario( Statement st ) {
	//UPDATE
		try {
			String sentSQL = "update USUARIO set "+ 
					"nombre = '" + nombre + "', " +
					"contrasenya = '" + contrasenya + "', " +
					"where (fichero = '" + file.getAbsolutePath() + "')";
			System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
			int val = st.executeUpdate( sentSQL );
			if (val!=1) return false;  // Se tiene que modificar 1, error si no
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
