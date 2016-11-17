package OCP.chap4;

import java.util.Optional;

public class Chap4_Optional {
    public static void main(String[] args) {
    }
}

/** @see pagee 182 | Returning an Optional */

class PlayOptional1 {

    public static Optional<Double> average(int... scores) {
        if (scores.length == 0) return Optional.empty();
        int sum = 0;
        for (int score : scores) sum += score;
        return Optional.of((double) sum / scores.length);
    }

    public static void main(String[] args) {
        
        // creating an optionnal from a value
        Integer value = 55;
        // use ternay operator
        Optional o1 = (value == null) ? Optional.empty(): Optional.of(value);
        // or use java factory method
        Optional o2 = Optional.ofNullable(value);
        
        
        System.out.println(average(90, 100)); // Optional[95.0]
        System.out.println(average()); // Optional.empty
        
        // isPresent | to check if a value is there and/or get it out of the box.
        Optional<Double> opt = average(90, 100);
        if (opt.isPresent())
        System.out.println(opt.get()); // 95.0
        
        // ifPresent() | a Consumer to be run when there is a value inside the Optional. 
        Optional<Double> opt2 = average(90, 100);
        opt.ifPresent(System.out::println);
        
        // orElse()
        Optional<Double> opt3 = average();
        System.out.println(opt.orElse(Double.NaN)); // NaN
        System.out.println(opt.orElseGet(() -> Math.random())); //  supplier, generate a value at runtime to return instead.
        System.out.println(opt.orElseThrow(() -> new IllegalStateException()));
        Optional<Double> opt4 = average(90, 100);
        System.out.println(opt.orElse(Double.NaN)); // 95
        System.out.println(opt.orElseGet(() -> Math.random())); // 95
        System.out.println(opt.orElseThrow(() -> new IllegalStateException())); // 95
    }
}
