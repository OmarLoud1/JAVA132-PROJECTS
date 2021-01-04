// Omar Loudghiri oxl51, EECS 132 project 1


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DateTest {
// create an instance of the class Date
    Date date1 = new Date(11,12);

    //test that getDate will return the input of the constructor
    @Test
    void getDay() {
        assertEquals(11, date1.getDay());

    }

    //test that getMonth will return the input of the constructor.
    @Test
    void getMonth() {
        assertEquals(12, date1.getMonth());
    }

    @Test
    void testIncrementDay() {
        date1.incrementDay();
        assertEquals(12, date1.getDay());
        // to test all the other sittuations:
        // when the month has 31 days and it it is the 31st day and we add one
        Date date2 = new Date(31, 3);
        date2.incrementDay();
        assertEquals(4,date2.getMonth());
        assertEquals(1,date2.getDay());

        //when the month has 30 days  and it is the 30th day and we add one
        Date date3 = new Date(30, 4);
        date3.incrementDay();
        assertEquals(5, date3.getMonth());
        assertEquals(1,date3.getDay());

        // when it is february and it is the 29th day
        Date date4 = new Date(29, 2);
        date4.incrementDay();
        assertEquals(3, date4.getMonth());
        assertEquals(1,date4.getDay());
    }

    @Test
    void testEquals() {
        // we know that date1 is 12/11, let's make another date2 that has the same values
        Date date2 = new Date(11, 12);
        assertTrue(date1.equals(date2));
        date2.incrementDay();
        assertFalse(date1.equals(date2));
    }

    @Test
    void testToString() {
        assertEquals("today is: 12/11", date1.toString());
    }
}