import utils.IntegerListSkipIterator;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String args[]) {
		skipIteratorDriverCode();


	}

	public static void skipIteratorDriverCode() {
		List<Integer> input = new ArrayList<>();
		input.add(1);
		input.add(2);
		input.add(6);
		input.add(2);
		input.add(3);
		input.add(3);
		input.add(2);
		input.add(6);
		input.add(6);
		input.add(6);
		input.add(6);
		input.add(6);

		IntegerListSkipIterator iterator = new IntegerListSkipIterator(input, new int[]{1, 6, 6, 2, 2, 3, 4, 5, 4, 6});

		while (iterator.hasNext())
			System.out.println(iterator.next());

	}

}