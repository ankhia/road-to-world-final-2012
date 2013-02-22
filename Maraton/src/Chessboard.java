import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Chessboard {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception  {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		while(n!=0){
			int columna = 1, fila = 1,tamaSig= 1, finaAct=1;
			for(;finaAct<=n-1;++fila){
				tamaSig= fila+(fila+1);
				finaAct += tamaSig;
				// System.out.println(" tama Sig " + tamaSig + " final "+ finaAct);
			}
			int mitadIntervalo = finaAct-((tamaSig/2)+1)+1;
			// System.out.println("n " + n);
			if(n <= mitadIntervalo){
				System.out.println(fila+" "+(n-(finaAct-tamaSig+1)+1));
			}else{
				System.out.println(((finaAct-n)+1)+" "+fila);
			}
			n = Integer.parseInt(bf.readLine());
		}

	}

}