/**
 * 1. Se tienen k segmentos de recta de longitudes enteras diferentes. 
 * Sea n la longitud del segmento más largo, 
 * ¿Cuál es el menor valor posible de n tal que no es posible escoger 
 * tres de estos segmentos de recta para forma un triángulo?
 * 
 */

package ProgramacionDinamica;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Milena
 */
public class Rec_Fibonacci {

	/**
	 * Main de la aplicacion
	 * lee el numero de segmentos para calcular el fibonacci 
	 * @throws Throwable
	 */
	public static void main(String[] args) throws Throwable {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(bf.readLine());
		while(k!=0){
			System.out.println("El menor n = "+ fib(k));	
		}
	}
	
	/**
	 * Serie Fibonacci comenzando en 1 y no en 0 como es normalmente
	 * esto es porque los segmentos de recta no se repiten
	 * 1 = 1; 2 = 2; 3 = 3; 4 = 5; 5 = 8 .... etc
	 * @param k El numero de segmentos para formar triangulos
	 * @return el fibonacci de k 
	 */
	public static int fib ( int k ) {
		if(k==1 || k==2)
			return k;
		else
			return fib(k-1)+fib(k-2);
	}
}
