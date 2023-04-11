package beginningClassWork;
import java.util.Scanner;

public class LeapYear {

	public static boolean isLeapYear(int year) {
		if(year % 4 == 0) {
			if((year % 100 == 0) && (year % 400 != 0)) {
				return false;
			}
			
			else {
				return true;
			}
		}
		
		else {
			return false;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("Type in a year: ");
		int year = reader.nextInt();
		boolean leapyear = isLeapYear(year);
		
		if(leapyear) {
			System.out.printf("The year %d is a leap year.", year);
		}
		
		else {
			System.out.printf("The year %d is not a leap year.", year);
		}
		
		reader.close();
		
	}

}
