package com.github.perscholas.manager;

import com.github.perscholas.EmployeeInterface;
import com.github.perscholas.Manager;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 6/10/2020.
 */
public class SetAddressTest {
    // given
    private void test(String addressToBeSet) {
        Manager manager = new Manager();
        EmployeeInterface managerAsEmployee = (EmployeeInterface)manager;

        // when
        managerAsEmployee.setAddress(addressToBeSet);

        // then
        String actual = managerAsEmployee.getAddress();
        Assert.assertEquals(addressToBeSet, actual);
    }

    @Test
    public void test1() {
        test("13 Marlfab Street");
    }

    @Test
    public void test2() {
        test("302 West Road");
    }

    @Test
    public void test3() {
        test("999 Unclever Avenue");
    }
}
