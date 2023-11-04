
public class SimpleDate {

    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean before(SimpleDate compared) {
        if (this.year < compared.year) {
            return true;
        }

        if (this.year == compared.year && this.month < compared.month) {
            return true;
        }

        if (this.year == compared.year && this.month == compared.month &&
                 this.day < compared.day) {
            return true;
        }

        return false;
    }

    public void advance(){
        // if day = 30, set day to 1
        if (this.day == 30){
            this.day = 1;
            // if month = 12, set month to 1 and increment year by 1
            // otherwise increment month by 1
            if (this.month == 12){
                this.month = 1;
                this.year = this.year + 1;
            } else {
                this.month = this.month + 1;
            }
        // otherwise increment day by 1
        } else {
            this.day = this.day + 1;
        }
    }

    public void advance(int howManyDays){
        for (int i = 0; i < howManyDays; i++){
            advance();
        }
    }
    public SimpleDate afterNumberOfDays(int days){
        SimpleDate newDate = new SimpleDate(this.day, this.month, this.year);
        for (int i = 0; i < days; i++) {
            newDate.advance();
        }
        return newDate;
    }
}
