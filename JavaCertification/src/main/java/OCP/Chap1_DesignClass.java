package OCP;

public class Chap1_DesignClass {
    public static void main(String args[]) {
    }
}

// @formatter:off


/**
 * instanceof
 * 
 * @see page 7
 */
interface Mother {}
class HeavyAnimal { }
class Hippo extends HeavyAnimal { }
class Elephant extends HeavyAnimal { }
class MotherHippo extends Hippo implements Mother { }

class InstanceOfClasseTest {
    public static void main(String args[]) {
        HeavyAnimal hippo = new Hippo();
        boolean b0 = hippo instanceof Mother; // false, Hippo does not implement Mother
        boolean b1 = hippo instanceof Hippo; // true
        boolean b2 = hippo instanceof HeavyAnimal; // true
        boolean b3 = hippo instanceof Elephant; // false
        boolean b4 = hippo instanceof Object; // true

        Hippo nullHippo = null;
        boolean b5 = nullHippo instanceof Object; // false

        Hippo anotherHippo = new Hippo(); 
        // boolean b5 = anotherHippo instanceof Elephant; // DOES NOT COMPILE,  Hippo doesn’t extend Elephant directly or indirectly.
        boolean b6 = anotherHippo instanceof Hippo; // true
        boolean b7 = anotherHippo instanceof HeavyAnimal; // true
        
        Mother motherHippo = new MotherHippo();
        boolean b8 = motherHippo instanceof Mother; // true
        boolean b9 = motherHippo instanceof Hippo; // true
        boolean b10 = motherHippo instanceof MotherHippo; // true
        
        System.out.println("b8="+b8 + ", b9=" + b9 + ", b10=" + b10);
    }
}

/**
 * Virtual Method & Equals & hashcode & toString
 * 
 * @see page 9
 */
abstract class Animal {
    String name = "???";
    public void printName() { System.out.println(name); }
    public abstract void feed(); 
    
    public void careFor() { play();}
    public void play() { System.out.println("pet animal"); }
}

class Cow extends Animal {
    public void feed() { addHay(); }
    private void addHay() { System.out.println("Cow - feed - add Hay"); }
}
class Bird extends Animal {
    public void feed() { addSeed(); }
    private void addSeed() { System.out.println("Bird - feed - add Seed"); }
}
class Lion extends Animal {
    private int idNumber;
    private int age;
    String name = "Leo";
    private double weight;
    
    public Lion() {
    }
    
    public Lion(int idNumber, int age, String name) {
        this.idNumber = idNumber;
        this.age = age;
        this.name = name;
    }
    public Lion(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
    
    public void feed() { addMeat(); }
    private void addMeat() { System.out.println("Lion - feed - add Mead");}
    public void play() { System.out.println("toss in meat"); }

    // ToString custom implementation
    @Override
    public String toString() {
        return "Name: " + name + ", Weight: " + weight;
    }
    
    @Override 
    public boolean equals(Object obj) {
        if ( !(obj instanceof Lion)) 
            return false;
        
        Lion otherLion = (Lion) obj;
        return this.idNumber == otherLion.idNumber;
        
        //  implements equals() to say that any two Lion objects with the same ID are the same Lion:
    }
    
    @Override
    public int hashCode() { 
        return idNumber; 
    }
    
}

class PlayWithAnimal {
    public static void main(String... args) {
        Animal animal = new Lion();
        animal.printName(); // ???
        animal.feed(); // Lion - feed - add Mead
        animal.careFor(); // toss in meat
        
        Animal a1 = new Lion("Simba", 3100);
        System.out.println(a1); // Name: Simba, Weight: 3100.0
    }
    
    public void feedAnimal(Animal animal) {
        animal.feed();
     }
}


class Card {
    private String rank;
    private String suit;

    public Card(String r, String s) {
        if (r == null || s == null)
            throw new IllegalArgumentException();
        rank = r;
        suit = s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Card))
            return false;
        Card c = (Card) obj;
        return rank.equals(c.rank) && suit.equals(c.suit);
    }

    public int hashCode() {
        return rank.hashCode();
    }
}

// @formatter:on