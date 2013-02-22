import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Angie Milena Vega Leon y Pierre Etienne Pradere Palacios
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=3&page=show_problem&problem=87
 * @veredict -- 
 * @problemId 151
 * @problemName  Power Crisis
 * @judge http://uva.onlinejudge.org/
 * @category Conteo
 * @level --
 * @date 10/01/2012
 **/ 

public class Uva151 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		while(N!=0){
			
			N = Integer.parseInt(bf.readLine());
		}
	}
	
	public static void getMinimunM( int n ){
		for(int i=1; i<n ; i++){
			
		}
	}
	
	public static boolean isFunciona(boolean []vec){
		for(int i=0; i<vec.length; ++i){
			if(vec[i])
				return false;
		}
		return true;
	}

}
