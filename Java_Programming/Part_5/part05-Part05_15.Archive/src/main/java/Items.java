// Class to compare items to preven duplicate entries
public class Items {
    private String name;
    private String identifyingNumber;

    public Items(String name, String identifyingNumber){
        this.name = name;
        this.identifyingNumber = identifyingNumber;
    }

    public boolean equals(Object compared){
        if (this == compared){
            return true;
        }
        if (!(compared instanceof Items)){
            return false;
        }

        Items comparedItems = (Items) compared;

        if (this.identifyingNumber.equals(comparedItems.identifyingNumber)){
            return true;
        } else {
            return false;
        }
    }
    // Return string using toSting method
    public String toString() {
        return this.identifyingNumber + ": " + this.name;
    }
}
