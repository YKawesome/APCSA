package helloworld;

import java.util.Scanner;

public class input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int age;
//		String first, last, name;
		String name;
		System.out.println("What is your name? ");
		Scanner reader = new Scanner(System.in);
		name = reader.next();
		System.out.println("Hi " + name);
		reader.close();
	}

}
