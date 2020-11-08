import java.util.HashMap;

public class BankAccount {

    private static long count = 0;
    private static HashMap<Long, BankAccount> hashMap = new HashMap<Long, BankAccount>();
    private AccountOwner accountOwner;
    private double balance;
    private long accountNumber;

    public BankAccount(AccountOwner accountOwner, double balance) {

        this.balance = balance;
        this.accountOwner = accountOwner;
        this.accountNumber = generateAccountNumber();
        hashMap.put(accountNumber, this);

    }


    public int deposit(double amount) {
        if (amount <= 0) {
            return 2;
        }
        else {
            balance += amount;
            return 1;
        }
    }

    public AccountOwner getAccountOwner() {
        return accountOwner;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getFormattedBalance() {

        return "$" + String.format("%,.2f", balance);
    }

    public int withdraw(double amount) {
        if (amount <= 0) {
            return 2;
        }
        else if (amount > balance) {
            return 3;
        }
        else {
            balance -= amount;
            return 1;
        }
    }

    public int transfer(long account, double amount) {
        BankAccount destination = hashMap.get(account);
        if (amount <= 0) {
            return 2;
        }
        else if (amount > balance) {
            return 3;
        }
        else if (destination == null) {
            return 4;
        }
        else {
            balance -= amount;
            destination.deposit(amount);
            return 1;
        }

    }

    public String getMaskedAccountNumber() {

        String hiddenNumber = Long.toString(accountNumber);
        hiddenNumber = hiddenNumber.substring(Math.max(0,hiddenNumber.length()-4), hiddenNumber.length());
        return "****" + String.format("%04d", Integer.parseInt(hiddenNumber));


    }

    private long generateAccountNumber() {
        return count++;
    }
}