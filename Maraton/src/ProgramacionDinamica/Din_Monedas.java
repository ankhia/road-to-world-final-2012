package ProgramacionDinamica;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Din_Monedas {

	/**
	 * Vector de monedas 
	 */
	static String monedas[];

	static int v [][];
	
	/**
	 * Lee el vector de monedas Ej: 9 20 1 1
	 * la respuesta para 2. 29 y para 4. 21
	 * @param args
	 * @throws Throwable
	 */
	public static void main(String[] args) throws Throwable {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while((linea=bf.readLine())!=null){
			monedas = linea.split(" ");
			v = new int [monedas.length][monedas.length];
			for (int i = 0; i < v.length; i++) {
				Arrays.fill(v[i], -1);
			}
			
			System.out.println(dp());
			System.out.println(dp2());
		}
	}
	
	/**
	 * Memoizacion :)
	 * @param i El inicio del vector de monedas
	 * @param j El final del vector de monedas
	 * @return El maximo valor posible alcanzable
	 */
	public static int mon(int i, int j){
		if(i<monedas.length && j >= 0){
			if(v[i][j]!=-1)
				return v[i][j];
			if(i>j)
				v[i][j] = 0;
			else
				v[i][j] =  (Math.max((Integer.parseInt(monedas[i])+Math.max(mon(i+1,j-1), mon(i+2,j))), (Integer.parseInt(monedas[j]))+Math.max(mon(i,j-2), mon(i+1,j-1))));

			return v[i][j];
		}
		else
			return 0;
	}

	/**
	 * Programacion Dinamica de la recursion de las monedas 
	 * Cuando juego primero
	 * @return El maximo valor posible alcanzable
	 */
	public static int dp(  ){
		int v[][] = new int [monedas.length][monedas.length];
		for (int i = 0; i < v.length; i++) {
			Arrays.fill(v[i], -1);
		}
		for (int l = 0; l < v.length; l++) 
			for (int k = 0; k < v.length; k++)
				if(l>k)
					v[l][k] = 0;

		for (int i = 0; i < v.length/2; i++) {
			int k = 0;
			int l = 1+2*i;
			int tam = (monedas.length-1)-2*i;
			for (int j = 0 ; j < tam ; tam--) {
				
				int a = ( k+1 < monedas.length && l-1 >= 0 ) ? v[k+1][l-1] : 0;
				int b = ( k+2 < monedas.length && l >= 0 ) ? v[k+2][l] : 0;
				int c = ( k < monedas.length && l-2 >= 0 ) ? v[k][l-2] : 0;
				int d = ( k+1 < monedas.length && l-1 >= 0 ) ? v[k+1][l-1] : 0;
				v[k][l]= Math.max(Integer.parseInt(monedas[k])+Math.max(a, b), Integer.parseInt(monedas[l])+Math.max(c, d));
				k++;l++;
			}
		}
		return v[0][monedas.length-1];
	}	
	
	/**
	 * Programacion Dinamica de la recursion de las monedas 
	 * Cuando juego primero
	 * @return El maximo valor posible alcanzable
	 */
	public static int dp2(  ){
		int v[][] = new int [monedas.length][monedas.length];
		for (int i = 0; i < v.length; i++) {
			Arrays.fill(v[i], -1);
		}
		for (int l = 0; l < v.length; l++) 
			for (int k = 0; k < v.length; k++)
				if(l>k)
					v[l][k] = 0;

		for (int i = 0; i < v.length/2; i++) {
			int k = 0;
			int l = 1+2*i;
			int tam = (monedas.length-1)-2*i;
			while(tam --> 0){
				int a = ( k+1 < monedas.length && l-1 >= 0 ) ? v[k+1][l-1] : 0;
				int b = ( k+2 < monedas.length && l >= 0 ) ? v[k+2][l] : 0;
				int c = ( k < monedas.length && l-2 >= 0 ) ? v[k][l-2] : 0;
				int d = ( k+1 < monedas.length && l-1 >= 0 ) ? v[k+1][l-1] : 0;
				v[k][l]= Math.max(Integer.parseInt(monedas[k])+Math.min(a, b), Integer.parseInt(monedas[l])+Math.min(c, d));
				k++;l++;
			}
		}
		return v[0][monedas.length-1];
	}	
}
