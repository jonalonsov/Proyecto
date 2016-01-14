package LP;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import LD.BasesDeDatos;
import LN.GestorRanking;
import LN.Partida;
import LN.Usuario;

import java.awt.Font;

public class TablaRanking extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MiTablaModelo modelo;
	private JButton btnAtras;
	private String nombre;
	private GestorRanking gr;
	int arrayLuzera;
	static Partida[] arrayPartida;

	/**
	 * Create the frame.
	 */
	public TablaRanking(String nombre) {
		setResizable(false);
		
		this.nombre = nombre;
		modelo = new MiTablaModelo(Usuario.nombresAtributos, Usuario.atributosEditables);
        
		gr = new GestorRanking();
		arrayLuzera = gr.cogerInfoDeTablaPartida(BasesDeDatos.getStatement(), nombre).size();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		 
		// Crear la tabla y el scrollpane
    	Ranking tabla = new Ranking( modelo );
        JScrollPane scrollPane = new JScrollPane( tabla );
        
		contentPane.add( scrollPane, "Center" );
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(this);
		btnAtras.setFont(new Font("Stencil", Font.PLAIN, 17));
		panel.add(btnAtras);
		
		this.RellenarTabla();
		
		this.pack();
	}


	public void RellenarTabla(){
		
		GestorRanking gr = new GestorRanking();
		int k = gr.cogerInfoDeTablaPartida(BasesDeDatos.getStatement(), nombre).size();
		
		
				 for(int i=0; i<k; i++){
					 	
				    	modelo.insertar( gr.cogerInfoDeTablaPartida(BasesDeDatos.getStatement(), nombre).get(i));
			    	}
				 

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnAtras)
			dispose();
	}
	


}