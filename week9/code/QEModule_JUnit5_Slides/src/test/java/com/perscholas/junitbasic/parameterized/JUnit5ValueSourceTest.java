package com.perscholas.junitbasic.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JUnit5ValueSourceTest {
	@ParameterizedTest
	@CsvSource({"1,1,2,true", "2,2,5,false"})
	void testJUnit5CsvParameters(String color) {
		System.out.println(color);
	}
}