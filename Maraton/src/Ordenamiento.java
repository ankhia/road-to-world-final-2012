import java.util.Arrays;


public class Ordenamiento {

	public static void main(String[] args) {
		long[] n = {8,5,7,4,3,1,9,2,6}; 
		System.out.println(Arrays.toString(n));
		burbuja( n );
		System.out.println(Arrays.toString(n));
	}
	
	/**
	 * Ordenamiento Burbuja
	 * Complejidad O(n^2)..
	 */
	private static void burbuja( long[] n ){
		for (int i = 0; i < (n.length-1); i++) {
			for (int j = (i+1); j < n.length; j++) {
				if( n[i] > n[j] ){
					long temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				}
				System.out.println(Arrays.toString(n));
			}
		}
	}
	
	private static void insercion() {
	}
	
	private static void quickSort() {
	}
}
