public class Cube {
    private int length;

    public Cube(int length){
        this.length = length;
    }

    // Calculating volume
    public int volume(){
        int result = 0;
        result = length * length * length;
        return result;
    }

    // Print info using Override method
    @Override
    public String toString() {
        return "The length of the edge is "+ length +" and volume "+ volume();
    }
}
