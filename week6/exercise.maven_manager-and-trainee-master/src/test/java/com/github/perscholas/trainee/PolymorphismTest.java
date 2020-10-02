package com.github.perscholas.trainee;

import com.github.perscholas.AbstractEmployee;
import com.github.perscholas.EmployeeInterface;
import com.github.perscholas.Trainee;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 6/10/2020.
 */
public class PolymorphismTest {
    @Test
    public void testInheritance() {
        // given
        Object trainee = new Trainee();

        // when
        Boolean outcome = trainee instanceof AbstractEmployee;

        // then
        Assert.assertTrue(outcome);
    }

    @Test
    public void testImplementation() {
        // given
        Object trainee = new Trainee();

        // when
        Boolean outcome = trainee instanceof EmployeeInterface;

        // then
        Assert.assertTrue(outcome);
    }
}
