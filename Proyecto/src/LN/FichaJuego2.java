package LN;



public class FichaJuego2 extends Ficha{

		private JLabelFicha2 miGrafico2;  // Etiqueta gr�fica del ficha1
		
		/**  Crea una nueva ficha de juego
		 */
		public FichaJuego2() {
			miGrafico2 = new JLabelFicha2();
		}
		
		/** Devuelve el JLabel gr�fico asociado a la ficha de juego
		 * @return	Etiqueta gr�fica de la ficha
		 */
		public JLabelFicha2 getGrafico2() {
			return miGrafico2;
		}
		

		@Override
		public void setPosX(double posX) {
			super.setPosX(posX);
			miGrafico2.setLocation( (int)posX, (int)posY );
		}

		@Override
		public void setPosY(double posY) {
			super.setPosY(posY);
			miGrafico2.setLocation( (int)posX, (int)posY );
		}

	}

