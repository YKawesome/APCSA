package helloworld;

import java.util.Scanner;
import java.lang.Math;

public class greedy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Constants
		double quarter = 0.25;
		double dime = 0.10;
		double nickel = 0.05;
//		double penny = 0.01;
		
		double quarters;
		double dimes;
		double nickels;
		double pennies;
		
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("O hai! How much change is owed?\n");
		double change = reader.nextDouble();
		
		quarters = Math.floor(change/quarter);
		change -= quarters*quarter;
		dimes = Math.floor(change/dime);
		change -= dimes*dime;
		nickels = Math.floor(change/nickel);
		change -= nickels*nickel;
		pennies = change*100;
		
		double coins = quarters + dimes + nickels + pennies;
		
		System.out.printf("%.0f", coins);
		
		reader.close();
		
	}

}
