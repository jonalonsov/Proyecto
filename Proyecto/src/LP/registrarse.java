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
import java.awt.Font;

public class registrarse extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNombreDeUsuario;
	private JLabel lblContrasea;
	private JButton btnAceptar;
	private JButton btnCancelar;

	public registrarse() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setBounds(130, 56, 184, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(130, 141, 184, 32);
		contentPane.add(passwordField);
		
		lblNombreDeUsuario = new JLabel("Nombre de usuario");
		lblNombreDeUsuario.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblNombreDeUsuario.setBounds(99, 25, 264, 20);
		contentPane.add(lblNombreDeUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblContrasea.setBounds(145, 100, 169, 32);
		contentPane.add(lblContrasea);
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setFont(new Font("Stencil", Font.BOLD, 18));
		btnAceptar.setBounds(27, 211, 401, 44);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(this);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setFont(new Font("Stencil", Font.BOLD, 18));
		btnCancelar.setBounds(27, 277, 401, 44);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String nombre = textField.getText();
		char[] elChar = passwordField.getPassword();
		String contrasenya = String.valueOf(elChar);						
		
		
		if (e.getSource() == btnAceptar){
			
			GestorJugador jugador = new GestorJugador(nombre, contrasenya);
		

			//BasesDeDatos.initBD("nuestrosDatos");
			BasesDeDatos.crearTablaBDUsuario();
			
			
			//chequea la tabla para ver si existe el usuario...
//			if(jugador.chequearYaEnTabla(BasesDeDatos.getStatement(), nombre) == false){  //--- HAU EZ DA BEREZ, anyadirFilaATablaUsuario bertan egiten da
				
				//Si no existe, a�ade fila con el usuario nuevo y sus respectivos atributos
				jugador.anyadirFilaATablauUsuario(BasesDeDatos.getStatement(), nombre);
				
				dispose();
				
//			}
			
//			else{
				
				//si el usuario ya existe aparece un mensaje de error   --> GESTORJUGADOR-EN DAO
//				 JOptionPane.showMessageDialog(null, "El usuario ya existe, prueba con otro","Mensaje de error",JOptionPane.ERROR_MESSAGE);
//			}
					
			
		}
		
		if (e.getSource() == btnCancelar){
			
			dispose();
		}
		
	}

}
