package com.github.perscholas;

import org.junit.Assert;
import org.junit.Test;

public class RemovePackDuplicatesTest {
    // given
    private void test(String[] array, String[] expected) {
        // when
        String[] actual = StringArrayUtils.packConsecutiveDuplicates(array);

        // then
        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void testRemovePackDuplicates1() {
        // given
        String[] array = {"a", "a", "a", "b", "c", "c", "a", "a", "d"};
        String[] expected = {"aaa", "b", "cc", "aa", "d"};
        test(array, expected);
    }


    @Test
    public void testRemovePackDuplicates2() {
        // given
        String[] array = {"t", "t", "q", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e"};
        String[] expected = {"tt", "q", "aaa", "b", "cc", "aa", "d", "eee"};
        test(array, expected);
    }



    @Test
    public void testRemovePackDuplicates3() {
        // given
        String[] array = {"m", "o", "o", "n", "m", "a", "n"};
        String[] expected = {"m", "oo", "n", "m", "a", "n"};
        test(array, expected);
    }


}
