package com.github.perscholas.trainee;

import com.github.perscholas.EmployeeInterface;
import com.github.perscholas.Trainee;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 6/10/2020.
 */
public class SetBasicSalaryTest {
    // given
    private void test(Double newSalary) {
        Trainee trainee = new Trainee();
        EmployeeInterface traineeAsEmployee = (EmployeeInterface)trainee;

        // when
        traineeAsEmployee.setBasicSalary(newSalary);

        // then
        Double actual = traineeAsEmployee.getBasicSalary();
        Assert.assertEquals(newSalary, actual);
    }

    @Test
    public void test1() {
        test(null);
    }

    @Test
    public void test2() {
        test(Double.MAX_VALUE);
    }

    @Test
    public void test3() {
        test(Double.MIN_VALUE);
    }

    @Test
    public void test4() {
        test(0.0);
        test(1.0);
        test(2.0);
    }
}
