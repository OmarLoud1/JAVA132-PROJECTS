// Omar Loudghiri oxl51, EECS 132 project 1

// tester document for the BankAccount Class, it is to be read along with the testing document as it serves as a guide to
// to read this document.

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest extends BankAccount {
// an instance of the class being tested BankAccount.
    BankAccount Account1 = new BankAccount();

    // checks to see if the setter and getter methods work.
    @Test
    void testBalance() {

        Account1.deposit(500.0);
        assertEquals(500.0,Account1.getBalance());
    }
    // checks to see if the setter and getter methods work.
    @Test
    void testInterestRate() {
        Account1.setInterestRate(12);
        assertEquals(12, Account1.getInterestRate());

    }

    // checks to see if the setter and getter methods work.
    @Test
    void testMinimumBalance() {
        Account1.setMinimumBalance(300);
        assertEquals(300, Account1.getMinimumBalance());
    }


    // checks to see if the setter and getter methods work.
    @Test
    void testAtmFee() {
        Account1.setAtmFee(5.0);
        assertEquals(5.0, Account1.getAtmFee());
    }

    // checks to see if the setter and getter methods work.
    @Test
    void testOverDraftFee() {
        Account1.setOverDraftFee(15.0);
        assertEquals(15.0,Account1.getOverDraftFee());
    }


    // checks to see if the setter and getter methods work.
    @Test
    void testBouncedCheckFee() {
        Account1.setBouncedCheckFee(20.0);
        assertEquals(20.0, Account1.getBouncedCheckFee());
    }


    // checks to see if the setter and getter functions work.
    @Test
    void testWithdrawFee() {
        Account1.setWithdrawFee(7.50);
        assertEquals(7.50, Account1.getWithdrawFee());
    }


    @Test
    void testWithdrawLimit() {
        // checks to see if the setter and getter functions work.
        Account1.setWithdrawLimit(10);
        assertEquals(10, Account1.getWithdrawLimit());
    }


    @Test
    void testWithdraw() {
        // set the withdrw limit to test the withdraw limit function.
        Account1.setWithdrawLimit(2);

        //we set the withdraw fee that will be charged when the counter reaches the limit
        Account1.setWithdrawFee(12.0);

        //deposits and withdraws the same amount, so the withdraw function returns true.
        Account1.deposit(250.0);

        assertTrue(Account1.withdraw(250.0));
        assertEquals(1, Account1.getWithdrawCounter());

        // deposits a higher amount to check another possibility.
        Account1.deposit(251.0);

        assertTrue(Account1.withdraw(250.0));
        assertEquals(2, Account1.getWithdrawCounter());

        // the counter has now reached the Withdraw limit.

        Account1.deposit(270.0);
        assertEquals(271, Account1.getBalance());
        assertTrue(Account1.withdraw(250.0));

        //checks if the 250.0 was withdrawn in addition to the withdraw fee of 12.0. 271.0-262.0=9.0
        assertEquals(9.0,Account1.getBalance());
        assertEquals(3, Account1.getWithdrawCounter());

        // checks to see if the withdrawal is refused if the funds are not sufficient.
        Account1.deposit(20.0);
        assertFalse(Account1.withdraw(250.0));

    }

    @Test
    void testWithdrawDraft() {
        //checks to see if behaves like withdraw method when the amount withdrawn is equals to the balance.
        Account1.deposit(250.0);
        assertTrue(Account1.withdrawDraft(250.0));

        //check to see if the Bounced check fee is deducted
        Account1.deposit(9.0);
        Account1.setBouncedCheckFee(8.0);
        assertFalse(Account1.withdrawDraft(50.0));
        assertEquals(1,Account1.getBalance());

        //check to see if the Bounced check fee is deducted, even if the funds arent sufficient for that fee
        Account1.deposit(10.0);
        Account1.setBouncedCheckFee(12.0);
        assertFalse(Account1.withdrawDraft(50.0));
        assertEquals(-1,Account1.getBalance());


    }

    @Test
    void testWithdrawAtm() {

        Account1.deposit(250.0);
        // sets the atm fee to be charged
        Account1.setAtmFee(5.0);
        assertTrue(Account1.withdrawAtm(240.0));
        //checks if the atm fee is charged along with the withdrawal amount
        assertEquals(5.0, Account1.getBalance());


    }

    @Test
    void testIncrementDay() {
        // set the balance lower than the minimum balance to test if the overdraft fee will be charged
        Account1.deposit(200.0);
        Account1.setMinimumBalance(250);
        Account1.setOverDraftFee(20.0);
        Account1.incrementDay();
        assertEquals(180.0, Account1.getBalance());
        // tests the get overdraftflag method and see if the value was set to false
        assertTrue(Account1.getOverdraftFlag());

        // the overdraft flag is now set to true, the overdraft fee should not get charged again.
        Account1.incrementDay();
        assertEquals(180.0, Account1.getBalance());

        //set the interest rate and set the balance higher than the minimum.
        //set the balance to 101,000.0
        Account1.deposit(100820.0);
        Account1.setInterestRate(10.2);
        Account1.incrementDay();
        assertEquals(2822.465753424657, Account1.getInterestEarned());



    }

    @Test
    void testIncrementMonth() {
        // set the balance and the interest rate
        Account1.deposit(1000.0);
        Account1.setInterestRate(10.0);
        // calculates the interest rate
        Account1.incrementDay();
        // deposits the interest rate
        Account1.incrementMonth();
        // check if the interest earned is deposited
        assertEquals(0,Account1.getInterestEarned());
        assertEquals(1027.3972602739725, Account1.getBalance());
        //check if overdraft flag is deposited
        assertFalse(Account1.getOverdraftFlag());
    }

    BankAccount Account2= new BankAccount(2.5, 25, 10, 3.5, 20);
    @Test
    void testConstructor(){
        //checks to see if the constructor assigned the appropriate values.
        assertEquals(2.5, Account2.getInterestRate());
        assertEquals(25, Account2.getMinimumBalance());
        assertEquals(10, Account2.getOverDraftFee());
        assertEquals(3.5, Account2.getAtmFee());
        assertEquals(20, Account2.getBouncedCheckFee());

    }
}
