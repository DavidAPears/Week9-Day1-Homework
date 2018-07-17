import java.util.ArrayList;
import java.util.Collections;

public class People {

    private String firstName;
    private String lastName;

    public People(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


// Getter & Setter for People (First & Last name):-

    public String getName() {
        return firstName + " " + lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


//

//    public ArrayList<String> randomPair(){
//        ArrayList<String> twoPeoples = new ArrayList<>();
//        shufflePeople();
//        twoPeoples.add(people.get(0));
//        twoPeoples.add(people.get(1));
//        return twoPeoples;
//    }

    }



