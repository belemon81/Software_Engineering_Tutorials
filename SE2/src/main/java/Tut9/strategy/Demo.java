package Tut9.strategy;

import Tut9.strategy.order.Order;
import Tut9.strategy.strategies.PayByCreditCard;
import Tut9.strategy.strategies.PayByPayPal;
import Tut9.strategy.strategies.PayStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * World first console e-commerce application.
 */
public class Demo {
    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }

    public static void main(String[] args) throws IOException {
        while (!order.isClosed()) {
            int cost = 0;
            String continueChoice;
            do {
                System.out.print("Please, select a product:" + "\n" +
                        "1 - Mother board" + "\n" +
                        "2 - CPU" + "\n" +
                        "3 - HDD" + "\n" +
                        "4 - Memory" + "\n");
                //TODO: get the input value and save to new variable 'choice' (int)
                System.out.println("Input choice: ");
                int choice = Integer.parseInt(reader.readLine());
                //TODO: set the cost based on the choice
                switch (choice) {
                    case 1:
                        cost = 1000;
                        break;
                    case 2:
                        cost = 2000;
                        break;
                    case 3:
                        cost = 3000;
                        break;
                    case 4:
                        cost = 2500;
                        break;
                }
                System.out.print("Count: ");
                int count = Integer.parseInt(reader.readLine());
                //TODO: set total cost of order = cost * count
                order.setTotalCost(cost * count);
                System.out.print("Do you wish to continue selecting products? Y/N: ");
                continueChoice = reader.readLine();
            } while (continueChoice.equalsIgnoreCase("Y"));

            if (strategy == null) {
                System.out.println("Please, select a payment method:" + "\n" +
                        "1 - PalPay" + "\n" +
                        "2 - Credit Card");
                //TODO: get the input value and save to new variable 'paymentMethod' (String)
                System.out.println("Input choice: ");
                String paymentMethod = reader.readLine();

                // Client creates different strategies based on input from user,
                // application configuration, etc.

                //TODO: if paymentMethod = 1 => pay by PayPal 
                //else pay by credit card
                if (paymentMethod.equals("1")) {
                    strategy = new PayByPayPal();
                } else {
                    strategy = new PayByCreditCard();
                }

                // Order object delegates gathering payment data to strategy
                // object, since only strategies know what data they need to
                // process a payment.
                order.processOrder(strategy);

                System.out.print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
                String proceed = reader.readLine();
                if (proceed.equalsIgnoreCase("P")) {
                    // Finally, strategy handles the payment.
                    if (strategy.pay(order.getTotalCost())) {
                        System.out.println("Payment has been successful.");
                    } else {
                        System.out.println("FAIL! Please, check your data.");
                    }
                    //TODO: close the order
                    order.setClosed();
                }
            }
        }
    }
}