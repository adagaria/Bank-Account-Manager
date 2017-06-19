import java.io.IOException;
import java.util.HashSet;

public class SavingsAccount extends BankAccount
{
   private boolean status; // Active or inactive
   
   
   public SavingsAccount(int accountID, String name, double bal, double intRate,
                         double mon)
   {
      super(accountID, name, bal, intRate, mon, "Basic Savings");
	  
      if (bal < 25.0 )
         status = false;   // Inactive
      else
         status = true;    // Active
      
    }

  
   public void withdrawMoney(int accountID, double amount)
   {
      if (status)
      {
         super.withdrawMoney(accountID, amount);
         if (getBalance(accountID) < 25.0)
            status = false;
      }
   }  
   

   
   public void deposit(int accountID, double amount)
   {
      super.deposit(accountID, amount);
      if (!status)
      {
         if (getBalance(accountID) >= 25.0)
            status = true;
      }
   }
   



   public void monthlyProcess(int accountID)
   {
      double msc;    // Monthly service charge
      
      if (getNumWithdrawals() > 4)
      {
         // Get the monthly service charges.
         msc = getMonthlyServiceCharges(accountID);
         // Increase the monthly service charges.
         setMonthlyServiceCharges(accountID, msc + (getNumWithdrawals() - 4));
         // Do the monthly processing.
         super.monthlyProcess(accountID);
         // Set the monthly charges back.
         setMonthlyServiceCharges(accountID, msc);
      }
      else
         super.monthlyProcess(accountID);       
   }
}
