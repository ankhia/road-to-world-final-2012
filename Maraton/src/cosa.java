import java.io.BufferedReader;
import java.io.InputStreamReader;


public class cosa {

	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (String line ; (line = in.readLine())!=null; ) {
			if(line.equals("*")) break;
			line = line.trim();
			boolean legal = true;
			try{
				double a = Double.parseDouble(line);
			}catch(Exception e){
//				System.out.println("a");
				legal = false;
			}

			if(! (line.contains(".") || line.contains("e") || line.contains("E") ) ){
//				System.out.println("a");
				legal = false;
			}
			int indicePunto = line.indexOf(".");
			if(indicePunto!=-1){
				if(indicePunto+1==line.length()) legal = false;
				else if( !Character.isDigit(line.charAt(indicePunto+1) ) ) legal = false;
				if( indicePunto-1<0 )legal=false;
				else if(!Character.isDigit(line.charAt(indicePunto-1) )) legal = false;
			}
			if(legal)
				sb.append(line + " is legal.\n");
			else
				sb.append(line+" is illegal.\n");

		}
		System.out.print(new String(sb));
	}
}
