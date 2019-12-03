package utils;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

/*
 * @author: Rushabh Mehta
 * */

public class MiscUtilities {

	private int factorial(int n) {
		if(n == 0)
			return 1;
		return n * factorial(n - 1);
	}

	public void rotate(int input[], int numberOfRotations) {
		for(int i = 0; i < numberOfRotations; i++) {
			int temp = input[input.length - 1];
			for(int j = input.length - 1; j > 0; j--)
				input[j] = input[j - 1];
			input[0] = temp;
		}
	}

	public LinkedList findPrimeFactors(String number) {
		BigInteger input = new BigInteger(number);

		if(input.compareTo(BigInteger.valueOf(2)) < 0)
			throw new IllegalArgumentException("Number must be greater than 1.");

		LinkedList primeFactors = new LinkedList();

		while(input.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
			primeFactors.add(BigInteger.valueOf(2));
			System.out.print(BigInteger.valueOf(2) + ",");
			input = input.divide(BigInteger.valueOf(2));
		}

		if(input.compareTo(BigInteger.ONE) > 0) {
			BigInteger f = BigInteger.valueOf(3);
			while(f.multiply(f).compareTo(input) <= 0) {
				if(input.mod(f).equals(BigInteger.ZERO)) {
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

	//leetcode 1185
	public String dayOfTheWeek(int day, int month, int year) {
		LocalDate date = LocalDate.of(year, month, day);
		switch(date.getDayOfWeek().toString()) {
			case "SUNDAY":
				return "Sunday";
			case "MONDAY":
				return "Monday";
			case "TUESDAY":
				return "Tuesday";
			case "WEDNESDAY":
				return "Wednesday";
			case "THURSDAY":
				return "Thursday";
			case "FRIDAY":
				return "Friday";
			case "SATURDAY":
				return "Saturday";
			default:
				return null;
		}
	}


	private int fibonacci(int n) {
		if(n <= 1)
			return n;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public int countWays(int n) {
		return fibonacci(n + 1);
	}

	public void a() {


	}

	//leetcode 96
	public int numTrees(int n) {
		int[] count = new int[n + 1];

		count[0] = 1;
		count[1] = 1;

		for(int i = 2; i <= n; i++) {
			for(int j = 0; j <= i - 1; j++) {
				count[i] = count[i] + count[j] * count[i - j - 1];
			}
		}

		return count[n];
	}


	public List<String> prioritizedOrders(int numOrders, List<String> orderList) {
		List<String> answer = new ArrayList<>();

		List<String> prime = new ArrayList<>();
		List<String> nonPrime = new ArrayList<>();

		for(String order : orderList) {
			if(order.substring(order.indexOf(" ") + 1).matches("^ *[0-9][0-9 ]*$"))
				nonPrime.add(order);
			else
				prime.add(order);
		}

		Map<String, String> primeOrdersMeta = new HashMap<>();
		List<String> primeMeta = new ArrayList<>();

		for(int i = 0; i < prime.size(); i++) {
			primeOrdersMeta.put(prime.get(i).substring(prime.get(i).indexOf(" ") + 1), prime.get(i));
			primeMeta.add(prime.get(i).substring(prime.get(i).indexOf(" ") + 1));
		}
		Collections.sort(primeMeta);
		for(String m : primeMeta) {
			if(primeOrdersMeta.containsKey(m)) {
				answer.add(primeOrdersMeta.get(m));
				prime.remove(prime.indexOf(primeOrdersMeta.get(m)));
				primeOrdersMeta.remove(m);
			} else {
				for(int i = 0; i < prime.size(); i++) {
					if(prime.get(i).contains(m)) {
						answer.add(prime.get(i));
					}

				}
			}

		}
		answer.addAll(nonPrime);
		return answer;
	}


	//PayPal HackerRank
	public int minMoves(List<Integer> a, List<Integer> m) {
		int moves = 0;

		List<Integer> aComplete = new ArrayList<>();
		List<Integer> mComplete = new ArrayList<>();

		for(int num : a) {
			while(num > 0) {
				aComplete.add(num % 10);
				num = num / 10;
			}
		}
		for(int num : m) {
			while(num > 0) {
				mComplete.add(num % 10);
				num = num / 10;
			}
		}

		for(int i = 0; i < mComplete.size(); i++) {
			int diff = mComplete.get(i) - aComplete.get(i);
			moves = moves + Math.abs(diff);
		}

		return moves;
	}


	//PayPal HackerRank
	public List<String> doesCircleExist(List<String> commands) {
		List<String> answer = new ArrayList<>();
		int xCoordinate = 0;
		int yCoordinate = 0;
		String currentDirection = "NORTH";


		for(String command : commands) {
			for(char action : command.toCharArray()) {
				switch(currentDirection) {
					case "NORTH":
						switch(action) {
							case 'G': yCoordinate++;
								break;
							case 'L': currentDirection = "WEST";
								break;
							case 'R': currentDirection = "EAST";
								break;
							default: System.out.println("Invalid Action");
						}
						break;
					case "EAST":
						switch(action) {
							case 'G': xCoordinate++;
								break;
							case 'L': currentDirection = "NORTH";
								break;
							case 'R': currentDirection = "SOUTH";
								break;
							default: System.out.println("Invalid Action");
						}
						break;
					case "SOUTH":
						switch(action) {
							case 'G': yCoordinate--;
								break;
							case 'L': currentDirection = "EAST";
								break;
							case 'R': currentDirection = "WEST";
								break;
							default: System.out.println("Invalid Action");
						}
						break;
					case "WEST":
						switch(action) {
							case 'G': xCoordinate--;
								break;
							case 'L': currentDirection = "SOUTH";
								break;
							case 'R': currentDirection = "NORTH";
								break;
							default: System.out.println("Invalidd Action");
						}
						break;
					default: System.out.println("Invalid vdirection");
				}
			}

			if(currentDirection.equals("NORTH") && ((xCoordinate * xCoordinate) + (yCoordinate * yCoordinate) > 0))
				answer.add("NO");
			else
				answer.add("YES");
		}
		return answer;
	}

	//leetcode 640
	public String solveEquation(String equation) {
		return null;
	}

}