import java.util.Scanner;

public class AccountDriver {
    
    // Entry point of program
    public static void main(String [] args) {

        Scanner keyboard = new Scanner(System.in);
        
        // Create array of Accounts
        Account accounts [] = new Account[10];
        int numAccounts = 0; 

        int choice;

        do {
            choice = menu(keyboard);
            System.out.println();
            
            if(choice == 1) {
                accounts[numAccounts++] = createAccount(keyboard);
            } else if(choice == 2) {
                doDeposit(accounts, numAccounts, keyboard);
            } else if(choice == 3) {
                doWithdraw(accounts, numAccounts, keyboard);
            } else if(choice == 4) {
                applyInterest(accounts, numAccounts, keyboard);
            } else {
                System.out.println("Houdoe!");
            }
            System.out.println();
        } while(choice != 5);
    }

    /**
     * Account choice
     * 
     * @param keyboard 
     * @return choice
     */
    public static int accountMenu(Scanner keyboard) {
        System.out.println("Selecteer Account Type");
        System.out.println("1. Standaard Account");
        System.out.println("2. Spaar Account");

        int choice;
        do {
            System.out.print("Vul uw keuze in: ");
            choice = keyboard.nextInt();
        }while(choice < 1 || choice > 2);
        
        return choice;
    } 

    public static int searchAccount(Account accounts [], int count, int accountNumber) {

        for(int i=0; i<count; i++) {
            if(accounts[i].getAccountNumber() == accountNumber) {
                return i;
            }
        }

        return -1; 
    }

    /**
     * Function to perform Deposit on a selected account
     */
    public static void doDeposit(Account accounts [], int count, Scanner keyboard) {
        // Get the account number
        System.out.print("\nVul uw account nummer in: ");
        int accountNumber = keyboard.nextInt();

        // search for account
        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0) {
            // Amount
            System.out.print("Vul uw stort bedrag in: ");
            double amount = keyboard.nextDouble();

            accounts[index].deposit(amount);
        } else {
            System.out.println("Er bestaat geen account met dit account nummer: " + accountNumber);
        }
    }

    public static void doWithdraw(Account accounts [], int count, Scanner keyboard) {
        // Get the account number
        System.out.print("\nVul uw account nummer in: ");
        int accountNumber = keyboard.nextInt();

        // search for account
        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0) {
            // Amount
            System.out.print("Vul het bedrag in wat u wilt opnemen: ");
            double amount = keyboard.nextDouble();
            accounts[index].withdraw(amount);
        } else {
            System.out.println("Er bestaat geen account met dit account nummer: " + accountNumber);
        }
    }

    public static void applyInterest(Account accounts [], int count, Scanner keyboard) {
        // Get the account number
        System.out.print("\nVul uw account nummer in: ");
        int accountNumber = keyboard.nextInt();

        // search for account
        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0) {
            
            // must be instance of savings account
            if(accounts[index] instanceof SavingsAccount) {
                ((SavingsAccount)accounts[index]).applyInterest();
            }
        } else {
            System.out.println("Er bestaat geen account met dit account nummer: " + accountNumber);
        }
    }

    /**
     * Function to create a new Account
     */
    public static Account createAccount(Scanner keyboard) {

        Account account = null; 
        int choice = accountMenu(keyboard);

        int accountNumber;
        System.out.print("Vul uw account nummer in: ");
        accountNumber = keyboard.nextInt();

        if(choice == 1)  { // current account
            account = new CurrentAccount(accountNumber);
        } else { // Savings account
            
            System.out.print("Vul uw rente percentage in: ");
            double ir = keyboard.nextDouble();
            account = new SavingsAccount(accountNumber, ir);
        }
        return account;
    }

    /**
     * Menu to display options and get the user's selection
     * 
     * @param keyboard
     * @return choice
     */
    public static int menu(Scanner keyboard) {
        System.out.println("Bank account menu");
        System.out.println("1. Maak nieuw account");
        System.out.println("2. Geld storten");
        System.out.println("3. Geld opnemen");
        System.out.println("4. Rente percentage invullen");
        System.out.println("5. Stop programma");

        int choice;

        do {
            System.out.print("Vul uw keuze in: ");
            choice = keyboard.nextInt();
        } while(choice < 1 || choice > 5);

        return choice;
    }    
}
