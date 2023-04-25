package Tut9.strategy.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Concrete strategy. Implements credit card payment method.
 */
public class PayByCreditCard implements PayStrategy {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;

    /**
     * Collect credit card data.
     */
    @Override
    public void collectPaymentDetails() {
        //TODO: Add 'try-catch' block to catch the IO error
        try {
            //TODO: Ask for card number, expiration date, CVV code then save them to suitable variables
            System.out.println("Enter card number: ");
            String cardNumber = READER.readLine();
            System.out.println("Enter expiration date (dd-mm-yyyy): ");
            String expDate = READER.readLine();
            System.out.println("Enter CVV code");
            String cvvCode = READER.readLine();
            //TODO: Create new CreditCard instance with given information
            card = new CreditCard(cardNumber, expDate, cvvCode);
            //TODO: Validate credit card number...
            if (cardNumber == null || (cardNumber.length() != 12 && cardNumber.length() != 16)) {
                System.out.println("Credit Card number is invalid!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO: Implement the pay() method

    /**
     * After card validation we can charge customer's credit card.
     */
    @Override
    public boolean pay(int paymentAmount) {
    	/*if 'cardIsPresent' => display a message 
    	to show that customer is paying with Credit Card with money amount
    	then reduce the card amount with that number
    	finally return true else return false */
        if (cardIsPresent()) {
            System.out.println("Customer is paying with Credit Card with money amount: " + paymentAmount);
            card.setAmount(card.getAmount() - paymentAmount);
            return true;
        }
        return false;
    }

    private boolean cardIsPresent() {
        return card != null;
    }
}
