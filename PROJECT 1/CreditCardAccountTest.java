// Omar Loudghiri oxl51    EECS 132 Project 1
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import javax.smartcardio.Card;

import static org.junit.jupiter.api.Assertions.*;
// a test class for the CreditCardAccount class, that will test all the methods in the class

public class CreditCardAccountTest extends CreditCardAccount {
//creates a new instance of this class to execute the methods on.
    CreditCardAccount Card1 = new CreditCardAccount();

    // test if the setter anf getter for credit card limit works.
    @Test
    void testCreditLimit() {
        Card1.setCreditLimit(1500);
        assertEquals(1500, Card1.getCreditLimit() );
    }

    //test if the set and get Interest rate work
    @Test
    void testInterestRate() {
        Card1.setInterestRate(20);
        assertEquals(20, Card1.getInterestRate());
    }


    //test the set and get methods for MinMonthlyPayment
    @Test
    void testMinMonthlyPayment() {
        Card1.setMinMonthlyPayment(500);
        assertEquals(500, Card1.getMinMonthlyPayment());
    }


    // test the set a and get the methods for LatePaymentPenalty.
    @Test
    void testLatePaymentPenalty() {
        Card1.setLatePaymentPenalty(25);
        assertEquals(25, Card1.getLatePaymentPenalty());
    }


    /* a method to test of the methods charge and get balance work, by charging an amount of money and checking if it
    it was added to the balance */
    @Test
    void testChargeBalance() {
        Card1.setCreditLimit(1500);
        //charge an amount lower than the credit limit.
        Card1.charge(1400);
        // check that the get balance returns the same amount.
        assertEquals(1400,Card1.getBalance());
        // charge an amount that is higher than the limit (with the balance) and check if returns false.
        assertFalse(Card1.charge(200));
        // check that the balance was not altered.
        assertEquals(1400,Card1.getBalance());
    }






    @Test
    void testPayment() {
        Card1.setCreditLimit(1000);
        Card1.charge(500);
        Card1.payment(400);
        assertEquals(100, Card1.getBalance());
        assertEquals(400, Card1.getPaidBack());
    }

    // a test for IncrementDay method.
    @Test
    void testIncrementDay() {
        //sets the limit to be able to borrow 500.
        Card1.setCreditLimit(1000);
        Card1.charge(500);
        // interest rate
        Card1.setInterestRate(20);
      // the Paid in full flag is set to false by default.
        Card1.incrementDay();
        assertEquals(27.397260273972602,Card1.getInterests());
    }
// test the increment month when the paid back amount is higher than the minimum
    @Test
    void testIncrementMonth() {
        //sets the limit to be able to borrow 500.
        Card1.setCreditLimit(1000);
        Card1.charge(500);
        // set the interest rate
        Card1.setInterestRate(20);
        // to generate interest we run IncrementDay, which gives us an interest of  27.397260273972602
        Card1.incrementDay();
        Card1.payment(400);
        Card1.setMinMonthlyPayment(20);
        // call the Increment Month method which will transfer the interest to the balance but not charge the late fee.
        Card1.incrementMonth();
        assertEquals(127.397260273972602, Card1.getBalance());
        assertEquals(Card1.getBalance(),Card1.getMonthlyPayment());
        Card1.payment(127.397260273972602);
        Card1.incrementMonth();
        assertTrue(isPaidInFullFlag());

    }
//tests the incremtn month method when the monthly minimum is greater than the paidback amount.
    @Test
    void testIncrementMonth2() {
        //sets the limit to be able to borrow 500.
        Card1.setPaidBack(0);
        Card1.setCreditLimit(1000);
        Card1.charge(500);
        // set the interest rate
        Card1.setInterestRate(20);
        // to generate interest we run IncrementDay, which gives us an interest of  27.397260273972602
        Card1.incrementDay();
        Card1.payment(400);
        Card1.setLatePaymentPenalty(10);
        Card1.setMinMonthlyPayment(401);
        Card1.incrementMonth();
        assertEquals(137.39726027397262, Card1.getBalance());
    }

    CreditCardAccount Card2 = new CreditCardAccount(1000, 20.0, 100, 25 );

    @Test
    void testConstructor(){
        assertEquals(1000, Card2.getCreditLimit());
        assertEquals(20.0, Card2.getInterestRate());
        assertEquals(100, Card2.getMinMonthlyPayment());
        assertEquals(25, Card2.getLatePaymentPenalty());
    }



}