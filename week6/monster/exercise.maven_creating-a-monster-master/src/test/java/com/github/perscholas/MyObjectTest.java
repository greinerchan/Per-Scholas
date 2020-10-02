package com.github.perscholas;

import org.junit.Assert;
import org.junit.Test;

public class MyObjectTest {
    @Test
    public void testRun() { // TODO
        // Given
        ApplicationRunner myObject = new ApplicationRunner();

        // when
        myObject.run();

        //then
        Assert.assertNotNull(myObject.toString());
    }
}
