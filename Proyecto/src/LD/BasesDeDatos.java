package LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;

public class BasesDeDatos {

	private static Connection connection = null;
	private static Statement statement = null; //CREATE, INSERT, MODIFY, ADD... ETA HOIETAKOK ITEKO BASES DE DATOS-EN
	
	/** Inicializa una BD SQLITE y devuelve una conexion con ella. Debe llamarse a este 
	 * metodo antes que ningun otro, y debe devolver no null para poder seguir trabajando con la BD.
	 * @param nombreBD	Nombre de fichero de la base de datos
	 * @return	Conexion con la base de datos indicada. Si hay algun error, se devuelve null
	 */
	public static Connection initBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC"); //.jar
		    connection = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg. 
			//TIMEOUT: Si estamos esperando una respuesta y si no nos dan en 30 mseg (en este caso), dejamos de esperar.
		    return connection;
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog( null, "Error!! Nombre: " + nombreBD + " / Contrasenya incorreta" , "ERROR", JOptionPane.ERROR_MESSAGE );
			System.out.println( "Error!! Nombre: " + nombreBD + " / Contrasenya incorreta");
			return null;
		}
	}
	
	/** Cierra la conexion con la Base de Datos*/
	public static void close() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Devuelve la conexion si ha sido establecida previamente (#initBD()).
	 * @return	Conexion con la BD, null si no se ha establecido correctamente.
	 */
	public static Connection getConnection() {
		return connection;
	}
	
	/** Devuelve una sentencia para trabajar con la BD,
	 * si la conexion si ha sido establecida previamente (#initBD()).
	 * @return	Sentencia de trabajo con la BD, null si no se ha establecido correctamente.
	 */
	public static Statement getStatement() {
		return statement;
	}
	
	/** Crea una tabla en una base de datos, si no existia ya.
	 * Debe haberse inicializado la conexion correctamente.
	 */
	//TABLA USUARIO
	public static void crearTablaBDUsuario() {
		if (statement==null) return;
		try {
			statement.executeUpdate("create table USUARIO (int numJuego, Sting nombre, String contrasenya)");
		} catch (SQLException e) {
			// Si hay excepcion es que la tabla ya exist�a (lo cual es correcto)
			e.printStackTrace();  
		}
	}
	
	//TABLA PREGUNTA
	public static void crearTablaBDPregunta() {
		if (statement==null) return;
		try {
			statement.executeUpdate("create table PREGUNTA (int num_Preg, String descp)");
		} catch (SQLException e) {
			// Si hay excepcion es que la tabla ya exist�a (lo cual es correcto)
			e.printStackTrace();  
		}
	}
	
	//TABLA PARTIDA
	public static void crearTablaBDPartida() {
		if (statement==null) return;
		try {
			statement.executeUpdate("create table PARTIDA (int punt, Date fecha)");
		} catch (SQLException e) {
			// Si hay excepcion es que la tabla ya exist�a (lo cual es correcto)
			e.printStackTrace();  
		}
	}
	
	//TABLA PART_PREG
	public static void crearTablaBDPart_Preg() {
		if (statement==null) return;
		try {
			statement.executeUpdate("create table PART_PREG (int num_Preg, Date fecha)");
		} catch (SQLException e) {
			// Si hay excepcion es que la tabla ya exist�a (lo cual es correcto)
			e.printStackTrace();  
		}
	}
	
	//TABLA TEMA
	public static void crearTablaBDTema() {
		if (statement==null) return;
		try {
			statement.executeUpdate("create table TEMA (String color, String descp)");
		} catch (SQLException e) {
			// Si hay excepcion es que la tabla ya exist�a (lo cual es correcto)
			e.printStackTrace();  
		}
	}
	
	//INSTRUCCIONES -- TABLA BAI???
}
