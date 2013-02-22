package ProgramacionDinamica;

/**
 * Complejidad O(nlogn)
 * 
 * Si n=1 terminar (toda lista de 1 elemento esta
 * ordenada)
 * Si n>1, partir la lista de elementos en dos o mas
 * subcolecciones; ordenar cada una de ellas; combinar en
 * una sola lista.
 */

import java.util.Arrays;

public class MergeSort {

	static int[] numeros;

	public static void main(String[] args) {
		numeros = new int[]{ 0 , 2 , 5 , 7, 6, 4, 3, 9, 1};
		int[] merge = merge(numeros);
 		System.out.println(Arrays.toString(merge));
	}

	
	static int[] merge ( int[] n ){
		if( n.length == 1 )
			return n;
		else {
			int tamA = (int) Math.floor((double)n.length/2);
			int tamB = (int) Math.ceil((double)n.length/2);

			int[] a = new int[tamA];
			int[] b = new int[tamB];

			for (int i = 0; i < tamA; i++) 
				a[i] = n[i];

			for (int i = tamA, j = 0 ; i < n.length; i++, j++) 
				b[j] = n[i];
			
			int[] partA = merge(a);
			int[] partB = merge(b); 
			
			int[] res = combinar(partA, partB); 
 			return res;
		}
	}

	private static int[] combinar(int[] partA, int[] partB) {
		int combinar[] = new int[partA.length+partB.length];
		int indA = 0;int indB = 0;
		for (int i = 0; i < partA.length+partB.length; i++) {
			if(indA < partA.length && indB < partB.length){
				if(partA[indA]<partB[indB]){
					combinar[i] = partA[indA];
					indA++;
				}
				else{
					combinar[i]= partB[indB];
					indB++;
				}
			}else if(indA < partA.length){
				combinar[i]= partA[indA];
				indA++;
			}else if(indB < partB.length){
				combinar[i]= partB[indB];
				indB++;
			}
		}
		return combinar;
	}
}
