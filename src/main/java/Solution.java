import multithreading.Printer;
import multithreading.RunnablePrinter;
import utils.IntegerListSkipIterator;
import utils.MiscUtilities;

import java.util.ArrayList;
import java.util.List;


public class Solution {

	public static void main(String args[]) {

		MiscUtilities m = new MiscUtilities();
		List<String> commands = new ArrayList<>();
		commands.add("R");
		commands.add("GL");
		m.doesCircleExist(commands);

	}

	private static void amazonOrderDriverCode(){
		MiscUtilities m = new MiscUtilities();
		List<String> orders = new ArrayList<>();
		orders.add("zld 93 12");
		orders.add("fp kindle book");
		orders.add("10a echo show");
		orders.add("17g 12 25 6");
		orders.add("ab1 kindle book");
		orders.add("125 echo dot second generation");
		m.prioritizedOrders(6, orders);
	}

	private static void threadDriverCode() {
		Printer printer = new Printer();
		new Thread(new RunnablePrinter(printer, 3, "RushabhResume.pdf")).start();
		new Thread(new RunnablePrinter(printer, 3, "JohnResume.pdf")).start();
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