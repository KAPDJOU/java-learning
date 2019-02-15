package algorithm;

/**
 * Itw Technichal Test
 * <p>
 * Array having list of interger, from 1 to 100. One number is missing. You have to find missing number and its index.
 * <p>
 * My Answer: We will calculate sum of integers present in array lets say Sum, and we will calculate sum of number from
 * 1
 * to 100 using x = n(n+1)/2.
 * <p>
 * then x-Sum will give you the missing number. He said I am just telling him the formula n blah blah. Finally i asked
 * his answer
 * <p>
 * His Answer: Funny one. We will have a for loop, for(i=1; i&amp;amp;lt;100; i++){ if(a[i] == null) //print i and a[i];
 * } lolz... please anybody tell me how this logic can output your missing number. And if u know null is the number,
 * then why are you looping and making it o(n) complexity. I think he googled the interview question, but not the
 * answers or approach :P
 * 
 * @author a614412
 * @see https://www.javacodegeeks.com/2018/04/how-to-find-k-missing-numbers-in-integer-array-with-duplicates-in-java.html
 */
public class MissingNumberInArray {

    public static void main(String[] args) {

	// given input
	int[] input = { 1, 1, 2, 3, 5, 5, 7, 9, 9, 9 };

	// let's create another array with same length
	// by default all index will contain zero
	// default value for int variable

	int[] register = new int[input.length];

	// now let's iterate over given array to
	// mark all present numbers in our register
	// array

	for (int i : input) {
	    register[i] = 1;
	}

	// now, let's print all the absentees
	System.out.println("missing numbers in given array");

	for (int i = 1; i < register.length; i++) {
	    if (register[i] == 0) {
		System.out.println(i);
	    }
	}
    }
}
