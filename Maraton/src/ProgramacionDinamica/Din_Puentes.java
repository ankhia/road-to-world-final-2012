package ProgramacionDinamica;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Din_Puentes {

	static int []a1;
	static int []b1;
	static String []a;
	static String []b;
	
	public static void main(String[] args) throws Throwable {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while( ( a = bf.readLine( ).split(" ") )!=null ){
			b = bf.readLine().split(" ");
			System.out.println(f(0, 0));
		}
	}
	
	
	public static int f( int i, int j ){
		if(i==a.length || j==b.length )
			return 0;
		if( a[i].equals(b[j]) ){
			return Math.max(f(i+1,j+1)+1, (Math.max(f(i+1,j), f(i,j+1))));
		}
		else
			return Math.max(f(i+1,j), f(i,j+1));
	}

}
