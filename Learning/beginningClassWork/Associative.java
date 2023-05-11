package beginningClassWork;
import java.util.Scanner;
public class Associative {

	private int x;
	private int y;
	private int z;
	
	public Associative(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int firstTwo() {
		return (x+y) * z;
	}
	
	public int lastTwo() {
		return x + (y*z);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("First integer: ");
		int x = reader.nextInt();
		System.out.print("Second integer: ");
		int y = reader.nextInt();
		System.out.print("Third integer: ");
		int z = reader.nextInt();
		
		Associative associator = new Associative(x,y,z);
		
		String msg1 = String.format("Grouping for the first two terms, (%d + %d) * %d = %d", x,y,z,associator.firstTwo());
		String msg2 = String.format("Grouping for the first two terms, (%d + %d) * %d = %d", x,y,z,associator.lastTwo());
		
		System.out.println(msg1);
		System.out.println(msg2);
		
		reader.close();
		
	}

}
