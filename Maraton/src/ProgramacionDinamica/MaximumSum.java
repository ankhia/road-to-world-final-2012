package ProgramacionDinamica;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaximumSum {

	static int array[][];
	static int sumas[][];
	
	public static void main(String[] args) throws Throwable {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while (  (linea=bf.readLine()) != null ) {
			int sizeArray = Integer.parseInt(linea);
			array = new int[sizeArray][sizeArray];
			sumas = new int[sizeArray][sizeArray];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[0].length; j++) {
					if(!st.hasMoreTokens())
						st=new StringTokenizer(bf.readLine());
					array[i][j] = Integer.parseInt(st.nextToken().trim());
				}
			}
			
			for (int i = 0; i < array.length; i++) {
				System.out.println(Arrays.toString(array[i]));
			}
			
			llenarSumas();
			System.out.println();
			for (int i = 0; i < array.length; i++) {
				System.out.println(Arrays.toString(sumas[i]));
			}
			
		}
	}
	
	
	static void llenarSumas(  ){
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if(i==0 && j==0)
					sumas[i][j]=array[i][j];
				else if(i==0)
					sumas[i][j]= array[i][j]+sumas[i][j-1];
				else if(j==0)
					sumas[i][j]= array[i][j]+sumas[i-1][j];
				else
					sumas[i][j]= array[i][j]+sumas[i-1][j]+sumas[i][j-1]-sumas[i-1][j-1];
			}
		}
	}
	
	static int D(int a, int b, int i, int j){
		return  sumas[i][j]-sumas[i][b-1]-sumas[a-1][j]+sumas[a-1][b-1];
	}
	
}
