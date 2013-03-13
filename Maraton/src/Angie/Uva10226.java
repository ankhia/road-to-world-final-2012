package Angie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.TreeMap;
public class Uva10226 {

	static TreeMap<String, Integer> h = new TreeMap<String, Integer>();
	public static void main(String[] args) throws Throwable {
		NumberFormat nf = NumberFormat.getInstance(Locale.US);
		nf.setMinimumFractionDigits(4);
		nf.setMaximumFractionDigits(4);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt( in.readLine( ) );
		in.readLine();
		for (int i = 0; i < t; i++) {
			int total = 0;
			for( String line; (line = in.readLine())!=null && !line.equals("");  ) {
				if( !h.containsKey(line))
					h.put(line, 1);
				else{
					h.put(line, h.get(line)+1);
				}
				total++;
			}
			for( String x : h.keySet() ) {
				//THIS WAS AN ERROR
				System.out.printf(Locale.US, "%s %.4f\n", x, 100.*h.get(x)/total ); 
//				sb.append(x+" "+nf.format(100.*h.get(x)/total)+"\n");
			}
			if( i < t-1 ){
				System.out.println();
//				sb.append("\n");
			}
			//THIS WAS AN ERROR
			h.clear();
		}
//		System.out.print(new String(sb));
	}
}
