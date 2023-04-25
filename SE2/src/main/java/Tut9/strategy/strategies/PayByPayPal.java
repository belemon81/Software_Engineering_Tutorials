package Tut9.strategy.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Concrete strategy. Implements PayPal payment method.
 */
public class PayByPayPal implements PayStrategy {
    private static final Map<String, String> DATA_BASE = new HashMap<>();

    static {
        //TODO: 'put' some test data (password & email) to DATA_BASE
        DATA_BASE.put("halo", "halo@gmail.com");
        DATA_BASE.put("sarah", "sarah@gmail.com");
    }

    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signedIn;

    //TODO: Implement the collectPaymentDetails() method

    /**
     * Collect customer's data.
     */
    @Override
    public void collectPaymentDetails() {
        //TODO: Add 'try-catch' block to catch the IO error
        while (!signedIn) {
            try {
                //TODO: Ask for email & password then save them to suitable variables
                System.out.println("Enter email: ");
                email = READER.readLine();
                System.out.println("Enter password: ");
                password = READER.readLine();
                //TODO: Verify the input values then display suitable message
                if (verify()) {
                    signedIn = true;
                    System.out.println("Signed in successfully!");
                } else {
                    System.out.println("Failed to sign in!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private boolean verify() {
        setSignedIn(email.equals(DATA_BASE.get(password)));
        return signedIn;
    }

    //TODO: Implement the pay() method

    /**
     * Save customer data for future shopping attempts.
     */
    @Override
    public boolean pay(int paymentAmount) {
    	/*if customer already 'signedIn' => display a message 
    	to show that customer is paying with PayPal with money amount
    	then return true else return false */
        if (signedIn) {
            System.out.println("Customer is paying with PayPal with money amount: " + paymentAmount);
            return true;
        }
        return false;
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}