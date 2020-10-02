package tuesday.fundamentalclauses;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import tuesday.fundamentalclauses.Game;
import tuesday.fundamentalclauses.Inventory;
import tuesday.fundamentalclauses.Person;
import tuesday.fundamentalclauses.Player;

public class Slide11WhenTest {
	
	@Test
	public void testGetName() {
		// given
		Person person = new Person();
		String expected = "Leon";
		person.setName(expected);
		
		// when
		String actual = person.getName();
		
		// then
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetItem() {
		// given
		Inventory inventory = new Inventory();
		String expected = "Milk";
		inventory.getItems().add(expected);
		
		// when
		String actual = inventory.getItems().get(0);
		
		// then
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetWinner() {
		// given
		Game game = new Game();
		Player expected = new Player();
		expected.setName("John");
		game.getPlayers().add(expected);
		
		// when
		Player actual = game.getPlayers().get(0);
		
		// then
		assertEquals(expected, actual);
	}
}