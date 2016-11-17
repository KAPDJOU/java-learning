package OCP.chap4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chap4_Stream_Advanced {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}


/** Working with Advanced Stream Pipeline Concepts | @see page 213 */

class PlayStream {
    public static void main(String[] args) {
     
        /** Linking Streams to the Underlying Data */
        {
            List<String> cats = new ArrayList<>();
            cats.add("Annie");
            cats.add("Ripley");
            Stream<String> stream = cats.stream();
            cats.add("KC");
            System.out.println(stream.count()); // The correct answer is 3
        }

        
        /** Collecting Results */
        // Collecting Using Basic Collectors
        {
           
            Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
            String result = ohMy.collect(Collectors.joining(", "));
            System.out.println(result); // lions, tigers, bears
        }
        {
            // the average length of the three animal names
            Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
            Double result = ohMy.collect(Collectors.averagingInt(String::length));
            System.out.println(result); // 5.333333333333333
        } {
            // using a Stream and then convert to a Collection at the end
            Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
            TreeSet<String> result = ohMy.filter(s -> s.startsWith("t"))
                    .collect(Collectors.toCollection(TreeSet::new));
            System.out.println(result); // [tigers]
        }
        /** Collecting into Maps */
        {
            // create a map from a stream
            Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
            Map<String, Integer> map = ohMy.collect(Collectors.toMap(s -> s, String::length));
            System.out.println(map); // {lions=5, bears=5, tigers=6}
        }{
            // map the length of the animal name to the name itself.
            Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
            TreeMap<Integer, String> map = ohMy.collect(Collectors.toMap(
                                             String::length,k -> k, (s1, s2) -> s1 + "," + s2, TreeMap::new));
            System.out.println(map); // // {5=lions,bears, 6=tigers}
            System.out.println(map.getClass()); // class. java.util.TreeMap
        }
        /** Collecting Using Grouping, Partitioning, and Mapping */
        {
            // we want to get groups of names by their length
            Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
            Map<Integer, List<String>> map = ohMy.collect(Collectors.groupingBy(String::length));
            System.out.println(map); // {5=[lions, bears], 6=[tigers]}
        } {
            Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
            Map<Integer, Set<String>> map = ohMy.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
            System.out.println(map); // {5=[lions, bears], 6=[tigers]}
        } {
            Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
            TreeMap<Integer, Set<String>> map = ohMy.collect(
                        Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
            System.out.println(map); // {5=[lions, bears], 6=[tigers]}
        } {
            Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
            TreeMap<Integer, List<String>> map = ohMy.collect(
            Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
            System.out.println(map);
        }
        // partitioning
        {
            // We have two sizes of signs. One can accommodate names with five or fewer characters. The other is needed for longer names.
            Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
            Map<Boolean, List<String>> map = ohMy.collect(Collectors.partitioningBy(s -> s.length() <= 5));
            System.out.println(map); // {false=[tigers], true=[lions, bears]}
        } {
            Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
            Map<Boolean, List<String>> map = ohMy.collect(Collectors.partitioningBy(s -> s.length() <= 7));
            System.out.println(map); // {false=[], true=[lions, tigers, bears]}
        } {
            Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
            Map<Boolean, Set<String>> map = ohMy.collect(
            Collectors.partitioningBy(s -> s.length() <= 7, Collectors.toSet()));
            System.out.println(map);// {false=[], true=[lions, tigers, bears]}
        } {
            // we can group by the length of the animal name to see how many of each length we have:
            Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
            Map<Integer, Long> map = ohMy.collect(Collectors.groupingBy(String::length, Collectors.counting()));
            System.out.println(map); // {5=2, 6=1}
        }
        // mapping
        {
            //  get the first letter of the first animal alphabetically of each length. 
            Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
            Map<Integer, Optional<Character>> map = ohMy.collect(
                    Collectors.groupingBy(
                    String::length,
                    Collectors.mapping(s -> s.charAt(0),
                    Collectors.minBy(Comparator.naturalOrder()))));
                    System.out.println(map); // {5=Optional[b], 6=Optional[t]}
        }
    }
    
    /** Chaining Optionals */
    //  given an Optional<Integer> and asked to print the value, but only if it is a three-digit number.
    private static void threeDigit(Optional<Integer> optional) {
        optional.map(n -> "" + n) // part 1
        .filter(s -> s.length() == 3) // part 2
        .ifPresent(System.out::println); // part 3
        }
    // get an Optional<Integer> representing the length of the String contained in another Optional. 
    private static void optionnalLength(Optional<String> optional) {
        Optional<Integer> result = optional.map(String::length);
    }
    

    
}