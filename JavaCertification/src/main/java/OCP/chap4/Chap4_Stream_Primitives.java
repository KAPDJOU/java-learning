package OCP.chap4;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.BooleanSupplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Chap4_Stream_Primitives {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}


/** Working with Primitives | @see page 205 */

class PlayPrimitivesStream {
    public static void main(String[] args) {
     
        /** Creating Primitive Streams */
        {
        DoubleStream empty = DoubleStream.empty();
        DoubleStream oneValue = DoubleStream.of(3.14);
        DoubleStream varargs = DoubleStream.of(1.0, 1.1, 1.2);
        
        oneValue.forEach(System.out::println); // 3.14
        System.out.println();
        varargs.forEach(System.out::println); // 1.0 1.1 1.2
        
        DoubleStream random = DoubleStream.generate(Math::random);
        DoubleStream fractions = DoubleStream.iterate(.5, d -> d / 2);
        
        random.limit(3).forEach(System.out::println);
        System.out.println();
        fractions.limit(3).forEach(System.out::println); // 0.5 2.25 0.125
        
        // generate a range of numbers 
        IntStream range = IntStream.range(1, 6);
        range.forEach(System.out::println);
        IntStream rangeClosed = IntStream.rangeClosed(1, 5);
        rangeClosed.forEach(System.out::println);

        // mapping from another stream type.
        Stream<String> objStream = Stream.of("penguin", "fish");
        IntStream intStream = objStream.mapToInt(s -> s.length());
            
        }
        
        /** sum() and average() and optional */
        {
            Stream<Integer> stream = Stream.of(1, 2, 3);
            System.out.println(stream.mapToInt(x -> x).sum()); // 6

            IntStream intStream1 = IntStream.of(1, 2, 3);
            System.out.println(intStream1.sum()); // 6
            
            LongStream longs = LongStream.of(5, 10);
            long sum = longs.sum();
            System.out.println(sum); // 15
            
            IntStream intStream2 = IntStream.of(1, 2, 3);
            OptionalDouble optionalAvg = intStream2.average();
            optionalAvg.ifPresent(System.out::println);
            System.out.println(optionalAvg.getAsDouble());
            System.out.println(optionalAvg.orElseGet(() -> Double.NaN));
            
            DoubleStream doubles = DoubleStream.generate(() -> Math.PI);
            OptionalDouble min = doubles.min(); // runs infinitely
        }
        
        /** Functional Interfaces for Primitives */
        {
            BooleanSupplier b1 = () -> true;
            BooleanSupplier b2 = () -> Math.random() > .5;
            System.out.println(b1.getAsBoolean()); // true
            System.out.println(b2.getAsBoolean()); // true or false
        }
        
        
    }

    /** Summarizing Statistics */
    
    private static int max(IntStream ints) {
        OptionalInt optional = ints.max();
        return optional.orElseThrow(RuntimeException::new);
    }
    private static int range(IntStream ints) {
        IntSummaryStatistics stats = ints.summaryStatistics();
        if (stats.getCount() == 0) throw new RuntimeException();
        return stats.getMax() - stats.getMin(); //The range is the minimum value subtracted from the maximum value. 
   }
}