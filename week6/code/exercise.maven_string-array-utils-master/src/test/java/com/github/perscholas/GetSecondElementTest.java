package com.github.perscholas;

import org.junit.Assert;
import org.junit.Test;

public class GetSecondElementTest {
    private void test(String[] array, String expected) {
        String actual = StringArrayUtils.getSecondElement(array);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetSecondElement1() {
        String[] array = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String expected = "quick";
        test(array, expected);
    }

    @Test
    public void testGetSecondElement2() {
        String[] array = {"quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String expected = "brown";
        test(array, expected);
    }


    @Test
    public void testGetSecondElement3() {
        String[] array = {"brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String expected = "fox";
        test(array, expected);
    }
}
