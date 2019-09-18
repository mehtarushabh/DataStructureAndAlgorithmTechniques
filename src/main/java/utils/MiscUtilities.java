package utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MiscUtilities {


	List<Integer> a = new ArrayList<>();
	Iterator<Integer> aaa = a.iterator();

	public int factorial(int n) {
		if (n == 0)
			return 1;
		return n * factorial(n - 1);
	}


	public void rotate(int input[], int numberOfRotations) {
		for (int i = 0; i < numberOfRotations; i++) {
			int temp = input[input.length - 1];
			for (int j = input.length - 1; j > 0; j--)
				input[j] = input[j - 1];
			input[0] = temp;
		}
	}


	public LinkedList findPrimeFactors(String number) {
		BigInteger input = new BigInteger(number);

		if (input.compareTo(BigInteger.valueOf(2)) < 0)
			throw new IllegalArgumentException("Number must be greater than 1.");

		LinkedList primeFactors = new LinkedList();



		while (input.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
			primeFactors.add(BigInteger.valueOf(2));
			System.out.print(BigInteger.valueOf(2) + ",");

			input = input.divide(BigInteger.valueOf(2));
		}

		if (input.compareTo(BigInteger.ONE) > 0) {
			BigInteger f = BigInteger.valueOf(3);
			while (f.multiply(f).compareTo(input) <= 0) {
				if (input.mod(f).equals(BigInteger.ZERO)) {
					primeFactors.add(f);
					System.out.print(f + ",");
					input = input.divide(f);
				} else
					f = f.add(BigInteger.valueOf(2));
			}
			System.out.print(input + ",");
			primeFactors.add(input);
		}
		return primeFactors;
	}


}
