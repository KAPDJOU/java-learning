package OCP.Chap3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Chap3_List_Set_Queue_Map {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}




/** Array and ArrayList | @see page 104 */

class PlayArraysAndList {
    public static void main(String[] args) {

        // TODO move and merge with OCA code  
     // linkedList
        {
            
        }
        // ArrayList
        {
            
        }
        
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


/** Set | Page 132 */

class PlaySet {
    public static void main(String[] args) {
        // Hashset
        {
            Set<Integer> set = new HashSet<>();
            boolean b1 = set.add(66); // true
            boolean b2 = set.add(10); // true
            boolean b3 = set.add(66); // false
            boolean b4 = set.add(8); // true
            System.out.print("HashSet : " );
            for (Integer integer: set) System.out.print(integer + ","); // 66,8,10,
            
        }
        // TreeSet
        {
            Set<Integer> set = new TreeSet<>();
            boolean b1 = set.add(66); // true
            boolean b2 = set.add(10); // true
            boolean b3 = set.add(66); // false
            boolean b4 = set.add(8); // true
            System.out.println();
            System.out.print("TreeSet : "  );
            for (Integer integer: set) System.out.print(integer + ","); // 8,10,66
            
            NavigableSet<Integer> set2 = new TreeSet<>();
            for (int i = 1; i <= 20; i++) set2.add(i);
            System.out.println();
            System.out.println(set2.lower(10)); // 9
            System.out.println(set2.floor(10)); // 10
            System.out.println(set2.ceiling(20)); // 20
            System.out.println(set2.higher(20)); // null
        }
    }
}


/** Set | Page 132 */

class PlayQueue {
    public static void main(String[] args) {
        // Queue 
        {
            Queue<Integer> queue = new ArrayDeque<>();
            System.out.println(queue.offer(10)); // true // [10]
            System.out.println(queue.offer(4)); // true // [10, 4]
            System.out.println(queue.peek()); // 10 // [10, 4]
            System.out.println(queue.poll()); // 10 // [4]
            System.out.println(queue.poll()); // 4 // []
            System.out.println(queue.peek()); // null // []    
        }
        // ArrayDeque
        {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            stack.push(10); // [10]
            stack.push(4); // [4, 10]
            System.out.println(stack.peek()); //4 // [4, 10]
            System.out.println(stack.poll()); // 4 // [10]
            System.out.println(stack.poll()); // 10
            System.out.println(stack.peek()); // null
        }
    }
}

/** Set | Page 138 */

class PlayMap {
    public static void main(String[] args) {
        // HashMap
        {            
            Map<String, String> map = new HashMap<>();
            map.put("koala", "bamboo");
            map.put("lion", "meat");
            map.put("giraffe", "leaf");
            String food = map.get("koala"); // bamboo
            for (String key: map.keySet())
            System.out.print(key + ","); // koala,giraffe,lion,
        }
        // TreeMap
        {
            Map<String, String> map = new TreeMap<>();
            map.put("koala", "bamboo");
            map.put("lion", "meat");
            map.put("giraffe", "leaf");
            String food = map.get("koala"); // bamboo
            for (String key: map.keySet())
            System.out.print(key + ","); // giraffe,koala,lion,    
            
            // System.out.println(map.contains("lion")); // DOES NOT COMPILE, method on the Collection interface but not the Map interface. 
            System.out.println(map.containsKey("lion")); // true
            System.out.println(map.containsValue("lion")); // false
            System.out.println(map.size()); // 3
        }
        
    }
}       