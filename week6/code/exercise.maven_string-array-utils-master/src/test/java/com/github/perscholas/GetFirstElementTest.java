package com.github.perscholas;

import org.junit.Assert;
import org.junit.Test;

public class GetFirstElementTest {
    // given
    private void test(String[] array, String expected) {
        // when
        String actual = StringArrayUtils.getFirstElement(array);

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetFirstElement1() {
        String[] array = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String expected = "the";
        test(array, expected);
    }

    @Test
    public void testGetFirstElement2() {
        String[] array = {"quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String expected = "quick";
        test(array, expected);
    }


    @Test
    public void testGetFirstElement3() {
        String[] array = {"brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String expected = "brown";
        test(array, expected);
    }
}
