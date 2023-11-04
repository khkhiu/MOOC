
public class PaymentTerminal {


    private double money;  // amount of cash
    private int affordableMeals; // number of sold affordable meals
    private int heartyMeals;  // number of sold hearty meals


    public PaymentTerminal() {
        // register initially has 1000 euros of money
        this.money = 1000;
    }

    // Methods for calculating cash
    public double eatAffordably(double payment) {
        // an affordable meal costs 2.50 euros
        // increase the amount of cash by the price of an affordable mean and return the change
        // if the payment parameter is not large enough, no meal is sold and the method should return the whole payment
        double change = payment;

        // If custermore has more than 2.50 euros
        if (payment >= 2.50) {
            // increment number of affordable meals sold
            affordableMeals = affordableMeals + 1;
            // increase amount of money in cash register
            this.money = this.money + 2.50;
            // calculate euros customer has left
            change = change - 2.50;
        }
        return change;
    }
    public double eatHeartily(double payment) {
        // a hearty meal costs 4.30 euros
        // increase the amount of cash by the price of a hearty mean and return the change
        // if the payment parameter is not large enough, no meal is sold and the method should return the whole payment
        double change = payment;

        // If custermore has more than 2.50 euros
        if (payment >= 4.30) {
            // increment number of hearty meals sold
            heartyMeals = heartyMeals + 1;
            // increase amount of money in cash register
            this.money = this.money + 4.30;
            // calculate euros customer has left
            change = change - 4.30;
        }
        return change;
    }

    // Calculate using 'PaymentCard' class
    public boolean eatAffordably(PaymentCard card) {
        // an affordable meal costs 2.50 euros
        // if the payment card has enough money, the balance of the card is decreased by the price, and the method returns true
        // otherwise false is returned
        if(card.balance() >= 2.50) {
            affordableMeals = affordableMeals + 1;
            return card.takeMoney(2.50);
        }
        else {
            return false;
        }
    }

    // Calculate using 'PaymentCard' class
    public boolean eatHeartily(PaymentCard card) {
        // a hearty meal costs 4.30 euros
        // if the payment card has enough money, the balance of the card is decreased by the price, and the method returns true
        // otherwise false is returned
        if(card.balance() >= 4.30) {
            heartyMeals = heartyMeals + 1;
            return card.takeMoney(4.30);
        }
        else {
            return false;
        }        
    }

    // Adding FX to add money to cards
    public void addMoneyToCard(PaymentCard card, double sum) {
        if (sum >= 0){
            card.addMoney(sum);
            this.money = this.money + sum;
        }
    }

    @Override
    public String toString() {
        return "money: " + money + ", number of sold affordable meals: " + affordableMeals + ", number of sold hearty meals: " + heartyMeals;
    }
}
