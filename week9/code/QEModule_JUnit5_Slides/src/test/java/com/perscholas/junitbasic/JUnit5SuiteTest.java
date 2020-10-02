package com.perscholas.junitbasic;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("JUnit 5 Test Suite") // Optional
@SelectPackages("com.perscholas.junitbasic.testsuite")
public class JUnit5SuiteTest {
	
}