package LN;



public class FichaJuego1 extends Ficha{

		private JLabelFicha1 miGrafico1;  // Etiqueta gráfica del ficha1
		
		/**  Crea una nueva ficha de juego
		 */
		public FichaJuego1() {
			miGrafico1 = new JLabelFicha1();
		}
		
		/** Devuelve el JLabel gráfico asociado a la ficha de juego
		 * @return	Etiqueta gráfica de la ficha
		 */
		public JLabelFicha1 getGrafico1() {
			return miGrafico1;
		}
		

		@Override
		public void setPosX(double posX) {
			super.setPosX(posX);
			miGrafico1.setLocation( (int)posX, (int)posY );
			// miGrafico.repaint();  // Al cambiar la location, Swing redibuja automáticamente
		}

		@Override
		public void setPosY(double posY) {
			super.setPosY(posY);
			miGrafico1.setLocation( (int)posX, (int)posY );
			// miGrafico.repaint();  // Al cambiar la location, Swing redibuja automáticamente
		}

	}
