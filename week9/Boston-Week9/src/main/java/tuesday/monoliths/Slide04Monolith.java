package tuesday.monoliths;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Slide04Monolith {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] invalidCharArray = "!@#$%^&*()".split("");
		List<String> invalidChars = Arrays.asList(invalidCharArray);
		
		System.out.println("Create a username:");
		String userName = scanner.nextLine();
		scanner.close();

		String[] userNameCharacterArray = userName.split("");
		for (String currentCharacter : userNameCharacterArray) {
			if (invalidChars.contains(currentCharacter)) {
				System.out.println("Invalid username");
				return;
			}
		}
		System.out.println("Username is valid!");
	}
}
