package tuesday.fundamentalclauses;

import org.junit.jupiter.api.Test;

import tuesday.fundamentalclauses.Game;
import tuesday.fundamentalclauses.Inventory;
import tuesday.fundamentalclauses.Person;
import tuesday.fundamentalclauses.Player;

public class Slide06GivenTest {
	@Test
	public void testGetName() {
		// given
		Person person = new Person();
		String expectedName = "Leon";
		person.setName(expectedName);
	}
	
	@Test
	public void testGetItem() {
		// given
		Inventory inventory = new Inventory();
		String expectedItem = "Milk";
		inventory.getItems().add(expectedItem);
	}
	
	@Test
	public void testGetWinner() {
		// given
		Game game = new Game();
		Player expectedWinner = new Player();
		game.getPlayers().add(expectedWinner);
	}
}