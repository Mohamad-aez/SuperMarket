package superMarktPackage.counterPackage;

import superMarktPackage.groceriesPackage.Groceries;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class counterController {
    // creating the current date
    static Date now = new Date();

    // defining variables for total price for each item and another variable for the sum of them
    static double diapersTotalPrice, robijnTotalPrice, brintaTotalPrice, chineseTotalPrice, yoghurtTotalPrice, totalAmount;

    /* creating a method taking an array list of groceries , payed amount from customer , Counter name
       doing all calculation for the products , total amount , balance "difference between payed amount and total amount " */
    public static void shoppingList(ArrayList<Groceries> shopList, double receivedAmount, Counter counter) {

        System.out.println(now);                                            // showing the date
        System.out.println("Counter Name : " + counter.counterName + "\n");   // showing counter name
        System.out.println("List of Groceries : \n");

        // loping through the shopping cart list and checking for each product on it
        shopList.forEach(item -> {
            if (item.getName() == "Robijn") {
                item.setPrice(3.0);
                // checking Qty to make discount
                if (item.getQuantity() >= 2) {
                    item.setDiscount(item.getPrice() * 0.31);
                    item.setPriceAfterDiscount(item.getPrice() - item.getDiscount());
                    robijnTotalPrice = (item.getPriceAfterDiscount() * item.getQuantity());
                    System.out.println("# " + item.getName() + "  , Quantities : " + item.getQuantity() + "  , Price : " + item.getPrice() + "  , Discount per piece" + item.getDiscount() + "  , Total Price : " + robijnTotalPrice);
                } else if (item.getQuantity() > 0 && item.getQuantity() < 2) {
                    robijnTotalPrice = (item.getPrice() * item.getQuantity());
                    System.out.println("# " + item.getName() + "  , Quantities : " + item.getQuantity() + "  , Price : " + item.getPrice() + "  , Total Price : " + robijnTotalPrice);
                }
            } else if (item.getName() == "Brinta") {
                // checking qty to make the calculation
                if (item.getQuantity() >= 1) {
                    item.setPrice(2.5);
                    brintaTotalPrice = (item.getPrice() * item.getQuantity());
                    System.out.println("# " + item.getName() + "  , Quantities : " + item.getQuantity() + "  , Price : " + item.getPrice() + "  , Total Price : " + brintaTotalPrice);
                }
            } else if (item.getName() == "Chinese vegetables") {
                // checking qty to make the calculation
                if (item.getQuantity() >= 1) {
                    item.setPrice(5.0);
                    chineseTotalPrice = (item.getPrice() * item.getQuantity());
                    System.out.println("# " + item.getName() + "  , Quantities : " + item.getQuantity() + "  , Price : " + item.getPrice() + "  , Total Price : " + chineseTotalPrice);
                }
            } else if (item.getName() == "Yoghurt") {
                // checking qty to make the calculation
                if (item.getQuantity() >= 1) {
                    item.setPrice(2.0);

                    // checking the date if it's Wednesday to make discount for this product
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(now);
                    boolean isWednesday = cal.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY;
                    if (isWednesday == true) {
                        item.setDiscount(item.getPrice() * 0.50);
                        item.setPriceAfterDiscount(item.getPrice() - item.getDiscount());
                        yoghurtTotalPrice = (item.getPriceAfterDiscount() * item.getQuantity());
                        System.out.println("# " + item.getName() + "  , Quantities : " + item.getQuantity() + "  , Price : " + item.getPrice() + "  , Discount per piece" + item.getDiscount() + "  , Total Price : " + yoghurtTotalPrice);

                    } else {
                        yoghurtTotalPrice = (item.getPrice() * item.getQuantity());
                        System.out.println("# " + item.getName() + "  , Quantities : " + item.getQuantity() + "  , Price : " + item.getPrice() + "  , Total Price : " + yoghurtTotalPrice);
                    }
                }

            } else if (item.getName() == "Diapers") {
                item.setPrice(10.0 / 3.0);
                // checking qty to make the calculation
                if (item.getQuantity() > 0 && item.getQuantity() < 4) {
                    diapersTotalPrice = item.getPrice() * item.getQuantity();
                    System.out.println("# " + item.getName() + "  , Quantities : " + item.getQuantity() + "  , Price : " + item.getPrice() + "  , Total Price : " + diapersTotalPrice);
                } else if (item.getQuantity() >= 4) {                   // check qty if equal 4 or more to apply discount
                    item.setDiscount(item.getPrice() * 0);
                    item.setPriceAfterDiscount(item.getPrice() - item.getDiscount());
                    diapersTotalPrice = ((item.getQuantity() / 4) * 10) + ((item.getQuantity() % 4) * item.getPrice());
                    System.out.println("# " + item.getName() + "  , Quantities : " + item.getQuantity() + "  , Price : " + item.getPrice() + "  , Discount : " + "buy 4 ** pay 3" + "  , Total Price : " + diapersTotalPrice);
                }
            }

        });
        // calculating the total amount
        totalAmount = (diapersTotalPrice + robijnTotalPrice + brintaTotalPrice + chineseTotalPrice + yoghurtTotalPrice);
        System.out.println("\nTotal Amount : " + totalAmount + " $.\n");

        // checking the payed amount "receiving amount"
        if (receivedAmount >= totalAmount) {
            System.out.println("Received Amount : " + receivedAmount + "$" + "  , Your Balance : " + (receivedAmount - totalAmount) + "$");
        } else {
            System.out.println("Received Amount : " + receivedAmount + "$" + "  , Please add : " + (totalAmount - receivedAmount));

        }

        System.out.println("\n\n   ****** Welcome to Supermarket ******\n");
    }
}

