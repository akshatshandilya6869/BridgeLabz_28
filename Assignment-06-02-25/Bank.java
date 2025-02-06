import java.util.*;

// Bank class
class Bank {
    private String name;
    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public Account openAccount(Customer customer, double initialDeposit) {
        Account newAccount = new Account(this, customer, initialDeposit);
        accounts.add(newAccount);
        customer.addAccount(newAccount);
        return newAccount;
    }

    public String getName() {
        return name;
    }
}

// Customer class
class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Account Balances for " + name + ":");
        for (Account account : accounts) {
            System.out.println("Bank: " + account.getBank().getName() + ", Balance: " + account.getBalance());
        }
    }
}

// Account class
class Account {
    private Bank bank;
    private Customer customer;
    private double balance;

    public Account(Bank bank, Customer customer, double balance) {
        this.bank = bank;
        this.customer = customer;
        this.balance = balance;
    }

    public Bank getBank() {
        return bank;
    }

    public double getBalance() {
        return balance;
    }
}

// Main class to test the implementation
public class BankSystem {
    public static void main(String[] args) {
        Bank bank1 = new Bank("ABC Bank");
        Customer customer1 = new Customer("John Doe");
        
        bank1.openAccount(customer1, 500.0);
        bank1.openAccount(customer1, 1000.0);
        
        customer1.viewBalance();
    }
}
