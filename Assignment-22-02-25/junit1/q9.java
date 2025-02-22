import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class BankAccountTest extends BasePlatformTestCase {
    private BankAccount bankAccount;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        bankAccount = new BankAccount(100.0);
    }

    @Test
    public void testDeposit() {
        bankAccount.deposit(50.0);
        assertEquals(150.0, bankAccount.getBalance());
    }

    @Test
    public void testWithdraw() {
        bankAccount.withdraw(30.0);
        assertEquals(70.0, bankAccount.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(200.0));
    }
}
