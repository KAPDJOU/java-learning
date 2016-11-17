package OCP.chap4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/** @see page 188 */

public class Chap4_Sream {
    public static void main(String[] args) {
    }
}

/** Creating Stream Sources */

class SourceStreams {
    public static void main(String[] args) {

        // . There are a few ways to create a finite stream:
        Stream<String> empty = Stream.empty(); // count = 0
        Stream<Integer> singleElement = Stream.of(1); // count = 1
        Stream<Integer> fromArray = Stream.of(1, 2, 3); // count = 2

        // convenient way to convert from a list to a stream
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> fromList = list.stream();
        Stream<String> fromListParallel = list.parallelStream(); // process elements in parallel

        // iteratee and generate
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);

    }
}

/** Terminal stream operations */

class StreamTer {
    public static void main(String[] args) {

        // count()
        {
            // This example shows calling count() on a finite stream:
            Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
            System.out.println(s.count()); // 3
        }

        // min() and max()
        { 
            //This example finds the animal with the fewest letters in its name
            Stream<String> s = Stream.of("monkey", "ape", "bonobo");
            Optional<String> min = s.min((s1, s2) -> s1.length() - s2.length());
            min.ifPresent(System.out::println); // ape
        
            Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
            System.out.println(minEmpty.isPresent()); // false
        }
        
        // findAny() and findFirst()
        { 
            // This example finds an animal
            Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
            Stream<String> infinite = Stream.generate(() -> "chimp");
            s.findAny().ifPresent(System.out::println); // monkey
            infinite.findAny().ifPresent(System.out::println); // chimp    
        }
        
        // allMatch(), anyMatch() and noneMatch()
        { 
            // This example checks whether animal names begin with letters
            List<String> list = Arrays.asList("monkey", "2", "chimp");
            Stream<String> infinite = Stream.generate(() -> "chimp");
            Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
            System.out.println(list.stream().anyMatch(pred)); // true
            System.out.println(list.stream().allMatch(pred)); // false
            System.out.println(list.stream().noneMatch(pred)); // false
            System.out.println(infinite.anyMatch(pred)); // true
        }

        // forEach()
        {
            Stream<String> s = Stream.of("Monkey", "Gorilla", "Bonobo");
            s.forEach(System.out::print); // MonkeyGorillaBonobo
        }

        // reduce() | regular reduction
        {
            // concatenate an array of Strings into a single String
            String[] array = new String[] { "w", "o", "l", "f" };
            // 1 - without functional programming
            String result = "";
            for (String s: array) result = result + s;
            System.out.println(result);
            // 2 - With stream and lambda
            Stream<String> stream = Stream.of(array);
            String word1 = stream.reduce("", (s, c) -> s + c);
            System.out.println(word1); // wolf
            // 3 - with stream and a method reference:
            String word2 = Stream.of(array).reduce("", String::concat);
            System.out.println(word2); // wolf

            //  a reduction to multiply all of the Integer objects in a stream
            Stream<Integer> stream2 = Stream.of(3, 5, 6);
            System.out.println(stream2.reduce(1, (a, b) -> a*b)); // 90
            
            // when you dd'ont specify ientify, Optionnal is retuurned
            BinaryOperator<Integer> op = (a, b) -> a * b;
            Stream<Integer> empty = Stream.empty();
            Stream<Integer> oneElement = Stream.of(3);
            Stream<Integer> threeElements = Stream.of(3, 5, 6);
            
            empty.reduce(op).ifPresent(System.out::print); // no output
            oneElement.reduce(op).ifPresent(System.out::print); // 3
            threeElements.reduce(op).ifPresent(System.out::print); // 90

            Stream<Integer> stream3 = Stream.of(3, 5, 6);
            System.out.println(stream3.reduce(1, op, op)); // 90
        }
        
        // collect() | mutable reduction | more efficient
        {
            Stream<String> stream = Stream.of("w", "o", "l", "f");
            StringBuilder word = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
            System.out.println(word); // wolf
            
            Stream<String> stream2 = Stream.of("w", "o", "l", "f");
            TreeSet<String> set = stream.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
            System.out.println(set); // [f, l, o, w]
            
            Stream<String> stream3 = Stream.of("w", "o", "l", "f");
            TreeSet<String> set3 = stream.collect(Collectors.toCollection(TreeSet::new));
            System.out.println(set); // [f, l, o, w]
            
            Stream<String> stream4 = Stream.of("w", "o", "l", "f");
            Set<String> set4 = stream4.collect(Collectors.toSet());
            System.out.println(set); // [f, w, l, o]
        }
    }
}

/** Common Intermediate Operations | page 196 */
class StreamInter {
    public static void main(String[] args) {
 
        // filter() 
        {
            Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
            s.filter(x -> x.startsWith("m")).forEach(System.out::print); // monkey
        }
        
        // distinct()
        {
            Stream<String> s = Stream.of("duck", "duck", "duck", "goose");
            s.distinct().forEach(System.out::print); // duckgoose
        }
        
        // limit() and skip()
        {
            Stream<Integer> s = Stream.iterate(1, n -> n + 1);
            s.skip(5).limit(2).forEach(System.out::print); // 6 7
        }

        // map()
        {
            // converts a list of String objects to a list of Integers representing their lengths:
            Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
            s.map(String::length).forEach(System.out::print); // 676
        }

        // flatMap() 
        {
            // This gets all of the animals into the same level along with getting rid of the empty list:
            List<String> zero = Arrays.asList();
            List<String> one = Arrays.asList("Bonobo");
            List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
            Stream<List<String>> animals = Stream.of(zero, one, two);
            animals.flatMap(l -> l.stream()).forEach(System.out::println);
            // Bonobo
            // Mama Gorilla
            // Baby Gorilla
        }
        
        // sorted()
        {
            Stream<String> s = Stream.of("brown-", "bear-");
            s.sorted().forEach(System.out::print); // bear-brown- 
            
            Stream<String> s2 = Stream.of("brown bear-", "grizzly-");
            s2.sorted(Comparator.reverseOrder()).forEach(System.out::print); // grizzly-brown bear

        }

        // peek()
        {
            // perform an operation without changing the result
            // common use is to output the contents of the stream as it goes by.
            Stream<String> stream = Stream.of("black bear", "brown bear", "grizzly");
            long count = stream.filter(s -> s.startsWith("g")).peek(System.out::println).count(); // grizzly
            System.out.println(count); // 1
        }
    }
}


class PlayStreamPipeline {
    public static void main(String[] args) {
        
        //  get the first two names alphabetically that are four characters long.
        {
            List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
            list.stream().filter(n -> n.length() == 4) // We care about String objects of length 4
                            .sorted() // Then we then want them sorted
                            .limit(2) // Then we want to first two. 
                            .forEach(System.out::println); // Then we want to print them out.
                            // Alex, Anna
        }
     // seiing how a strem pipeline work behind the scenes 
        {
        Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
        infinite.limit(5)
            .filter(x -> x % 2 == 1)
            .forEach(System.out::print); // 135
    
            Stream<Integer> infinite2 = Stream.iterate(1, x -> x + 1);
            infinite2.limit(5)
                        .peek(System.out::print)
                        .filter(x -> x % 2 == 1)
                        .forEach(System.out::print); // 11233455
        
        Stream<Integer> infinite3 = Stream.iterate(1, x -> x + 1);
        infinite3.filter(x -> x % 2 == 1)
                    .limit(5)
                    .forEach(System.out::print); // 13579
    
        Stream<Integer> infinite4 = Stream.iterate(1, x -> x + 1);
        infinite4.filter(x -> x % 2 == 1)
                    .peek(System.out::print)
                    .limit(5)
                    .forEach(System.out::print); // 1133557799
        }
    }
}

