package beginningClassWork;
import java.util.Scanner;

public class Mario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner reader = new Scanner(System.in);
		
		int height;
		
		//Get an acceptable height from user
		while(true) {
			System.out.print("Height: ");
			height = reader.nextInt();
			if(height>=0 && height <=23) {
				break;
			}
			System.out.println("Invalid value");
		}
		
		//For loop for each pyramid layer
		for(int i = 0; i < height; i++) {
			
			//Declare variables that will represent the spaces and the #s per layer
			String emptiness = "";
			String tags = "";
			
			
			//Add correct amount of spaces for that layer
			for(int j = 0; j < height-(i+1); j++) {
				emptiness+=" ";
			}
			
			//Add correct amount of #s for that layer
			for(int j = 0; j < i+1; j++) {
				tags+="#";
			}
			
			//Print out final message per line
			System.out.println(emptiness+tags + "  " + tags + emptiness);
			
		}
		
		
		reader.close();
		
	}

}
