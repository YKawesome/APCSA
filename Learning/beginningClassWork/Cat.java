package beginningClassWork;

public class Cat {
	
	//instance variables/fields **PRIVATE**
	private String name;
	private int age;
	private String breed;
	private String color;
	private int weight;
	
	public Cat(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		
	}
	
	public Cat(String name, int age, int weight, String breed, String color) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.breed = breed;
		this.color = color;
	}
	
	public String speak() {
		return String.format("Meow! My name is %s!", name);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cat cat1 = new Cat("meowza", 38, 96000);
		System.out.println(cat1.name);
		System.out.println(cat1.speak());
		
		Cat fatCat = new Cat("Thing", 12, 614400000);
		System.out.print(fatCat.speak());
		
//		Cat fancyCat = new Cat("Charles", 77, 1, "Siamese", "Beige");
		
		
	}

}
