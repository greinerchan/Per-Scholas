package com.github.perscholas.manager;

import com.github.perscholas.EmployeeInterface;
import com.github.perscholas.Manager;
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
        Manager manager = new Manager();

        // then
        EmployeeInterface managerAsEmployee = (EmployeeInterface)manager;
        String actualAddress = managerAsEmployee.getAddress();
        Double actualSalary = managerAsEmployee.getBasicSalary();
        Long actualId = managerAsEmployee.getId();
        String actualName = managerAsEmployee.getName();
        Long actualPhone = managerAsEmployee.getPhoneNumber();
        Double actualSpecialAllowance =  managerAsEmployee.getSpecialAllowance();
        Double actualHra = managerAsEmployee.getHealthReimbursementAccount();

        Assert.assertNull(actualAddress);
        Assert.assertNull(actualSalary);
        Assert.assertNull(actualId);
        Assert.assertNull(actualName);
        Assert.assertNull(actualPhone);
        Assert.assertEquals(expectedSpecialAllowance, actualSpecialAllowance);
        Assert.assertEquals(expectedHra, actualHra);
    }
}
