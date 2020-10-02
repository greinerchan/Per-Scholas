package tuesday.abstractingclauses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class DieTest {
	@Test
	public void testConstructor() {
		// given
		Integer expectedFaceValue = null;
		Integer expectedNumberOfFaces = null;
		
		// when
		Die die = new Die(expectedNumberOfFaces);
		Integer actualFaceValue = die.getCurrentFaceValue();
		Integer actualNumberOfFaces = die.getNumberOfFaces();
		
		// then
		assertEquals(expectedFaceValue, actualFaceValue);
		assertEquals(expectedNumberOfFaces, actualNumberOfFaces);
	}
	
	@Test
	public void testRoll() {
		// given
		Integer numberOfFaces = 6;
		Integer unexpected = null;
		Die die = new Die(numberOfFaces);
		
		// when
		die.roll();
		Integer actual = die.getCurrentFaceValue();
		System.out.println(actual);
		
		// then
		assertNotEquals(unexpected, actual);
	}
}
