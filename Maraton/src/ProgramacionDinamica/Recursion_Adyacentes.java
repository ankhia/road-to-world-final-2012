package ProgramacionDinamica;

public class Recursion_Adyacentes {

	static int vec[] = new int[]{2,4,10,-10,5};
	public static void main(String[] args) {
		System.out.println(f(vec.length-1));
	}
	
	static int f( int i ){
		if(i<0) return 0;
		else return Math.max(vec[i], (Math.max(g(i-1)+vec[i], f(i-1))));
	}
	
	static int g( int i ){
		if(i<0) return 0;
		else return Math.max(g(i-1)+vec[i], vec[i]);
			
	}

}
