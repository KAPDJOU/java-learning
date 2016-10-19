package OCP;

public class Chap1_Enum {
    public static void main(String args[]) {
    }
}

// @formatter:off

/** Simple Enum */

enum Season {
    WINTER, SPRING, SUMMER, FALL
}

class playSeason {
    public static void main(String args[]) {
        Season s = Season.SUMMER;
        System.out.println(Season.SUMMER); // SUMMER
        System.out.println(s == Season.SUMMER); // true
        System.out.println(s.equals(Season.SUMMER)); // true
        System.out.println("SUMMER".equals(Season.SUMMER)); // false

        // values() | get an array of all of the values
        for (Season season : Season.values()) {
            System.out.println(season.ordinal() + " " + season.name());
        }

        // valueOf() | create an enum from a String
        Season s1 = Season.valueOf("SUMMER"); // SUMMER
        // Season s2 = Season.valueOf("summer"); // IllegalArgumentException, No enum constant enums.Season.summer

        // Using Enums in Switch Statements
        Season summer = Season.SUMMER;
        switch (summer) {
        // case Season.SPRING: // DOES NOT COMPILE
        case WINTER:
            System.out.println("Get out the sled!");
            break;
        case SUMMER:
            System.out.println("Time for the pool!");
            break;
        default:
            System.out.println("Is it summer yet?");
        }
    }
}

/** Adding Constructors, Fields, and Methods */

enum Season2 {
    WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium");
    private String expectedVisitors; // the enum value

    // private constructor
    private Season2(String expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
    }

    public void printExpectedVisitors() {
        System.out.println(expectedVisitors);
    }
}

class playSeason2 {
    public static void main(String args[]) {
        System.out.println(Season2.SUMMER.name()); // SUMMER

        Season2.SUMMER.printExpectedVisitors(); // High
        Season2.FALL.printExpectedVisitors(); // Medium
    }
}

/** abstract and defaut method */

enum Season3 {
    WINTER {
        public void printHours() { System.out.println("short hours 9am-3pm"); }
        public void printExpectedVisitors() { System.out.println("Low"); }
    }, SPRING {
        public void printHours() { System.out.println("9am-5pm"); }
    }, SUMMER {
        public void printHours() { System.out.println("long hours 9am-7pm"); }
    }, FALL {
        public void printHours() { System.out.println("9am-5pm"); }
    };
    
    public abstract void printHours();
    public void printExpectedVisitors() { System.out.println("default hours"); }
}

class playSeason3 {
    public static void main(String args[]) {
        Season3.WINTER.printExpectedVisitors(); // Low
        Season3.SPRING.printExpectedVisitors(); // default
        Season3.FALL.printHours(); // 9am-5pm
    }
}


/** Constructor is caling only once by java */

enum OnlyOne {
    ONCE(true);
    
    private OnlyOne(boolean b) {
        System.out.println("constructing");
    }

    public static void main(String[] args) {
        OnlyOne firstCall = OnlyOne.ONCE; // prints constructing
        OnlyOne secondCall = OnlyOne.ONCE; // doesn't print anything
    }
}

//@formatter:on