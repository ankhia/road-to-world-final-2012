package Angie;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Acm10938 {

	static ArrayList<Integer>[]con ;
	static int[] papasDirectos;
	static long[ ] disRootANodo;
	static int[ ] niveles;
	static int[ ] papasSecciones; 
	static int[ ] secciones;

	static int nodo1;
	static int nodo2;

	public static void main(String[] args) throws Throwable {
		Scanner in = new Scanner(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int leaves ; (leaves = in.nextInt()) != 0; ) {
			con = new ArrayList[leaves];
			disRootANodo = new long[leaves];
			niveles = new int[leaves];
			papasDirectos = new int[leaves];
			papasDirectos[0] = -1;
			papasSecciones = new int[leaves];
			secciones = new int[leaves];

			for (int i = 0; i < leaves-1; i++) {
				int A = in.nextInt();
				int B = in.nextInt();
				ArrayList<Integer> arr;
				ArrayList<Integer> arr2;

				if(con[A-1]!=null)	arr = con[A-1];
				else				arr = new ArrayList<Integer>();

				if(con[B-1]!=null) arr2 = con[B-1];
				else			   arr2 = new ArrayList<Integer>();

				arr.add( B-1 );
				arr2.add( A-1 );
				con[A-1] = arr;
				con[B-1] = arr2;
				papasDirectos[ B-1 ] = A-1;
			}
			bfs();

			int [] copy = niveles.clone();
			Arrays.sort(copy);
			int raizH = (int)( Math.ceil( Math.sqrt( (double)(copy[copy.length-1]+1) ) ) );
			for (int i = 0; i < niveles.length; i++) {
				secciones[i] = niveles[i]/raizH;
			}
//			System.out.println(Arrays.toString(secciones));
			dfs(raizH);
//			System.out.println(Arrays.toString(papasSecciones));
			int query = in.nextInt();
			for (int i = 0; i < query; i++) {
				nodo1 = in.nextInt();
				nodo2 = in.nextInt();
				int nodoLCA = LCA(nodo1-1, nodo2-1);
				long dist = solve(nodo1-1, nodo2-1, nodoLCA);
				long p = (long)(Math.ceil(dist/2.));
				if(dist%2==0){
					int nodoOrigen = -1;
					if( niveles[nodo1-1] > niveles[nodo2-1] )
						nodoOrigen = nodo1;
					else
						nodoOrigen = nodo2;
					int nodo = (solvePar( p, nodoOrigen-1 )+1);
					System.out.println(  nodo  );
					sb.append("The fleas meet at "+nodo+".\n");
				}else{
//					int nodoOrigen = -1;
//					int n2 = -1;
//					if(niveles[nodo1-1]>niveles[nodo2-1]){
//						nodoOrigen=nodo1;
//						n2 = nodo2;
//					}else{
//						nodoOrigen=nodo2;
//						n2 = nodo1;
//					}
//					int a = solvePar(p-1 ,nodoOrigen-1);
//					sb.append("The fleas jump forever between "+Math.min( a[0]+1,a[1]+1 )+ " and "+Math.max( a[0]+1,a[1]+1 )+".\n");
//					System.out.println(a+1);
				}
			}
		}
		System.out.print(new String(sb));
	}


	private static int solvePar( long p , int n ) {
		int nodoSolucion = -1;
		boolean termine = false;
		while( !termine ){
			if( papasSecciones[n]!=-1 ){
				long k = Math.abs(niveles[papasSecciones[n]] - niveles[n]);
				if( p-k == 0 ){
					termine = true;
					nodoSolucion = papasSecciones[n];
				}else if( p-k > 0 ){
					p-=k;
					n = papasSecciones[n];
				}else{
					while( p --> 0 ){
						n = papasDirectos[n];
					}
					nodoSolucion = n;
					termine = true;
				}
			}else{
				while(n!=-1 && p --> 0){
					n = papasDirectos[n];
				}
				nodoSolucion = n;
				termine = true;
			}
		}
		return nodoSolucion;
	}

	public static long solve( int nodo1, int nodo2 , int nodoLCA){
		return disRootANodo[nodo1] + disRootANodo[nodo2] - 2*disRootANodo[nodoLCA];
	}

	public static void solvePar(int nodoLCA, int dist ){
		long subir = -1;
		if( nodoLCA == nodo1 || nodoLCA == nodo2 ){

			subir = generarNodos((long) Math.ceil(dist/2.));
		}else{
			subir = generarNodos(dist);
		}
		while( subir > 0 ){

		}

	}

	private static long generarNodos( long subir ) {
		boolean termine = false;
		while( subir > 0 && !termine ){
			if(secciones[nodo1-1]<secciones[nodo2-1]){
				long restar = Math.abs(niveles[nodo2-1]-niveles[papasSecciones[nodo2-1]]);
				if( subir - restar < 0 )
					termine = true;
				else {
					subir -= restar;
					nodo2 = papasSecciones[nodo2-1]+1;
				}
			}else{
				long restar = Math.abs(niveles[nodo1-1]-niveles[papasSecciones[nodo1-1]]);
				if( subir - restar < 0 )
					termine = true;
				else {
					subir -= restar;
					nodo1 = papasSecciones[nodo1-1]+1;
				}
			}
		}
		return subir;
	}

	public static void bfs( ){

		Queue<Integer> nodo = new LinkedList<Integer>();
		Queue<Long> peso = new LinkedList<Long>();
		Queue<Integer> nivel = new LinkedList<Integer>();
		boolean visitados[] = new boolean[secciones.length];

		nodo.add(0);
		peso.add(0l);
		nivel.add(0);
		while(!nodo.isEmpty()){
			int n = nodo.poll();
			long p = peso.poll();
			int niv = nivel.poll();
			for (int i = 0; con[n] != null && i < con[n].size(); i++) {
				if(!visitados[con[n].get(i)]){ 
					nodo.add(con[n].get(i));
					peso.add(p+1);
					nivel.add(niv+1);
				}
			}
			disRootANodo[n] = p;
			niveles[n] = niv;
			visitados[n] = true;
		}
	}

	public static void dfs( int raizH ){
		Stack<Integer> p = new Stack<Integer>();
		p.add(0);
		papasSecciones[0] = -1;
		boolean visitados[] = new boolean[papasSecciones.length];
		while(!p.isEmpty()){
			int nodo = p.pop();
			int niv = niveles[nodo];
			if( niv % raizH != 0  )
				papasSecciones[nodo] = papasSecciones[papasDirectos[nodo]];
			else
				papasSecciones[nodo] = papasDirectos[nodo];

			for (int i = 0; con[nodo] != null && i < con[nodo].size(); i++) {
				if(!visitados[con[nodo].get(i)])
					p.add(con[nodo].get(i));
			}
			visitados[nodo] = true;
		}
	}

	public static int LCA( int nodo1 , int nodo2 ){
		while( papasSecciones[nodo1] != papasSecciones[nodo2] ){
			if(niveles[nodo1]>niveles[nodo2])
				nodo1 = papasSecciones[nodo1];
			else
				nodo2 = papasSecciones[nodo2];
		}
		while( nodo1 != nodo2 ){
			if( niveles[nodo1] > niveles[nodo2] )
				nodo1 = papasDirectos[nodo1];
			else 
				nodo2 = papasDirectos[nodo2];
		}
		return nodo1;
	}
}
