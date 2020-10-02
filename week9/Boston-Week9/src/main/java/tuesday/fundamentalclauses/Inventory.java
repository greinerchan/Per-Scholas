package tuesday.fundamentalclauses;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private List<String> items;

	public Inventory() {
		this.items = new ArrayList<>();
	}
	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}
	
}
