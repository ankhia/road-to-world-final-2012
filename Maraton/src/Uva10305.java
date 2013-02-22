import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Uva10305 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String linea = null;
		while(!(linea = bf.readLine()).equals("0 0")){
			String aux[] = linea.split(" ");
			ArrayList<Integer>[] g = new ArrayList[Integer.parseInt(aux[0])];
			for(int i=0;i<g.length;++i)
				g[i]=new ArrayList<Integer>();
			int tam = Integer.parseInt(aux[1]);
			for(int i=0;i<tam;++i){
				aux = bf.readLine().split(" ");
				g[Integer.parseInt(aux[0])-1].add(Integer.parseInt(aux[1])-1);
			}
			int r[] = topologicalSort(g);
			for(int i = 0;i<r.length;++i){
				System.out.print((r[i]+1)+((i+1<r.length)?" ":""));
			}
		}
	}
	
	public static int[] topologicalSort(ArrayList<Integer>[] lAdy){
		int n = lAdy.length;
		int state[] = new int[n];
		ArrayList<Integer> r = new ArrayList<Integer>();
		for(int v=0;v<n;++v){
			if(state[v]==0 && !dfsTs(lAdy, v, state, r))
				return null;
		}
		int t=r.size();
		int a[] =new int[t];
		for(int i=0;i<t;++i)
			a[i]=r.get(t-1-i);
		System.out.println(r);
		return a;
	}
	
	public static boolean dfsTs(ArrayList<Integer>[] lAdy, int v, int[] state , ArrayList<Integer>  r){
		state[v]=1;
		for(int w : lAdy[v]){
			if(state[w]==1 ||(state[w]==0&&!dfsTs(lAdy, w, state, r)))
				return false;
		}
		state[v]=2;
		r.add(v);
		return true;
	}

}
