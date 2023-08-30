import java.util.*;

public class ATM {

    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        String check;
        do {
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int ch = in.nextInt();
            System.out.println();
            
            switch (ch) {
                case 1:
                    System.out.println("Your current balance in your account is " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount for deposit: ");
                    double depositAmount = in.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Your current balance in your account after deposit " + account.getBalance());
                    break;
                case 3:
                    System.out.print("Enter amount for withdraw: ");
                    double withdrawAmount = in.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdraw of " + withdrawAmount + " is successfully done. Your current balance is " + account.getBalance());
                    } else {
                        System.out.println("Insufficient balance or invalid amount.");
                    }
                    break;
                case 4:
                    System.out.println("You are exiting from this machine.");
                    System.out.println("Thank you for using the ATM.");
                    System.out.println("Have a nice day.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }

            System.out.println();
            System.out.print("Do you want to continue or want to exit? (y/n): ");
            check = in.next();
        } while (check.equalsIgnoreCase("y"));

        in.close(); // Close the scanner when no longer needed
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Automated Teller Machine (ATM).");
        double initial = 10000;
        BankAccount bankaccount = new BankAccount(initial);
        ATM atm = new ATM(bankaccount);
        atm.run();
    }
}
