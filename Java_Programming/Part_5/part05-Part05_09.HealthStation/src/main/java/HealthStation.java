
public class HealthStation {

    //var for counting number of times a person has been weighed
    private int timesWeight = 0;

    public int weigh(Person person) {
        // Count number of times a person has been weighted
        timesWeight = timesWeight + 1;
        // FX to retun weigh of a person
        return person.getWeight();
    }

    public void feed(Person person) {
        // Increase weigh of person by 1 after feeding
        // using setWeight() method in Pseron.java
        person.setWeight(person.getWeight()+1);
    }

    public int weighings() {
        // Return number of times a person has been weighted
        return timesWeight;
    }
}