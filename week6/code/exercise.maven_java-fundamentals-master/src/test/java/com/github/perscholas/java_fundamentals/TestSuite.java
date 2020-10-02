package com.github.perscholas.java_fundamentals;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by leon Hunter on 2/5/18.
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestPredicateUtilities.class,
        TestMathUtilities.class,
        TestStringUtilities.class,
})
public class TestSuite {
}
