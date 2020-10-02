package com.perscholas.junitbasic.parameterized;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JUnit5CsvSourceTest {
	@ParameterizedTest
	@CsvSource({"1,1,2,true", "1,1,3,false"})
	void testJUnit5CsvParameters(int num1, int num2, int expectedAnswer, boolean veracity) {
		if (veracity) {
			assertTrue(Math.addExact(num1, num2) == expectedAnswer);
			System.out.println(num1 + " plus " + num2 + " equals " + expectedAnswer);
		} else {
			assertFalse(Math.addExact(num1, num2) == expectedAnswer);
			System.out.println(num1 + " plus " + num2 + " does not equal " + expectedAnswer);
		}
	}
}