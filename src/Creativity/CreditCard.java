package Creativity;

import javax.swing.*;

/*R-1.11*/
public class CreditCard {
    // Instance variables:
    private String customer; // name of the customer (e.g., "John Bowman")
    private String bank; // name of the bank (e.g., "California Savings")
    private String account; // account identifier (e.g., "5391037593875309")
    private int limit; // credit limit (measured in dollars)
    protected double balance; // current balance (measured in dollars)

    // Constructors:
    public CreditCard(String cust, String bk, String acnt, int lim, double initialBal) {
        customer = cust;
        bank = bk;
        account = acnt;
        limit = lim;
        balance = initialBal;
    }

    public CreditCard(String cust, String bk, String acnt, int lim) {
        this(cust, bk, acnt, lim, 0.0); // use a balance of zero as default
    }

    // Accessor methods:
    public String getCustomer() {
        return customer;
    }

    public String getBank() {
        return bank;
    }

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
            if(amount >= 0){
                balance -= amount;
            }else JOptionPane.showMessageDialog(null, "Invalid Amount");


    }

    //Update limit
    //R.1-11
    public void setLimit(int limit) {
        this.limit = limit;
    }

    // Utility method to print a card's information
    public void printSummary() {
        System.out.println("Customer=" + customer);
        System.out.println("Bank=" + bank);
        System.out.println("Account=" + account);
        System.out.println("Balance=" + balance); // implicit cast
        System.out.println("Limit=" + limit); // implicit cast
    }

    public static void main(String[] args) {
        // Create an array of CreditCard objects to simulate a wallet
        CreditCard[] wallet = new CreditCard[3];

        // Initialize each card in the wallet with customer information
        wallet[0] = new CreditCard("John Bowman", "CaliforniaSavings", "5391037593875309", 5000);
        wallet[1] = new CreditCard("John Bowman", "CaliforniaFederal", "3485039933951954", 3500);
        wallet[2] = new CreditCard("John Bowman", "CaliforniaFinance", "5391037593875309", 2500, 300);  // Initial balance of 300

        // Simulate charges over 16 months (assuming val represents month)
        for (int val = 1; val <= 16; val++) {
            wallet[0].charge(3 * val);  // Charge 3 times the month value on card 1
            wallet[1].charge(2 * val);  // Charge 2 times the month value on card 2
            wallet[2].charge(val);       // Charge the month value on card 3
        }

        // Print summary of each card in the wallet
        for (CreditCard card : wallet) {
            card.printSummary();

            // Make payments until balance is below $200
            while (card.getBalance() > 200.0) {
                card.makePayment(200);
                System.out.println("New balance = " + card.getBalance());
            }
        }
    }

}
