package com.github.perscholas.trainee;

import com.github.perscholas.EmployeeInterface;
import com.github.perscholas.Trainee;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 6/10/2020.
 */
public class SetNameTest {
    // given
    private void test(String nameToBeSet) {
        Trainee trainee = new Trainee();
        EmployeeInterface traineeAsEmployee = (EmployeeInterface)trainee;

        // when
        traineeAsEmployee.setName(nameToBeSet);

        // then
        String actual = traineeAsEmployee.getName();
        Assert.assertEquals(nameToBeSet, actual);
    }

    @Test
    public void testDivya() {
        test("Divya");
    }

    @Test
    public void testDinesh() {
        test("Dinesh");
    }

    @Test
    public void testChris() {
        test("Chris");
    }
}
