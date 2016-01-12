package LN;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javax.swing.JOptionPane;

import LD.BasesDeDatos;

public class GestorRanking {
	
	//String usuario;
	//int puntUsuario;
	//int fecha;
	
		
	public GestorRanking( ){
//		this.usuario = usuario;
//		this.puntUsuario = puntUsuario;
//		this.fecha = fecha;
//		this.file = file;
		
	}
		

	public boolean existeTabla(){
		boolean b=false;
		try{
				    
		    Statement stat = BasesDeDatos.getStatement();
		    ResultSet rs1=stat.executeQuery("select * from PARTIDA");
				
		    if(rs1.next()){
		    	b=true;
		    }
		        return(b);
		    }    	
		     catch (Exception e){	
			return b;
		    }
	}
	
//    PARTIDA!!    //
	
	/** Comprueba si un usuario ya esta en la tabla USUARIO de BD,considerando la trayectoria completa del disco como informacion clave.
	 * @param st	Sentencia ya abierta de base de datos
	 * @return	true si el usuario ya esta en la tabla, false en caso contrario
	 */
	public boolean chequearYaEnTabla( Statement st, String nombre, String fecha, int puntUsuario ) {
		//SELECT
		
		try {

			if(nombre.equals("Trivial")){
				
				String sentSQL = "select * from PARTIDA where ( nombreUsuario = '"+ nombre +"' and puntUsuario = '"+ puntUsuario + "')";
				System.out.println( sentSQL ); 
				
				ResultSet rs = st.executeQuery( sentSQL );
				
				if (rs.next()) {  // Normalmente se recorre con un while, pero aqui solo hay que ver si ya existe
					rs.close();
					JOptionPane.showMessageDialog(null, "Esta partida ya se ha guardado,","Mensaje de error",JOptionPane.ERROR_MESSAGE);
					return true;
				}
				return false;
			}
			else{
				
				String sentSQL = "select * from PARTIDA where ( fecha = '"+ fecha + "')";
				System.out.println( sentSQL ); 
				
				ResultSet rs = st.executeQuery( sentSQL );
				
				if (rs.next()) {  // Normalmente se recorre con un while, pero aqui solo hay que ver si ya existe
					rs.close();
					JOptionPane.showMessageDialog(null, "Esta partida ya se ha guardado,","Mensaje de error",JOptionPane.ERROR_MESSAGE);
					return true;
				}
				return false;
			}
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

		if (chequearYaEnTabla(st, usuario, fecha, puntUsuario)) {  // Si esta ya en la tabla
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
					"fecha = '" + fecha + "')";
			System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
			int val = st.executeUpdate( sentSQL );
			if (val!=1) return false;  // Se tiene que modificar 1, error si no
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Partida> cogerInfoDeTablaPartida( Statement st, String usuario ) {
		//SELECT
		
		ArrayList<Partida> ListaPartida = new ArrayList<Partida>();
		
			try {

				String sentSQL = "select * from PARTIDA where (nombreUsuario = '" + usuario + "')";
				System.out.println( sentSQL ); 
				
				ResultSet rs = st.executeQuery( sentSQL );
				
				while(rs.next())
				      {
						
						ListaPartida.add(new Usuario(rs.getString("nombreUsuario"), null, rs.getInt("puntUsuario"), rs.getString("fecha")));
				      
				      }
					
					return ListaPartida;
					
			} catch (SQLException e) {
				e.printStackTrace();
				Collections.sort(ListaPartida);
				return ListaPartida;
			}
		}
	
//	public ArrayList<Usuario> cogerInfoDeTablaUsuario( Statement st, String usuario ) {
//		//SELECT
//		
//		ArrayList<Usuario> ListaPartidaUsuario = new ArrayList<Usuario>();
//		
//			try {
//
//				String sentSQL = "select * from PARTIDA where (nombreUsuario = '" + usuario + "')";
//				System.out.println( sentSQL ); 
//				
//				ResultSet rs = st.executeQuery( sentSQL );
//				
//				while(rs.next())
//				      {
//						
//						ListaPartidaUsuario.add(new Usuario(rs.getString("nombreUsuario"), null, rs.getInt("puntUsuario"), rs.getString("fecha")));
//				      
//				      }
//					
//					return ListaPartidaUsuario;
//					
//			} catch (SQLException e) {
//				e.printStackTrace();
//				return ListaPartidaUsuario;
//			}
//		}
//	
//	public ArrayList<Maquina> cogerInfoDeTablaMaquina( Statement st ) {
//		//SELECT
//		
//		ArrayList<Maquina> ListaPartidaMaquina = new ArrayList<Maquina>();
//		
//			try {
//
//				String sentSQL = "select * from PARTIDA where (nombreUsuario = 'Trivial')";
//				System.out.println( sentSQL ); 
//				
//				ResultSet rs = st.executeQuery( sentSQL );
//				
//				while(rs.next())
//				      {
//						
//					ListaPartidaMaquina.add(new Maquina(rs.getInt("puntUsuario"), rs.getString("fecha")));
//				      
//				      }
//					
//					return ListaPartidaMaquina;
//					
//			} catch (SQLException e) {
//				e.printStackTrace();
//				return ListaPartidaMaquina;
//			}
//		}
}
