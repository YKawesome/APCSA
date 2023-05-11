package helloworld;

import java.util.Scanner;

public class Landcalculation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double landsfeet, landacres;
		System.out.println("How many square feet of land do you own?");
		Scanner reader = new Scanner(System.in);
		landsfeet = reader.nextInt();
		landacres = landsfeet/43560;
		System.out.format("You own %.2f acres of land", landacres);
		reader.close();
		
	}

}
