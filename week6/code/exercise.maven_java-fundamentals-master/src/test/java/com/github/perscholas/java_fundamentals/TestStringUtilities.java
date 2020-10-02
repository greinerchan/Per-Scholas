package com.github.perscholas.java_fundamentals;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Leon Hunter on 6/14/17.
 */
public class TestStringUtilities {
    @Test
    public void getHelloWorldTest() {
        // : Given
        String expected = "Hello World";

        // : When
        String actual = StringUtilities.getHelloWorld();

        // : Then
        assertEquals(expected, actual);

    }

    @Test
    public void concatenationStringTest(){
        // : Given
        String one = "Hello";
        String two = " Java";
        String expected = "Hello Java";

        // : When
        String actual = StringUtilities.concatenation(one,two);


        // : Then
        assertEquals(expected, actual);
    }


    @Test
    public void concatenationStringAndIntegerTest(){
        // : Given
        int one = 1;
        String two = " Java";
        String expected = "1 Java";

        // : When
        String actual = StringUtilities.concatenation(one,two);


        // : Then
        assertEquals(expected, actual);
    }

    @Test
    public void substringBeginTest(){
        // : Given
        String input = "Hello";
        String expected = "Hel";

        // : When
        String actual = StringUtilities.getPrefix(input);

        // : Then
        assertEquals(expected, actual);
    }

    @Test
    public void substringEndTest(){
        // : Given
        String input = "Hello";
        String expected = "llo";

        // : When
        String actual = StringUtilities.getSuffix("Hello");

        // : Then
        assertEquals(expected, actual);
    }

    @Test
    public void testCompareToEquals(){
        // : Given
        String inputValue = "Zipcode";
        String comparableValue = "Zipcode";

        // : When
        boolean actual = StringUtilities.compareTwoStrings(inputValue, comparableValue);

        // : Then
        assertTrue(actual);
    }


    @Test
    public void testCompareToNotEquals(){
        // : Given
        String inputValue = "Zipcode";
        String comparableValue = "Zipcodee";

        // : When
        boolean actual = StringUtilities.compareTwoStrings(inputValue, comparableValue);

        // : Then
        assertFalse(actual);
    }

    @Test
    public void getTheMiddleCharOfZipcode(){
        // : Given
        String input = "Zipcode";
        Character expected = 'c';

        // : When
        Character actual = StringUtilities.getMiddleCharacter(input);

        // : Then
        Assert.assertEquals(expected.toString(), actual.toString());
    }


    @Test
    public void getTheMiddleCharOfZipcoder(){
        // : Given
        String input = "Zipcoder";
        Character expected = 'c';

        // : When
        Character actual = StringUtilities.getMiddleCharacter(input);

        // : Then
        Assert.assertEquals(expected.toString(), actual.toString());
    }


    @Test
    public void getTheFirstWord(){
        // : Given
        String input = "Zipcode Wilmington";
        String expected = "Zipcode";

        // : When
        String actual = StringUtilities.getFirstWord(input);

        // : Then
        assertEquals(expected, actual);
    }


    @Test
    public void getTheSecondWord(){
        // : Given
        String input = "Zipcode Wilmington";
        String expected = "Wilmington";

        // : When
        String actual = StringUtilities.getSecondWord(input);

        // : Then
        assertEquals(expected, actual);
    }

    @Test
    public void reverseThem(){
        // : Given
        String input = "Zipcode Wilmington";
        String expected = "notgnimliW edocpiZ";


        // : When
        String actual = StringUtilities.reverse(input);

        // : Then
        assertEquals(expected, actual);
    }
}
