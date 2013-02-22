/**
 * 2. Considere una fila de n monedas de valores v1 … vn, donde n es par. 
 * Usted juega contra un oponente alternando turnos. En cada turno, 
 * un jugador puede escoger una de las dos monedas en los extremos de la fila (la primera o la última) 
 * y apropiarse de ella. Determine el máximo valor posible de dinero que puede ganar si usted juega primero.
 * 
 * 4. Considere una fila de n monedas de valores v1 … vn, donde n es par. 
 * Usted juega contra un oponente alternando turnos. En cada turno, 
 * un jugador puede escoger una de las dos monedas en los extremos de la fila (la primera o la última) 
 * y apropiarse de ella. Determine el máximo valor posible de dinero que puede ganar si usted juega primero 
 * y su oponente juega de la mejor forma posible.
 * 
 */

package ProgramacionDinamica;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Milena
 */
public class Rec_Monedas {

	/**
	 * Vector de monedas 
	 */
	static String monedas[];
	
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
			System.out.println(mon(0, monedas.length-1));
			System.out.println(mon2(0, monedas.length-1));
		}
	}

	/**
	 * Si yo juego Primero
	 * Es simplemente lo maximo de lo maximo que puedo obtener tomando la primera o la ultima
	 * @param i El inicio del vector de monedas
	 * @param j El final del vector de monedas
	 * @return El maximo valor posible alcanzable
	 */
	public static int mon(int i, int j){
		if(i>j)
			return 0;
		else
			//si juego primero, sera lo maximo, de lo maximo que puedo obtener de la siguiente manera
			//tomando la moneda i : (Integer.parseInt(monedas[i]) +
			//y asumir que mi oponente toma la j, o toma la siguiente a la que tome: Math.max(mon(i+1,j-1), mon(i+2,j)))
			//de la misma forma tomando j 
			return (Math.max((Integer.parseInt(monedas[i])+Math.max(mon(i+1,j-1), mon(i+2,j))), (Integer.parseInt(monedas[j]))+Math.max(mon(i,j-2), mon(i+1,j-1))));
	}
	
	/** 
	 * Si yo juego Primero y mi oponente juega de la mejor forma posible
	 * Es lo maximo de lo minimo que mi oponente va a dejarme
	 * @param i La posicion en la cual voy en el vector de monedas. De la primera posicion a la ultima
	 * @param j La posicion en la cual voy en el vector de monedas. De la ultima posicion a la primera
	 * @return El maximo valor posible alcanzable
	 */
	public static int mon2(int i, int j){
		if(i>j)
			return 0;
		else
			return   Math.max(Integer.parseInt(monedas[i])+Math.min(mon2(i+1,j-1), mon2(i+2,j)), 
							  Integer.parseInt(monedas[j])+Math.min(mon2(i+1,j-1), mon2(i,j-2)));
	}
}
