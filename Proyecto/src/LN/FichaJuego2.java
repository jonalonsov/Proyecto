package LN;



public class FichaJuego2 extends Ficha{

		private JLabelFicha2 miGrafico2;  // Etiqueta gráfica del ficha1
		
		/**  Crea una nueva ficha de juego
		 */
		public FichaJuego2() {
			miGrafico2 = new JLabelFicha2();
		}
		
		/** Devuelve el JLabel gráfico asociado a la ficha de juego
		 * @return	Etiqueta gráfica de la ficha
		 */
		public JLabelFicha2 getGrafico2() {
			return miGrafico2;
		}
		

		@Override
		public void setPosX(double posX) {
			super.setPosX(posX);
			miGrafico2.setLocation( (int)posX, (int)posY );
			// miGrafico.repaint();  // Al cambiar la location, Swing redibuja automáticamente
		}

		@Override
		public void setPosY(double posY) {
			super.setPosY(posY);
			miGrafico2.setLocation( (int)posX, (int)posY );
			// miGrafico.repaint();  // Al cambiar la location, Swing redibuja automáticamente
		}

	}

