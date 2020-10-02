package com.github.perscholas;

import org.junit.Assert;
import org.junit.Test;

public class GetLastElementTest {
    private void test(String[] array, String expected) {
        String actual = StringArrayUtils.getLastElement(array);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetLastElement1() {
        String[] array = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String expected = "dog";
        test(array, expected);
    }

    @Test
    public void testGetLastElement2() {
        String[] array = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy"};
        String expected = "lazy";
        test(array, expected);
    }


    @Test
    public void testGetLastElement3() {
        String[] array = {"the", "quick", "brown", "fox", "jumps", "over"};
        String expected = "over";
        test(array, expected);
    }
}
