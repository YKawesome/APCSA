package beginningClassWork;

public class AboutMe {
	
	//Private instance fields
	private String name;
	private String school;
	private int age;
	
	//Constructor
	public AboutMe(String name, String school, int age) {
		this.name = name;
		this.school = school;
		this.age = age;
	}
	
	//Getter methods
	public String myName() {
		return name;
	}
	
	public String mySchool() {
		return school;
	}
	
	public int myAge() {
		return age;
	}
	
	
	
	//Main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create AboutMe object
		AboutMe ididit = new AboutMe("Yousef", "Beckman High School", 17);
		
		//Final output
		System.out.printf("My name is %s, and I attend %s. I am %d years old.", ididit.myName(), ididit.mySchool(), ididit.myAge());
	}

}
