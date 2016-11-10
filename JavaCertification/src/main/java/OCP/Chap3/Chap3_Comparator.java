package OCP.Chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Chap3_Comparator {
    public static void main(String[] args) {
    }
}

// @formatter:off
 

/** Comparable | page 143 */

class Duck implements Comparable<Duck> {
    private String name;
    private int weight;

    public Duck(String name) {
        this.name = name;
    }

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    
    // setter getter
    public String getName() { return name; }
    public int getWeight() { return weight; }
    
    // toString, use readable output
    public String toString() { 
        return name;
    }

    @Override
    public int compareTo(Duck d) {
        return name.compareTo(d.name); // call String's compareTo
    }

    public static void main(String[] args) {
        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("Quack"));
        ducks.add(new Duck("Puddles"));
        Collections.sort(ducks); // sort by name
        System.out.println(ducks); // [Puddles, Quack]
    }
}

class Animal implements Comparable<Animal> {
    private int id;

    @Override
    public int compareTo(Animal a) {
        return id - a.id;
    }

    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal a2 = new Animal();
        a1.id = 5;
        a2.id = 7;
        System.out.println(a1.compareTo(a2)); // -2
        System.out.println(a1.compareTo(a1)); // 0
        System.out.println(a2.compareTo(a1)); // 2
    }
}

/** Comparator | page 146 */

class PlayComparator {
    public static void main(String[] args) {

        // comparator with anonymous inner class
        Comparator<Duck> byWeight = new Comparator<Duck>() {
            public int compare(Duck d1, Duck d2) {
                return d1.getWeight() - d2.getWeight();
            }
        };
        // compatator implementation with lambda syntax
        Comparator<Duck> byWeight2 = (d1, d2) -> d1.getWeight() - d2.getWeight();

        List<Duck> ducks = new ArrayList<>();
        ducks.add(new Duck("Quack", 7));
        ducks.add(new Duck("Puddles", 10));
        Collections.sort(ducks);
        System.out.println(ducks); // [Puddles, Quack]

        Collections.sort(ducks, byWeight);
        System.out.println(ducks); // [Quack, Puddles]
    }
}

/** Comparing multiple fields */

class Squirrel {
    private int weight;
    private String species;

    public Squirrel(String theSpecies) {
        if (theSpecies == null)
            throw new IllegalArgumentException();
        species = theSpecies;
    }

    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
    public String getSpecies() { return species;}
}

// Comparator to sort by species name. 
// If two squirrels are from the species, we want to sort the one that weighs the least first
class MultiFieldComparator implements Comparator<Squirrel> {
    @Override
    public int compare(Squirrel s1, Squirrel s2) {
        int result = s1.getSpecies().compareTo(s2.getSpecies());
        if (result != 0) return result;
        return s1.getWeight() - s2.getWeight();
    }
 }
// with java 8 syntax, method chaining & helper methods on Compartor interface
class ChainingComparator implements Comparator<Squirrel> {
    @Override
    public int compare(Squirrel s1, Squirrel s2) {
        Comparator<Squirrel> c = Comparator.comparing(s -> s.getSpecies());
        c = c.thenComparingInt(s -> s.getWeight());
        return c.compare(s1, s2);
    }
}

/** Searching and Sorting | page 150 */

// @formatter:on

class SortRabbits {

    static class Rabbit {
        int id;
    }

    public static void main(String[] args) {
        List<Rabbit> rabbits = new ArrayList<>();
        rabbits.add(new Rabbit());
        Comparator<Rabbit> c = (r1, r2) -> r1.id - r2.id;
        Collections.sort(rabbits, c);
    }
}

class playBinarySearchWithComparator {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Fluffy", "Hoppy");
        Comparator<String> c = Comparator.reverseOrder(); // compartr reverse the natural ascending order in descending
                                                          // order
        int index = Collections.binarySearch(names, "Hoppy", c);
        System.out.println(index); // -1
    }
}

class UseTreeSet {
    static class Rabbit {
        int id;
    }

    public static void main(String[] args) {
        Set<Duck> ducks = new TreeSet<>();
        ducks.add(new Duck("Puddles"));

        Set<Rabbit> rabbit = new TreeSet<>();
        rabbit.add(new Rabbit()); // throws an exception, Rabbit does not implement Comparable

        //  rigth way, tell collections that require sorting that you wish to use a specific Comparator
        Comparator<Rabbit> c = (r1, r2) -> r1.id - r2.id;
        Set<Rabbit> rabbit2 = new TreeSet<>(c);
        rabbit.add(new Rabbit());
    }
}