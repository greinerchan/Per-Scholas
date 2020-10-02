package com.github.perscholas;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 6/10/2020.
 */
@SuppressWarnings("all")
public class FireMonsterTest {
    @Test
    public void testPolymorphism() {
        // given
        FireMonster fireMonster = new FireMonster();

        // when
        Boolean assertion = fireMonster instanceof Monster;

        // then
        Assert.assertTrue(assertion);
    }

    @Test
    public void testAttack() {
        // given
        FireMonster fireMonster = new FireMonster();
        Monster monster = (Monster) fireMonster;
        String expected = "Fire Ball";

        // when
        String actual = monster.attack();

        // then
        Assert.assertEquals(expected, actual);
    }
}
