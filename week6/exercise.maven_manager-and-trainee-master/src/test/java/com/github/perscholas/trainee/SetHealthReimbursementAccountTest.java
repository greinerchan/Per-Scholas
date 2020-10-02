package com.github.perscholas.trainee;

import com.github.perscholas.EmployeeInterface;
import com.github.perscholas.Trainee;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 6/10/2020.
 */
public class SetHealthReimbursementAccountTest {
    // given
    private void test(Double newHealthReimbursementAccountValue) {
        Trainee trainee = new Trainee();
        EmployeeInterface traineeAsEmployee = (EmployeeInterface)trainee;

        // when
        traineeAsEmployee.setHealthReimbursementAccount(newHealthReimbursementAccountValue);

        // then
        Double actual = traineeAsEmployee.getHealthReimbursementAccount();
        Assert.assertEquals(newHealthReimbursementAccountValue, actual);
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
