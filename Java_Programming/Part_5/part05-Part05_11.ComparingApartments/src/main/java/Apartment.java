
public class Apartment {

    private int rooms;
    private int squares;
    private int princePerSquare;

    public Apartment(int rooms, int squares, int pricePerSquare) {
        this.rooms = rooms;
        this.squares = squares;
        this.princePerSquare = pricePerSquare;
    }

    public boolean largerThan(Apartment compared){
       boolean isLarger = false;
       // Comparing size of apartments
       if (this.squares > compared.squares){
        isLarger = true;
       }
       return isLarger;
    }

    public int priceDifference(Apartment compared){
        int priceFirst = 0;
        int priceToBeCompared = 0;
        int priceDifference = 0;
        // price for first apartment
        priceFirst = this.princePerSquare * this.squares;
        // price for second apartment
        priceToBeCompared = compared.princePerSquare * compared.squares;

        // Comparing price and returning value
        priceDifference = priceFirst - priceToBeCompared;
        return Math.abs(priceDifference);
    }

    public boolean moreExpensiveThan(Apartment compared) {
        // set isMoreExpensive to false by default
        boolean isMoreExpensive = false;
        // Calculating difference
        int priceFirst = 0;
        int priceToBeCompared = 0;
        // price for first apartment
        priceFirst = this.princePerSquare * this.squares;
        // price for second apartment
        priceToBeCompared = compared.princePerSquare * compared.squares;
        if (priceFirst > priceToBeCompared){
            isMoreExpensive = true;
        }
        return isMoreExpensive;
    }
}
