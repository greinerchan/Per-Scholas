package tuesday.monoliths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import tuesday.monoliths.Slide05Decoupling;

public class Slide05DecouplingTest {
	@Test
	public void test1() {
		assertTrue(Slide05Decoupling.isValid("fred"));
	}
	
	@Test
	public void test2() {
		assertTrue(Slide05Decoupling.isValid("John"));
	}
	
	@Test
	public void test3() {
		assertTrue(Slide05Decoupling.isValid("George"));
	}
	
	@Test
	public void test4() {
		assertFalse(Slide05Decoupling.isValid("Freddy!"));
	}
	
	@Test
	public void test5() {
		assertFalse(Slide05Decoupling.isValid("@perscholas"));
	}
	
	@Test
	public void test6() {
		assertFalse(Slide05Decoupling.isValid("$500.50"));
	}
}
