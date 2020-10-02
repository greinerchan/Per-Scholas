package com.github.perscholas.manager;

import com.github.perscholas.EmployeeInterface;
import com.github.perscholas.Manager;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 6/10/2020.
 */
public class SetNameTest {
    // given
    private void test(String nameToBeSet) {
        Manager manager = new Manager();
        EmployeeInterface managerAsEmployee = (EmployeeInterface)manager;

        // when
        managerAsEmployee.setName(nameToBeSet);

        // then
        String actual = managerAsEmployee.getName();
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
