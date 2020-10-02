package com.github.perscholas;

import org.junit.Assert;
import org.junit.Test;

public class GetNumberOfOccurrencesTest {
    private String[] testInput;

    // given
    private void test(String valueToCount, int expected) {
        this.testInput = new String[]{"aba", "aba", "baa", "bab", "bba", "bba", "bba", "bba", "bbb", "bbb", "bbb", "baa"};
        
        // when
        int actual = StringArrayUtils.getNumberOfOccurrences(testInput, valueToCount);

        // then
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test1() {
        String valueToCount = "aba";
        int expected = 2;
        test(valueToCount, expected);
    }

    @Test
    public void test2() {
        String valueToCount = "baa";
        int expected = 2;
        test(valueToCount, expected);
    }

    @Test
    public void test3() {
        String valueToCount = "bbb";
        int expected = 3;
        test(valueToCount, expected);
    }


    @Test
    public void test4() {
        String valueToCount = "bab";
        int expected = 1;
        test(valueToCount, expected);
    }

}
