package beginningClassWork;

public class Dog {
	
	private String name;
	private int age;
	private int weight;
	
	public Dog(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	public String speak() {
		return "Woof!";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dog myDog = new Dog("Fido", 27, 96000);
		System.out.print(myDog.speak());
	}

}
