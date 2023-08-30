public class BankAccount {
    private double balance;  // Store the account balance

    // Constructor to initialize the balance
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Get the current account balance
    public double getBalance() {
        return balance;
    }

    // Deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;  // Increase balance by deposited amount
        }
    }

    // Withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;  // Decrease balance by withdrawn amount
            return true;  // Successful withdrawal
        }
        return false;  // Withdrawal unsuccessful (insufficient funds or invalid amount)
    }
}
