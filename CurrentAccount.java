// Current Account
public class CurrentAccount extends Account {


    // default constructor
    public CurrentAccount() {
        super();
    }

    /**
     * Parameter constructor to intialize CurrentAccount
     * with a custom Account Number and a Customer Transaction
     * Fee. 
     */
    public CurrentAccount(int accountNumber) {
        super(accountNumber);
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
        if( amount > 0) {
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
        if(amount > 0) {
            // Check sufficient balance
            if(amount <= balance) {

                System.out.printf("Het brdrag van %.2f is opgenomen van uw account%n", amount);
                balance -= amount;
                System.out.printf("Uw nieuwe saldo is: %.2f%n", balance);
            }
        } else {
            System.out.println("Een negatief bedrag kan niet worden opgenomen.");
        }
    }
}
