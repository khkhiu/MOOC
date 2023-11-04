
public class Product {

    private String name;
    private double price;
    private int quantity;

    public Product(String initialName, double initialPrice, int initialQuantity){
        this.name = initialName;
        this.quantity = initialQuantity;
        this.price = initialPrice;
    }
    
    public void printProduct(){
        System.out.println(name + ", price" + price + " " + quantity + " pcs");
    }
}
