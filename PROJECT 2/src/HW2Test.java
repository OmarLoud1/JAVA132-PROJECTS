// Omar Loudghiri oxl51 HW2 project number 2 EECS132

import static org.junit.jupiter.api.Assertions.*;

class HW2Test {

    @org.junit.jupiter.api.Test
    void replaceFirstK() {
        // test when no string is inputed and the number is negative.
        assertEquals(HW2.replaceFirstK("", 'q', 'q', -1),"string is null");

        // test when the string's input is only one character
        assertEquals(HW2.replaceFirstK("1", '1', '2', 1),"2");

        // test both when the input string is many, and when we are looking for an element in the beginning of the string.
        assertEquals(HW2.replaceFirstK("Mississippi River", 'M', 'I', 3),"Iississippi River");

        // test when we are looking for an element at the beginning and end of the string
        assertEquals(HW2.replaceFirstK("Missouri River", 'r', '*', 3), "Missou*i Rive*");


    }

    @org.junit.jupiter.api.Test
    void allChars() {
        //0.test when the input is not a letter character, returns an error.
        assertEquals(HW2.allChars('0','<'),"null" );

        // 1/begining. test when only the first character is the input of both params, also tests that it can find a at the beginning of the the string
        assertEquals(HW2.allChars('a','a'), "a");

        // many/ middle test when the a character bigger than one is input
        assertEquals(HW2.allChars('c','c'), "c");

        // many/ end test when many things are being looked for in the middle and the the last of the string.
        assertEquals(HW2.allChars('d', 'z'),"defghijklmnopqrstuvwxyz");
    }

    @org.junit.jupiter.api.Test
    void showCharOfString() {
        // 0. test we dont input anyhting on both sides
        assertEquals(HW2.showCharOfString("", ""), "error: no input");

        //1. test when only one character of the string is input on both side
        assertEquals(HW2.showCharOfString("a", "a"), "a");

        // many. beginning, test when are looking for a char at the begining of the string
        assertEquals(HW2.showCharOfString("abc", "a"), "a__");

        //middle. test that it can search for a char in the middle of the string
        assertEquals(HW2.showCharOfString("abc", "b"), "_b_");

        //many, middle and end. This is a common test and it looks for a character in the middle of both params.
        assertEquals( HW2.showCharOfString("Missouri River", "s SR!r"), "__ss__r_ R___r");

    }



    @org.junit.jupiter.api.Test
    void hiddenString() {
        //0, when the input is 0 or invalid
        assertEquals(HW2.hiddenString(new char[]{},""), false);

        //1. when the input is only one char and a string made of one char
        assertEquals(HW2.hiddenString(new char[]{'a'},"a"), true);

        //many. first: we test to see if the method will find a string in the beginning of a bigger array of chars
        assertEquals(HW2.hiddenString(new char[]{'a','b','c','d'},"ab"), true);

        //middle: we test if the desired string is found in the middle
        assertEquals(HW2.hiddenString(new char[]{'a','b','c','d'},"bc"), true);

        //last: we test if it is found in the middle of the char.
        assertEquals(HW2.hiddenString(new char[]{'a','b','c','d'},"cd"), true);

        //backwards, tests if the method works when the string is found backwards
        assertEquals(HW2.hiddenString(new char[]{'a','b','c','d'},"dcba"), true);

        // normal test: true
        assertTrue( HW2.hiddenString(new char[]{'a','b','r','a','c','a','d','a'}, "carb"));

        // normal false test
        assertFalse(HW2.hiddenString(new char[]{'a','b','r','a','c','a','d','a'}, "brad"));

    }

    @org.junit.jupiter.api.Test
    void testHiddenString() {
        //0. we test that no input will return false
        assertFalse(HW2.hiddenString(new char[][]{{},{},{}}, ""));

        //1. test that one input works
        assertTrue(HW2.hiddenString(new char[][]{{'a',},{},{}}, "a"));

        // many/first this test that an input with many chars and the result is in the first three chars
        assertTrue(HW2.hiddenString(new char[][]{{'a', 'b', 'c'},{'r','c','a','d'},{'b','r','f'}}, "abc"));

        //middle, if we search chars in the middle of the array
        assertTrue(HW2.hiddenString(new char[][]{{'a', 'b', 'c'},{'r','c','a','d'},{'b','r','f'}}, "cad"));

        //end. if we search at the end of the array
        assertTrue(HW2.hiddenString(new char[][]{{'a', 'b', 'c'},{'r','c','a','d'},{'b','r','f'}}, "abc"));

        //vertical search beginning
        assertTrue(HW2.hiddenString(new char[][]{{'a', 'b', 'c'},{'r','c','a','d'},{'b','r','f'}}, "arb"));

        // vertical test middle
        assertTrue(HW2.hiddenString(new char[][]{{'a', 'b', 'c'},{'r','c','a','d'},{'b','r','f'}}, "bcr"));

        //vertical test last
        assertTrue(HW2.hiddenString(new char[][]{{'a', 'b', 'c'},{'r','c','a','d'},{'b','r','f'}}, "caf"));

        //diagonal test first/ middle
        assertTrue(HW2.hiddenString(new char[][]{{'a', 'b', 'c'},{'r','w','a'},{'b','r','f'}}, "awf"));

        //diagonal last
        assertTrue(HW2.hiddenString(new char[][]{{'a', 'b', 'c'},{'r','w','z'},{'b','r','f'}}, "cwb"));




    }
}