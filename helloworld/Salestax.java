package helloworld;
import java.util.Scanner;

public class Salestax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double statetax, countytax, totaltax, purchase, totalsale;
		Scanner reader = new Scanner(System.in);
		
		System.out.println("How much was the purchase?");
		purchase = reader.nextDouble();
		statetax = 0.04*purchase;
		countytax = 0.02*purchase;
		totaltax = statetax+countytax;
		totalsale = purchase + totaltax;
		
		System.out.format("Subtotal: $%.2f\n", purchase);
		System.out.format("State Tax: $%.2f\n", statetax);
		System.out.format("County Tax: $%.2f\n", countytax);
		System.out.format("Total Tax: $%.2f\n", totaltax);
		System.out.format("Total: $%.2f", totalsale);
		
		reader.close();
		
	}

}
