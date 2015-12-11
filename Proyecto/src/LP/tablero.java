package LP;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LN.PanelConImagen;

import java.awt.Toolkit;
import java.io.IOException;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class tablero extends JFrame {

	private PanelConImagen contentPane;
	private JTextField Pregunta;
	
					
				

	public tablero() {
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
		
		JRadioButton NUMEROUNO = new JRadioButton("New radio button");
		NUMEROUNO.setBounds(28, 87, 109, 23);
		panel.add(NUMEROUNO);
		
		JRadioButton NUMERODOS = new JRadioButton("New radio button");
		NUMERODOS.setHorizontalAlignment(SwingConstants.TRAILING);
		NUMERODOS.setBounds(28, 125, 109, 23);
		panel.add(NUMERODOS);
		
		JRadioButton NMEROTRES = new JRadioButton("New radio button");
		NMEROTRES.setBounds(171, 87, 109, 23);
		panel.add(NMEROTRES);
		
		JRadioButton NUMEROCUATRO = new JRadioButton("New radio button");
		NUMEROCUATRO.setBounds(171, 125, 109, 23);
		panel.add(NUMEROCUATRO);
		
		
	}
}
