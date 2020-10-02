package tuesday.monoliths;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Slide05Decoupling {
	public static Boolean isValid(String userName) {
		String[] invalidCharArray = "!@#$%^&*()".split("");
		List<String> invalidChars = Arrays.asList(invalidCharArray);

		String[] userNameCharacterArray = userName.split("");
		for (String currentCharacter : userNameCharacterArray) {
			if (invalidChars.contains(currentCharacter)) {
				System.out.println("Invalid username");
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Create a username:");
		String userName = s.nextLine();
		if (isValid(userName)) {
			System.out.println("Username is valid!");
		}
		s.close();
	}
}
