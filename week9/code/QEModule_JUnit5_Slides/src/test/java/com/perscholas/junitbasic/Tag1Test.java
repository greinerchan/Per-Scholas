package com.perscholas.junitbasic;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class Tag1Test {
	@Test
	@Tag("tagDemo")
	public void testTrue() {
		assertTrue(true);
	}
}
