package LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;

public class Partida {

	int punt;
	String fecha;
	
	public Partida(int punt, String fecha){
		this.punt = punt;
		this.fecha = fecha;
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
				
				if (rs.next()) {  // Normalmente se recorre con un while, pero aqui solo hay que ver si ya existe
					rs.close();
					//JOptionPane.showMessageDialog(null, "El usuario ya existe, prueba con otro","Mensaje de error",JOptionPane.ERROR_MESSAGE);
					return true;
				}
				return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	
	public boolean anyadirFilaATablauUsuario( Statement st, String nombre, int puntUsuario, int puntMaq, String fecha ) {
		//INSERT

			if (chequearYaEnTabla(st, nombre)) {  // Si esta ya en la tabla
				// Insercion normal
				try {
					String sentSQL = "insert into PARTIDA values('" + nombre + ", "+ puntUsuario +", " + fecha + ", "+ puntMaq +"')"; 
					System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
					int val = st.executeUpdate( sentSQL );
					if (val!=1) return false;  // Se tiene que añadir 1 - error si no
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
			
			else
				return false;
	}
	
	public void Ranking(Statement statement, String nombre){
		
		try {
			statement.executeQuery("select puntUsuario from PARTIDA where (nombreUsuario = '" + nombre + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
}
