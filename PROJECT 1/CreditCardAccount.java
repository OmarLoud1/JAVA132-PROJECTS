// Omar Loudghiri (oxl51)

// This class is made to keep track of the transaction of a credit card along with the interest rates.
// all the values are set to be 0.0 by default for testing purposes


public class CreditCardAccount {
// FIELDS:

    //a. a field that stores the maximum amount a credit card can borrow.
    private int creditLimit;

    //b. a field that stores the credit interestRate for the card.
    private double interestRate;

    //c.  a field that stores the minimum amount that has to be payed back per month to avoid paying a fee.
    private int minMonthlyPayment;

    //d. the fee that is payed if the repayment of a fee is late.
    private int latePaymentPenalty;

    //e. the balance or the amount borrowed by the account.
    private double balance;

    //f. the amount needed to be payed this month in order to reimburse all the debt in full.
    private double monthlyPayment;

    //h. a field that stores the total amount paid back for that month
    private double paidBack;

    //i. a variable that keeps track of the interest accumulated by the card.
    private double interests;

    //i. a variable that keeps track of whether the balance has been paid in full or not (monthlypayment).
    private boolean paidInFullFlag;

//CONSTRUCTORS

    // the default constructor that sets all the values to zero and lets the tester set their own values.
    public CreditCardAccount(){
        creditLimit = 0;
        interestRate = 0.0;
        minMonthlyPayment = 0;
        latePaymentPenalty = 0;
        balance = 0.0;
        monthlyPayment = 0.0;
        paidBack = 0.0;
        interests = 0.0;
        paidInFullFlag = true;
    }
    // a constructor that allows to set the credit limit, the interest rate, the minimum payment, and the late penalty fee.
    public CreditCardAccount( int creditLimit, double interestRate, int minMonthlyPayment, int latePaymentPenalty){
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
        this.minMonthlyPayment = minMonthlyPayment;
        this.latePaymentPenalty = latePaymentPenalty;
    }



//METHODS

    //a. a method to access the credit limit for this card
    public int getCreditLimit() {
        return creditLimit;
    }

    //a. a limit to set the credit limit.
    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    //b. a method to access the interest rate.
    public double getInterestRate() {
        return interestRate;
    }

    //b. a method to change the interest rate.
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    //c.a method to access the value of the minimum monthly payment.
    public int getMinMonthlyPayment() {
        return minMonthlyPayment;
    }

    //c. a method to set the minimum monthly payment.
    public void setMinMonthlyPayment(int minMonthlyPayment) {
        this.minMonthlyPayment = minMonthlyPayment;
    }

    //d. a method to access the late payment fee.
    public int getLatePaymentPenalty() {
        return latePaymentPenalty;
    }

    //d. a method to set the fee of a late payment
    public void setLatePaymentPenalty(int latePaymentPenalty) {
        this.latePaymentPenalty = latePaymentPenalty;
    }

    //e. a method to access the amount this card owes.
    public double getBalance() {
        return balance;
    }

    //f. a method to access the amount a payment has to be to pay the full debt.
    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    //f. a method to set what amount needs to be paid back to set the balance to 0;
    public void setMonthlyPayment(double monthlyPayment){
        this.monthlyPayment = monthlyPayment;
    }

    /* g. a method that charge the credit card an amount of money( the amount to borrow) if the balance is not higher
    * than the limit*/
    public boolean charge(double charge) {
        // if doesn't exceed the limit of the card it goes through, else returns false
        if ((getBalance() + charge) < getCreditLimit()) {
            balance = getBalance() + charge;
        } else {
            return false;
        }
        return true;

    }

    //h. a method that pays back an amount of money towards the debt earned so far.
    public void payment(double payment) {
        paidBack += payment;

        balance = getBalance() - payment;
    }

    //h. a method that returns the amount paid back that month
    public double getPaidBack(){
      return this.paidBack;
    }

    //i. a method that calculates the interest and keeps track of whether it was paid back or not
    public void incrementDay(){
        // if the balance is not paid in full, the interests are added up for the day.

            this.interests = interests + (getBalance() + interests) * (getInterestRate() / 365);
    }

    //i.a method that accesses the interest earned so far
    public double getInterests() {
        return interests;
    }

    /* j.a method that transfers the interests for the month into the balance, and charges the late payment if the
    * minimum payment wasn't payed the late fee will be charged*/

    public void incrementMonth(){
        //the interests are added to the balance.
        balance += interests;
        interests = 0;
        /* if the ampunt of money paid back is equal to the monthly payment value then the debt is paid back and the flag
        * is set to true */
       if (paidBack >= getMonthlyPayment()){
           this.paidInFullFlag= true;
       }
       else {
           this.paidInFullFlag = false;
       }
        // if the ammount paid back is lower than the minimum then the fee is charged
        if(paidBack < getMinMonthlyPayment()) {
            balance += getLatePaymentPenalty();
        }

        paidBack = 0;
        setMonthlyPayment(balance);
    }

    // a method to set the paidBack amount;
    public void setPaidBack(double paidBack) {
        this.paidBack = paidBack;
    }

    // a method to access the paid in full flag
    public boolean isPaidInFullFlag() {
        return paidInFullFlag;
    }
}


