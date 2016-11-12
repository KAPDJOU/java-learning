package OCP.ReviewQuestions;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Chap3_RQ {
    public static void main(String[] args) {
    }
}

/** Question 3 */
class Chap3_Q3 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add(7);
        // for (String s : list) System.out.print(s); // DOES not compile, mix generic and legacy code
    }
}

/** Question 4 */
class Chap3_Q4 {
    public static void main(String[] args) {
        ArrayDeque<String> greetings = new ArrayDeque<String>();
        greetings.push("hello"); // push use a LIFO(lat in, first out)
        greetings.push("hi"); 
        greetings.push("ola");
        greetings.pop(); // remove "ola" , last element added
        greetings.peek(); // look at new last element, but dont remove it
        while (greetings.peek() != null)
        System.out.print(greetings.pop());  
        
        //output : hihello
    }
}

/** Question 6 */
class Chap3_Q6 {
    public static void main(String[] args) {

    }
}
class Hello<T> {
    T t;
    public Hello(T t) { this.t = t; }
    public String toString() { return t.toString(); }
    public static void main(String[] args) {
        System.out.print(new Hello<String>("hi")); // create hello class with generics type String
        System.out.print(new Hello("there")); // compile warning, create hello class with generics type Object
        
        // output | hithere
    } 
}

/** Question 7 */
class Chap3_Q7 {
    public static void main(String[] args) {
        Set<Number> numbers = new HashSet<>();
        numbers.add(new Integer(86));
        numbers.add(75);
        numbers.add(new Integer(86));
        numbers.add(null);
        numbers.add(309L);
        Iterator iter = numbers.iterator();
        while (iter.hasNext())
        System.out.print(iter.next());
        
        // The output is indeterminate. eg: null3098675
    }
}


/** Question 8 */
class Chap3_Q8 {
    public static void main(String[] args) {
        TreeSet<String> tree = new TreeSet<String>();
        tree.add("one");
        tree.add("One");
        tree.add("ONE");
        System.out.println(tree.ceiling("On")); 
        
        // output : One
    }
}


/** Question 10 */
class Chap3_Q10 {
    public static void main(String[] args) {

    }
}
class MyComparator implements Comparator<String> {
    public int compare(String a, String b) {
        return b.toLowerCase().compareTo(a.toLowerCase());
    }
    public static void main(String[] args) {
        String[] values = { "123", "Abb", "aab" };
        Arrays.sort(values, new MyComparator()); // sort elements in reverse alphabetcal order in case insensitive fashion
        for (String s: values)
        System.out.print(s + " ");
        
        // ouput : Abb aab 123
    }
}

/** Question 11 */
class Chap3_Q11 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>(10);
            for (int i = 1; i <= 10; i++) {
            map.put(i, i * i);
        }
        System.out.println(map.get(4));
        
        // output : 16
    }
}


/** Question 12 */
class Chap3_Q12 {
    public static void main(String[] args) {

    }
}
class Helper {
    public static <U extends Exception> void printException(U u) {
        System.out.println(u.getMessage());
    }
    public static void main(String[] args) {
       // __________________________________ statement can fill in the blank
        Helper.printException(new FileNotFoundException("A"));
        Helper.printException(new Exception("B"));
        Helper.<NullPointerException>printException(new NullPointerException("D"));
    } 
}


/** Question 14 */
class Chap3_Q14 {
    public static void main(String[] args) {
        Sorted s1 = new Sorted(88, "a");
        Sorted s2 = new Sorted(55, "b");
        TreeSet<Sorted> t1 = new TreeSet<>();
        t1.add(s1); 
        t1.add(s2);
        TreeSet<Sorted> t2 = new TreeSet<>(s1);
        t2.add(s1); t2.add(s2);
        System.out.println(t1 + " " + t2);
        
        // output : [88, 55] [55, 88]
    }
}
class Sorted implements Comparable<Sorted>, Comparator<Sorted> {
    private int num;
    private String text;
    Sorted(int n, String t) {
        this.num = n;
        this.text = t;
    }
    public String toString() { return "" + num; }
    public int compareTo(Sorted s) { return text.compareTo(s.text); }
    public int compare(Sorted s1, Sorted s2) { return s1.num - s2.num; }
    
}

/** Question 15 */
class Chap3_Q15 {
    public static void main(String[] args) {
        Comparator<Integer> c = (o1, o2) -> o2 - o1;
        List<Integer> list = Arrays.asList(5, 4, 7, 1);
        Collections.sort(list, c); // sorted in descending order
        System.out.println(Collections.binarySearch(list, 1)); // search in default ascending order
        
        // binarySearch required both use the same order , result is undefined, 
    }
}


/** Question 18 */
class Chap3_Q18 {
    public static void main(String[] args) {

    }
}

/** Question 20 */
class Chap3_Q20 {
    public static void main(String[] args) {

    }
}

/** Question 25 */
class Chap3_Q25 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, null);
        map.merge(1, 3, (a,b) -> a + b); // call mapping funtin and adds two number to get 13, then updates the maps
        map.merge(3, 3, (a,b) -> a + b); // not call the mapping function, replacce the null with new value of 3
        System.out.println(map);
        
        // ouptut : {1=13, 2=20, 3=3}
    }
}
