
 // Omar Loudghiri (oxl51) EECS 132 project1

// This Class keeps track of someone's bank account. All the functions that a standard bank account might have.
// All the default values are assumed to be 0.0 for testing purposes.


public class BankAccount {
// Fields, the letter before them is the order in which they are set in the instructions.

    // a. a field to store the account's amount of money.
    private double balance;

    // b. a field to store the interest rate for this account.
    private double interestRate;

    // c. a field to store the minimum balance for this account. If the balance falls below it, a fee is charged.
    private int minimumBalance;

    // d. a field that stores the atm fee whenever money is withdrawn form this account through an atm.
    private double atmFee;

    // e. a field that stores the overdraft fee, if the balance is lower than the minimum value this fee is charged.
    private double overDraftFee;

    // f. a field that stores the fee that is charged if the the withdrawal amount exceeds the balance of the account.
    private double bouncedCheckFee;

    // g. a field that stores the value of the fee that is charged if the monthly free withdraws are all used.
    private double withdrawFee;

    /* h. a field that stores the number of monthly free withdraws an account can make before a fee is charged,
    0 if unlimited., resets every month
     */
    private int withdrawLimit;

    // m. a field variable that stores the interest earned, the interest is earned daily.
    private double interestEarned;

    // m. a field variable of type boolean that keeps track of whether the overdraft fee has been charged  that month.
    private boolean overdraftFlag;

    // #. a field that stores the number of withdraws that happened this month;
     int withdrawCounter;

// constructors

    // a constructor that initializes all the values if the class is called with no input.(default)
    public BankAccount() {
        balance = 0.0;
        interestRate = 0.0;
        minimumBalance = 0;
        atmFee = 0.0;
        overDraftFee = 0.0;
        bouncedCheckFee = 0.0;
        withdrawFee = 0.0;
        withdrawLimit = 0;
        interestRate = 0.0;
        overdraftFlag = false;
        withdrawCounter = 0;
    }
    // a constructor that allows to set fields when creating a new instance of this class.
    public BankAccount(double interestRate, int minimumBalance, double overDraftFee, double atmFee, double bouncedCheckFee){
        setInterestRate(interestRate);
        setMinimumBalance(minimumBalance);
        setOverDraftFee(overDraftFee);
        setAtmFee(atmFee);
        setBouncedCheckFee(bouncedCheckFee);
    }

// Methods

    // a. a method to access the account's balance.

    public double getBalance() {
        return balance;
    }

    // a private method that can change the value of the balance.
    private void setBalance(double balance){
        this.balance=balance;
    }

    // b. a method to access the interest rate.

    public double getInterestRate() {
        return interestRate;
    }

    // b. a method to change the interest rate.

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // c. a method to access the minimum balance.


    public int getMinimumBalance() {
        return minimumBalance;
    }

    // c. a method to change the minimum balance threshold.

    public void setMinimumBalance(int minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    // d. a method to access the atm Fee.

    public double getAtmFee() {
        return atmFee;
    }

    // d. a method to change the value of the atm Fee.

    public void setAtmFee(double atmFee) {
        this.atmFee = atmFee;
    }

    // e. a method to access the overdraft fee.

    public double getOverDraftFee() {
        return overDraftFee;
    }

    // e. a method that changes the value the overdraft fee.

    public void setOverDraftFee(double overDraftFee) {
        this.overDraftFee = overDraftFee;
    }

    // f. a method that accesses the value of the BouncedCheck fee.
    public double getBouncedCheckFee() {
        return bouncedCheckFee;
    }

    // f. a method that changes the value of the bounced check fee.
    public void setBouncedCheckFee(double bouncedCheckFee) {
        this.bouncedCheckFee = bouncedCheckFee;
    }

    // g. a method to access the withdraw fee.
    public double getWithdrawFee() {
        return withdrawFee;
    }

    // g. a method to modify the value of the withdraw fee.
    public void setWithdrawFee(double withdrawFee) {
        this.withdrawFee = withdrawFee;
    }

    // h. a method to access the withdraw limit of the account.
    public int getWithdrawLimit() {
        return withdrawLimit;
    }

    // h. a method to change the withdraw limit of the account
    public void setWithdrawLimit(int withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    // a method to access the withdraw counter field
    public int getWithdrawCounter(){
        return withdrawCounter;
    }

    // i. a method that will deposit money into the account.(add only)
    public void deposit (double deposit){
        this.balance = getBalance() + deposit;
    }

    // j. a method that will withdraw money from the balance
    public boolean withdraw(double withdraw){
        /* if there are enough funds in the account, the client is allowed to proceed, and the amount withdrawn is
         deducted from the account.
         */
        if(withdraw <= getBalance()) {
            setBalance(getBalance() - withdraw);

            // if the client still has enough free withdraws for the month, the counter counts this withdrawal.
            if (withdrawCounter < getWithdrawLimit()){
                withdrawCounter ++;
            }
            //else the client is charged the the withdraw fee.
            else {
                withdrawCounter ++;
                setBalance((getBalance() - getWithdrawFee()));
            }
            return true;
        }
        else {
            return false;
        }

    }

    /* k. a method that will work exactly like the withdraw method unless the balance doesn't have enough funds,
          in that case the bounced check fee is deducted from the balance.
     */

    public boolean withdrawDraft(double withdrawDraft){
        if(withdrawDraft <= getBalance()) {
          return withdraw(withdrawDraft);
        }
        else {
            setBalance(getBalance() - getBouncedCheckFee());
            return false;
        }

    }

    // l. a method that withdraws money from an ATM, reducing the atm fee along with the withdraw amount;
    public boolean withdrawAtm(double withdrawAtm){
         return withdraw(withdrawAtm+atmFee);
    }

    /* m. a method that adds the interest earned to the balance unless the balance is below the minimum,
    then it charges the overdraft fee.
     */
    public void  incrementDay(){
        if ( getBalance() < getMinimumBalance() && !overdraftFlag){
           setBalance(getBalance() - getOverDraftFee());
            overdraftFlag = true;
        }
        else if(getBalance() > getMinimumBalance()){
            interestEarned = ((getBalance() + interestEarned) * (getInterestRate() / 365));
        }
    }

    // m. a method that will access the interest earned
    public double getInterestEarned() {
        return interestEarned;
    }

    // n. a method that deposits the interest earned so far into the balance.

    public void incrementMonth(){
        deposit(this.getInterestEarned());
        interestEarned = 0;
        overdraftFlag = false;
    }

    //n. a method that gets the field Overdraftflag.
    public boolean getOverdraftFlag() {
        return overdraftFlag;
    }


}
