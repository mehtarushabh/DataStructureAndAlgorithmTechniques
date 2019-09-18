package knapsack;

public class Item {
	int weight;
	int value;

	public Item(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}


	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
