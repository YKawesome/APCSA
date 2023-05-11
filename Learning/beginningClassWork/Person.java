package beginningClassWork;

public class Person {
	
	//instance variables/fields (ALWAYS DECLARE FIELDS AS PRIVATE)
	//create name, age, weight fields
	
	private String name;
	private int age;
	private int weight;
	
	
	
	
	
	//constructor = a special method that is called when you use the "new"
	
	public Person(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	public Person() {
		this.name = "Failure";
		this.age = 12;
		this.weight = 96000;
	}
	
	
	//method - an action that objects/instances of the class can perform
	
	public String speak() {
		
		return String.format("Hi there! My name is %s. I am %d years old and I weight %d pounds", name, age, weight);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person p1 = new Person();
		Person me = new Person("Yousef", 17, 145);
		
		System.out.println(p1.speak());
		System.out.print(me.speak());
		
		
	}

}
