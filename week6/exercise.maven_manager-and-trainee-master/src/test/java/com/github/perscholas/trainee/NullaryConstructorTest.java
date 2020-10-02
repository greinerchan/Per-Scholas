package com.github.perscholas.trainee;

import com.github.perscholas.EmployeeInterface;
import com.github.perscholas.Trainee;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 6/10/2020.
 */
public class NullaryConstructorTest {
    @Test
    public void test() {
        // given
        Double expectedSpecialAllowance = 250.80;
        Double expectedHra = 1000.50;

        // when
        Trainee trainee = new Trainee();

        // then
        EmployeeInterface traineeAsEmployee = (EmployeeInterface)trainee;
        String actualAddress = traineeAsEmployee.getAddress();
        Double actualSalary = traineeAsEmployee.getBasicSalary();
        Long actualId = traineeAsEmployee.getId();
        String actualName = traineeAsEmployee.getName();
        Long actualPhone = traineeAsEmployee.getPhoneNumber();
        Double actualSpecialAllowance =  traineeAsEmployee.getSpecialAllowance();
        Double actualHra = traineeAsEmployee.getHealthReimbursementAccount();

        Assert.assertNull(actualAddress);
        Assert.assertNull(actualSalary);
        Assert.assertNull(actualId);
        Assert.assertNull(actualName);
        Assert.assertNull(actualPhone);
        Assert.assertEquals(expectedSpecialAllowance, actualSpecialAllowance);
        Assert.assertEquals(expectedHra, actualHra);
    }
}
