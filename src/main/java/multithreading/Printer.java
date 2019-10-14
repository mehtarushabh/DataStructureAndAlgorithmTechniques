package multithreading;
/*
 * @author: Rushabh Mehta
 * */

public class Printer {
	synchronized void printDocument(int copies, String name) {
		for(int i = 0; i < copies; i++)
			System.out.println("Printing " + name + " " + (i + 1) + " time");
	}
}