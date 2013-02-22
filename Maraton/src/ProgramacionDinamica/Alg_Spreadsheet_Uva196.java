package ProgramacionDinamica;

import java.io.*;
import java.util.*;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=132
 * @veredict Accepted 
 * @problemId 196
 * @problemName  Spreadsheet
 * @judge http://uva.onlinejudge.org/
 * @category Graph , BFS, DFS
 * @level Easy
 * @date 11/09/2012
 **/ 
public class Alg_Spreadsheet_Uva196 {

	public static String[] letras = new String[]{"A","B","C","D","E","F","G","H","I","J",
		"K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"}; 
	static HashMap<String, Integer> columnas;
	static String m[][];
	static boolean vis[][];
	public static void main(String[] args) throws Throwable {
		inicializar();
		StringBuilder sb = new StringBuilder();
		Scanner in = new Scanner(new InputStreamReader(System.in));
		int casos = in.nextInt();
		for (int casitos = 0; casitos < casos ; casitos ++ ) {
			int col = in.nextInt();
			int fil = in.nextInt();
			m = new String[fil][col];
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					m[i][j] = in.next();
				}
			}

			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					if( isFormula( m[i][j] ) ){
						m[i][j]=dfs( i, j )+"";
						sb.append(m[i][j]);
					} else{
						sb.append(m[i][j]);
					}
					if( j<m[i].length-1)
						sb.append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(new String(sb));
	}

	private static int dfs( int i, int j ) {
		Stack<String> pila = new Stack<String>();
		int suma = 0;
			pila.push(m[i][j]);
		while(!pila.isEmpty()){
			String actual = pila.pop();
			if(isFormula(actual)){
				
				String datos[] = getDatosFormula(actual);
				if( datos.length  <= 1 ) {
					int[] filcol = getFilCol(actual);
					if(!isFormula(m[filcol[0]][filcol[1]])){
						suma+=Integer.parseInt(m[filcol[0]][filcol[1]]);
					} else{
						suma += dfs( filcol[0], filcol[1]);
					}
				}else {
					for (int k = 0; k < datos.length; k++) {
						String expresion = datos[k]; 
						if( isFormula(expresion) ){
							suma += dfs( getFilCol(expresion)[0], getFilCol(expresion)[1]);
						}else{
							suma+= Integer.parseInt(expresion);
						}
					}
				} 
			} else {
				suma+=Integer.parseInt(actual);
			}
		}		
		m[i][j] = suma+"";
		return suma;
	}


	private static int[] getFilCol( String expresion ){
		int[] filcol = new int[2];
		String letras="";
		String numero = "";
		for (int i = 0; i < expresion.length(); i++) {
			char actual = expresion.charAt(i);
			if(Character.isLetter(actual))
				letras+=actual;
			else if(Character.isDigit(actual))
				numero+=actual;
		}
		filcol[1] = columnas.get(letras);
		
		filcol[0] = Integer.parseInt(numero)-1;
		return filcol;
	}

	private static boolean isFormula( String expresion ){
		boolean esForm = false;
		if( expresion.charAt(0) == '=' || Character.isLetter(expresion.charAt(0)))
			esForm = true;
		return esForm;
	}

	private static String[] getDatosFormula( String formula ){
		if(formula.charAt(0)=='=')
			formula = formula.substring(1);
		String[] datos = formula.split("\\+");
		return datos;
	}

	private static void inicializar() {
		columnas = new HashMap<String, Integer>();
		Queue<String> cola = new LinkedList<String>();
		int value = 0;
		for (int i = 0; i < letras.length; i++) {
			cola.add(letras[i]);		
			columnas.put(letras[i], value);
			value++;
		}

		while( !cola.isEmpty() ){
			String actual = cola.poll();
			for (int i = 0; i < letras.length ; ) {
				StringBuilder sb = new StringBuilder( actual );	
				for (int j = 0; j < 1 ; j++, i++) {
					sb.append(letras[i]);
				}
				String nuevo = new String(sb);
				if( nuevo.length() < 3 )
					cola.add(nuevo);
				columnas.put(nuevo, value);
				value++;
			}
		}
	}
}
