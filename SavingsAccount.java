//Alana Henden, HW4, CST338, 10/19/24
//SavingsAccount.java
//This class extends the abstract Account class and implements its version of the getBalance() method
//This class contains a interestRate attribute associated with Savings accounts to calculate the final monthly balance

public class SavingsAccount extends Account{

    private double interestRate;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    //calc according to interest rate and balance
    //no extra fees besides this
    public double calcMonthlyInterest() {
        return (interestRate * getBal());
    }

    public double getBalance() {
        double totalInt = calcMonthlyInterest();
        return (getBal() + totalInt);
    }
}
