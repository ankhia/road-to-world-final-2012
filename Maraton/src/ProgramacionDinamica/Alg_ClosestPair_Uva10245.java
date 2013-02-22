package ProgramacionDinamica;

import java.io.*;
import java.text.*;
import java.util.*;

/**
 * @author Angie Milena Vega Leon
 * @linkDeArchivo http://uva.onlinejudge.org/external/102/10245.pdf
 * @veredict Accepted 
 * @problemId 10245
 * @problemName The Closest Pair Problem
 * @judge http://uva.onlinejudge.org/
 * @category Divide and Conquer, Algoritmo de Puntos mas cercanos.
 * @level Medium
 * @date 10/09/2012
 **/ 
public class Alg_ClosestPair_Uva10245 {

	static double[][] coordenadas;
	public static void main(String[] args) throws Throwable {
		StringBuilder sb = new StringBuilder( );
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String linea; (linea=in.readLine())!=null; ) {
			int N = Integer.parseInt(linea);
			if(N == 0) break;
			coordenadas = new double[N][2];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				coordenadas[i][0] = Double.parseDouble(st.nextToken());
				coordenadas[i][1] = Double.parseDouble(st.nextToken());
			}

			Arrays.sort(coordenadas, new Comparator<double[]>() {
				public int compare(double[] o1, double[] o2) {
					if(o1[0]<o2[0]) return 1;
					if(o2[0]<o1[0]) return -1;
					return 0;
				}
			});


			double dis =  dyc( 0, coordenadas.length-1 );
			DecimalFormatSymbols s = new DecimalFormatSymbols();
			s.setDecimalSeparator('.');
			DecimalFormat df = new DecimalFormat("0.0000",s);
			double val = 10000.0000;
			if(dis > val)
				sb.append("INFINITY\n");
			else
				sb.append(df.format(dis)+"\n");
		}
		System.out.print(new String(sb));
	}

	static double dyc( int ini, int fin ){
		if(ini > fin) return Double.MAX_VALUE;
		if( ini == fin ) return  Double.MAX_VALUE;
		else if( ini+1 == fin ){
//			System.out.println(distancia(coordenadas[ini], coordenadas[fin]));
			return distancia(coordenadas[ini], coordenadas[fin]);
		}else{
			int mid = (ini+fin)/2;
//			System.out.println( " mid " + mid );
			double disRec = Math.min( dyc( ini, mid ), dyc( mid+1, fin ));
			
			int indIni; int indFin;
			if( mid-2 >=0 )	indIni = mid-2;
			else if( mid-1 >=0 )indIni = mid-1;
			else			indIni = mid;
			if( mid+2 < coordenadas.length ) indFin = mid+2;
			else if( mid+1 < coordenadas.length ) indFin = mid+1;
			else indFin = mid;
//			System.out.println( " indINI " +indIni + "  indFIN " + indFin );
			double disFrag = menorDistanciaFragmento(indIni, indFin);
			
			return Math.min(disRec, disFrag);
		}
	}

	static double menorDistanciaFragmento( int a , int b ){
		double dis = Double.MAX_VALUE;
		if(a<b){
			for (int i = a; i < b; i++) {
				for (int j = i+1; j <= b; j++) {
					double dis2 = distancia(coordenadas[i], coordenadas[j]);
					if( dis2 < dis )
						dis = dis2;
				}
			}
		}
		return dis;
	}

	static double distancia( double p1[], double p2[] ){
		return Math.sqrt( (Math.pow((p2[0] - p1[0]),2) ) + (Math.pow((p2[1] - p1[1]),2) ));
	}

}
