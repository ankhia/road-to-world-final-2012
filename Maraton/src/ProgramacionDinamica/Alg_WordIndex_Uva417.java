package ProgramacionDinamica;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/external/4/417.pdf
 * @veredict Accepted 
 * @problemId 417
 * @problemName  Word Index
 * @judge http://uva.onlinejudge.org/
 * @category Graph , BFS
 * @level Easy
 * @date 07/09/2012
 **/ 
import java.io.*;
import java.util.*;

public class Alg_WordIndex_Uva417 {

	public static String[] letras = new String[]{"a","b","c","d","e","f","g","h","i","j",
		"k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	public static HashMap<String, Integer> h ;
	
	public static void main(String[] args) throws Throwable {
		h = new HashMap<String, Integer>();
		bfs();
		BufferedReader bf = new BufferedReader( new InputStreamReader( System.in ) );
		StringBuilder sb = new StringBuilder();
		for (String line; (line = bf.readLine())!=null; ) {
			if( h.get(line) == null )
				sb.append("0\n");
			else
				sb.append(h.get(line)+"\n");
		}
		System.out.print(new String(sb));
	}

	public static void bfs( ){
		Queue<String> cola = new LinkedList<String>();
		int value = 1;
		for (int i = 0; i < letras.length; i++){
			cola.add(letras[i]);
			h.put(letras[i], value);
			value++;
		}
		while( !cola.isEmpty() && value < 83682 ){
			for (int k = 0; k < letras.length && value < 83682; k++) {
				String actual = cola.poll( );
				int pos = h.get(actual.charAt(actual.length()-1)+"");
				int i = pos;
				while(  i < letras.length && value < 83682 ) {
					int j = 0 ;
					String nuevo = actual;
					while( j < 1 && i < letras.length && value < 83682){
						nuevo += letras[i];
						i++;j++;
					}
					cola.add(nuevo);
					h.put(nuevo, value);
					value++;
				}
			}
		}
	}
}
