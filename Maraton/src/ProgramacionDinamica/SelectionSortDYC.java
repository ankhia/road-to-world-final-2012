package ProgramacionDinamica;

/**
 * Complejidad teta de n al cuadrado (supongo)
 * 
 * 	1. Localizar el mayor elemento en un array
 *	2. Intercambiarlo con el valor de la posición n-ésima
 *	   del array
 *  3. Localizar el mayor elemento del subarray 0 a n-1
 *  4. Intercambiarlo con el valor de la posición n-1  
 *  5. Repetir el proceso para el resto de las posiciones
 */

import java.util.Arrays;

public class SelectionSortDYC {

	static int[] numeros;
	
	public static void main(String[] args) {
		numeros = new int[]{ 0 , 2 , 5 , 7, 6, 4, 3, 9, 1};
		int[] sel = selectionSort(numeros, numeros.length-1);//no hizo nada
		System.out.println(Arrays.toString(sel));
		
	}
	
	static int[] selectionSort( int[] n, int maxPos ){
		
		int indexOfMax;
		for (int k = maxPos; k >= 1; k--) { //hasta 1 pues siempre sera el menor
			indexOfMax = k; //en la primera iteracion es la ultima posicion (n-1)
			for (int j = k-1; j >= 0; j--) 
				if(n[j]>n[indexOfMax])
					indexOfMax = j;
			if(indexOfMax!=k){
				n[k]^=n[indexOfMax];//intercambiamos
				n[indexOfMax]^= n[k];
				n[k]^=n[indexOfMax];
			}
		}
		return n;
	}
	
}
