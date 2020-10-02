package com.github.perscholas.manager;

import com.github.perscholas.AbstractEmployee;
import com.github.perscholas.EmployeeInterface;
import com.github.perscholas.Manager;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 6/10/2020.
 */
public class PolymorphismTest {
    @Test
    public void testInheritance() {
        // given
        Object manager = new Manager();

        // when
        Boolean outcome = manager instanceof AbstractEmployee;

        // then
        Assert.assertTrue(outcome);
    }

    @Test
    public void testImplementation() {
        // given
        Object manager = new Manager();

        // when
        Boolean outcome = manager instanceof EmployeeInterface;

        // then
        Assert.assertTrue(outcome);
    }
}
