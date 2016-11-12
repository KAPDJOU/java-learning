package OCP.Chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/** @see Page 152 */

public class Chap3_Java8 {
    public static void main(String[] args) {

        // Using Method References

        Consumer<List<Integer>> methodRef1 = Collections::sort;
        Consumer<List<Integer>> lambda1 = l -> Collections.sort(l);

        String str = "abc";
        Predicate<String> methodRef2 = str::startsWith;
        Predicate<String> lambda2 = s -> str.startsWith(s);

        Predicate<String> methodRef3 = String::isEmpty;
        Predicate<String> lambda3 = s -> s.isEmpty();

        Supplier<ArrayList> methodRef4 = ArrayList::new;
        Supplier<ArrayList> lambda4 = () -> new ArrayList();

        // removeIf | Removing Conditionally
        {
            List<String> list = new ArrayList<>();
            list.add("Magician");
            list.add("Assistant");
            System.out.println(list); // [Magician, Assistant]
            list.removeIf(s -> s.startsWith("A"));
            System.out.println(list); // [Magician]
        }

        // replaceAll | Updating All Elements
        {
            List<Integer> list = Arrays.asList(1, 2, 3);
            list.replaceAll(x -> x * 2);
            System.out.println(list); // [2, 4, 6]
        }

        // forEach | Looping through a Collection
        {
            List<String> cats = Arrays.asList("Annie", "Ripley");
            // with consumer
            cats.forEach(c -> System.out.println(c));
            // with method reference
            cats.forEach(System.out::println);
        }

        // java 8 Map APIs
        // putIfAbsent | update the value for a specific key in the map
        {
            Map<String, String> favorites = new HashMap<>();
            favorites.put("Jenny", "Bus Tour");
            favorites.put("Tom", null);

            favorites.putIfAbsent("Jenny", "Tram"); // Jenny’s value is not updated because one was already present.
            favorites.putIfAbsent("Sam", "Tram");
            favorites.putIfAbsent("Tom", "Tram");
            System.out.println(favorites); // {Tom=Tram, Jenny=Bus Tour, Sam=Tram}
        }
        // java 8 Map APIs
        // merge | allows adding logic to the problem of what to choose
        {
            BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;

            Map<String, String> favorites = new HashMap<>();
            favorites.put("Jenny", "Bus Tour");
            favorites.put("Tom", "Tram");
            favorites.put("Sam", null);

            String jenny = favorites.merge("Jenny", "Skyride", mapper);
            String tom = favorites.merge("Tom", "Skyride", mapper);
            favorites.merge("Sam", "Skyride", mapper);

            System.out.println(favorites); // {Tom=Skyride, Jenny=Bus Tour, Sam=Skyride}
            System.out.println(jenny); // Bus Tour
            System.out.println(tom); // Skyride

        }
        {
            BiFunction<String, String, String> mapper = (v1, v2) -> null;
            Map<String, String> favorites = new HashMap<>();
            favorites.put("Jenny", "Bus Tour");
            favorites.put("Tom", "Bus Tour");
            
            favorites.merge("Jenny", "Skyride", mapper);
            favorites.merge("Sam", "Skyride", mapper);
            System.out.println(favorites); // {Tom=Bus Tour, Sam=Skyride}
        }
        // java 8 Map APIs
        // computeIfPresent and computeIfAbsent
        {
            Map<String, Integer> counts = new HashMap<>();
            counts.put("Jenny", 1);
            
            BiFunction<String, Integer, Integer> mapper = (k, v) -> v + 1;
            Integer jenny = counts.computeIfPresent("Jenny", mapper);
            Integer sam = counts.computeIfPresent("Sam", mapper);
            System.out.println(counts); // {Jenny=2}
            System.out.println(jenny); // 2
            System.out.println(sam); // null
        }
        {
            Map<String, Integer> counts = new HashMap<>();
            counts.put("Jenny", 15);
            counts.put("Tom", null);
            
            Function<String, Integer> mapper = (k) -> 1;
            Integer jenny = counts.computeIfAbsent("Jenny", mapper); // 15
            Integer sam = counts.computeIfAbsent("Sam", mapper); // 1
            Integer tom = counts.computeIfAbsent("Tom", mapper); // 1
            System.out.println(counts); // {Tom=1, Jenny=15, Sam=1}
        }
        {
            Map<String, Integer> counts = new HashMap<>();
            counts.put("Jenny", 1);
            
            counts.computeIfPresent("Jenny", (k, v) -> null); // removes the key from the map.
            counts.computeIfAbsent("Sam", k -> null); //  doesn’t add a key
            System.out.println(counts); // {}
        }
    }
}

class DuckHelper {
    public static int compareByWeight(Duck d1, Duck d2) {
        return d1.getWeight() - d2.getWeight();
    }

    public static int compareByName(Duck d1, Duck d2) {
        return d1.getName().compareTo(d2.getName());
    }
}

class playDuckHelper {
    public static void main(String[] args) {

        Comparator<Duck> byWeight = DuckHelper::compareByWeight;
        // equivlent of : (d1, d2) -> DuckHelper.compareByWeight(d1, d2);

    }
}
