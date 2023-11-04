public class Fitbyte {
    private int age;
    private int restingHeartRate;

    public Fitbyte(int age, int restingHeartRate){
        this.age = age;
        this.restingHeartRate = restingHeartRate;
    }

    public double targetHeartRate(double percentage){
        // Formula of target heart rate = (maximum heart rate - resting heart rate) * (target heart rate percentage) + resting heart rate
        double result = 0;
        double maxHeartRate = 0;
        maxHeartRate = 206.3 - (0.711 * age);
        result = (maxHeartRate - restingHeartRate) * percentage + restingHeartRate;

        return result;
    }
}