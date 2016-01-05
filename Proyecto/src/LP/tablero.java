package LP;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.BoundedRangeModel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;

import LD.BasesDeDatos;
import LN.Casilla;
import LN.Dado;
import LN.FichaJuego;
import LN.GestorCasillas;
import LN.Maquina;
import LN.PanelConImagen;
import LN.Partida;
import LN.Usuario;

import java.awt.Toolkit;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;



public class tablero extends JFrame implements ActionListener{

	private int contadorPrueba = 0;
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
	private FichaJuego miFicha = new FichaJuego();
	private JButton btnOK;
	private JButton btnPrueba;
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
		panel.setBounds(502, 261, 334, 188);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPreguntas = new JLabel("PREGUNTAS");
		lblPreguntas.setBounds(119, 5, 95, 18);
		lblPreguntas.setFont(new Font("Verdana", Font.BOLD, 14));
		panel.add(lblPreguntas);
		
		Pregunta = new JTextArea();
		//Pregunta.setBounds(28, 35, 283, 40);
		//panel.add(Pregunta);
		Pregunta.setColumns(10);
		Pregunta.setEditable(false);
		
		JScrollPane scroll = new JScrollPane(Pregunta);
		scroll.setBounds(28, 35, 283, 40);
		panel.add(scroll);
		
		NUMEROUNO = new JRadioButton(" ");
		NUMEROUNO.setBounds(28, 87, 22, 23);
		panel.add(NUMEROUNO);
		
		NUMERODOS = new JRadioButton(" ");
		NUMERODOS.setHorizontalAlignment(SwingConstants.LEFT);
		NUMERODOS.setBounds(28, 125, 22, 23);
		panel.add(NUMERODOS);
		
		NUMEROTRES = new JRadioButton(" ");
		NUMEROTRES.setBounds(171, 87, 22, 23);
		panel.add(NUMEROTRES);
		
		NUMEROCUATRO = new JRadioButton(" ");
		NUMEROCUATRO.setBounds(171, 125, 22, 23);
		panel.add(NUMEROCUATRO);
		
		respuesta_1 = new JTextField();
		respuesta_1.setBounds(56, 88, 110, 20);
		panel.add(respuesta_1);
		respuesta_1.setColumns(10);
		respuesta_1.setEditable(false);
				
		respuesta_2 = new JTextField();
		respuesta_2.setColumns(10);
		respuesta_2.setBounds(56, 126, 110, 20);
		panel.add(respuesta_2);
		respuesta_2.setEditable(false);
		
		respuesta_3 = new JTextField();
		respuesta_3.setColumns(10);
		respuesta_3.setBounds(199, 88, 110, 20);
		panel.add(respuesta_3);
		respuesta_3.setEditable(false);
		
		respuesta_4 = new JTextField();
		respuesta_4.setColumns(10);
		respuesta_4.setBounds(199, 126, 110, 20);
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
		
		btnPrueba = new JButton("prueba");
		btnPrueba.setBounds(10, 36, 68, 62);
		contentPane.add(btnPrueba);
		
		
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
		btnPrueba.addActionListener(this);
		
		
		
		
		this.AnadirInformacion();
		
		//crear posiciones casillas
		GestorCasillas.comenzarCasillas();
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {


		if (e.getSource() == btnTirarDado){
			
			
			
		
			int numeroDado = lblDado.tirarDado();
			System.out.println(numeroDado);
			
		}
		
		if (e.getSource() == btnPrueba){
			
			int pos_x = GestorCasillas.getPos_x(contadorPrueba);
			int pos_y = GestorCasillas.getPos_y(contadorPrueba);
			miFicha.setPosicion(pos_x, pos_y);
			System.out.println(contadorPrueba + "     " + pos_x + "   "+pos_y);
			contadorPrueba= contadorPrueba+1;
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
	
	public void creaFicha( int posX, int posY ) {
		// Crear y a�adir el ficha a la ventana
		
		miFicha.setPosicion( posX, posY );
		contentPane.add( miFicha.getGrafico() );
	}
	
	
	
	public void ComprobarRespuesta(String respuestaSeleccionada){
		
		if(respuestaSeleccionada.equals(correcta)){
			jug1_aciertos++;
			jug1_puntos = jug1_puntos + 5;
			textField_1.setText(String.valueOf(jug1_aciertos));
			textField.setText(String.valueOf(jug1_puntos));
			this.RespuestaCORRECTA(true);
		}
		else{
						
			jug1_puntos = jug1_puntos - 3;
			textField.setText(String.valueOf(jug1_puntos));
			JOptionPane.showMessageDialog( null, "¡RESPUESTA INCORRECTA!" , "RESPUESTA", JOptionPane.INFORMATION_MESSAGE);
			this.AnadirInformacion();
			
			 this.RespuestaMaquina();
			
		}
	}
	
	public void RespuestaCORRECTA(boolean jugador){  //jugador: true: usuario / false: maquina
		if(jugador == true)
			JOptionPane.showMessageDialog( null, "¡BIEN! ¡RESPUESTA CORRECTA!" , "RESPUESTA", JOptionPane.INFORMATION_MESSAGE);
		if (jugador == false){
			
			try {
				Thread.sleep( 500 );
			} catch (Exception e) {
			}
			
			JOptionPane.showMessageDialog( null, "¡RESPUESTA DE TRIVIAL CORRECTA!" , "RESPUESTA", JOptionPane.INFORMATION_MESSAGE);
			
			
		}
			
		this.AnadirInformacion();
		this.FinalPartida();
		
	}
	
	public void RespuestaMaquina(){

		Random random = new Random();
		aleatorio = random.nextInt(array.length);
		
		if(aleatorio == 1){
			maquina_aciertos++;
			maquina_puntos = maquina_puntos + 5;
			
			textField_aciertosMaquina.setText(String.valueOf(maquina_aciertos));
			textField_puntosMaquina.setText(String.valueOf(maquina_puntos));
			this.RespuestaCORRECTA(false);
			this.RespuestaMaquina();
			
			
		}else if (aleatorio == 0){
			try {
				Thread.sleep( 500 );
			} catch (Exception e) {
			}
			maquina_puntos = maquina_puntos - 3;
			textField_puntosMaquina.setText(String.valueOf(maquina_puntos));
			JOptionPane.showMessageDialog( null, "¡RESPUESTA DE TRIVIAL INCORRECTA! TU TURNO" , "RESPUESTA", JOptionPane.INFORMATION_MESSAGE);
			this.AnadirInformacion();
			
		}
		
		
	}
	
	
	public void FinalPartida(){
	
		aleatorio = -1;
		
		if(jug1_aciertos >= 11){
			Date data = new Date();
			SimpleDateFormat formato = new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss" );
			System.out.println( "Fecha de la partida: " + formato.format(data) );
			
			Usuario jugador = new Usuario(nombre, null, jug1_puntos, formato.format(data));
			Maquina maquina = new Maquina (0, formato.format(data));
			
			ArrayList<Partida> partida = new ArrayList<Partida>();
			partida.add(jugador);
			partida.add(maquina);
			
			JOptionPane.showMessageDialog( null, "¡HAS GANADO! ¡FELICIDADES!" , "FIN DE LA PARTIDA", JOptionPane.INFORMATION_MESSAGE);
			dispose();

		}
		
		if(maquina_aciertos >= 11){
			JOptionPane.showMessageDialog( null, "HAS PERDIDO LA PARTIDA, LO SENTIMOS" , "FIN DE LA PARTIDA", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
		
	}
}
