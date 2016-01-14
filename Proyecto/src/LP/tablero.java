package LP;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import LD.BasesDeDatos;
import LN.Dado;
import LN.FichaJuego1;
import LN.FichaJuego2;
import LN.GestorCasillas;
import LN.GestorRanking;
import LN.PanelConImagen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;



public class tablero extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int contadorPrueba = -1;
	private int contadorUsuario = -1;
	private int numeroDadoUsuario=0;
	private PanelConImagen contentPane;
	private JTextArea Pregunta;
	private JRadioButton NUMEROUNO;
	private JRadioButton NUMERODOS;
	private JRadioButton NUMEROTRES;
	private JRadioButton NUMEROCUATRO;
	private JTextField respuesta_1;
	private JTextField respuesta_2;
	private JTextField respuesta_3;
	private JTextField respuesta_4;
	private JTextField textField;
	private JTextField textField_1;
	private Dado lblDado;
	private JButton btnTirarDado;
	String correcta;
	private FichaJuego1 miFicha1 = new FichaJuego1();
	private FichaJuego2 miFicha2 = new FichaJuego2();         
	
	private JButton btnOK;
	private JButton btnSalir;
	GestorCasillas GestorCasillas = new GestorCasillas();
	
	private Integer[] array = {0, 1};
	
	int jug1_aciertos = 0;
	int maquina_aciertos = 0;
	int jug1_puntos = 0;
	int maquina_puntos = 0;
	
	String resp1 = "";
	String resp2 = "";
	String resp3 = "";
	String resp4 = "";
	
	String nombre;
	int aleatorio;
	private JLabel label;
	private JTextField textField_puntosMaquina;
	private JTextField textField_aciertosMaquina;

	public tablero( String nombre ) {
		this.nombre = nombre;
		
		BasesDeDatos.crearTablaBDPregunta();
		BasesDeDatos.insertarPreguntas(BasesDeDatos.getStatement());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1000, 1000, 4500, 3000);
		contentPane = new PanelConImagen();
		Image background = contentPane.createImage("/imagenes/tablero_vectorized.png").getImage();
		background.getScaledInstance(100, 300, 0);
		contentPane.setBackgroundImage(background);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(217, 218, 186));
		
		JPanel panel = new JPanel();
		panel.setBounds(495, 261, 354, 193);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPreguntas = new JLabel("PREGUNTAS");
		lblPreguntas.setBounds(119, 5, 95, 18);
		lblPreguntas.setFont(new Font("Verdana", Font.BOLD, 14));
		panel.add(lblPreguntas);
		
		NUMEROUNO = new JRadioButton(" ");
		NUMEROUNO.setBounds(17, 87, 22, 23);
		panel.add(NUMEROUNO);
		
		NUMERODOS = new JRadioButton(" ");
		NUMERODOS.setHorizontalAlignment(SwingConstants.LEFT);
		NUMERODOS.setBounds(17, 125, 22, 23);
		panel.add(NUMERODOS);
		
		NUMEROTRES = new JRadioButton(" ");
		NUMEROTRES.setBounds(171, 87, 22, 23);
		panel.add(NUMEROTRES);
		
		NUMEROCUATRO = new JRadioButton(" ");
		NUMEROCUATRO.setBounds(171, 125, 22, 23);
		panel.add(NUMEROCUATRO);
		
		respuesta_1 = new JTextField();
		respuesta_1.setBounds(45, 87, 120, 23);
		panel.add(respuesta_1);
		respuesta_1.setColumns(10);
		respuesta_1.setEditable(false);
				
		respuesta_2 = new JTextField();
		respuesta_2.setColumns(10);
		respuesta_2.setBounds(45, 126, 121, 20);
		panel.add(respuesta_2);
		respuesta_2.setEditable(false);
		
		respuesta_3 = new JTextField();
		respuesta_3.setColumns(10);
		respuesta_3.setBounds(199, 88, 120, 22);
		panel.add(respuesta_3);
		respuesta_3.setEditable(false);
		
		respuesta_4 = new JTextField();
		respuesta_4.setColumns(10);
		respuesta_4.setBounds(199, 126, 120, 22);
		panel.add(respuesta_4);
		respuesta_4.setEditable(false);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(NUMEROUNO);
		bg.add(NUMERODOS);
		bg.add(NUMEROTRES);
		bg.add(NUMEROCUATRO);
		
		
		
	
		JLabel lblPuntos = new JLabel("PUNTOS");
		lblPuntos.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblPuntos.setBounds(59, 614, 111, 26);
		contentPane.add(lblPuntos);
		
		textField = new JTextField();
		textField.setBounds(59, 651, 94, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPreguntasAcertadas = new JLabel("PREGUNTAS CORRECTAS");
		lblPreguntasAcertadas.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblPreguntasAcertadas.setBounds(255, 614, 296, 34);
		contentPane.add(lblPreguntasAcertadas);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(255, 654, 94, 26);
		contentPane.add(textField_1);
		
		
		
		btnTirarDado = new JButton("Tirar \r\nDado");
		btnTirarDado.setFont(new Font("Stencil", Font.PLAIN, 14));
		btnTirarDado.setBounds(117, 36, 126, 39);
		contentPane.add(btnTirarDado);
		btnTirarDado.addActionListener(this);
		
		lblDado = new Dado();
		lblDado.setBounds(280, 11, 88, 87);
		contentPane.add(lblDado);
		
		btnOK = new JButton("OK");
		btnOK.setBounds(146, 154, 54, 23);
		panel.add(btnOK);
		btnOK.addActionListener(this);
		btnOK.setEnabled(false);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(43, 34, 283, 40);
		panel.add(scroll);
		
		Pregunta = new JTextArea();
		scroll.setViewportView(Pregunta);
		Pregunta.setColumns(10);
		Pregunta.setEditable(false);
		
		
		JLabel lblJugador = new JLabel("JUGADOR 1: " + nombre);
		lblJugador.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblJugador.setBounds(24, 577, 376, 26);
		contentPane.add(lblJugador);
		
		label = new JLabel("PUNTOS");
		label.setFont(new Font("Stencil", Font.PLAIN, 25));
		label.setBounds(1224, 618, 111, 26);
		contentPane.add(label);
		
		textField_puntosMaquina = new JTextField();
		textField_puntosMaquina.setColumns(10);
		textField_puntosMaquina.setBounds(1234, 651, 94, 26);
		contentPane.add(textField_puntosMaquina);
		
		JLabel label_1 = new JLabel("PREGUNTAS CORRECTAS");
		label_1.setFont(new Font("Stencil", Font.PLAIN, 25));
		label_1.setBounds(883, 614, 296, 34);
		contentPane.add(label_1);
		
		textField_aciertosMaquina = new JTextField();
		textField_aciertosMaquina.setColumns(10);
		textField_aciertosMaquina.setBounds(1085, 651, 94, 26);
		contentPane.add(textField_aciertosMaquina);
		
		JLabel lblJugador_1 = new JLabel("JUGADOR 2: Trivial");
		lblJugador_1.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblJugador_1.setBounds(959, 581, 376, 26);
		contentPane.add(lblJugador_1);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setFont(new Font("Stencil", Font.PLAIN, 14));
		btnSalir.setIcon(new ImageIcon(tablero.class.getResource("/imagenes/red_x.png")));
		btnSalir.setBounds(1241, 11, 94, 34);
		contentPane.add(btnSalir);

		PreguntaUsuario();
		
		//crear posiciones casillas
		GestorCasillas.comenzarCasillas1();
		GestorCasillas.comenzarCasillas2();
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {


		if (e.getSource() == btnTirarDado){

			numeroDadoUsuario = lblDado.tirarDado();
			System.out.println(numeroDadoUsuario);
			
			
			btnOK.setEnabled(true);
			btnTirarDado.setEnabled(false);
			
			if(numeroDadoUsuario == 1){
			JOptionPane.showMessageDialog( null, "HAS SACADO UN 1, ACIERTA LA PREGUNTA PARA PODER MOVER LA FICHA" , null, JOptionPane.INFORMATION_MESSAGE);
			}
			if(numeroDadoUsuario == 2){
				JOptionPane.showMessageDialog( null, "HAS SACADO UN 2, ACIERTA LA PREGUNTA PARA PODER MOVER LA FICHA" , null, JOptionPane.INFORMATION_MESSAGE);
			}
			if(numeroDadoUsuario == 3){
				JOptionPane.showMessageDialog( null, "HAS SACADO UN 3, ACIERTA LA PREGUNTA PARA PODER MOVER LA FICHA" , null, JOptionPane.INFORMATION_MESSAGE);
			}
			if(numeroDadoUsuario == 4){
				JOptionPane.showMessageDialog( null, "HAS SACADO UN 4, ACIERTA LA PREGUNTA PARA PODER MOVER LA FICHA" , null, JOptionPane.INFORMATION_MESSAGE);
			}
			if(numeroDadoUsuario == 5){
				JOptionPane.showMessageDialog( null, "HAS SACADO UN 5, ACIERTA LA PREGUNTA PARA PODER MOVER LA FICHA" , null, JOptionPane.INFORMATION_MESSAGE);
			}
			if(numeroDadoUsuario == 6){
				JOptionPane.showMessageDialog( null, "HAS SACADO UN 6, ACIERTA LA PREGUNTA PARA PODER MOVER LA FICHA" , null, JOptionPane.INFORMATION_MESSAGE);
			}
			
			
			AnadirInformacion();	
			
		}
		
		
		if (e.getSource() == btnOK){
			
			//SELECCION DE RESPUESTA
			if(NUMEROUNO.isSelected()==true){
				this.ComprobarRespuesta(resp1);
				
			} if(NUMERODOS.isSelected()==true){
				this.ComprobarRespuesta(resp2);
				
			} if(NUMEROTRES.isSelected()==true){
				this.ComprobarRespuesta(resp3);
				
			} if(NUMEROCUATRO.isSelected()==true){
				this.ComprobarRespuesta(resp4);
				
			}
		}
		
		if (e.getSource() == btnSalir)
			dispose();
		
	}
	
	
	
	
	
	public void AnadirInformacion(){
		
		Statement st = BasesDeDatos.getStatement();
		String s = "";
		
		try {
			s = "select * from PREGUNTA order by RANDOM()";
			ResultSet rs = st.executeQuery(s);
			Pregunta.setText(rs.getString("descp"));
			
			resp1 = rs.getString("resp1");
			respuesta_1.setText(resp1);
			
			resp2 = rs.getString("resp2");
			respuesta_2.setText(resp2);
			
			resp3 = rs.getString("resp3");
			respuesta_3.setText(resp3);
			
			resp4 = rs.getString("resp4");
			respuesta_4.setText(resp4);
			
			correcta = rs.getString("correcta");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void PreguntaUsuario(){
		
			Pregunta.setText("Â¡TIRA EL DADO!");
						
			respuesta_1.setText(" ");
			
			respuesta_2.setText(" ");
			
			respuesta_3.setText(" ");
			
			respuesta_4.setText(" ");
			
	}
	
	public void PreguntaMaquina(){
		
		Pregunta.setText("ES EL TURNO DE LA MAQUINA");
					
		respuesta_1.setText(" ");
		
		respuesta_2.setText(" ");
		
		respuesta_3.setText(" ");
		
		respuesta_4.setText(" ");
		
}
	
	public void creaFicha1( int posX, int posY ) {
		// Crear y anyadir el ficha a la ventana
		
		miFicha1.setPosicion( posX, posY );
		contentPane.add( miFicha1.getGrafico1() );
	}
	public void creaFicha2( int posX, int posY ) {
		// Crear y anyadir el ficha a la ventana
		
		miFicha2.setPosicion( posX, posY );
		contentPane.add( miFicha2.getGrafico2() );
	}
	
	
	public void ComprobarRespuesta(String respuestaSeleccionada){
		
		btnTirarDado.setEnabled(true);
		btnOK.setEnabled(false);
		
		
		if(respuestaSeleccionada.equals(correcta)){
			jug1_aciertos++;
			
			textField_1.setText(String.valueOf(jug1_aciertos));
			this.RespuestaCORRECTA(true);
			
			
			
		}
		else{
						
			jug1_puntos = jug1_puntos - 3;
			textField.setText(String.valueOf(jug1_puntos));
			JOptionPane.showMessageDialog( null, "¡RESPUESTA INCORRECTA!" , "RESPUESTA", JOptionPane.INFORMATION_MESSAGE);
			PreguntaMaquina();
			
			
			btnTirarDado.setEnabled(false);
			btnOK.setEnabled(false);
			
			this.RespuestaMaquina();
			
		}

	}
	
	public void RespuestaCORRECTA(boolean jugador){  //jugador: true: usuario / false: maquina
		if(jugador == true){
			JOptionPane.showMessageDialog( null, "¡BIEN! ¡RESPUESTA CORRECTA! VUELVE A TIRAR EL DADO" , "RESPUESTA", JOptionPane.INFORMATION_MESSAGE);
		
			contadorUsuario = contadorUsuario + numeroDadoUsuario;
			if(contadorUsuario > 10) {contadorUsuario=10;}
			System.out.println("contador=" + contadorUsuario);
			//mover ficha
			int pos_x1 = GestorCasillas.getPos_x1(contadorUsuario);
			int pos_y1 = GestorCasillas.getPos_y1(contadorUsuario);
			miFicha1.setPosicion(pos_x1, pos_y1);
			System.out.println(contadorUsuario + "     " + pos_x1 + "   "+pos_y1);
			numeroDadoUsuario=0;
			jug1_puntos = jug1_puntos + GestorCasillas.getPunt(contadorUsuario);
			textField.setText(String.valueOf(jug1_puntos));
			
			
			
			this.FinalPartida();
		}
		
		if (jugador == false){
			numeroDadoUsuario=0;
			try {
				Thread.sleep( 500 );
			} catch (Exception e) {
			}

			RespuestaMaquina();

		}
		
		PreguntaUsuario();
		
		
	}
	
	public void RespuestaMaquina(){

		Random random = new Random();
		aleatorio = random.nextInt(array.length);
		
		if(aleatorio == 1){
			maquina_aciertos++;	
			
			textField_aciertosMaquina.setText(String.valueOf(maquina_aciertos));
			
			
			Random caras = new Random();
	        int numeroDadoMaquina = caras.nextInt(6)+1;
	        contadorPrueba= contadorPrueba + numeroDadoMaquina;
	        if(contadorPrueba > 10)	contadorPrueba=10;
	        
			int pos_x2 = GestorCasillas.getPos_x2(contadorPrueba);
			int pos_y2 = GestorCasillas.getPos_y2(contadorPrueba);
			miFicha2.setPosicion(pos_x2, pos_y2);
			System.out.println(contadorPrueba + "     " + pos_x2 + "   "+pos_y2);
			maquina_puntos = maquina_puntos + GestorCasillas.getPunt(contadorPrueba);
			textField_puntosMaquina.setText(String.valueOf(maquina_puntos));
			
			
			JOptionPane.showMessageDialog( null, "¡RESPUESTA DE TRIVIAL CORRECTA! SU FICHA MOVERA "+ numeroDadoMaquina +" CASILLAS" , "RESPUESTA", JOptionPane.INFORMATION_MESSAGE);
			
			numeroDadoUsuario=0;
			try {
				Thread.sleep( 500 );
			} catch (Exception e) {
			}
			
			if(contadorPrueba == 10){
				this.FinalPartida();
			}else{
				this.RespuestaCORRECTA(false);
			}

			
		}else if (aleatorio == 0){
			try {
				Thread.sleep( 500 );
			} catch (Exception e) {
			}
			maquina_puntos = maquina_puntos - 3;
			textField_puntosMaquina.setText(String.valueOf(maquina_puntos));
			JOptionPane.showMessageDialog( null, "¡RESPUESTA DE TRIVIAL INCORRECTA! TU TURNO" , "RESPUESTA", JOptionPane.INFORMATION_MESSAGE);
			
			btnTirarDado.setEnabled(true);
			btnOK.setEnabled(false);
			PreguntaUsuario();
			
		}
		
		
	}
	
	
	public void FinalPartida(){
	
		aleatorio = -1;
		Date data = new Date();
		SimpleDateFormat formato = new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss" );
		System.out.println( "Fecha de la partida: " + formato.format(data) );
		
		if(contadorUsuario == 10){
			
			BasesDeDatos.crearTablaBDPartida();
			GestorRanking gr = new GestorRanking();
			gr.anyadirFilaATablaPartida(BasesDeDatos.getStatement(), nombre, jug1_puntos, formato.format(data));
			
			JOptionPane.showMessageDialog( null, "¡HAS GANADO! ¡FELICIDADES!" , "FIN DE LA PARTIDA", JOptionPane.INFORMATION_MESSAGE);
			dispose();
			
		}
		
		if(contadorPrueba == 10){
			
			BasesDeDatos.crearTablaBDPartida();
			GestorRanking gr = new GestorRanking();
			gr.anyadirFilaATablaPartida(BasesDeDatos.getStatement(), "Trivial", maquina_puntos, formato.format(data));
			
			JOptionPane.showMessageDialog( null, "HAS PERDIDO LA PARTIDA, LO SENTIMOS" , "FIN DE LA PARTIDA", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
		
	}
}