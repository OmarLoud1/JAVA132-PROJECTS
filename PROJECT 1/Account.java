// Omar Loudghiri (oxl51) EECS 132 project 1
// This class will keep track of the owner of a specific account, their name, address and other sensitive information.
// AO : account owner

import java.util.*;

public class Account  {
// Fields

    //a. a field to store the AO's first name.
    private String firstName;

    //b. a field to store the AO's last name.
    private String lastName;

    //c. a field to store AO's first address line.
    private String streetAddress;

    //d. a field to store AO's zipCode.
    private String zipCode;

    //e. a field to store the instance of a bank account that will be a savings' account
    private BankAccount savingsAccount;

    //f. a field to store a checking account which is an instance of a bank account
    private BankAccount checkingAccount;

    //g. a field to store a money market account, an instance of a bank account.
    private BankAccount moneyMarketAccount;

    //h. a field to store an instance of a credit card account.
    private CreditCardAccount creditCardAccount;

    //i. a field that stores the date that the account is opperating on.
    private Date date;









//constructors


    public Account (String firstName, String lastName, String streetAddress, String zipCode, int day, int month){

    this.setFirstName(firstName);
    this.setLastName(lastName);
    this.setStreetAddress(streetAddress);
    this.setZipCode(zipCode);
    this.setDate(day, month);

}


//Methods

    //a. a method to access the first name of the AO
    public String getFirstName() {
        return firstName;
    }

    //a. a method to change the AO's first name.
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //b. a method to access AO's last name.
    public String getLastName() {
        return lastName;
    }

    //b. a method to change AO's last name.
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //c. a method to access AO's address
    public String getStreetAddress() {
        return streetAddress;
    }

    //c. a method to change AO's address
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    //d. a method to access the AO's zipcode
    public String getZipCode() {
        return zipCode;
    }

    //d. a method to change AO's zipcode
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    //e. a method that accesses the instance of a the banck account that serves as a saving's account
    public BankAccount getSavingsAccount() {
        return savingsAccount;
    }

    //e. a method that will assign a saving account to this specific account
    public void setSavingsAccount(BankAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    //f. a method that accesses the checking account associated to the thi bank account
    public BankAccount getCheckingAccount() {
        return checkingAccount;
    }

    //f. a method that will assign an already existent checking account to this account
    public void setCheckingAccount(BankAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    //g. a method to access the money market account associate to this account
    public BankAccount getMoneyMarketAccount() {
        return moneyMarketAccount;
    }

    //g. a method to assign a money market account to this account.
    public void setMoneyMarketAccount(BankAccount moneyMarketAccount) {
        this.moneyMarketAccount = moneyMarketAccount;
    }

    //h. a method that will access the instance of a credit card account associated to this account
    public CreditCardAccount getCreditCardAccount() {
        return creditCardAccount;
    }

    //h. a method that will assign an already existent instance of a credit card to this account
    public void setCreditCardAccount(CreditCardAccount creditCardAccount) {
        this.creditCardAccount = creditCardAccount;
    }

    //i. a method that will access the current date this account is operating on
    public Date getDate() {
        return date;
    }

    //i. a method that will assign an instance of the class date to this account in order to monitor the date.
    public void setDate(int day, int month) {
        this.date = new Date(day, month);
    }

    /*j.a function that will initiate the increment day function on date which it will add one day to the date counter.
    This method will also run the increment day method on all the bank accounts attached to this account.

     */
    public void incrementDay(){
        this.date.incrementDay();

        if (savingsAccount != null) {
            this.savingsAccount.incrementDay();
        }
        if (checkingAccount != null){
            this.checkingAccount.incrementDay();
        }
        if (moneyMarketAccount != null){
            this.moneyMarketAccount.incrementDay();
        }
        if (creditCardAccount != null){
            this.creditCardAccount.incrementDay();
        }
       if(this.date.getDay() == 1){
           if (savingsAccount != null) {
               this.savingsAccount.incrementMonth();
           }
           if (checkingAccount != null){
               this.checkingAccount.incrementMonth();
           }
           if (moneyMarketAccount != null){
               this.moneyMarketAccount.incrementMonth();
           }
           if (creditCardAccount != null){
               this.creditCardAccount.incrementMonth();
           }

       }
    }

    /*k. a method that overrides the equal method and makes as such as if the name and the adress of an account is the
    same as another account's then the method returns equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if(obj == null || this.getClass() != obj.getClass() ) return false;
        Account other = (Account) obj;
        return( this.getFirstName() == other.getFirstName() && this.getLastName() == other.getLastName() &&
                this.getStreetAddress() == other.getStreetAddress() && this.getZipCode() == other.getZipCode());
    }

    /*l. a method that overrides the toString method and makes it return the name and address along with the balance
    of all the existent accounts.
     */
    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append(this.getFirstName() + " " + this.getLastName() + " " + this.getStreetAddress() + " " + this.getZipCode());

        if (savingsAccount != null) {
            sb.append("Savings: " + this.savingsAccount.getBalance() + " ");
        }
        if (checkingAccount != null){
            sb.append("Checking: " + this.checkingAccount.getBalance() + " ");
        }
        if (moneyMarketAccount != null){
            sb.append("Money Market: " + this.moneyMarketAccount.getBalance() + " ");
        }
        if (creditCardAccount != null){
            sb.append("Credit Card: " + this.creditCardAccount.getBalance() + " ");
        }

        return sb.toString();

    }
}
