package utils;

import java.util.*;

/*
 * @author: Rushabh
 * */

public class IntegerListSkipIterator implements Iterator {
	private final Map<Integer, Integer> conditionArrayFrequencyMap;
	private final List<Integer> listToIterate;
	private int counter;
	private Integer lastReturn;

	public IntegerListSkipIterator(List<Integer> listToIterate, int[] conditionArray) {
		this.conditionArrayFrequencyMap = new HashMap<>();
		this.listToIterate = listToIterate;
		this.counter = 0;
		this.lastReturn = null;

		for (int value : conditionArray) {
			if (this.conditionArrayFrequencyMap.containsKey(value))
				this.conditionArrayFrequencyMap.put(value, this.conditionArrayFrequencyMap.get(value) + 1);
			else
				this.conditionArrayFrequencyMap.put(value, 1);
		}
	}

	private boolean conditionChecker(int key) {
		if (conditionArrayFrequencyMap.containsKey(key)) {
			conditionArrayFrequencyMap.put(key, conditionArrayFrequencyMap.get(key) - 1);
			if (conditionArrayFrequencyMap.get(key) == 0)
				conditionArrayFrequencyMap.remove(key);
			return true;
		} else
			return false;
	}

	@Override
	public boolean hasNext() {
		if (listToIterate.size() > counter) {
			if (conditionChecker(listToIterate.get(counter))) {
				counter++;
				return hasNext();
			}
			return true;
		} else
			return false;
	}

	@Override
	public Integer next() {
		if (hasNext()) {
			lastReturn = listToIterate.get(counter);
			counter++;
			return lastReturn;
		} else
			throw new NoSuchElementException();
	}
}