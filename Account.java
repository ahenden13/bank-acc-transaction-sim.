//Alana Henden, HW4, CST338, 10/19/24
//Account.java
//This Account class implements 3 interfaces and its corresponding methods: depositable, withdrawable, and balanceable.
//This class is abstract and has an abstract getBalance method, which is
//implemented by its 2 child classes (CheckingAccount and SavingsAccount)

public abstract class Account implements Depositable, Withdrawable, Balanceable {

    private double balance;
    private int transactionCount;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBal() {
        return balance;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(int numTrans) {
        transactionCount = numTrans;
    }

    public abstract double getBalance();

    public void setBalance(double amount) {
        balance = amount;
    }

    //cant deposit negative money or anything greater than $999,999.99
    public boolean deposit(double amount) {
        boolean complete;
        if (amount < 0 || amount > 999999.99) {
            complete = false;
            System.out.println("Error: can not deposit this amount.");
        } else {
            complete = true;
            balance += amount;
        }
        return complete;
    }

    //can not withdraw negative numbers or more than the balance
    public boolean withdraw(double amount) {
        boolean complete;
        if (amount < 0 || amount > balance) {
            complete = false;
            System.out.println("Error: can not withdraw this amount.");
        } else {
            complete = true;
            balance -= amount;
        }
        return complete;
    }


}
