import java.io.*;
import java.util.*;

public class Main {
	static int sortedArray[];
	
	/**
	 * Description: Write data from file "path" to an ArrayList "list"
	 * @param path - path to the file which is supposed to be read
	 * @param list - ArrayList which should contain read data.
	 * return Creating list.
	 * */
	public static void readToList (String path, List<String> list){
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}
	}
	
	/**
	 * Description: Sorting "array" by selectionSort method
	 * @param array - array which should be sorted
	 * return Sorted array.
	 * */
	public static void selectionSort(int array[]) {
		for (int i = 0; i < array.length; i++) {
			
			//Suppose that 1 element of the array C is minimal. Remember it's value and index.
			int min = array[i];
			int imin = i;
			//In the array C except 1st element, which we supposed to be minimal, trying to find any element which is < min.
			for (int j = i + 1; j < array.length; j++) {
				// If current arrayC element is < min, then min = this element and index of min = index of current
				if (array[j] < min) {
					min = array[j];
					imin = j;
				}
			}
			//If there is found an element < than element on position i, then swap them.
			if (i != imin) {
				int tmp = array[i];
				array[i] = array[imin];
				array[imin] = tmp;
			}
		}
	}
	
	public static int getSortedArray(int id) {
		if (id >= 0 && id < 9)
		return sortedArray[id];
		else return 0;
	}
	public static void setSortedArray(int newValue, int id) {
		if (id >= 0 && id < 9) {
			sortedArray[id] = newValue;
		}
	}
	
	public static void main(String[] args) {
		List<String> A = new ArrayList<String>();
		List<String> B = new ArrayList<String>();
		
		//Read elements by line from file A.txt
		readToList("src/A.txt", A);  //Creating a String ArrayList "A" by calling method readToList
		
		//Read elements by line from file B.txt		
		readToList("src/B.txt", B);	 //Creating a String ArrayList "B" by calling method readToList

		//End of Read elements from file
		
		int arrayA[] = new int[A.size()];
		int arrayB[] = new int[B.size()];
		int cSize = A.size() + B.size();
		int arrayC[] = new int[cSize];

		System.out.println("\n A: \n");
		for (int i = 0; i < A.size(); i++) {
			arrayA[i] = Integer.valueOf(A.get(i)).intValue();
			System.out.println(arrayA[i]);
		} // Array A type of int, created from A ArrayList type of String

		System.out.println("\n B: \n");
		for (int i = 0; i < B.size(); i++) {
			arrayB[i] = Integer.valueOf(B.get(i)).intValue();
			System.out.println(arrayB[i]);
		} // Array B type of int, created from B ArrayList type of String

		// Creating C = A + B
		for (int i = 0; i < arrayA.length; i++) {
			arrayC[i] = arrayA[i];
		}
		int m = 0;
		for (int i = arrayA.length; i < cSize; i++) {
			arrayC[i] = arrayB[m];
			m++;
		}
		// End of creating C

		selectionSort(arrayC); //Sorting C by calling method selectionSort
		// End of sorting C
		sortedArray = new int[cSize];
		System.out.println("\n Result of sorting C = A + B: \n");
		for (int i = 0; i < cSize; i++) {
			System.out.println(arrayC[i]);
			setSortedArray(arrayC[i], i);
		}
	}
}
