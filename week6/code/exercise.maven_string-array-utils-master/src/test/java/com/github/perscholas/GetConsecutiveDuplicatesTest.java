package com.github.perscholas;

import org.junit.Assert;
import org.junit.Test;

public class GetConsecutiveDuplicatesTest {
    private void test(String[] array, String[] expectedArray) {
        String[] actual = StringArrayUtils.removeConsecutiveDuplicates(array);
        Assert.assertEquals(actual, expectedArray);
    }


    @Test
    public void testRemoveConsecutiveDuplicates1() {
        test(
                new String[]{"aba", "aba", "baa", "bab", "bba", "bba", "bba", "bba", "bbb", "bbb"},
                new String[]{"aba", "baa", "bab", "bba", "bbb"});
    }


    @Test
    public void testRemoveConsecutiveDuplicates2() {
        test(
                new String[]{"aba", "aba", "baa", "bab", "bba", "zzz", "bba", "bba", "bba", "bbb", "bbb"},
                new String[]{"aba", "baa", "bab", "bba", "zzz", "bba", "bbb"});
    }


    @Test
    public void testRemoveConsecutiveDuplicates3() {
        test(
                new String[]{"aba", "aba", "baa", "bab", "bba", "zzz", "bba", "bba", "bba", "aba", "bbb"},
                new String[]{"aba", "baa", "bab", "bba", "zzz", "bba", "aba", "bbb"});
    }

}
