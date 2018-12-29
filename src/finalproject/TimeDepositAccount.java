/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package finalproject;

/**
   An account that earns interest at a fixed rate until a maturity date.
*/
public class TimeDepositAccount extends SavingsAccount
{
   /**
      Constructs a time deposit account with a given interest rate and maturity.
      @param rate the interest rate
      @param maturity the number of months to maturity
   */
   public TimeDepositAccount(double rate, int maturity)
   {
      super(rate);
      periodsToMaturity = maturity;
   }

   /**
     Constructs a time deposit account with an account number and a given balance.
     @param anAccountNumber the account number for this account
     @param initialBalance the initial balance
     @param maturity the number of months to maturity
   */
   public TimeDepositAccount(int anAccountNumber, double initialBalance, double rate, int maturity)
   {
      // Construct superclass
      super(anAccountNumber, initialBalance, rate);

      // Initialize transaction count
      periodsToMaturity = maturity;
   }
   /**
      Adds the earned interest to the account balance.
   */
   public void addInterest()
   {
      periodsToMaturity--;
      super.addInterest();
   }

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   public void withdraw(double amount)
   {
      if (periodsToMaturity > 0)
      {
        super.withdraw(EARLY_WITHDRAWAL_PENALTY);
      }
      super.withdraw(amount);
   }

   private int periodsToMaturity;
   private static double EARLY_WITHDRAWAL_PENALTY = 20;
}
