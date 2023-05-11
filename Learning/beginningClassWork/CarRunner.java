package beginningClassWork;
import java.util.Scanner;

public class CarRunner {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Make: ");
		String make = reader.next();
		
		System.out.println("Year: ");
		int year = reader.nextInt();
		
		Car myCar = new Car(year, make);
		
		for(int i = 0; i < 5; i++) {
			myCar.accelerate();
			System.out.printf("%d %s, Car Speed: %d\n", myCar.getYearModel(), myCar.getMake(), myCar.getSpeed());
		}
		
		for(int i = 0; i < 5; i++) {
			myCar.brake();
			System.out.printf("%d %s, Car Speed: %d\n", myCar.getYearModel(), myCar.getMake(), myCar.getSpeed());
		}
		
		reader.close();

	}

}