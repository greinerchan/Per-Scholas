package com.github.perscholas;

import org.junit.Assert;
import org.junit.Test;

public class ReverseTest {

    private void test(String[] array, String[] expected) {
        String[] actual = StringArrayUtils.reverse(array);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReverse1() {
        String[] array = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String[] expected = {"dog", "lazy", "the", "over", "jumps", "fox", "brown", "quick", "the"};
        test(array, expected);
    }



    @Test
    public void testReverse2() {
        String[] array  = {"dog", "lazy", "the", "over", "jumps", "fox", "brown", "quick", "the"};
        String[] expected = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        test(array, expected);
    }


    @Test
    public void testReverse3() {
        String[] expected = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String[] actual = StringArrayUtils.reverse(StringArrayUtils.reverse(expected));
        Assert.assertArrayEquals(expected, actual);
    }

}
