package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Color;

public class Menu extends JFrame {

	private JPanel contentPane;

	
	public Menu() {
		setResizable(false);
		setForeground(Color.BLACK);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnJugar = new JButton("JUGAR");
		btnJugar.setFont(new Font("Stencil", Font.BOLD, 18));
		btnJugar.setBounds(10, 11, 438, 76);
		contentPane.add(btnJugar);
		
		JButton btnInstrucciones = new JButton("INSTRUCCIONES");
		btnInstrucciones.setFont(new Font("Stencil", Font.BOLD, 18));
		btnInstrucciones.setBounds(10, 98, 438, 76);
		contentPane.add(btnInstrucciones);
		
		JButton btnRanking = new JButton("RANKING");
		btnRanking.setFont(new Font("Stencil", Font.BOLD, 18));
		btnRanking.setBounds(10, 187, 438, 76);
		contentPane.add(btnRanking);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Stencil", Font.BOLD, 18));
		btnSalir.setBounds(10, 274, 438, 76);
		contentPane.add(btnSalir);
	}
}
