package com.github.perscholas;

import org.junit.Assert;
import org.junit.Test;

public class ContainsTest {

    @Test
    public void test1() {
        // given
        String[] array = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String valueToCheck = "the";
        Boolean expected = true;

        // when
        Boolean actual = StringArrayUtils.contains(array, valueToCheck);

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        // given
        String[] array = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String valueToCheck = "the";
        Boolean expected = true;

        // when
        Boolean actual = StringArrayUtils.contains(array, valueToCheck);

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAll() {
        String[] array = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        for (String s : array) {
            boolean outcome = StringArrayUtils.contains(array, s);
            Assert.assertTrue(outcome);
        }
    }


}
