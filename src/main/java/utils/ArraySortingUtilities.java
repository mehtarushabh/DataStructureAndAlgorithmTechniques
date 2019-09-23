package utils;

/*
 * @author: Rushabh Mehta
 * */

public class ArraySortingUtilities {

	private final int[] originalInput;
	private int[] inputArray;

	public ArraySortingUtilities(final int[] input) {
		this.originalInput = input.clone();
		this.inputArray = input.clone();
	}

	public void printArray() {
		for (int value : this.inputArray) System.out.println(value);
	}

	public void resetInput() {
		this.inputArray = this.originalInput.clone();
	}

	public void bubbleSort() {
		for (int i = this.inputArray.length - 1; i > 0; i--)
			for (int j = 0; j < i; j++)
				if (this.inputArray[j] > this.inputArray[j + 1])
					swapElements(this.inputArray, j, j + 1);
	}

	public void selectionSort() {
		for (int lui = this.inputArray.length - 1; lui > 0; lui--) {
			int largest = 0;
			for (int i = 1; i <= lui; i++) {
				if (this.inputArray[i] > this.inputArray[largest])
					largest = i;
			}
			swapElements(this.inputArray, largest, lui);
		}
	}

	public void insertionSort() {
		for (int fui = 0; fui < this.inputArray.length; fui++) {
			int newElement = this.inputArray[fui];
			int i;
			for (i = fui; i > 0 && this.inputArray[i - 1] > newElement; i--)
				this.inputArray[i] = this.inputArray[i - 1];
			this.inputArray[i] = newElement;
		}
	}

	public void mergeSort() {
		mergeSortUtil(this.inputArray, 0, this.inputArray.length);
	}

	public void quickSort() {
		quickSortUtil(this.inputArray, 0, this.inputArray.length);
	}

	private void quickSortUtil(int[] input, int start, int end) {
		if (end - start < 2)
			return;

		int pivot = quickSortPartition(input, start, end);
		quickSortUtil(input, start, pivot);
		quickSortUtil(input, pivot + 1, end);
	}

	private int quickSortPartition(int[] input, int start, int end) {
		int pivot = input[start];
		int i = start;
		int j = end;

		while (i < j) {
			while (i < j && input[--j] >= pivot) ;
			if (i < j) {
				input[i] = input[j];
			}

			while (i < j && input[++i] <= pivot) ;
			if (i < j) {
				input[j] = input[i];
			}
		}
		input[j] = pivot;
		return j;
	}


	private void mergeSortUtil(int[] input, int startIndex, int endIndex) {
		if (endIndex - startIndex < 2)
			return;
		int mid = (startIndex + endIndex) / 2;

		mergeSortUtil(input, startIndex, mid);
		mergeSortUtil(input, mid, endIndex);
		mergeSortArraysMerge(input, startIndex, mid, endIndex);
	}

	private void mergeSortArraysMerge(int[] input, int startIndex, int mid, int endIndex) {
		if (input[mid - 1] <= input[mid])
			return;

		int i = startIndex, j = mid, tempIndex = 0;
		int[] temp = new int[endIndex - startIndex];

		while (i < mid && j < endIndex)
			temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];

		System.arraycopy(input, i, input, startIndex + tempIndex, mid - i);
		System.arraycopy(temp, 0, input, startIndex, tempIndex);
	}

	private void swapElements(int[] input, int first, int second) {
		if (first == second)
			return;
		else {
			int temporary = input[first];
			input[first] = input[second];
			input[second] = temporary;
		}
	}
}