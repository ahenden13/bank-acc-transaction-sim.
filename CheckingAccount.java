//Alana Henden, HW4, CST338, 10/19/24
//CheckingAccount.java
//This class extends the abstract Account class and implements its version of the getBalance() method
//This class contains a monthlyFee attribute associated with checking accounts to calculate the final monthly balance

public class CheckingAccount extends Account {

    private double monthlyFee;
    //fee is per transaction (deposit or withdrawal)
    //no interest on checking accounts

    public CheckingAccount(double balance, double monthlyFee) {
        super(balance);
        this.monthlyFee = monthlyFee;
    }

    public double calcMonthlyFee() {
        return (monthlyFee * getTransactionCount());
    }

    public double getBalance() {
        double totalFee = calcMonthlyFee();
        return (getBal() - totalFee);
    }
}
