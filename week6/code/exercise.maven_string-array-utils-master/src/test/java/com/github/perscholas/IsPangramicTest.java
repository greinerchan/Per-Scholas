package com.github.perscholas;

import org.junit.Assert;
import org.junit.Test;

public class IsPangramicTest {

    @Test
    public void testIsPangramic1() {
        // given
        String[] array = {"The quick brown", "Fox jumps over", "The lazy dog"};

        // when
        boolean outcome = StringArrayUtils.isPangramic(array);

        // then
        Assert.assertTrue(outcome);
    }

    @Test
    public void testIsPangramic2() {
        // given
        String[] array = {"The", "quick", "onyx", "goblin", "jumps", "over", "the", "lazy", "dwarf"};

        // when
        boolean outcome = StringArrayUtils.isPangramic(array);

        // then
        Assert.assertTrue(outcome);
    }

    @Test
    public void testIsPangramic3() {
        // given
        String[] array = {"Five quacking", "zephyrs", "jolt my", "wax bed"};

        // when
        boolean outcome = StringArrayUtils.isPangramic(array);

        // then
        Assert.assertTrue(outcome);
    }


    @Test
    public void testIsPangramic4() {
        // given
        String[] array = {"a", "b", "c", "d"};

        // when
        boolean outcome = StringArrayUtils.isPangramic(array);

        // then
        Assert.assertFalse(outcome);
    }



}
