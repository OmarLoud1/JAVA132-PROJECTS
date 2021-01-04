// Omar Loudghiri oxl51, EECS 132 project 1

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest extends CreditCardAccount {
// the method tested with this constructor are : setFirtName, setLastName, setStreetAddress, setZipCode, setDay.
// this constructor takes 6 inputts that correspond to the first and last name and to the address and zipcode along with
//a value for the day and month the account is operating on
Account Account1 = new Account("Omar", "Loudghiri", " 11331 Juniper Road, Cleveland",
        "44106", 11, 1);

//this method to test that setfirstname method worked well when calling the constructor
    @Test
    void getFirstName() {
        assertEquals("Omar", Account1.getFirstName());
    }

// this method is made to test the set last name method worked
    @Test
    void getLastName() {
        assertEquals("Loudghiri", Account1.getLastName());

    }

// this method is to test that the setStreetAdress method worked correctly when called by the constructor
    @Test
    void getStreetAddress() {
        assertEquals("11331 Juniper Road, Cleveland", Account1.getStreetAddress());

    }

// this method is to test that zipcode was tested correctly
    @Test
    void getZipCode() {
        assertEquals("44106", Account1.getZipCode());
    }

// this method creates a new bank account and assign it as the saving's account of the account we are working on
    @Test
    void getSavingsAccount() {
        BankAccount Account1_saving = new BankAccount();
        Account1.setSavingsAccount(Account1_saving);
        assertEquals("BankAccount@7d70d1b1" ,Account1.getSavingsAccount());
    }


    @Test
    void getCheckingAccount() {
        BankAccount Account1_Checking = new BankAccount();
        Account1.setCheckingAccount(Account1_Checking);
        assertEquals("BankAccount@7d70d1b1" ,Account1.getCheckingAccount());
    }

    @Test
    void getMoneyMarketAccount() {
        BankAccount Account1_Market = new BankAccount();
        Account1.setMoneyMarketAccount(Account1_Market);
        assertEquals("BankAccount@7d70d1b1" ,Account1.getMoneyMarketAccount());
    }

    @Test
    void getCreditCardAccount() {
        CreditCardAccount Account1_Credit = new CreditCardAccount();
        Account1.setCreditCardAccount(Account1_Credit);
        assertEquals("CreditCardAccount@7d70d1b1" ,Account1.getCreditCardAccount());
    }

    // a method that tests if the set date method used by the constructor works, it returns the toString method of the
    // Date class.
    @Test
    void getDate() {
        assertEquals("today is: 1/11", Account1.getDate());
    }

    /*to test this method I will create one instance of an account that is a bank account and another instance of a
    credit card to the test that both the increment day is used from both those classes

     */
    @Test
    void testIncrementDay() {
        // checking account of type BankAccount with a balance that is lower than the minimum so increment day withdraws
        //overdraft fee
        Account1.setDate(30,3);
        BankAccount Account1_Checking = new BankAccount(2.5, 250, 20, 3.5, 20);;
        Account1.setCheckingAccount(Account1_Checking);
        Account1_Checking.deposit(200);

        //Credit card of type credit card account
        CreditCardAccount Account1_Credit = new CreditCardAccount(1000, 20.0, 100, 25 );;
        Account1.setCreditCardAccount(Account1_Credit);
        Account1_Credit.charge(800);

        Account1.incrementDay();
        assertEquals("today is: 3/31", Account1.getDate() );
        assertEquals(180,Account1_Checking.getBalance());
        assertEquals(43.83561643835616, Account1_Credit.getInterests());

        //change the minimum balance for the account to gain interest and check that they were added to the balance
        Account1_Checking.setMinimumBalance(10);
        // now check that if the month changes increment month is executed too.

        Account1.incrementDay();
        // check that interests and the late payment penalty were both added to the balance
        assertEquals(915.0731844623757, Account1_Credit.getBalance());
        assertEquals(181.23287671232876, Account1_Checking.getBalance());
        assertEquals( "today is: 4/1", Account1.getDate());

    }

    // a test to see if two account have the same name and last name and adress return equal
    @Test
    void testEquals() {
        // we make the exact same account
        Account Account2 = new Account("Omar", "Loudghiri", " 11331 Juniper Road, Cleveland",
                "44106", 11, 1);
        assertTrue( Account1.equals(Account2));
        // we then make a different account
        Account Account3 = new Account("Jen", "Foster", " Cornell Road, Cleveland",
                "44106", 11, 1);
        assertFalse(Account1.equals(Account3));

    }

    // a test to see if the toString method returns the name of the account owner along with their adress, zipcode and
    //whatever account they own with the balance of that account
    @Test
    void testToString() {
        BankAccount Account1_Checking = new BankAccount();
        Account1.setCheckingAccount(Account1_Checking);
        Account1_Checking.deposit(200);
        CreditCardAccount Account1_Credit = new CreditCardAccount();;
        Account1.setCreditCardAccount(Account1_Credit);
        Account1_Credit.setCreditLimit(1000);
        Account1_Credit.charge(800);

        assertEquals("Omar Loudghiri  11331 Juniper Road, Cleveland 44106Checking: 200.0 Credit Card: 800.0 ",Account1.toString());


    }
}