package LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import LD.BasesDeDatos;

public class Instrucciones {

	Statement st;
	
	public Instrucciones(){
		st = BasesDeDatos.getStatement();
		BasesDeDatos.crearTablaBDInstrucciones();
	}
	
	
	public void InsertarInstrucciones(Statement st){
		
		if(st==null)
			System.out.println("¡Bases de Datos sin inicializar!");
		
		else{
			try {
				
				st.executeUpdate("insert into INSTRUCCIONES values ('REGLAS DEL JUEGO"
																+ "\n\nSe jugara de forma individual, tomando como contrario el ordenador, con "
																+ "un numero de puntos y numero de aciertos 0. El objetivo es llegar al "
																+ "centro, respondiendo bien las preguntas que se planteen. "
																+ "\n\nEl primer tirador arroja el dado y mueve su ficha el número de casillas "
																+ "resultante, moviendo el número completo de casillas que marque el dado."
																+ "Cuando una ficha llega a una casilla, se formula al jugador una pregunta. "
																+ "diferente. En el centro de la pantalla se incluye una pregunta con cuatro "
																+ "respuestas posibles. Una vez seleccionada la respuesta se tiene que "
																+ "clikar el boton OK para saber si la respuesta ha sido correcta. Si es correcta, "
																+ "se anyadira los puntos que correspondan a esa casilla (cada casilla tiene su propio "
																+ "valor) a la puntuacion del jugador y +1 preguntas acertadas y seguira tirando el "
																+ "dado para avanzar. Si es incorrecta, se restara -3 puntos y se quedara en la casilla "
																+ "que ya este."
																+ "\n\nEl ganador sera el primero que llege al centro de la tabla."
																+ "\n\n¡SUERTE!')");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
