package softTeam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Finding the highest value in an array
 * find the largest number in an array in java by sorting the array and returning the largest number.
 * 
 * finding the min or max value in an unordered array
 * 
 * @link https://www.baeldung.com/java-array-min-max
 * 
 * @author citizendiop
 */
public class LargestInArray {

    public static void main(String args[]) {
	int a[] = { 1, 2, 5, 6, 3, 2 };
	int b[] = { 44, 66, 99, 77, 33, 22, 55 };
	
	System.out.println("Using for loop");
	System.out.println("Largest: " + getLargest(a));
	System.out.println("Largest: " + getLargest(b));
	
	System.out.println();
	System.out.println("Using array Sort");
	System.out.println("Largest: " + getLargest2(a));
	System.out.println("Largest: " + getLargest2(b));
	
	System.out.println();
	System.out.println("Using java 8 stream");
	System.out.println("Largest : " + MaxUsesIntegerComparator(a));
	System.out.println("Largest : " + MaxUsesIntegerComparator(b));
	System.out.println();
	System.out.println("Smallest : " + MinUsesIntegerComparator(a));
	System.out.println("Smallest : " + MinUsesIntegerComparator(b));
    }

    /**
     * sorting the array and returning the largest number.
     */
    public static int getLargest(int[] numbers) {
	int temp;
	int size = numbers.length;
	for (int i = 0; i < size; i++) {
	    for (int j = i + 1; j < size; j++) {
		if (numbers[i] > numbers[j]) {
		    temp = numbers[i];
		    numbers[i] = numbers[j];
		    numbers[j] = temp;
		}
	    }
	}
	return numbers[size - 1];
    }

    /**
     * using Arrays built in sort function
     */
    public static int getLargest2(int[] a) {
	Arrays.sort(a);
	return a[a.length - 1];
    }

    /**
     * using collections
     */
    public static int getLargest3(Integer[] a) {
	List<Integer> list = Arrays.asList(a);
	Collections.sort(list);
	int element = list.get(a.length - 1);
	return element;
    }

    /**
     * Finding the Smallest Value
     */
    public static int MinUsesIntegerComparator(int[] a) {
	return Arrays.stream(a).min().getAsInt();
    }
    
    public static int MaxUsesIntegerComparator(int[] a) {
	return Arrays.stream(a).max().getAsInt();
    }

}