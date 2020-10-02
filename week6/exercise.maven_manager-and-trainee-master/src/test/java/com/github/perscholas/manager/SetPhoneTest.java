package com.github.perscholas.manager;

import com.github.perscholas.EmployeeInterface;
import com.github.perscholas.Manager;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 6/10/2020.
 */
public class SetPhoneTest {
    // given
    private void test(Long phoneNumber) {
        Manager manager = new Manager();
        EmployeeInterface managerAsEmployee = (EmployeeInterface)manager;

        // when
        managerAsEmployee.setPhoneNumber(phoneNumber);

        // then
        Long actual = managerAsEmployee.getPhoneNumber();
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
