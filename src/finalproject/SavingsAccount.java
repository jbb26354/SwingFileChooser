/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package finalproject;

/**
   An account that earns interest at a fixed rate.
*/
public class SavingsAccount extends BankAccount
{
   /**
      Constructs a bank account with a given interest rate.
      @param rate the interest rate
   */
   public SavingsAccount(double rate)
   {
      interestRate = rate;
   }

   /**
     Constructs a savings account with an account number and a given balance.
     @param anAccountNumber the account number for this account
     @param initialBalance the initial balance
     @param rate the interest rate
   */
   public SavingsAccount(int anAccountNumber, double initialBalance, double rate)
   {
      // Construct superclass
      super(anAccountNumber, initialBalance);

      interestRate = rate;
   }

   /**
      Adds the earned interest to the account balance.
   */
   public void addInterest()
   {
      double interest = getBalance() * interestRate / 100;
      deposit(interest);
   }

   private double interestRate;
}
