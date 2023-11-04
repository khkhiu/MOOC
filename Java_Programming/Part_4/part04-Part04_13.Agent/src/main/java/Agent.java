/*
Remove the class' print method, and create a public String toString() method for it, 
which returns the string representation shown above.
 */

public class Agent {

    private String firstName;
    private String lastName;
    
    public Agent(String initFirstName, String initLastName) {
        this.firstName = initFirstName;
        this.lastName = initLastName;
    }
    
    // Original code
    //public void print() {
    //System.out.println("My name is " + this.lastName + ", " + this.firstName + " " + this.lastName);
    //}

    public String toString(){
        return "My name is " + this.lastName + ", " + this.firstName + " " + this.lastName;
    }
    
}
