package utils;

import java.util.*;

/*
 * @author: Rushabh Mehta
 *
 * This Integer list skip iterator is am implementation of the Iterator interface
 * with a condition. The conditionArray contains a set of integers who's values will be skipped
 * as the iterator iterates through the list. This iterator is limited to only integer fields.
 * */

public class IntegerSkipIterator implements Iterator {


	private final List<Integer> listToIterate;
	private final Map<Integer, Integer> skipConditionFrequency;
	private int counter;
	private Integer lastReturn;

	/*
	 * This is the constructor where we initialize all the variables
	 * the Map<Integer,Integer> is a HashMap that contains the elements in the condition array
	 * and its corresponding frequency.
	 * */
	public IntegerSkipIterator(List<Integer> input, int[] skipCondition) {
		listToIterate = new ArrayList<>(input);
		counter = 0;
		lastReturn = null;
		skipConditionFrequency = new HashMap<>();

		for(int value : skipCondition) {
			if(skipConditionFrequency.containsKey(value))
				skipConditionFrequency.put(value, skipConditionFrequency.get(value) + 1);
			else
				skipConditionFrequency.put(value, 1);
		}
	}


	private boolean conditionCheck(int key) {
		if(skipConditionFrequency.containsKey(key)) {
			skipConditionFrequency.put(key, skipConditionFrequency.get(key) - 1);
			if(skipConditionFrequency.get(key) == 0)
				skipConditionFrequency.remove(key);
			return true;
		} else
			return false;
	}


	@Override
	public boolean hasNext() {
		if(listToIterate.size() > counter) {
			if(conditionCheck(listToIterate.get(counter))) {
				counter++;
				return hasNext();
			}
			return true;
		} else
			return false;
	}


	@Override
	public Integer next() {
		if(hasNext()) {
			lastReturn = listToIterate.get(counter);
			counter++;
			return lastReturn;
		} else
			throw new NoSuchElementException("End of List Reached");
	}

}