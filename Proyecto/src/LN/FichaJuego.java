package LN;



public class FichaJuego extends Ficha{

		private JLabelFicha miGrafico;  // Etiqueta gráfica del coche
		
		/**  Crea una nueva ficha de juego
		 */
		public FichaJuego() {
			miGrafico = new JLabelFicha();
		}
		
		/** Devuelve el JLabel gráfico asociado al coche de juego
		 * @return	Etiqueta gráfica del coche
		 */
		public JLabelFicha getGrafico() {
			return miGrafico;
		}

		@Override
		public void setPosX(double posX) {
			super.setPosX(posX);
			miGrafico.setLocation( (int)posX, (int)posY );
			// miGrafico.repaint();  // Al cambiar la location, Swing redibuja automáticamente
		}

		@Override
		public void setPosY(double posY) {
			super.setPosY(posY);
			miGrafico.setLocation( (int)posX, (int)posY );
			// miGrafico.repaint();  // Al cambiar la location, Swing redibuja automáticamente
		}

	}
