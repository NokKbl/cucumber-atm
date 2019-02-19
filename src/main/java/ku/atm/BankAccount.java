package ku.atm;

/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
*/
public class BankAccount {
   private double balance;
   private double nego;

   /**
      Constructs a bank account with a zero balance.
   */
   public BankAccount() {
      balance = 0;
   }

   /**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
   */
   public BankAccount(double initialBalance) {
      balance = initialBalance;
   }

   /**
    Constructs a bank account with a given balance.
    @param initialBalance the initial balance
    @param negoAmount the negotiated amount
    */
   public BankAccount(double initialBalance, double negoAmount) {
      balance = initialBalance;
      nego = negoAmount;
   }

   /** 
      Deposits money into the account.
      @param amount the amount of money to withdraw
   */
   public void deposit(double amount) {
      balance = balance + amount;
   }

   /** 
      Withdraws money from the account.
      @param amount the amount of money to deposit
   */
   public void withdraw(double amount) throws NotEnoughBalanceException {
       if(nego > 0.0){
          if(amount <= (balance + nego)) {
             nego -= Math.abs(balance - amount);
             balance = 0;
          }else{
             throw new NotEnoughBalanceException("cannot withdraw more than negotiated amount specified");
          }
       }else{
          if (amount > balance)
             throw new NotEnoughBalanceException("cannot withdraw more than balance");
          balance = balance - amount;
       }
   }

   /** 
      Gets the account balance.
      @return the account balance
   */
   public double getBalance() {
      return balance; 
   }

   public double getNegotiatedAmount(){
      return nego;
   }

}

