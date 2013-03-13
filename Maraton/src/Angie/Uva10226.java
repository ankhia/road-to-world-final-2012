package Angie;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class Uva10226 {

	static TreeMap<char[], Integer> h = new TreeMap<char[], Integer>(new Comparator<char[]>() {
		public int compare(char[] o1, char[] o2) {
			int min = o1.length < o2.length ? o1.length : o2.length;
			for (int i = 0; i < min; i++) {
				if(o1[i]!=o2[i])
					return o1[i]-o2[i];
			}
			if(o1.length > o2.length)
				return 1;
			else if(o2.length > o1.length)
				return -1;
			return 0;
		}
	});
	static ArrayList<String> a = new ArrayList<String>();
	static TreeSet<String> b= new TreeSet<String>();
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt( in.readLine( ) );
		in.readLine();
		for (int i = 0; i < t; i++) {
			int total = 0;
			for( String line; (line = in.readLine())!=null && !line.equals("");  ) {
				char[] v = line.toCharArray( );
//				a.add(line);
//				b.add(line);
				if( h.get(v) == null )
					h.put(v, 1);
				else{
					h.put(v, h.get(v)+1);
				}
				total ++;
			}
			for( char[] x : h.keySet() ) {
				System.out.printf(new String(x)+" %.4f\n", ( total > 0 ? ( (double)(h.get(x)*100 ) / total  ): 0.  ) );
			}
		}
	}
}
