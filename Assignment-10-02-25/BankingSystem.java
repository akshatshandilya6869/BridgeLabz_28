/ Abstract class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New Balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
        System.out.println("Interest: " + calculateInterest());
    }
}

// Interface for loan functionality
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * (interestRate / 100);
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan application submitted for " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 5000; // Example condition: Minimum balance required for loan eligibility
    }
}

// CurrentAccount subclass
class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        return 0; // No interest for Current Account
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan application submitted for " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000; // Different condition for current account loan eligibility
    }
}

// Main class to demonstrate polymorphism
public class BankingSystem {
    public static void main(String[] args) {
        BankAccount[] accounts = {
            new SavingsAccount("SA123", "Alice", 10000, 5),
            new CurrentAccount("CA456", "Bob", 20000, 5000)
        };

        for (BankAccount account : accounts) {
            account.displayDetails();
            System.out.println("Loan Eligibility: " + ((Loanable) account).calculateLoanEligibility());
            ((Loanable) account).applyForLoan(5000);
            System.out.println("----------------------------");
        }
    }
}

