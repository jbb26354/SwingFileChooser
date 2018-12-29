/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package finalproject;

/**
   A checking account that charges transaction fees.
*/
public class CheckingAccount extends BankAccount
{
   /**
      Constructs a checking account with a given balance.
      @param initialBalance the initial balance
   */
   public CheckingAccount(double initialBalance)
   {
      // Construct superclass
      super(initialBalance);

      // Initialize transaction count
      transactionCount = 0;
   }

   /**
     Constructs a checking account with an account number and a given balance.
     @param anAccountNumber the account number for this account
     @param initialBalance the initial balance
   */
   public CheckingAccount(int anAccountNumber, double initialBalance)
   {
      // Construct superclass
      super(anAccountNumber, initialBalance);

      // Initialize transaction count
      transactionCount = 0;
   }

   public void deposit(double amount)
   {
      transactionCount++;
      // Now add amount to balance
      super.deposit(amount);
   }

   public void withdraw(double amount)
   {
      transactionCount++;
      // Now subtract amount from balance
      super.withdraw(amount);
   }

   /**
      Deducts the accumulated fees and resets the
      transaction count.
   */
   public void deductFees()
   {
      if (transactionCount > FREE_TRANSACTIONS)
      {
         double fees = TRANSACTION_FEE *
               (transactionCount - FREE_TRANSACTIONS);
         super.withdraw(fees);
      }
      transactionCount = 0;
   }

   private int transactionCount;

   private static final int FREE_TRANSACTIONS = 3;
   private static final double TRANSACTION_FEE = 2.0;
}
