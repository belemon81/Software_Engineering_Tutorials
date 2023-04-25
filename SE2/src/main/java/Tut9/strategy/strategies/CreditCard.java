package Tut9.strategy.strategies;

/**
 * Dummy credit card class.
 */
public class CreditCard {
    private int amount;
    private String number;
    private String date;
    private String cvv;

    CreditCard(String number, String date, String cvv) {
        this.amount = 100_000;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }

    //TODO: Implement the getAmount() method
    public int getAmount() {
        return amount;
    }

    //TODO: Implement the setAmount() method
    public void setAmount(int amount) {
        this.amount = amount;
    }
}