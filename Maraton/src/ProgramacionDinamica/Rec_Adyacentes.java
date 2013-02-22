package ProgramacionDinamica;


public class Rec_Adyacentes {

	static int[] entrada = new int[]{5, -3, 8, -10, 7, -4};
//	static int entrada[] = new int[]{2,4,10,-10,5};
	static int n;
	public static void main(String[] args) {
		n= entrada.length;
		System.out.println(f(entrada.length-1));
		System.out.println(f2());
		
	}
	
	
	/**
	 * Solucion Angie :)
	 * @param i
	 * @return la mayor subsecuencia que da la maxima suma 
	 */
	static int f( int i ){
		if(i<0) return 0;
		else return Math.max(entrada[i], (Math.max(g(i-1)+entrada[i], f(i-1))));
	}
	
	/**
	 * @param i
	 * @return la maxima suma de una subsecuencia que contiene el elemento i-esimo
	 * como ultimo elemento
	 */
	static int g( int i ){
		if(i<0) return 0;
		else return Math.max(g(i-1)+entrada[i], entrada[i]);
	}
	

	//Solucion profe
		static int f2( ){
			int maximo = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				int a = g2(i); 
				if(a > maximo)
					maximo = a;
			}
			return Math.max(0, maximo);
		}
		static int g2(int i){
			if(i==0)
				return entrada[i];
			else
				return Math.max(entrada[i], g2(i-1)+entrada[i]);
		}
}
