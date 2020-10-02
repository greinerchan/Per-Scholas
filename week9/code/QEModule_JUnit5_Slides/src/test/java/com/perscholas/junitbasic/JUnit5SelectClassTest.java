package com.perscholas.junitbasic;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import com.perscholas.junitbasic.testsuite.Class1Test;
import com.perscholas.junitbasic.testsuite.Class3;

@RunWith(JUnitPlatform.class)
@SelectClasses({Class1Test.class, Class3.class})
public class JUnit5SelectClassTest {
	
}
