package tuesday.abstractingclauses;

import java.util.concurrent.ThreadLocalRandom;

public class Die {
	private Integer numberOfFaces;
	private Integer currentFaceValue;
	
	public Die(Integer numberOfFaces) {
		this.numberOfFaces = numberOfFaces;
	}
	
	public void roll() {
		ThreadLocalRandom randomNumberGenerator = ThreadLocalRandom.current();
		Integer randomFaceValue = randomNumberGenerator.nextInt(1, numberOfFaces);
		this.currentFaceValue = randomFaceValue;
	}
	
	public Integer getCurrentFaceValue() {
		return currentFaceValue;
	}
	
	public Integer getNumberOfFaces() {
		return numberOfFaces;
	}
}
