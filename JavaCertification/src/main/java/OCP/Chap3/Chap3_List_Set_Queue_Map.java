package OCP.Chap3;

import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
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
            
        }
    }
}