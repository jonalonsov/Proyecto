package LP;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;



import LD.BasesDeDatos;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnJugar;
	private JButton btnInstrucciones;
	private JButton btnRanking;
	private JButton btnSalir;
	private String nombre;

	
	public Menu(String nombre) {
		this.nombre = nombre;
		
		setResizable(false);
		setForeground(Color.BLACK);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnJugar = new JButton("JUGAR");
		btnJugar.setFont(new Font("Stencil", Font.BOLD, 18));
		btnJugar.setBounds(10, 11, 438, 76);
		contentPane.add(btnJugar);
		btnJugar.addActionListener(this);
		
		btnInstrucciones = new JButton("INSTRUCCIONES");
		btnInstrucciones.setFont(new Font("Stencil", Font.BOLD, 18));
		btnInstrucciones.setBounds(10, 98, 438, 76);
		contentPane.add(btnInstrucciones);
		btnInstrucciones.addActionListener(this);
		
		btnRanking = new JButton("RANKING");
		btnRanking.setFont(new Font("Stencil", Font.BOLD, 18));
		btnRanking.setBounds(10, 187, 438, 76);
		contentPane.add(btnRanking);
		btnRanking.addActionListener(this);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Stencil", Font.BOLD, 18));
		btnSalir.setBounds(10, 274, 438, 76);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == btnJugar){
	
			tablero tablero = new tablero(nombre);
			tablero.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			tablero.setVisible(true);
			
			tablero.creaFicha1( 120, 130 );
			tablero.creaFicha2(1145,130);
			
		}
		
		if (e.getSource() == btnInstrucciones){
			
			instrucciones i = new instrucciones();
			i.setVisible(true);
			
		}
		
		if (e.getSource() == btnRanking){
		
			TablaRanking i = new TablaRanking(nombre);
			i.setVisible(true);
			
		}
		

		if (e.getSource() == btnSalir){
			
			BasesDeDatos.close();
			dispose();
			
		}
		
	}
	
	
	
}
