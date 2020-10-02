package com.github.perscholas.trainee;

import com.github.perscholas.EmployeeInterface;
import com.github.perscholas.Trainee;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 6/10/2020.
 */
public class NonNullaryConstructorTest {
    // given
    private void test(
            Long expectedId,
            String expectedName,
            String expectedAddress,
            Long expectedPhoneNumber,
            Double expectedSalary) {
        Double expectedSpecialAllowance = 250.80;
        Double expectedHra = 1000.50;

        // when
        Trainee trainee = new Trainee(expectedId, expectedName, expectedAddress, expectedPhoneNumber, expectedSalary);
        EmployeeInterface traineeAsEmployee = (EmployeeInterface) trainee;

        // then
        String actualAddress = traineeAsEmployee.getAddress();
        Double actualSalary = traineeAsEmployee.getBasicSalary();
        Long actualId = traineeAsEmployee.getId();
        String actualName = traineeAsEmployee.getName();
        Long actualPhone = traineeAsEmployee.getPhoneNumber();
        Double actualSpecialAllowance = traineeAsEmployee.getSpecialAllowance();
        Double actualHra = traineeAsEmployee.getHealthReimbursementAccount();

        Assert.assertEquals(expectedAddress, actualAddress);
        Assert.assertEquals(expectedSalary, actualSalary);
        Assert.assertEquals(expectedId, actualId);
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPhoneNumber, actualPhone);
        Assert.assertEquals(expectedSpecialAllowance, actualSpecialAllowance);
        Assert.assertEquals(expectedHra, actualHra);
    }


    @Test
    public void test0() {
        test(null, null, null, null, null);
    }

    @Test
    public void test1() {
        test(Long.MAX_VALUE, "", null, Long.MIN_VALUE, Double.MAX_VALUE);
    }

    @Test
    public void test2() {
        test(Long.MIN_VALUE, null, "", Long.MAX_VALUE, Double.MIN_VALUE);
    }

    @Test
    public void test3() {
        test(1L, "Billy", "13 West Street", 555123987L, 65000.0);
        test(2L, "Silly", "14 East Street", 554123987L, 65001.0);
        test(3L, "Jilly", "15 North Street", 553123987L, 65002.0);
    }
}
