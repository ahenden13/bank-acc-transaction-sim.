//Alana Henden, HW4, CST338, 10/19/24
//AccountApp.java
//This is my demo class, where I will read in user input for initial balances, fees, and interest rates.
//After reading in initial info, I will read in more user input to gather info on what type of transactions
//are taking place with which account. At the end, I will display all the monthly fees, interest, and balances for both accounts

import java.util.Scanner;

public class AccountApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter initial Checking amount: ");
        double initCheckingBal = in.nextDouble();
        System.out.print("Enter initial Savings amount: ");
        double initSavingsBal = in.nextDouble();
        System.out.print("Enter Checking fee: ");
        double checkFee = in.nextDouble();
        System.out.print("Enter Savings interest rate: ");
        double savingsInt = in.nextDouble();
        double percent = savingsInt*100;
        CheckingAccount ca = new CheckingAccount(initCheckingBal, checkFee);
        SavingsAccount sa = new SavingsAccount(initSavingsBal, savingsInt);

        System.out.println("\n\nOK! This is your information");
        System.out.printf("Checking Amount: $%.2f\n", initCheckingBal);
        System.out.printf("Savings Amount: $%.2f\n", initSavingsBal);
        System.out.printf("Checking Fee: $%.2f\n", checkFee);
        System.out.printf("Interest Rate: %.1f%%\n", percent);
        System.out.println();

        System.out.println("Enter transactions for the month.\n");
        boolean again = true;
        String transType;
        String accType;
        String checkCont;
        Double amt;
        int transCount = 0;
        while (again) {
            System.out.print("Withdrawal or deposit? (w/d): ");
            transType = in.next();
            System.out.print("Checking or Savings? (c/s): ");
            accType = in.next();
            System.out.print("Amount? $ ");
            amt = in.nextDouble();
            if (accType.equals("c")) {
                if (transType.equals("w")) {
                    if (ca.withdraw(amt)) {
                        transCount++;
                    }
                } else if (transType.equals("d")) {
                    if (ca.deposit(amt)) {
                        transCount++;
                    }
                }
            } else if (accType.equals("s")) {
                if (transType.equals("w")) {
                    sa.withdraw(amt);
                } else if (transType.equals("d")) {
                    sa.deposit(amt);
                }
            }

            System.out.print("\nContinue? (y/n): ");
            checkCont = in.next();
            if (checkCont.equals("n")) {
                again = false;
            }
            System.out.println();
        }
        ca.setTransactionCount(transCount);

        System.out.println("\n\nMonthly Payments and Fees");
        System.out.printf("Checking Fee: $%.2f", ca.calcMonthlyFee());
        System.out.printf("\nSavings interest payment: $%.2f", sa.calcMonthlyInterest());

        System.out.println("\n\nFinal Balances");
        System.out.printf("Checking: $%.2f\n", ca.getBalance());
        System.out.printf("Savings: $%.2f\n", sa.getBalance());

    }
}
