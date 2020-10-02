package com.github.perscholas.trainee;

import com.github.perscholas.EmployeeInterface;
import com.github.perscholas.Trainee;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 6/10/2020.
 */
public class SetPhoneTest {
    // given
    private void test(Long phoneNumber) {
        Trainee trainee = new Trainee();
        EmployeeInterface traineeAsEmployee = (EmployeeInterface)trainee;

        // when
        traineeAsEmployee.setPhoneNumber(phoneNumber);

        // then
        Long actual = traineeAsEmployee.getPhoneNumber();
        Assert.assertEquals(phoneNumber, actual);
    }

    @Test
    public void test1() {
        test(null);
    }

    @Test
    public void test2() {
        test(Long.MAX_VALUE);
    }

    @Test
    public void test3() {
        test(Long.MIN_VALUE);
    }

    @Test
    public void test4() {
        test(0L);
        test(1L);
        test(2L);
    }
}
