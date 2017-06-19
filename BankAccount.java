import java.util.HashMap;
import java.util.HashSet;

import org.json.simple.JSONObject;

/**
   The BankAccount class stores data about a bank account
   for the BankAccount and SavingsAccount Classes 
   programming challenge.
*/

public abstract class BankAccount
{
                 					
   private int numDeposits;               // Number of deposits
   private int numWithdrawals;            // Number of withdrawals

   public static HashMap<Integer , JSONObject> accounts = new HashMap<Integer, JSONObject>();
   static HashSet karSet = new HashSet();
  public static HashSet BankAccount(){
	   return SavingsAccount.karSet;
   }
   
   public BankAccount(int accountID, String name, double bal, double intRate,
                      double mon, String accountType)
   { 

		JSONObject dataset = new JSONObject();
		dataset.put("Account Type", accountType);
		dataset.put("Name",name);
		dataset.put("Balance", bal);
		dataset.put("intRate", intRate );
		dataset.put("Monthly Service", mon);
		accounts.put(accountID, dataset);
		karSet.add(accountID);
		}
   
   public void deposit (int accountID, double amount){
	   accounts.get(accountID).put("Balance",  (double) accounts.get(accountID).get("Balance") + amount);
	   numDeposits++;
   }
   
   public double getBalance (int accountID){
	   return (double) accounts.get(accountID).get("Balance");
   }
   
	public void withdrawMoney(int accountID, double ammount){
		accounts.get(accountID).put("Balance",  (double)  accounts.get(accountID).get("Balance") - ammount);
		numWithdrawals++;
	}
	
	public JSONObject getAccountInfo(int accountID){
		return accounts.get(accountID);
	}

	public int totalWithdraw(){
		return numWithdrawals;
	}

   
 private void calcInterest(int accountID)
   {
      // Get the monthly interest rate.
      double monIntRate = ((double)accounts.get(accountID).get("intRate")) / 12;
      
      // Get the amount of interest for the month.
      double monInterest = ((double)accounts.get(accountID).get("Balance")) * (double) accounts.get(accountID).get("Monthly Service");
  
      
      // Add the interest to the balance.
      accounts.get(accountID).put("Balance", (double) accounts.get(accountID).get("Balance") + (double) accounts.get(accountID).get("Monthly Service"));
   }

   
   public void monthlyProcess(int accountID)
   {
      // Subtract the monthly service charges
      // from the balance.
	   accounts.get(accountID).put("Balance", (double) accounts.get(accountID).get("Balance") - (double) accounts.get(accountID).get("Monthly Service"));
      
      
      // Calculate and add the interest for
      // the month.
      calcInterest(accountID);
      
      // Reset the number of deposits and
      // withdrawals to zero.
      numDeposits = 0;
      numWithdrawals = 0;
   }
   

   public void setMonthlyServiceCharges(int accountID, double m)
   {
      accounts.get(accountID).put("Monthly Service", m);
   }

   
   public int getNumDeposits()
   {
      return numDeposits;
   }


   
   public int getNumWithdrawals()
   {
      return numWithdrawals;
   }


   
   public double getInterestRate(int accountID)
   {
      return (double) accounts.get(accountID).get("intRate");
   }


   
   public double getMonthlyServiceCharges(int accountID)
   {
      return (double) accounts.get(accountID).get("Monthly Service");
      
   }
   

   
}
