package beginningClassWork;
import java.util.Scanner;


public class EmailGenerator {
	
	public static String makeUserName(String s1, String s2) {
		return (s1 + s2.substring(0,1)).toLowerCase();
	}
	
	public static int makeIdNumber() {
		return (int)(Math.random()*Math.pow(10, 8));
	}
	
	public static String makeEmail(String username, int idnumber, String domain) {
		return username + "@" + ("" + idnumber).substring(0,4) + domain;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String domain = "mytusd.org";
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("First Name: ");
		String firstname = reader.next();
		
		System.out.print("Last Name: ");
		String lastname = reader.next();
		
		System.out.printf("This user's e-mail is: %s", makeEmail(makeUserName(firstname,lastname), makeIdNumber(), domain));
		
		
		reader.close();
		
	}

}
