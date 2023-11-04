public class Counter {

    private int value;

    public Counter(int startValue) {
        this.value = startValue;
    }

    public Counter() {
        this.value = 0;
    }

    public int value() {
        return value;
    }

    public void increase() {
        value++;
    }

    public void increase(int increaseBy) {
        if (increaseBy > 0) {
            value = value + increaseBy;
        }
        return;
    }

    public void decrease() {
        value--;
    }

    public void decrease(int decreaseBy) {

        if (decreaseBy > 0) {
            value = value - decreaseBy;
        }
        return;
    }

}