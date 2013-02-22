package Angie;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

import static java.lang.Integer.*;


public class Uva10013 {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String linea;(linea=in.readLine())!=null;) {
			int N = parseInt(linea);
			in.readLine();
			for (int casos = 0; casos < N; casos++) {
				int cant = parseInt(in.readLine());
				BigInteger big = BigInteger.ZERO;
				for (int cantidades = (cant-1); cantidades >= 0; cantidades--) {
					StringTokenizer st = new StringTokenizer(in.readLine());
					int num1 = Integer.parseInt(st.nextToken());
					int num2 = Integer.parseInt(st.nextToken());
					long a = (long) (num1*Math.pow(10, cantidades));
					long b = (long) (num2*Math.pow(10, cantidades));
					big = big.add( BigInteger.valueOf(a));
					big = big.add( BigInteger.valueOf(b));
				}
				
				sb.append(big+"\n\n");
				if(casos<N-1)
					in.readLine();
			}
			String res = sb.substring(0, sb.length()-2);
			System.out.println(res);
		}
	}
}
