package OCP.Chap3;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
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
        
        
        {
            Queue<Integer> queue = new ArrayDeque<>();
            System.out.println(queue.offer(10)); // true // [10]
            System.out.println(queue.offer(4)); // true // [10, 4]
            System.out.println(queue.peek()); // 10 // [10, 4]
            System.out.println(queue.poll()); // 10 // [4]
            System.out.println(queue.poll()); // 4 // []
            System.out.println(queue.peek()); // null // []    
        }
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