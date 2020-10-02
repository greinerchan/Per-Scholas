package com.github.perscholas;

import org.junit.Assert;
import org.junit.Test;

public class ApplicationRunnerTest {
    @Test
    public void testRun() { // TODO
        // Given
        ApplicationRunner applicationRunner = new ApplicationRunner();

        // when
        applicationRunner.run();

        //then
        Assert.assertNotNull(applicationRunner.toString());
    }
}
