package OCP.Chap3;

import java.util.ArrayList;
import java.util.List;

public class Chap3_Generics {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

// @formatter:off
 
/** Generic Classes | @see page 109 */

class Crate<T> {
    private T contents;

    public T emptyCrate() {
        return contents;
    }

    public void packCrate(T contents) {
        this.contents = contents;
    }
}

class SizeLimitedCrate<T, U> {
    private T contents;
    private U sizeLimit;

    public SizeLimitedCrate(T contents, U sizeLimit) {
        this.contents = contents;
        this.sizeLimit = sizeLimit;
    }
}

interface Mother {}
class HeavyAnimal { }
class Hippo extends HeavyAnimal { }
class Elephant extends HeavyAnimal { }
class MotherHippo extends Hippo implements Mother { }

class PlayGenrerics {
    public static void main(String[] args) {
        Elephant elephant = new Elephant();
        Crate<Elephant> crateForElephant = new Crate<>();
        crateForElephant.packCrate(elephant);
        Elephant inNewHome = crateForElephant.emptyCrate();
        
        Crate<Hippo> crateForHippo = new Crate<>();

        Elephant elephant2 = new Elephant();
        Integer numPounds = 15_000;
        SizeLimitedCrate<Elephant, Integer> c1 = new SizeLimitedCrate<>(elephant, numPounds);
        
    }
}


/** Generic Interfaces | @see page 112 */

class Robot { }

interface Shippable<T> {
    void ship(T t);
}

class ShippableRobotCrate implements Shippable<Robot> {
    public void ship(Robot t) {}
}
class ShippableAbstractCrate<U> implements Shippable<U> {
    public void ship(U t) { }
}

class ShippableCrate implements Shippable {
    public void ship(Object t) { }
}

/** Generic Methods | @see page 114 */

class Box { 
    public static <T> void sink(T t) { }
    public static <T> T identity(T t) { return t; }
    // public static T noGood(T t) { return t; } // DOES NOT COMPILE
    public static <T> Crate<T> ship(T t) {
        System.out.println("Preparing " + t);
        return new Crate<T>();
    }
}

class PlayGenericMethod {
    public static void main(String[] args) {
        Box.<String>ship("package");
        Box.<String[]>ship(args);
    }
}

/** Bound | @see page 117 */

class PlayBounds {

    // Unbounded Wildcards
    
    public static void printList(List<?> list) {
        for (Object x : list)
            System.out.println(x);
    }

    // Upper-Bounded Wildcards
 
    public static long total(List<? extends Number> list) {
        long count = 0;
        for (Number number : list)
            count += number.longValue();
        return count;
    }

    private static void anyFlyer(List<Flyer> flyer) {}
    private static void groupOfFlyers(List<? extends Flyer> flyer) {}
    
    // lower bound
    public static void addSound(List<? super String> list) {
        list.add("quack");
    }

    // 
    static <T> T method1(List<? extends T> list) {
        return list.get(0);
    }
    static void method4(List<? super B> list) {
    }
    
    // main method 
    
    public static void main(String[] args) {
        List<String> keywords = new ArrayList<>();
        keywords.add("java");
        printList(keywords);
        
        List<Flyer> flyers = new ArrayList<>();
        List<Goose> gooses = new ArrayList<Goose>();
        groupOfFlyers(flyers);
        groupOfFlyers(gooses);
        anyFlyer(flyers);
        // anyflyer(gooses); // gooses can be passed only to the method with the upper bound
        
        List<String> strings = new ArrayList<String>();
        strings.add("tweet");
        List<Object> objects = new ArrayList<Object>(strings);
        addSound(strings);
        addSound(objects);
        
        List<?> list1 = new ArrayList<A>();
        List<? extends A> list2 = new ArrayList<A>();
        List<? super A> list3 = new ArrayList<A>();
        // List<? extends B> list4 = new ArrayList<A>(); // DOES NOT COMPILE
        List<? extends B> list4 = new ArrayList<C>(); 
        List<? super B> list5 = new ArrayList<A>();
        // List<?> list6 = new ArrayList<? extends A>(); // DOES NOT COMPILE
        
        method1(strings);
        method4(new ArrayList<A>());
        method4(new ArrayList<B>());
        method4(new ArrayList<Object>());
        
    }
}
// Upper-Bounded Wildcards | example with interface
interface Flyer { void fly(); }
class HangGlider implements Flyer { public void fly() {} }
class Goose implements Flyer { public void fly() {} }

// Putting It All Together
class A {}
class B extends A { }
class C extends B { }

// @formatter:on