package JavaPrimer.Project;

import javax.swing.*;

/*R-1.11*/
public class CreditCard {
    // Instance variables:
    private String account; // account identifier (e.g., "5391037593875309")
    private int limit; // credit limit (measured in dollars)
    protected double balance; // current balance (measured in dollars)

    public CreditCard(String account, int limit, double initialBal) {
        this.limit = limit;
        this.account = account;
        this.balance = initialBal;
    }


    // Accessor methods:
    public String getAccount() {
        return account;
    }

    public int getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    // Update methods:
    public boolean charge(double price) { // make a charge
        if (price + balance > limit) // if charge would surpass limit
            return false; // refuse the charge
        // at this point, the charge is successful
        balance += price; // update the balance
        return true; // announce the good news
    }

    //R.1-12
    public void makePayment(double amount) {// make a payment
        //Modified to ensure for no processing amount
        if (amount >= 0) {
            balance -= amount;
        } else JOptionPane.showMessageDialog(null, "Invalid Amount");


    }

    //Update limit
    //R.1-11
    public void setLimit(int limit) {
        this.limit = limit;
    }

    // Utility method to print a card's information
    public static void printSummary(CreditCard card) {
        System.out.println("Account=" + card.account);
        System.out.println("Balance=" + card.balance); // implicit cast
        System.out.println("Limit=" + card.limit); // implicit cast
    }
}
