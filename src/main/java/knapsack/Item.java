package knapsack;

public class Item {
	private final int weight;
	private final int value;

	public Item(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public int getValue() {
		return value;
	}
}
