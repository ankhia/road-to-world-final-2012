/**
 * Professor Stewart is consulting for the president of a corporation that is planning a company party. 
 * The company has a hierarchical structure; that is, the supervisor relation forms a tree rooted at the president. 
 * The personnel office has ranked each employee with a conviviality rating, which is a real number. 
 * In order to make the party fun for all attendees, the president does not want both an employee and his or her immediate supervisor 
 * to attend. Professor Stewart is given the tree that describes the structure of the corporation, 
 * using the left-child, right-sibling representation. Each node of the tree holds, in addition to the pointers,
 *  the name of an employee and that employee's conviviality ranking. 
 *  Describe an algorithm to make up a guest list that maximizes the sum of the conviviality ratings of the guests.
 *   Analyze the running time of your algorithm.
 */
package ProgramacionDinamica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CompanyParty {

	public static void main(String[] args) throws Throwable{
		BufferedReader bf = new BufferedReader(new FileReader(new File("in.in")));
		String linea;
		while((linea=bf.readLine())!=null){
			
		}
	}
}
class Nodo {
	
}