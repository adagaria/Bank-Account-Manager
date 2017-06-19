import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashSet;

/**
   This program demonstrates a solution to the
   BankAccount and SavingsAccount Classes
   programming challenge.
*/

public class Manager
{

   public static void main(String[] args) throws IOException
   {
	  DecimalFormat dollar = new DecimalFormat("#,##0.00");
           
      
      // Create a SavingsAccount object with a $100.
      SavingsAccount savings = 
                   new SavingsAccount(101, "Allen", 1000.0, 0.02, 1.50);
    SavingsAccount saving2 = 
              new SavingsAccount(102, "Frank", 700.0, 0.02, 1.50);
    /*  SavingsAccount savings3 = 
              new SavingsAccount(103, "Jamie", 800.0, 0.02, 1.50);
      SavingsAccount savings4 = 
              new SavingsAccount(104, "Akshat", 900.0, 0.02, 1.50);*/
      
      // Display what we've got.
      System.out.println("Balance: $" + 
                         dollar.format(savings.getBalance(101)));
      System.out.println("Number of deposits: " + 
                         savings.getNumDeposits());
      System.out.println("Number of withdrawals: " + 
                         savings.getNumWithdrawals());
      System.out.println();
      
      // Make some deposits.
      savings.deposit(101, 25.00);
      savings.deposit(101, 10.00);
      savings.deposit(101, 35.00);
      
      // Display what we've done so far.
      System.out.println("Balance: $" + 
                         dollar.format(savings.getBalance(101)));
      System.out.println("Number of deposits: " + 
                         savings.getNumDeposits());
      System.out.println("Number of withdrawals: " + 
                         savings.getNumWithdrawals());
      System.out.println();
      
      // Make some withdrawals.
      savings.withdrawMoney(101, 100.00);
      savings.withdrawMoney(101, 50.00);
      savings.withdrawMoney(101, 10.00);
      savings.withdrawMoney(101, 1.00);
      savings.withdrawMoney(101, 1.00);
      
      // Display what we've done so far.
      System.out.println("Balance: $" + 
                         dollar.format(savings.getBalance(101)));
      System.out.println("Number of deposits: " + 
                         savings.getNumDeposits());
      System.out.println("Number of withdrawals: " + 
                         savings.getNumWithdrawals());
      System.out.println();

      // Do the monthly processing.
      savings.monthlyProcess(101);
   
      // Display what we've done so far.
      System.out.println("Balance 101: $" + 
                         dollar.format(savings.getBalance(101)));
      System.out.println("Number of deposits: " + 
                         savings.getNumDeposits());
      System.out.println("Number of withdrawals 101: " + 
                         savings.getNumWithdrawals());
      
     System.out.println(BankAccount.BankAccount());
   }
   
}

