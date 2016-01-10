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

	/**
	 * Create the frame.
	 */
	public TablaRanking(String nombre) {
		
		this.nombre = nombre;
		modelo = new MiTablaModelo(Usuario.nombresAtributos, Usuario.atributosEditables);
        
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
		
//		try {
//			ResultSet rs = st.executeQuery("select * from PARTIDA where (nombreUsuario = '" + nombre + "')");
//			ArrayList<Usuario> datuak = new ArrayList<Usuario>;
		
		GestorRanking gr = new GestorRanking();
		int k = gr.cogerInfoDeTablaUsuario(BasesDeDatos.getStatement(), nombre).size();
//			while(rs.next()){
				 for(int i=0; i<k; i++){
			    		
			    		//datuak[i] = rs.getObject(i+1);
					
				    	modelo.insertar( gr.cogerInfoDeTablaUsuario(BasesDeDatos.getStatement(), nombre).get(i));
			    	}
//	    	}
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnAtras)
			dispose();
	}
}
