package helloworld;
import java.util.Scanner;
public class Stringmanipulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner reader = new Scanner(System.in);
		System.out.print("What is your favorite city?\n");
		String city = reader.nextLine();
		int strlength = city.length();
		String upstr = city.toUpperCase();
		String lowstr = city.toLowerCase();
		
		
		System.out.printf("%o\n%s\n%s",strlength,upstr,lowstr);
		
		reader.close();
	}

}
