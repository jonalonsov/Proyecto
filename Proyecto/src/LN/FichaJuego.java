package LN;



public class FichaJuego extends Ficha{

		private JLabelFicha miGrafico;  // Etiqueta gr�fica del coche
		
		/**  Crea una nueva ficha de juego
		 */
		public FichaJuego() {
			miGrafico = new JLabelFicha();
		}
		
		/** Devuelve el JLabel gr�fico asociado al coche de juego
		 * @return	Etiqueta gr�fica del coche
		 */
		public JLabelFicha getGrafico() {
			return miGrafico;
		}

		@Override
		public void setPosX(double posX) {
			super.setPosX(posX);
			miGrafico.setLocation( (int)posX, (int)posY );
			// miGrafico.repaint();  // Al cambiar la location, Swing redibuja autom�ticamente
		}

		@Override
		public void setPosY(double posY) {
			super.setPosY(posY);
			miGrafico.setLocation( (int)posX, (int)posY );
			// miGrafico.repaint();  // Al cambiar la location, Swing redibuja autom�ticamente
		}

	}
