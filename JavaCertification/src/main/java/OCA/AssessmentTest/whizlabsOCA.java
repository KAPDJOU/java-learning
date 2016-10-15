package OCA.AssessmentTest;

import java.util.ArrayList;
import java.util.List;

/**
 * FREE TEST from whizlabs.com
 * 
 * @see http://www.whizlabs.com/ocajp-scja/
 */
public class whizlabsOCA {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

/**
 * Question 4
 */

class Question4 {
    public static void main(String[] args) {
        int sum = 0;
        for (int x = 0; x <= 10; x++)
            sum += x;
        // System.out.println("Sum for 0 to " + x); // error on this given line, Loop variable scoop limited to that
        // enclosed scope
        System.out.println("=" + sum); // 55
    }
}

/** Question 8 */
class Question8 {
    public static void main(String[] args) {
        String s = "A";

        switch (s) {
        case "a":
            System.out.println("simple A ");
        default:
            System.out.println("default");
        case "A":
            System.out.println("Capital A");
        }

        // output : Capital A

        // the swith use equlas method of string , so in this case passing A only matches case with A, s only "capital
        // A" will be printed as out
    }
}

/** Question 13 */
class Question13 {
    private String name;
    private boolean pass;

    public static void main(String[] args) {
        Question13 wb = new Question13();
        System.out.print("name =" + wb.name);
        System.out.print(", pass =" + wb.pass);

        // output : name = null, pass = false

        // both varaibles are instance variables, no nedd to initialize them,they take their default values
    }
}

/** Question 23 24 */
class Question23and24 {
    public static void main(String[] args) {
        
        // List<int> list0 = new ArrayList<>(); // not compile, can't use primitive for colletion types
        
        List<Integer> list = new ArrayList<>();
        list.add(21);
        list.add(13);
        list.add(30);
        list.add(11);
        list.add(2);
        list.removeIf(e -> e % 2 == 0); // inset here
        System.out.println(list);  // ouput : [21, 13, 11]
        
        list.add(30);
        list.removeIf(e -> e % 2 != 0);
        System.out.println(list);  // ouput : [30]

    }
}