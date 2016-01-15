package LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;

import LD.BasesDeDatos;

public class GestorRanking {

		
	public GestorRanking( ){

	}
		

//    PARTIDA!!    //
	
	/** Comprueba si un usuario ya esta en la tabla USUARIO de BD,considerando la trayectoria completa del disco como informacion clave.
	 * @param st	Sentencia ya abierta de base de datos
	 * @return	true si el usuario ya esta en la tabla, false en caso contrario
	 */
	public boolean chequearYaEnTabla( Statement st, String fecha ) {
		//SELECT
		
		try {
				
			String sentSQL = "select * from PARTIDA where ( fecha = '"+ fecha + "')";
			System.out.println( sentSQL ); 
			
			ResultSet rs = st.executeQuery( sentSQL );
			
			if (rs.next()) {
				rs.close();
				JOptionPane.showMessageDialog(null, "Esta partida ya se ha guardado,","Mensaje de error",JOptionPane.ERROR_MESSAGE);
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
	public boolean anyadirFilaATablaPartida( Statement st, String usuario, int puntUsuario, String fecha ) {
	//INSERT

		if (chequearYaEnTabla(st, fecha)) {  // Si esta ya en la tabla
			return modificarFilaEnTablaPartida(st, usuario, fecha, puntUsuario);
		}
		// Insercion normal
		try {
			String sentSQL = "insert into PARTIDA values(" + "'" + usuario + "', " + "'" + puntUsuario + "', " + "'" + fecha +  "')"; 
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
	public boolean modificarFilaEnTablaPartida( Statement st, String usuario, String fecha, int puntUsuario ) {
	//UPDATE
		
		try {
			String sentSQL = "update PARTIDA set "+ 
					"nombreUsuario = '" + usuario + "', " +
					"puntUsuario = '" + puntUsuario + "', " +
					"fecha = '" + fecha + "'";
			System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
			int val = st.executeUpdate( sentSQL );
			if (val!=1) return false;  // Se tiene que modificar 1, error si no
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	
	// COGER INFORMACIÓN DE LA TABLA PARTIDA Y PONER EN ARRAYLIST
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<Partida> cogerInfoDeTablaPartida( Statement st, String usuario ) {
		//SELECT
		
		ArrayList<Partida> ListaPartida = new ArrayList<Partida>();
		
			try {

				String sentSQL = "select * from PARTIDA ";
				System.out.println( sentSQL ); 
				
				ResultSet rs = st.executeQuery( sentSQL );
				
				while(rs.next())
				      {
						
						ListaPartida.add(new Usuario(rs.getString("nombreUsuario"), null, rs.getInt("puntUsuario"), rs.getString("fecha")));
				      
				      }
				
				
					
					Collections.sort(ListaPartida);
					
					return ListaPartida;
					
			} catch (SQLException e) {
				e.printStackTrace();
				
				
			//   ORDENAR	
//				Collections.sort(ListaPartida, new Comparator() {
//					@SuppressWarnings("unused")
//					public int compare(Partida p1, Partida p2) {
//						// Aqui comparamos p2 con p1 para ordenar de mayor a menor y no alrebes
//						return new Integer(p2.getPunt()).compareTo(new Integer(p1.getPunt()));
//					}
//
//					@Override
//					public int compare(Object arg0, Object arg1) {
//						// TODO Auto-generated method stub
//						return 0;
//					}
//				}
//				);
				Collections.sort(ListaPartida);
				return ListaPartida;
			}
		}

}
