package ProgramacionDinamica;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Milena
 */
public class Rec_Puentes {

	static int []a1;
	static int []b1;
	static String []a;
	static String []b;

	/**
	 * Lee los puentes norte y sur Ej: 1 2 3 4
	 * 								   2 3 4 1 
	 * La respuesta del caso sera 3
	 * @param args
	 * @throws Throwable
	 */
	public static void main(String[] args) throws Throwable {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while( ( a = bf.readLine( ).split(" ") )!=null ){
			b = bf.readLine().split(" ");
			System.out.println(f(0, 0));
		}
	}
	
	/**
	 * Recursion segun el hippie
	 * @param i Posicion en la que voy en el mapa parte norte
	 * @param j Posicion en la que voy en el mapa parte sur
	 * @return El maximo numero de puentes que puedo crear sin cruzarlos
	 */
	public static int f( int i, int j ){
		if(i==a.length || j==b.length )
			return 0;
		if( a[i].equals(b[j]) ){
			//si son iguales sera lo maximo que obtengo si creo el puente ahi : f(i+1,j+1)+1
			//o lo maximo de lo maximo si no lo creo y avanzo en i o avanzo en j : f(i+1,j), f(i,j+1)
			return Math.max(f(i+1,j+1)+1, (Math.max(f(i+1,j), f(i,j+1))));
		}
		else
			//si no son iguales sera simplemente correrme pues no tengo como crear un puente
			return Math.max(f(i+1,j), f(i,j+1));
	}

	/**
	 * Recursion segun Pierre (mucho menos optima.. complejidad exponencial)
	 * @param i
	 * @param j
	 * @return
	 */
	public static int maxPuentes( int i , int j ){
		int maximo = Integer.MIN_VALUE;
		if( i >= a.length || j >= b.length )
			return 0;
		else{
			int contar = Integer.MIN_VALUE;
			for (int k = i; k < a.length; k++) {
				for (int l = j; l < b.length; l++) {
					if(a[k].equals(b[l]))
						contar = maxPuentes(k+1, l+1) + 1;
						if(contar > maximo)
							maximo = contar;
				}
			}
		}
		return maximo;
	}
}
