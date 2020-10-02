package com.github.perscholas;

import org.junit.Assert;
import org.junit.Test;

public class GetSecondToLastElementTest {
    private void test(String[] array, String expected) {
        String actual = StringArrayUtils.getSecondToLastElement(array);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetSecondToLastElement1() {
        String[] array = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String expected = "lazy";
        test(array, expected);
    }

    @Test
    public void testGetSecondToLastElement2() {
        String[] array = {"the", "quick", "brown", "fox", "jumps", "over", "lazy"};
        String expected = "over";
        test(array, expected);
    }


    @Test
    public void testGetSecondToLastElement3() {
        String[] array = {"the", "quick", "brown", "fox", "jumps", "over"};
        String expected = "jumps";
        test(array, expected);
    }

}
