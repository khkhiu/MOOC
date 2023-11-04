public class Timer {
    private ClockHand seconds;
    // hundredSeconds == miliseconds
    private ClockHand hunderedSeconds;

    // Method that defines the timer for second and milisecond
    public Timer() {
        this.seconds = new ClockHand(60);
        this.hunderedSeconds = new ClockHand(100);
    }

    //Method that moves timer forward 1 milisecond
    public void advance() {
        this.hunderedSeconds.advance();
        if(this.hunderedSeconds.value() == 0){
            this.seconds.advance();;
        }
    }
    // Method that prints timer
    public String toString() {
        return this.seconds + ":" + this.hunderedSeconds;
    }
}