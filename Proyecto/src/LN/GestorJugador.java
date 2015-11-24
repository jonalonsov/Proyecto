package LN;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorJugador {

	File file;
	String contrasenya;
	String nombre;
	int numJug;
	
	public GestorJugador(int numJug, String nombre, String contrasenya, File file){
		this.nombre = (nombre==null?"":nombre);
		this.contrasenya = (contrasenya==null?"":contrasenya);
		this.numJug = numJug;
		this.file = file;
		
	}

	
	
//    USUARIO!!    //
	
	/** Comprueba si un usuario ya esta en la tabla USUARIO de BD,considerando la trayectoria completa del disco como informacion clave.
	 * @param st	Sentencia ya abierta de base de datos
	 * @return	true si el usuario ya esta en la tabla, false en caso contrario
	 */
	public boolean chequearYaEnTabla( Statement st ) {
	//SELECT
		try {
			String sentSQL = "select * from USUARIO where (fichero = '" + file.getAbsolutePath() + "')";
			System.out.println( sentSQL ); 
			ResultSet rs = st.executeQuery( sentSQL );
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
		
	/** Añade un usuario a la tabla USUARIO de BD, 
	 * que debe estar abierta y tener el formato y los nombres de campos apropiados: (int numJuego, Sting nombre, String contrasenya)
	 * Usa la sentencia INSERT de SQL.
	 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al usuario)
	 * @return	true si la inserción es correcta, false en caso contrario
	 */
	public boolean anyadirFilaATablauUsuario( Statement st ) {
	//INSERT

		if (chequearYaEnTabla(st)) {  // Si esta ya en la tabla
			return modificarFilaEnTablaUsuario(st);
		}
		// Insercion normal
		try {
			String sentSQL = "insert into USUARIO values(" +
					"'" + file.getAbsolutePath() + "', " +
					"'" + numJug + "', " +
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
			String sentSQL = "update USUARIO set "
					+ "num_Jug = '" + numJug + "', " +
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
