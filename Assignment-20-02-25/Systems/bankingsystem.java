import java.util.*;

public class BankingSystem {
    public static void main(String[] args) {
        // Store customer accounts (AccountNumber -> Balance) in HashMap
        Map accounts = new HashMap();
        accounts.put(101, 5000);
        accounts.put(102, 7000);
        accounts.put(103, 3000);
        accounts.put(104, 9000);

        // Sort customers by balance using TreeMap
        Map sortedAccounts = new TreeMap(new BalanceComparator(accounts));
        sortedAccounts.putAll(accounts);
        System.out.println("Accounts sorted by balance: " + sortedAccounts);

        // Process withdrawal requests using Queue
        Queue withdrawals = new LinkedList();
        withdrawals.add(new WithdrawalRequest(102, 2000));
        withdrawals.add(new WithdrawalRequest(101, 1000));
        withdrawals.add(new WithdrawalRequest(103, 500));

        processWithdrawals(accounts, withdrawals);
        System.out.println("Updated Account Balances: " + accounts);
    }

    // Process withdrawals
    public static void processWithdrawals(Map accounts, Queue withdrawals) {
        while (!withdrawals.isEmpty()) {
            WithdrawalRequest request = (WithdrawalRequest) withdrawals.poll();
            if (accounts.containsKey(request.accountNumber)) {
                int currentBalance = (Integer) accounts.get(request.accountNumber);
                if (currentBalance >= request.amount) {
                    accounts.put(request.accountNumber, currentBalance - request.amount);
                    System.out.println("Withdrawal of " + request.amount + " from Account " + request.accountNumber + " successful.");
                } else {
                    System.out.println("Insufficient balance in Account " + request.accountNumber);
                }
            }
        }
    }
}

// Custom comparator to sort accounts by balance
class BalanceComparator implements Comparator {
    private Map baseMap;

    public BalanceComparator(Map baseMap) {
        this.baseMap = baseMap;
    }

    public int compare(Object a, Object b) {
        return ((Integer) baseMap.get(a)).compareTo((Integer) baseMap.get(b));
    }
}

// Withdrawal request class
class WithdrawalRequest {
    int accountNumber;
    int amount;

    public WithdrawalRequest(int accountNumber, int amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}
