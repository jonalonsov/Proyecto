package LP;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;

import LD.BasesDeDatos;
import LN.PanelConImagen;

import java.awt.Toolkit;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class tablero extends JFrame {

	private PanelConImagen contentPane;
	private JTextField Pregunta;
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
	private JLabel lblDado;
	//Random r;
					
				

	public tablero() {
		//r = new Random();
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
		
		Pregunta = new JTextField();
		Pregunta.setBounds(28, 35, 283, 40);
		panel.add(Pregunta);
		Pregunta.setColumns(10);
		Pregunta.setEditable(false);
		
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
		respuesta_1.setBounds(56, 88, 86, 20);
		panel.add(respuesta_1);
		respuesta_1.setColumns(10);
		respuesta_1.setEditable(false);
		
		
//		Statement st = null;
//		try {
//			String s = "select * from PREGUNTA";
//			st.executeQuery(s);  // -- NULL POINTER EXCEPTION
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		respuesta_1.setCaret((Caret) st);
		
		respuesta_2 = new JTextField();
		respuesta_2.setColumns(10);
		respuesta_2.setBounds(56, 126, 86, 20);
		panel.add(respuesta_2);
		respuesta_2.setEditable(false);
		
		respuesta_3 = new JTextField();
		respuesta_3.setColumns(10);
		respuesta_3.setBounds(199, 88, 86, 20);
		panel.add(respuesta_3);
		respuesta_3.setEditable(false);
		
		respuesta_4 = new JTextField();
		respuesta_4.setColumns(10);
		respuesta_4.setBounds(199, 126, 86, 20);
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
		
		lblDado = new JLabel("New label");
		lblDado.setBounds(280, 26, 69, 63);
		contentPane.add(lblDado);
		
	}
}
