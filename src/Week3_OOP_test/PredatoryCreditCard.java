package Week3_OOP_test;

public class PredatoryCreditCard extends CreditCard{

    private double apr; // annual percentage rate
    private double minPaymentRate = 0.01;
    private double balance = getBalance();


    // Constructor for this class
    public PredatoryCreditCard(String cust, String bk, String acnt, int lim,double initialBal, double rate) {
        super(cust, bk, acnt, lim, initialBal); // initialize superclass attributes
        apr = rate;
    }

    // A new method for assessing monthly interest charges
    public void processMonth(int calls) {
        double currentBalance = getBalance(); // Get the current balance using the getter

        if (currentBalance > 0) {
            // Only charge interest on a positive balance
            double monthlyFactor = Math.pow(1 + apr, 1.0 / 12); // Compute monthly rate
            double newBalance = currentBalance * monthlyFactor; // Calculate new balance with interest
            setBalance(newBalance); // Update the balance using the setter
        } else if (calls > 0) {
            charge(calls * 1.00); // Charge for calls
        }

        // Calculate minimum payment
        double minPayment = currentBalance * minPaymentRate;

        // Check for late payment and assess late fee
        if (currentBalance < minPayment && isLate()) {
            double lateFeeAmount = lateFee();
            setBalance(currentBalance + lateFeeAmount); // Assess late fee and update balance
        }

    }
    private boolean isLate(){
        return true;
    }
    private double lateFee() {
        // You can define the late fee logic here (e.g., a fixed amount or a percentage of balance)
        // For example, a 5% late fee:
        return balance * 0.05;
    }

// Overriding the charge method defined in the superclass
    public boolean charge(double price) {
        boolean isSuccess = super.charge(price); // call inherited method
        if (!isSuccess)
            balance += 5; // assess a $5 penalty
        return isSuccess;
    }
    public static void main(String[] args){
        PredatoryCreditCard p = new PredatoryCreditCard("thinh","chau","haha",900,1000,0.5);
        printSummary(p);
        p.processMonth(10);
        System.out.println();
        printSummary(p);
    }
}

