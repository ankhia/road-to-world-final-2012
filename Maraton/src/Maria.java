import java.io.*;
import static java.lang.Integer.*;

public class Maria {
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while(!(linea=in.readLine()).equals("-1")){
			System.out.println(f(parseInt(linea)-1));
		}
	}
	static int f( int n ){
		if(n==0||n==1) return 1;
		else return f(n-1)+f(n-2);
	}
}
