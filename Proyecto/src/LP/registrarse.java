package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

import LD.BasesDeDatos;
import LN.GestorJugador;

public class registrarse extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNombreDeUsuario;
	private JLabel lblContrasea;
	private JButton btnAceptar;
	private JButton btnCancelar;

	public registrarse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(65, 56, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(65, 113, 86, 20);
		contentPane.add(passwordField);
		
		lblNombreDeUsuario = new JLabel("Nombre de usuario");
		lblNombreDeUsuario.setBounds(65, 31, 112, 14);
		contentPane.add(lblNombreDeUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(65, 87, 86, 14);
		contentPane.add(lblContrasea);
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBounds(65, 203, 89, 23);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(this);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(270, 203, 110, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String nombre = textField.getText();
		char[] elChar = passwordField.getPassword();
		String contrasenya = String.valueOf(elChar);						
		GestorJugador jugador = new GestorJugador(nombre, contrasenya, null);
//		jugador.anyadirUnaFila(BasesDeDatos.getStatement(), "ainhoa", "bai");
//		System.out.println(jugador.contar());
		
//		if(jugador.existeTabla()==true){
			BasesDeDatos.initBD("nuestrosDatos");
			BasesDeDatos.crearTablaBDUsuario();
			
//		}
		
		if (e.getSource() == btnAceptar){
			
			
			
			
			//chequea la tabla para ver si existe el usuario...
			if(jugador.chequearYaEnTabla(BasesDeDatos.getStatement(), nombre) == false){  //--- HAU EZ DA BEREZ, anyadirFilaATablaUsuario bertan egiten da
				
				//Si no existe, a�ade fila con el usuario nuevo y sus respectivos atributos
				jugador.anyadirFilaATablauUsuario(BasesDeDatos.getStatement(), nombre);
				
				dispose();
				
			}
			
			else{
				
				//si el usuario ya existe aparece un mensaje de error
				 JOptionPane.showMessageDialog(null, "El usuario ya existe, prueba con otro","Mensaje de error",JOptionPane.ERROR_MESSAGE);
			}
					
			
		}
		
		if (e.getSource() == btnCancelar){
			
			dispose();
		}
		
	}

}
