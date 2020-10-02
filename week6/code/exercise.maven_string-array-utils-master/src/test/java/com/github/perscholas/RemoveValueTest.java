package com.github.perscholas;

import org.junit.Assert;
import org.junit.Test;

public class RemoveValueTest {

    private void test(String[] array, String[] expected,String valueToRemove) {
        String[] actual = StringArrayUtils.removeValue(array, valueToRemove);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveValue() {
        String[] array = {"The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String[] expected = {"quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        test(array, expected,"The");
    }

    @Test
    public void testRemoveValue1() {
        String[] array = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String[] expected = {"the", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        test(array, expected,"quick");
    }

    @Test
    public void testRemoveValue2() {
        String[] array = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String[] expected = {"the", "quick", "fox", "jumps", "over", "the", "lazy", "dog"};
        test(array, expected,"brown");
    }


}
