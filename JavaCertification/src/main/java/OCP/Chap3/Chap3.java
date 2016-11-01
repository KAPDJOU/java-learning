package OCP.Chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashMap;
import java.util.List;

public class Chap3 {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

/** Array and ArrayList | @see page 104 */

class PlayArraysAndList {
    public static void main(String[] args) {

        // TODO move and merge with OCA code  
        
        /* Diamond Operator */
        {
            // before java 5
            List names1 = new ArrayList();
            // since java 5
            List<String> names2 = new ArrayList<String>();
            // since java 7, diamond Operator
            List<String> names3 = new ArrayList<>();
            HashMap<String, HashMap<String, String>> map2 = new HashMap<>();

        }
        /* */
        {
            List<String> list = new ArrayList<>(); // empty list
            list.add("Fluffy"); // [Fluffy]
            list.add("Webby"); // [Fluffy, Webby]
            String[] array = new String[list.size()]; // empty array
            array[0] = list.get(1); // [Webby]
            array[1] = list.get(0); // [Webby, Fluffy]
            for (int i = 0; i < array.length; i++)
                System.out.print(array[i] + "-"); // Webby-Fluffy-
        }

        {
            String[] array1 = { "gerbil", "mouse" }; // [gerbil, mouse]
            List<String> list1 = Arrays.asList(array1); // returns fixed size list
            list1.set(1, "test"); // [gerbil, test]
            array1[0] = "new"; // [new, test]
            String[] array2 = (String[]) list1.toArray(); // [new, test]
            list1.remove(1); // throws UnsupportedOperationException | list is not resizable
        }

        /* Searching and Sorting */
        {
            int[] numbers = { 6, 9, 1, 8 };
            Arrays.sort(numbers); // [1,6,8,9]
            System.out.println(Arrays.binarySearch(numbers, 6)); // 1
            System.out.println(Arrays.binarySearch(numbers, 3)); // -2
        }
        {
            List<Integer> list = Arrays.asList(9, 7, 5, 3);
            Collections.sort(list); // [3, 5, 7, 9]
            System.out.println(Collections.binarySearch(list, 3)); // 0
            System.out.println(Collections.binarySearch(list, 2)); // -1
        }
        /* Wrapper Classes and Autoboxing */
        {
            // code moved in OCA
        }

    }
}
