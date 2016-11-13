package OCP.chap4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Chap4_Functionalinterface {
    public static void main(String[] args) {
    }
}


/** page 174 | Implementing Supplier */

class Play_Supplier{
    public static void main(String[] args) {
    
        { // static method references
            Supplier<LocalDate> s1 = LocalDate::now; // method reference
            Supplier<LocalDate> s2 = () -> LocalDate.now(); // lambda
            LocalDate d1 = s1.get();
            LocalDate d2 = s2.get();
            System.out.println(d1);
            System.out.println(d2);
        }
        { // use a constructor reference to create the object
            Supplier<StringBuilder> s1 = StringBuilder::new;
            Supplier<StringBuilder> s2 = () -> new StringBuilder();
            System.out.println(s1.get());
            System.out.println(s2.get());
        }
        { // using generics to declare what type of Supplier we are using. 
            Supplier<ArrayList<String>> s1 = ArrayList<String>::new;
            ArrayList<String> a1 = s1.get();
            System.out.println(a1);
        }
    }
}

/** Implementing Consumer and BiConsumer */

class Play_Consumer{
    public static void main(String[] args) {
        { // Consumer
            Consumer<String> c1 = System.out::println;
            Consumer<String> c2 = x -> System.out.println(x);
            c1.accept("Annie");
            c2.accept("Annie");
        }
        { // BiConsumer
            Map<String, Integer> map = new HashMap<>();
            BiConsumer<String, Integer> b1 = map::put;
            BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
            b1.accept("chicken", 7);
            b2.accept("chick", 1);
            System.out.println(map); // {chicken=7, chick=1}
        }       
    }
}

/** Implementing Predicate and BiPredicate */
class Play_Predicate{
    public static void main(String[] args) {
        {
            Predicate<String> p1 = String::isEmpty;
            Predicate<String> p2 = x -> x.isEmpty();
            System.out.println(p1.test(""));
            System.out.println(p2.test(""));
        }
        {
            BiPredicate<String, String> b1 = String::startsWith;
            BiPredicate<String, String> b2 = (string, prefix) -> string.startsWith(prefix);
            System.out.println(b1.test("chicken", "chick"));
            System.out.println(b2.test("chicken", "chick"));
        }
    }
}

/** Implementing Function and BiFunction */
class Play_Function{
    public static void main(String[] args) {
        {
            Function<String, Integer> f1 = String::length; //  converts a String to the length of the String
            Function<String, Integer> f2 = x -> x.length();
            System.out.println(f1.apply("cluck")); // 5
            System.out.println(f2.apply("cluck")); // 5
        }
        { //  combines two String objects and produces another String
            BiFunction<String, String, String> b1 = String::concat;
            BiFunction<String, String, String> b2 = (string, toAdd) -> string.concat(toAdd);
            System.out.println(b1.apply("baby ", "chick")); // baby chick
            System.out.println(b2.apply("baby ", "chick")); // baby chick
            
        }
    }
}

/** Implementing UnaryOperator and BinaryOperator */
class Play_UnaryOperator {
    public static void main(String[] args) {
        {
            UnaryOperator<String> u1 = String::toUpperCase;
            UnaryOperator<String> u2 = x -> x.toUpperCase();
            System.out.println(u1.apply("chirp"));
            System.out.println(u2.apply("chirp"));
        }
        {
            BinaryOperator<String> b1 = String::concat; //this does the same thing as the BiFunction example
            BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);
            System.out.println(b1.apply("baby ", "chick")); // baby chick
            System.out.println(b2.apply("baby ", "chick")); // baby chick
        }
    }
}