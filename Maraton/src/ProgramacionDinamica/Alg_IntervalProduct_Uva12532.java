package ProgramacionDinamica;


/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3977
 * @veredict Accepted 
 * @problemId 12532
 * @problemName  IntervalProduct
 * @judge http://uva.onlinejudge.org
 * @category Segment Tree, Math
 * @level Easy
 * @date 23/11/2012
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alg_IntervalProduct_Uva12532 {

	static int[] start;
	static int[] end;

	static int[] segPos;
	static int[] segNeg;
	static int[] segCer;

	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line; ( line = in.readLine() )!=null; ) {
			StringTokenizer st = new StringTokenizer(line);
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int tam = N*4;
			start = new int[tam];
			end = new int[tam];
			segPos = new int[tam];
			segNeg = new int[tam];
			segCer = new int[tam];
			
			build_segment_tree( 1, N, 0 );
			
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				changeVal((i+1),(i+1), 0, Integer.parseInt(st.nextToken()));
			}

			for (int query = 0; query < K; query++) {
				st = new StringTokenizer(in.readLine());
				char a = st.nextToken().charAt(0);
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				if( a == 'C' ){
					changeVal(i, i, 0, j);
				}
				else{
					int q = query( i, j, 0 );
					if( q > 0 )
						sb.append("+");
					else if( q < 0 )
						sb.append("-");
					else
						sb.append("0");
				}
				
			}
			sb.append("\n");
			
		}
		System.out.print(new String(sb));
	}

	private static int query(int ini, int fin , int index) {
		if(  ini == start[index] && fin == end[index] ){
			if( segCer[index] > 0)
				return 0;
			else if( segNeg[index]%2== 0 )
				return 1;
			else 
				return -1;
		} else {
			int derIni = start[rightChild(index)];
			int derFin = end[rightChild(index)];

			int izqIni = start[leftChild(index)];
			int izqFin = end[leftChild(index)];

			int hijoDerIni =  ( ini > derIni ) ? ini: derIni;
			int hijoDerFin =  ( fin < derFin ) ? fin: derFin;
			int hijoIzqIni =  ( ini > izqIni ) ? ini: izqIni; 
			int hijoIzqFin =  ( fin < izqFin ) ? fin: izqFin;

			int mul = 1;

			if( hijoDerIni <= hijoDerFin ){
				mul *= query(hijoDerIni, hijoDerFin, rightChild(index));
			}
			if( hijoIzqIni <= hijoIzqFin ){
				mul *= query(hijoIzqIni, hijoIzqFin, leftChild(index));
			}

			return mul;
		}
	}
	
	private static void changeVal( int ini, int fin , int index, int value) {
		if(  ini == start[index] && fin == end[index] ){
			if(  value == 0 ){
				segCer[index] = 1;
				segNeg[index] = 0;
				segPos[index] = 0;
			}
			else if( value < 0 ){
				segNeg[index] = 1;
				segPos[index] = 0;
				segCer[index] = 0;
			}
			else {
				segPos[index] = 1;
				segNeg[index] = 0;
				segCer[index] = 0;
			}
//			actualizar_tree( index );
		} else {
			int derIni = start[rightChild(index)];
			int derFin = end[rightChild(index)];

			int izqIni = start[leftChild(index)];
			int izqFin = end[leftChild(index)];

			int hijoDerIni =  ( ini > derIni ) ? ini: derIni;
			int hijoDerFin =  ( fin < derFin ) ? fin: derFin;
			int hijoIzqIni =  ( ini > izqIni ) ? ini: izqIni; 
			int hijoIzqFin =  ( fin < izqFin ) ? fin: izqFin;
			
			if( hijoDerIni <= hijoDerFin ){
				changeVal(hijoDerIni, hijoDerFin, rightChild(index), value);
			}
			if( hijoIzqIni <= hijoIzqFin ){
				changeVal(hijoIzqIni, hijoIzqFin, leftChild(index), value);
			}
			segPos[index] = segPos[rightChild(index)]+segPos[leftChild(index)];
			segNeg[index] = segNeg[rightChild(index)]+segNeg[leftChild(index)];
			segCer[index] = segCer[rightChild(index)]+segCer[leftChild(index)];
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
	


//	public static void actualizar_tree( int i, int[]seg ){
//		int parent = parent(i);
//		while( parent >= 0 )
//		{
//			int l = leftChild(parent);
//			int r = rightChild(parent);
//			seg[parent] = seg[l]+seg[r];
//			parent = parent(parent);
//		}
//	}
	
//	public static void actualizar_tree( int i ){
//		int parent = parent(i);
//		while( parent >= 0 )
//		{
//			int l = leftChild(parent);
//			int r = rightChild(parent);
//			segPos[parent] = segPos[l]+segPos[r];
//			segNeg[parent] = segNeg[l]+segNeg[r];
//			segCer[parent] = segCer[l]+segCer[r];
//			parent = parent(parent);
//		}
//	}
	
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

//public static void changeValue( int i , int val ){
//boolean encontre = false;
//for (int j = 1; j < start.length && !encontre; j++) {
//	if( start[j]==end[j] && i == start[j] ){
//		if( val > 0 ){
//			segPos[j] = 1;
//			segNeg[j] = 0;
//			segCer[j] = 0;
//			encontre = true;
//		}
//		else if( val < 0 ){
//			segNeg[j] = 1;
//			segPos[j] = 0;
//			segCer[j] = 0;
//			encontre = true;
//		}else {
//			segCer[j] = 1;
//			segNeg[j] = 0;
//			segPos[j] = 0;
//			encontre = true;
//		}
//		actualizar_tree( j );
//	}
//}
//}