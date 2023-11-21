package helloworld;

import java.util.ArrayList;

public class Person {
    String name;
    String race;
    String sex;
    String dob;
    ArrayList<String> interests = new ArrayList<String>();
    ArrayList<String> friends = new ArrayList<String>();
    String[] family;
    boolean hasFriends = false;
    String college;
    String major;
    

    public Person(String name, String race, String sex, String dob) {
        this.name = name;
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

    public void addCollege(String college, String major) {
        this.college = college;
        this.major = major;
    }

    public void addFriends(String... args) {
        for(String s: args) {
            friends.add(s);
        }
    }

    public String friendsString() {
        String result = "";
        for(String s: friends) {
            result+=s+", ";
        }
        // result = result.substring(0,result.length()-2);
        return result;
    }

    public String toString() {
        return String.format("%s was born on %s.%nHe is part of a family of %d that includes his %s, his %s, and his %s, who he cannot be more happy with.%nHis friends include but are certainly not limited to: %n%s.%nHe will be attending %s for the next 4 years and will be studying %s.%nAfter applying to 19 colleges it has certainly been interesting getting into only 1...%nbut he knew what he was getting into when applying for %s.%nLooking back at the endless past though, he could not be happier.%nWhile Senior year had included a low point—perhaps one of his lowest—he decided to carry on.%nThis whole life thing is pretty confusing, but the wheel always comes around.%nThe true Great Perhaps is the belief that it'll all work out in the end.%nAnd with the year over, I really think it will :)%n",name, dob, family.length+1, family[0],family[1],family[2],friendsString(),college,major,major);
    }



    public static void main(String[] args) {
        Person Yousef = new Person("Yousef", "INDIAN", "Male", "12/21/2004");

        Yousef.setFamily(new String[] {"Mom", "Dad", "Sister"});
        Yousef.addInterest("Robotics");
        Yousef.hasFriends = true;

        
        Yousef.addFriends("Brian", "Jeff", "Hannah", "Megan", "Shelley", "Austin", "Brandon", "Ian", "Brandon", "Erel", "Dominique", "Dillon", "Amy", "Aayush", "Sofia", "Ayla", "Deven", "Hasan", "Rohan", "Matthew", "Rykyn", "Rhyan", "Gerald", "Andres", "Cody", "Jeremy", "Chelsea", "Audrey", "Dennis", "Walter");

        Yousef.addCollege("UCI", "Computer Science");

        System.out.print(Yousef);
        


    }
}
