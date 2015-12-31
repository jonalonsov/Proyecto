package LN;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;



public class JLabelFicha extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int TAMANYO_FICHA = 80;  // píxels (igual ancho que algo)
	
	/** Construye y devuelve el JLabel de la ficha con su gráfico y tamaño
	 */
	public JLabelFicha() {
		// Esto se haría para acceder por sistema de ficheros
		// 		
		// Esto se hace para acceder tanto por recurso (jar) como por fichero
		try {
			setIcon( new ImageIcon( JLabelFicha.class.getResource( "/imagenes/ficha1.png" ).toURI().toURL() ) );
		} catch (Exception e) {
			System.err.println( "Error en carga de recurso: ficha1.png no encontrado" );
			e.printStackTrace();
		}
		setBounds( 0, 0, TAMANYO_FICHA, TAMANYO_FICHA );
		// Esto sería útil cuando hay algún problema con el gráfico: borde de color del JLabel
		// setBorder( BorderFactory.createLineBorder( Color.yellow, 4 ));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);   // En este caso no nos sirve el pintado normal de un JLabel
		Image img = ((ImageIcon)getIcon()).getImage();
		Graphics2D g2 = (Graphics2D) g;  // El Graphics realmente es Graphics2D
		// Escalado más fino con estos 3 parámetros:
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
		
        // Dibujado de la imagen
        g2.drawImage( img, 0, 0, TAMANYO_FICHA, TAMANYO_FICHA, null );
	}
		
}
