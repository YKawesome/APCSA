package helloworld;
import java.util.Scanner;

public class Wage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		System.out.println("What is your name? ");
		String name = reader.nextLine();
		System.out.println("How many hours did you work this week?");
		int hours = reader.nextInt();
		System.out.println("What is your hourly pay rate?");
		double payrate = reader.nextDouble();
		System.out.printf("Hello, %s\n", name);
		System.out.printf("Your gross pay is $%.2f", hours*payrate);
		reader.close();
		
	}

}
