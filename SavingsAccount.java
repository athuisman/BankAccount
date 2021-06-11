// Savings Account child class
// has an interest rate
// a method to apply interest - profit 

public class SavingsAccount extends Account {

    // interest rate
    private double interestRate;

    // default constructor
    public SavingsAccount() {
        super();
    }

    /**
     * Parameter constructor to intialize Savings account with a customer account
     * number and interest rate
     */
    public SavingsAccount(int accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }

    // getter function
    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calcInterest() {
        return balance * interestRate;
    }

    public void applyInterest() {
        double interest = calcInterest();
        System.out.printf("Het rente bedrag van %.2f euro is toegevoegd aan uw account%n", interest);
        deposit(interest);
    }

    /**
     * Function to deposit funds into the account as long as the amount parameter is
     * > 0
     * 
     * Apply Transaction fee for the CurrentAccount
     * 
     * @param amount value to be deposited
     */
    public void deposit(double amount) {

        // First Check amount
        if (amount > 0) {
            balance += amount;
            System.out.printf("Bedrag %.2f gestort%n", amount);
            System.out.printf("Uw nieuwe saldo is: %.2f%n", balance);

        } else {
            System.out.println("Een negatief bedrag kan niet worden gestort.");
        }
    }

    /**
     * Function to withdraw funds from the Account as long as 1. Amount to withdraw
     * must be > 0 2. Amount to withdraw must be <= balance
     * 
     * @param amount value to be withdrawn
     */
    public void withdraw(double amount) {

        // Same check
        if (amount > 0) {
            // Check sufficient balance
            if ((amount) <= balance) {
                System.out.printf("Het bedrag van %.2f is opgenomen van uw account%n", amount);
                balance -= amount;
                System.out.printf("Uw nieuwe saldo is: %.2f%n", balance);
            }
        } else {
            System.out.println("Een negatief bedrag kan niet worden opgenomen.");
        }
    }
}
