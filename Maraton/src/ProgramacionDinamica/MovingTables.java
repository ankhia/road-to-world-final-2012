package ProgramacionDinamica;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class MovingTables {

	static int superArray;
	static ArrayList<int[]> array;
	static int v[];
	static int solucion[];
	static HashMap<Integer,Integer> posiciones;
	public static void main(String[] args) throws Throwable {
		posiciones = new HashMap<Integer, Integer>();
		solucion = new int[401];
		llenarPosiciones();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int casos = Integer.parseInt(in.readLine());
		for (int c = 0; c < casos; c++) {
			Arrays.fill(solucion, 0);
			superArray = 0;
			array = new ArrayList<int[]>();
			StringTokenizer st ;
			int masCasos = Integer.parseInt(in.readLine());
			for (int i = 0; i < masCasos; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				v = new int[2];
				v[0] = Math.min(a, b);
				if(v[0]%2==0) v[0]-=1;
				v[1] = Math.max(a, b);
				if(v[1]%2==1) v[1]+=1;
				array.add(v);
			}

			System.out.println(solve3()*10);
		}
	}
	
	private static void llenarPosiciones() {
		int contador = 0;
		for(int i=1;i<=401;++i){
			posiciones.put(i, contador);
			if(i%2==0)
				contador++;
		}
	}

	
	static int solve3(){
		int maximo = Integer.MIN_VALUE;
		for(int i=0;i<array.size();++i){
			int a = array.get(i)[0];
			int b = array.get(i)[1];
			for(int j=a;j<=b;++j){
				solucion[j]+=1;
				if(solucion[j]>maximo)
					maximo=solucion[j];
			}
		}
		return maximo;
	}
	
	public static void solve(  ){
		
		while( array.size() > 0 ){
			ArrayList<int[]> copia = new ArrayList<int[]>();
			copia.add(array.get(0));
			array.remove(0);
			for (int i = 0; i < array.size(); i++) {
				boolean sePuede = true;
				for (int j = 0; j < copia.size() && sePuede; j++) {
					if( array.get(i)[0] >= copia.get(j)[0] && array.get(i)[1] <= copia.get(j)[1] )
						sePuede = false;
					else if( array.get(i)[0] < copia.get(j)[0] && array.get(i)[1] >= copia.get(j)[0])
						sePuede = false;
					else if( array.get(i)[0] > copia.get(j)[0] &&  array.get(i)[0] <= copia.get(j)[1])
						sePuede=false;
					else if( array.get(i)[0] == copia.get(j)[0] || array.get(i)[1] == copia.get(j)[1] )
						sePuede=false;
				}
				if(sePuede){
					copia.add(array.get(i));
					array.remove(i);
					i--;
				}
			}
			superArray+=10;
		}
	}
	
	public static void solve2(  ){
		
		while( array.size() > 0 ){
			ArrayList<int[]> copia = new ArrayList<int[]>();
			copia.add(array.get(0));
			array.remove(0);
			for (int i = 0; i < array.size(); i++) {
				boolean sePuede = true;
				for (int j = 0; j < copia.size() && sePuede ; j++) {
					// copia es el que sirve
					// array es quien voy a comparar a ver si tambien sirve
					int a = array.get(i)[0], b = array.get(i)[1], c = copia.get(j)[0], d = copia.get(j)[1];
					if(! ( b < c || a>d))
						sePuede = false;
				}
				if(sePuede){
					copia.add(array.get(i));
					array.remove(i);
					i--;
				}
			}
			superArray+=10;
		}
	}
}
