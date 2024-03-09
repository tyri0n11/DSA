package Reinforcement;

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
    public static void printSummary(CreditCard card) {
        System.out.println("Customer=" + card.customer);
        System.out.println("Bank=" + card.bank);
        System.out.println("Account=" + card.account);
        System.out.println("Balance=" + card.balance); // implicit cast
        System.out.println("Limit=" + card.limit); // implicit cast
    }


    public static void main(String[] args) {
        CreditCard[] wallet = new CreditCard[3];
        wallet[0] = new CreditCard("John Bowman", "California Savings", "5391037593875309", 5000);
        wallet[1] = new CreditCard("John Bowman", "California Federal", "3485039933951954", 3500);
        wallet[2] = new CreditCard("John Bowman", "California Finance", "5391037593875309", 2500, 300);

        //R.1-13 wallet[2] is the one
        for (int val = 1; val <= 20; val++) {
            wallet[0].charge(3 * val);
            wallet[1].charge(2 * val);
            wallet[2].charge(val);
        }


        for (CreditCard card : wallet) {
            CreditCard.printSummary(card); // calling static method
            while (card.getBalance() > 200.0) {
                card.makePayment(200);
                System.out.println("New balance=" + card.getBalance());
            }
        }
    }
}
