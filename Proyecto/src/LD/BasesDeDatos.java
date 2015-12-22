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
			JOptionPane.showMessageDialog( null, "Ondo!! Nombre: " + nombreBD + " / DATU BASEA KONEKTATU DA" , "BIEN", JOptionPane.INFORMATION_MESSAGE);
		    return connection;
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog( null, "Error!! Nombre: " + nombreBD + " / no se ha conectado la base de datos" , "ERROR", JOptionPane.ERROR_MESSAGE );
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
			statement.executeUpdate("create table USUARIO ( nombre string, contrasenya string)");
		} catch (SQLException e) {
			// Si hay excepcion es que la tabla ya exist�a (lo cual es correcto)
			if (!e.getMessage().equals("table interaccion already exists"))
				e.printStackTrace();  
		}
	}
	
	//TABLA PREGUNTA
	public static void crearTablaBDPregunta() {
		if (statement==null) return;
		try {
			statement.executeUpdate("create table PREGUNTA (descp string, resp1 string, resp2 string, resp3 string, resp4 string, correcta string)");
		
			try {
				statement.executeUpdate( "insert into PREGUNTA values(" 
										+ "'¿Donde se encuentra el Palacio Taj Mahal?'," + 
										"'China', 'India', 'Japon', 'Rusia', 'India')" );
				
				statement.executeUpdate( "insert into PREGUNTA values(" 
										+ "'El animal que come tanto plantas como animales se denomina: '," + 
										"'Oviparos', 'Herbivoro', 'Omnivoro', 'Carnivoro', 'Omnivoro')" );
				
				statement.executeUpdate( "insert into PREGUNTA values(" 
										+ "'¿Como se llama la forma de gobierno que se crea con la revolucion francesa?'," + 
										"'Libelarismo', 'Liberacion', 'Ilustracion', 'Feudalismo', 'Libelarismo')" );
				
				statement.executeUpdate( "insert into PREGUNTA values(" 
										+ "'El Renacimiento se produjo en Europa Occidental durante: '," + 
										"'La Edad Contemporanea', 'La Edad Media', 'La Edad Moderna', 'La Edad Antigua', 'La Edad Moderna')" );
				
				statement.executeUpdate( "insert into PREGUNTA values(" 
										+ "'¿Cual es el elemento químico cuyo símbolo es Pb?'," + 
										"'Polonio', 'Platino', 'Praseodimio', 'Plomo', 'Plomo')" );
				
				statement.executeUpdate( "insert into PREGUNTA values(" 
										+ "'¿Que acontecimiento marca el inicio de la Edad Moderna?'," + 
										"'Revolución Industrial', 'Máquina de vapor', 'Descubrimiento de America', 'La caida del Imperio Romano', 'Descubrimiento de America')" );
				
				statement.executeUpdate( "insert into PREGUNTA values(" 
										+ "'El Monte Vesubio se encentra en: '," + 
										"'Corcega', 'Sicilia', 'Napoles', 'Roma', 'Napoles')" );
				
				statement.executeUpdate( "insert into PREGUNTA values(" 
										+ "'¿Quien pinto La lechera?'," + 
										"'Joaquin Sorolla', 'Joan Miro', 'Johannes Vermeer', 'Max Ernst', 'Johannes Vermeer')" );
				
				statement.executeUpdate( "insert into PREGUNTA values(" 
										+ "'La ciencia o rama de la biología que estudia los vegetales se denomina:'," + 
										"'Botanica', 'Ecologia', 'Microbiologia', 'Zoologia', 'Botanica')" );
				
				statement.executeUpdate( "insert into PREGUNTA values(" 
										+ "'¿Donde se encuentra el Catedral Braga?'," + 
										"'España', 'Portugal', 'Italia', 'Grecia', 'Portugal')" );
				
				statement.executeUpdate( "insert into PREGUNTA values(" 
										+ "'El gentilicio de la provincia de Albacete es: '," + 
										"'Albacereño', 'Albaceteño', 'Albecetense', 'Albecetano', 'Albaceteño')" );
				
				statement.executeUpdate( "insert into PREGUNTA values(" 
										+ "'¿En qué movimiento cultural se encuentra Mariano Benlliure?'," + 
										"'Romanticismo', 'Fauvismo', 'Impresionismo', 'Realismo', 'Realismo')" );
				
				statement.executeUpdate( "insert into PREGUNTA values(" 
										+ "'¿Cual de las siguientes palabras deberia de llevar tilde segun las reglas ortograficas?'," + 
										"'Surgir', 'Toner', 'Capaz', 'Programar', 'Toner')" );
				
				statement.executeUpdate( "insert into PREGUNTA values(" 
										+ "'¿De que estilo arquitectonico es la plaza mayor de Salamanca?'," + 
										"'Gotico', 'Barroco', 'Romanico, 'Renacentista', 'Barroco')" );
				
				statement.executeUpdate( "insert into PREGUNTA values(" 
										+ "'¿Cual de los siguientes autores no pertenece a la Ilustración?'," + 
										"'Fernandez de Moratin', 'Samaniego Zabala', 'Becquer', 'Jovrllanos', 'Becquer')" );
				
				statement.executeUpdate( "insert into PREGUNTA values(" 
										+ "'¿Cual es la magnitud que relaciona espacio y tiempo?'," + 
										"'Temperatura', 'Peso', 'Velocidad', 'Gravedad', 'Velocidad')" );
				
				statement.executeUpdate( "insert into PREGUNTA values(" 
										+ "'¿En donde se encuentra la Acropolis?'," + 
										"'Venecia', 'Atenas', 'Roma', 'Florencia', 'Atenas')" );
				
				statement.executeUpdate( "insert into PREGUNTA values(" 
										+ "'¿Cual fue la primera capital de los Estados Unidos de America?'," + 
										"'Nueva York', 'Chicago', 'Washington', 'Philadelphia', 'Nueva York')" );
				
				statement.executeUpdate( "insert into PREGUNTA values(" 
										+ "'¿Cual de las siguientes palabras es compuesta?'," + 
										"'Escobilla', 'Libreria', 'Mediodia', 'Cogedor', 'Mediodia')" );
				
				statement.executeUpdate( "insert into PREGUNTA values(" 
										+ "'¿Con la muerte de quien dio por finalizado el Sgli de Oro?'," + 
										"'Machado', 'Quevedo', 'Calderon', 'Cervantes', 'Calderon')" );
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			// Si hay excepcion es que la tabla ya exist�a (lo cual es correcto)
			e.printStackTrace();  
		}
	}
	
	//TABLA PARTIDA
	public static void crearTablaBDPartida() {
		if (statement==null) return;
		try {
			statement.executeUpdate("create table PARTIDA (punt int, fecha Date)");
		} catch (SQLException e) {
			// Si hay excepcion es que la tabla ya exist�a (lo cual es correcto)
			e.printStackTrace();  
		}
	}
	
	//TABLA PART_PREG
	public static void crearTablaBDPart_Preg() {
		if (statement==null) return;
		try {
			statement.executeUpdate("create table PART_PREG ( num_Preg int,  fecha Date)");		
		} catch (SQLException e) {
			// Si hay excepcion es que la tabla ya exist�a (lo cual es correcto)
			e.printStackTrace();  
		}
	}
	
	//TABLA TEMA
	public static void crearTablaBDTema() {
		if (statement==null) return;
		try {
			statement.executeUpdate("create table TEMA ( color string,  descp string)");
		} catch (SQLException e) {
			// Si hay excepcion es que la tabla ya exist�a (lo cual es correcto)
			e.printStackTrace();  
		}
	}
	
	//INSTRUCCIONES -- TABLA BAI???
}
