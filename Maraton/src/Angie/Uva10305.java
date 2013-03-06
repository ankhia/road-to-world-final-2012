package Angie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Uva10305 {

	static ArrayList[] lAdy;
	static boolean visitados[];
	static boolean aristasEntrantes[];
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String linea; (linea = in.readLine())!=null; ) {
			StringTokenizer st = new StringTokenizer(linea);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==0&&m==0)break;
			lAdy = new ArrayList[n];
			aristasEntrantes = new boolean[n];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				ArrayList<Integer> arr ;
				if( lAdy[a-1] == null ){
					arr = new ArrayList<Integer>();
				}else{
					arr = lAdy[a-1];
				}
				arr.add(b-1);
				lAdy[a-1] = arr;
				aristasEntrantes[b-1]=true;
			}
			
//			for (int i = 0; i < lAdy.length; i++) {
//				for (int j = 0; lAdy[i]!=null && j < lAdy[i].size(); j++) {
//					System.out.print(lAdy[i].get(j) +" ");	
//				}
//				System.out.println();
//			}
			
			ArrayList<Integer> o = BFS( );
			for (int i = 0; i < o.size(); i++) {
				System.out.println(o.get(i)+" ");
				sb.append(o.get(i)+" ");
			}
			for (int i = 0; i < visitados.length; i++) {
				if(!visitados[i]){
					sb.append(i+1+" ");
				}
			}
			sb = new StringBuilder( sb.substring(0, sb.length()-2) );
			sb.append("\n");
		}
		System.out.println(new String(sb))	;
	}
	
	static ArrayList<Integer> BFS(  ){
		ArrayList<Integer> ordenTop = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>( );
		for (int i = 0; i < aristasEntrantes.length; i++) {
			q.add(i);	
		}
		visitados = new boolean[lAdy.length];
		
		while (!q.isEmpty()) {
			int act = q.poll();
			if(!visitados[act])
			ordenTop.add(act+1);
			visitados[act] = true;
			for (int i = 0;  lAdy[act]!=null && i <lAdy[act].size( ) ; i++) {
				if(!visitados[ (Integer) lAdy[act].get(i) ]){
					q.add( (Integer) lAdy[act].get(i) );
					visitados[(Integer) lAdy[act].get(i)] = true;
				}
			}
		}
		return ordenTop;
	}
}
