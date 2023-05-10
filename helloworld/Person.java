package helloworld;

import java.util.ArrayList;

public class Person {
    String race;
    String sex;
    String dob;
    ArrayList<String> interests = new ArrayList<String>();
    String[] family;
    boolean hasFriends = false;
    

    public Person(String race, String sex, String dob) {
        this.race = race;
        this.sex = sex;
        this.dob = dob;
    }

    public void setFamily(String[] family) {
        this.family = family;
    }

    public void addInterest(String interest) {
        interests.add(interest);
    }



    public static void main(String[] args) {
        Person Yousef = new Person("INDIAN", "Male", "12/21/2004");



        Yousef.setFamily(new String[] {"Mom", "Dad", "Sister"});
        Yousef.addInterest("Robotics");
        Yousef.hasFriends = true;


        
        Yousef.setFamily(new String[] {"Mom", "Dad", "Sister"});
        Yousef.addInterest("Robotics");
        Yousef.hasFriends = true;
        








    }
}
