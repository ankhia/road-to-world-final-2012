/**
 * Suppose that you are given an n × n checkerboard and a checker. You must move the checker from the bottom edge of the board to the top edge of the board according to the following rule. 
 * At each step you may move the checker to one of three squares:
 * the square immediately above,
 * the square that is one up and one to the left (but only if the checker is not already in the leftmost column),
 * the square that is one up and one to the right (but only if the checker is not already in the rightmost column).
 * Each time you move from square x to square y, you receive p(x, y) dollars. 
 * You are given p(x, y) for all pairs (x, y) for which a move from x to y is legal. Do not assume that p(x, y) is positive.
 * Give an algorithm that figures out the set of moves that will move the checker from somewhere along the bottom edge 
 * to somewhere along the top edge while gathering as many dollars as possible. 
 * Your algorithm is free to pick any square along the bottom edge as a starting point 
 * and any square along the top edge as a destination in order to maximize the number of dollars gathered along the way. 
 * What is the running time of your algorithm?
 */

package ProgramacionDinamica;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Checkers {

	static int[][]matriz;
	static int[][]memoriza;
	static int[][]dinamica;
	
	public static void main(String[] args) throws Throwable {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		while(n!=0 && m!=0){
			matriz = new int[m][n];
//			memoriza = new int [m][n];
			dinamica = new int[m][n];
			
			for (int i = 0; i < m; i++) {
//				Arrays.fill(memoriza[i], Integer.MIN_VALUE);
				Arrays.fill(dinamica[i],Integer.MIN_VALUE);
			}
			for (int i = 0; i < m; i++) {
				st =new StringTokenizer(bf.readLine());
				for (int j = 0; j < n; j++)
					matriz[i][j]=Integer.parseInt(st.nextToken());
			}
			
			llenarDinamica();
			int mayor = Integer.MIN_VALUE;
			int h = dinamica.length-1;
			for (int j = 0; j < dinamica[0].length; j++) {
				if(dinamica[h][j]>mayor)
					mayor = dinamica[h][j];
			}
//			for (int j = 0; j < matriz[0].length; j++) {
//				int sol = f( matriz.length-1, j );
//				if(sol>mayor)
//					mayor = sol;
//			}
//			for (int i = 0; i < m; i++) {
//				System.out.println(Arrays.toString(memoriza[i]));
//				System.out.println(Arrays.toString(dinamica[i]));
//			}
			
			System.out.println(mayor);
			st = new StringTokenizer(bf.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

		}
	}
	
	public static void llenarDinamica( ){
		for (int j = 0; j < dinamica[0].length; j++) 
			dinamica[0][j] = matriz[0][j];
		for (int i = 1; i < dinamica.length; i++) {
			for (int j = 0; j < dinamica[0].length; j++) {
				int mayor = matriz[i][j]+dinamica[i-1][j];
				if( j-1 >= 0  )
					mayor = Math.max(mayor, matriz[i][j]+dinamica[i-1][j-1]); 
				if( j+1 < dinamica[0].length )
						mayor = Math.max(mayor, matriz[i][j]+dinamica[i-1][j+1]);
				dinamica[i][j] = mayor;
			}
		}
	}
	
//	public static int f( int i, int j ){
//		
//		if( j < 0 || j >= matriz[0].length)
//			return	Integer.MIN_VALUE;
//		if (memoriza[i][j]!=Integer.MIN_VALUE) 
//			return memoriza[i][j];
//		if( i==0 )
//			memoriza[i][j] = matriz[i][j];
//		else 
//			memoriza[i][j] = Math.max(Math.max(f(i-1,j), f(i-1,j-1)), f(i-1,j+1))+matriz[i][j];
//		return memoriza[i][j];
//	}
}
