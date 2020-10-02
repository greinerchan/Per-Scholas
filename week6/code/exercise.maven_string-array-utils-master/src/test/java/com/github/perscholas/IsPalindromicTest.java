package com.github.perscholas;

import org.junit.Assert;
import org.junit.Test;

public class IsPalindromicTest {


    @Test
    public void testIsPalindromic1() {
        // given
        String[] array = {"a", "b", "c", "b", "a"};

        // when
        boolean outcome = StringArrayUtils.isPalindromic(array);

        // then
        Assert.assertTrue(outcome);
    }



    @Test
    public void testIsPalindromic2() {
        // given
        String[] array = {"Is this a palindrome?", "This is a palindrome", "Is this a palindrome?"};

        // when
        boolean outcome = StringArrayUtils.isPalindromic(array);

        // the
        Assert.assertTrue(outcome);
    }


    @Test
    public void testIsPalindromic3() {
        // given
        String[] array = {"Is this a plaindrome?", "This is not a plaindrome", "Is this a palindrome?", "This is not a palindrome"};

        // when
        boolean outcome = StringArrayUtils.isPalindromic(array);

        // then
        Assert.assertFalse(outcome);
    }


}
