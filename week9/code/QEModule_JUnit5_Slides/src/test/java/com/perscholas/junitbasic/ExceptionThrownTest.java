package com.perscholas.junitbasic;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ExceptionThrownTest {

	@Test
	public void testNumberFormatException() {
		assertThrows(NumberFormatException.class, () -> {
			Integer.parseInt("Five");
		});
	}
}