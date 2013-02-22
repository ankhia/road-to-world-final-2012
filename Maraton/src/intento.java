import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class intento {

	static Stack<Character> p;
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for (int i = 0; i < t; i++) {
			p = new Stack<Character>();
			String cadena = in.readLine();
			boolean fallo = false;
			for (int j = 0; j < cadena.length() && !fallo; j++) {
				if( cadena.charAt(j) == '(' && ( j==0 || ( (j-1)>=0 && cadena.charAt(j-1) != ':' ))){
					System.out.println("1 " );
					p.add(cadena.charAt(j));
				}
				else if( !p.isEmpty() && cadena.charAt(j) == ')' && p.peek() == '(' && (  (j-1)>=0 && cadena.charAt(j-1) != ':' ) ){
					System.out.println("2 " );
					p.pop();
				}
			}
			if(p.isEmpty() && !fallo)
				System.out.println("Case #"+(i+1)+": YES");
			else 
				System.out.println("Case #"+(i+1)+": NO");
		}
	}
}
