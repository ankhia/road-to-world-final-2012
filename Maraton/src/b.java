import java.io.BufferedReader;
import java.io.InputStreamReader;


public class b {

	static String line;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb  = new StringBuilder();
		int x = Integer.parseInt(in.readLine());
		for (int i = 0; i < x; i++) {
			
			line = in.readLine();
			if( f(0,0) )
				sb.append("Case #"+(i+1)+": YES\n");
			else
				sb.append("Case #"+(i+1)+": NO\n");
		}
		System.out.print(new String(sb));
	}
	
	static boolean f( int i , int c ){
		if( c < 0 || ( c > 0 && i==line.length()))
			return false;
		else if( c==0 && i==line.length() )
			return true;
		else {
			if( line.charAt(i)!=')' && line.charAt(i)!='('  ){
				return f( i+1, c );
			}else if( i-1 >= 0 && line.charAt(i-1)==':' ){
				return (f(i+1,c) || f(i+1, (line.charAt(i)=='(')? c+1:c-1 ));
			}else{
				return f( i+1,(line.charAt(i)=='(')? c+1:c-1 );
			}
		}
	}
}
