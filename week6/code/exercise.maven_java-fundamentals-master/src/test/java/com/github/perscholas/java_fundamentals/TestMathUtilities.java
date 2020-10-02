package com.github.perscholas.java_fundamentals;

import com.github.perscholas.java_fundamentals.mathutilities.TestAddition;
import com.github.perscholas.java_fundamentals.mathutilities.TestSubtraction;
import com.github.perscholas.java_fundamentals.mathutilities.TestDivision;
import com.github.perscholas.java_fundamentals.mathutilities.TestMultiplication;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Leon Hunter on 6/14/17.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestAddition.class,
        TestSubtraction.class,
        TestDivision.class,
        TestMultiplication.class
})
public class TestMathUtilities {
}