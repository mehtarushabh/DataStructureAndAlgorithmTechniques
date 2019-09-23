package hashtables;

/*
 * @author: Rushabh
 *
 * */

public class SimpleHashTable {

	private Employee[] hashTable;

	public SimpleHashTable() {
		this.hashTable = new Employee[10];
	}

	private int hashKey(String key) {
		return key.length() % this.hashTable.length;
	}

	private boolean occupied(int index) {
		return hashTable[index] != null;
	}


	public void put(String key, Employee employee) {
		int hashedKey = hashKey(key);

		if (occupied(hashedKey)) {
			int stopIndex = hashedKey;

			if (hashedKey == hashTable.length - 1)
				hashedKey = 0;
			else
				hashedKey++;

			while (occupied(hashedKey) && hashedKey != stopIndex)
				hashedKey = (hashedKey + 1) % hashTable.length;
		}

		if (occupied(hashedKey))
			System.out.println("Already exist" + hashedKey);
		else {
			hashTable[hashedKey] = employee;
		}
	}

	public Employee get(String key) {
		int hKey = hashKey(key);
		return hashTable[hKey];
	}

	public void printTable() {
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null)
				System.out.println(hashTable[i].getFirstName() + " " + hashTable[i].getLastName() + " " + hashTable[i].getId());
			else
				System.out.println(hashTable[i]);
		}

	}

}