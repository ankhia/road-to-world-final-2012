import java.io.*;
import java.util.*;
import static java.lang.Integer.*;
public class aaaa{
	public static void main(String[] args) throws Throwable{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		System.setOut(new PrintStream("A.out"));
		for(int N=parseInt(in.readLine().trim()),n=0;n++<N;){
			char[] a=in.readLine().trim().toCharArray();
			int[] arr=new int[26];
			for(char s:a)
				if(Character.isLetter(s))
					arr[Character.toLowerCase(s)-'a']++;
			Arrays.sort(arr);
			long sol=0;
			for(int i=arr.length-1;i>=0;i--)
				sol+=(i+1)*arr[i];
			System.out.println("Case #"+n+": "+sol);
		}
	}
}