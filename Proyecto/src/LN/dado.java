package LN;

import java.util.Random;

public class dado {
	
        public int tirarDado() {
                Random dado = new Random();
               
                return dado.nextInt(6) + 1;
        }
}