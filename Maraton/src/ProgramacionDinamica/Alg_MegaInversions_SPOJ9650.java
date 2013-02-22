package ProgramacionDinamica;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://www.spoj.pl/problems/TRIPINV/
 * @veredict Accepted 
 * @problemId 9650
 * @problemName  Word Index
 * @judge http://www.spoj.pl/problems/TRIPINV/
 * @category Segment Tree, Math
 * @level Easy
 * @date 06/09/2012
 **/ 
import static java.lang.Integer.parseInt;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Alg_MegaInversions_SPOJ9650 {

	static int[] n;
	static int[] start;
	static int[] end;
	static int[] startMen;
	static int[] endMen;

	static int[] cantxNumMay;
	static int[] cantxNumMen;

	static int[] mayores;
	static int[] menores;

	public static void main(String[] args) throws Throwable{
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String linea;(linea = in.readLine())!=null;) {
			int casos = parseInt(linea);
			n = new int[casos];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < casos; i++) {
				n[i] = parseInt(st.nextToken());
			}
//			int log = (int) (Math.floor(Math.log10(casos)/Math.log10(2)));
			int tam = (int)(4 * casos);
			start = new int[tam];
			cantxNumMay = new int[casos];
			end = new int[tam];
			mayores = new int[tam];

			startMen = new int[tam]; 
			endMen = new int[tam];
			cantxNumMen= new int[casos];
			menores = new int[tam];

			build_segment_tree(1, casos, 0);
			build_segment_tree_menores( 1, casos, 0 );

			BigInteger total = BigInteger.ZERO;
			if(casos >= 3 ){
				for (int i = 0; i < n.length ; i++) {
					int j = 1;
					boolean encontre = false;
					while(!encontre){
						if( n[i] >= start[j] && n[i] <= end[j] ){
							if(start[j] == end[j] && n[i] == end[j] ){
								mayores[j] = mayores[j]+1;
								cantxNumMay[i] = queryRange(n[i]+1, casos, 0);
//								System.out.println(Arrays.toString(cantxNumMay));
								actualizar_tree(j);
								j=1;
								break;
							}
							j=2*j+1;
						}
						else if(  n[i] >= end[j] ){
							if(start[j] == end[j] && n[i] == end[j] ){
								mayores[j] = mayores[j]+1;
								cantxNumMay[i] = queryRange(n[i]+1, casos, 0);
//								System.out.println(Arrays.toString(cantxNumMay));
								actualizar_tree(j);
								j=1;
								break;
							}
							j = 2*(parent(j))+2;
						}
					}
				}

				for ( int k= casos-1;  k>=0; k--) {
					int j = 1;
					boolean encontre = false;
					while(!encontre){	
						if( n[k] >= startMen[j] && n[k] <= endMen[j] ){
							if(startMen[j] == endMen[j] && n[k] == endMen[j] ){
								menores[j] = menores[j]+1;
								cantxNumMen[k] = queryRange_menores(1, n[k]-1, 0);
//								System.out.println(Arrays.toString(cantxNumMen));
								actualizar_tree_menores(j);
								j=1;
								break;
							}
							j=2*j+1;
						}else if(  n[k] >= endMen[j] ){
							if(startMen[j] == endMen[j] && n[k] == endMen[j] ){
								menores[j] = menores[j]+1;
								cantxNumMen[k] = queryRange_menores(1,n[k]-1, 0);
//								System.out.println(Arrays.toString(cantxNumMen));
								actualizar_tree_menores(j);
								j=1;
								break;
							}
							j = 2*(parent(j))+2;
						}
					}
				}

				for (int j = 0; j < cantxNumMay.length; j++) {
					total = total.add(BigInteger.valueOf(cantxNumMay[j]).multiply(BigInteger.valueOf(cantxNumMen[j]))) ;
				}
			}
			sb.append(total+"\n");
			
		}
		System.out.print(new String(sb));
	}

	public static int queryRange( int ini , int fin, int index ){
		if(  ini == start[index] && fin == end[index] ){
			return mayores[index];
		} else {
			int derIni = start[rightChild(index)];
			int derFin = end[rightChild(index)];

			int izqIni = start[leftChild(index)];
			int izqFin = end[leftChild(index)];

			int hijoDerIni =  ( ini > derIni ) ? ini: derIni;
			int hijoDerFin =  ( fin < derFin ) ? fin: derFin;
			int hijoIzqIni =  ( ini > izqIni ) ? ini: izqIni; 
			int hijoIzqFin =  ( fin < izqFin ) ? fin: izqFin;

			int suma = 0;

			if( hijoDerIni <= hijoDerFin ){
				suma += queryRange(hijoDerIni, hijoDerFin, rightChild(index));
			}
			if( hijoIzqIni <= hijoIzqFin ){
				suma += queryRange(hijoIzqIni, hijoIzqFin, leftChild(index));
			}

			return suma;
		}
	}

	public static int queryRange_menores( int ini , int fin, int index ){
		if(  ini == startMen[index] && fin == endMen[index] ){
			return menores[index];
		} else {
			int derIni = startMen[rightChild(index)];
			int derFin = endMen[rightChild(index)];

			int izqIni = startMen[leftChild(index)];
			int izqFin = endMen[leftChild(index)];

			int hijoDerIni =  ( ini > derIni ) ? ini: derIni;
			int hijoDerFin =  ( fin < derFin ) ? fin: derFin;
			int hijoIzqIni =  ( ini > izqIni ) ? ini: izqIni; 
			int hijoIzqFin =  ( fin < izqFin ) ? fin: izqFin;

			int suma = 0;

			if( hijoDerIni <= hijoDerFin ){
				suma += queryRange_menores(hijoDerIni, hijoDerFin, rightChild(index));
			}
			if( hijoIzqIni <= hijoIzqFin ){
				suma += queryRange_menores(hijoIzqIni, hijoIzqFin, leftChild(index));
			}

			return suma;
		}
	}

	public static void actualizar_tree( int i ){
		int parent = parent(i);
		while( parent >= 0 )
		{
			int l = leftChild(parent);
			int r = rightChild(parent);
			mayores[parent] = mayores[l]+mayores[r];
			parent = parent(parent);
		}
	}

	public static void actualizar_tree_menores( int i ){
		int parent = parent(i);
		while( parent >= 0 )
		{
			int l = leftChild(parent);
			int r = rightChild(parent);
			menores[parent] = menores[l]+menores[r];
			parent = parent(parent);
		}
	}


	public static void build_segment_tree( int s, int e, int i ){
		if(i<start.length){
			start[i] = s;
			end[i] = e;
		}else return;
		if( s >= e ) return;
		int mid = (int) Math.floor((s+e)/2);
		build_segment_tree(s, mid, 2*i+1);
		build_segment_tree(mid+1, e, 2*i+2);
	}

	private static void build_segment_tree_menores(int s, int e, int i) {
		if(i<startMen.length){
			startMen[i] = s;
			endMen[i] = e;
		}else return;
		if( s >= e ) return;
		int mid = (int) Math.floor((s+e)/2);
		build_segment_tree_menores(s, mid, 2*i+1);
		build_segment_tree_menores(mid+1, e, 2*i+2);

	}


	public static int parent( int i ){	
		return (int)(Math.ceil((double)i/2)-1); 
	}
	public static int leftChild( int i ){	
		return 2*i+1;					
	}
	public static int rightChild( int i ){
		return 2*i+2;					
	}
}