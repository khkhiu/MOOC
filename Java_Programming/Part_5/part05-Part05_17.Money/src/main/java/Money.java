
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros = euros + cents / 100;
            cents = cents % 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return this.euros;
    }

    public int cents() {
        return this.cents;
    }

    public String toString() {
        String zero = "";
        if (this.cents < 10) {
            zero = "0";
        }

        return this.euros + "." + zero + this.cents + "e";
    }

    public Money plus(Money addition) {
        // calculate new money value
        int newEurosAmt = euros + addition.euros();
        int newCentsAmt = cents + addition.cents();
        // Convert cents into euro amount
        if (newCentsAmt > 99) {
            newCentsAmt = newCentsAmt - 100;
            newEurosAmt = newEurosAmt + 1;
        }
        return new Money(newEurosAmt, newCentsAmt);
    }

    public boolean lessThan(Money compared) {
        boolean isLessThan = false;
        // Comparing euro amounts
        if ((100 * euros + cents) < (100 * compared.euros() + compared.cents())) {
            isLessThan = true;
        }
        return isLessThan;
    }

    public Money minus(Money decreaser) {
        // calculate new money value
        int newEurosAmt = euros - decreaser.euros();
        int newCentsAmt = cents - decreaser.cents();
        // Convert cents into euro amount
        if (newCentsAmt < 0) {
            newCentsAmt = newCentsAmt + 100;
            newEurosAmt = newEurosAmt - 1;
        }
        // Set euro and cents to zero if value becomes negative
        if (newEurosAmt < 0) {
            newEurosAmt = 0;
            newCentsAmt = 0;
        }
        Money newMoney = new Money(newEurosAmt, newCentsAmt);
        return newMoney;
    }
}
