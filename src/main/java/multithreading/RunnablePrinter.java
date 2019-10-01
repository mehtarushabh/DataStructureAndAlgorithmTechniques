package multithreading;
/*
 * @author: Rushabh Mehta
 * */

public class RunnablePrinter implements Runnable {
	private Printer printer;
	private int copies;
	private String documentName;

	public RunnablePrinter(Printer printer, int copies, String documentName) {
		this.printer = printer;
		this.documentName = documentName;
		this.copies = copies;
	}

	@Override
	public void run() {
		printer.printDocument(copies, documentName);
	}
}
