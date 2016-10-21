package OCP.chap2;

public class Chap2 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}

/** Designing an Interface | @see page 48 */

interface Fly {
    public int getWingSpan() throws Exception;

    public static final int MAX_SPEED = 100;

    public default void land() {
        System.out.println("Animal is landing");
    }

    public static double calculateSpeed(float distance, double time) {
        return distance / time;
    }
}

class Eagle implements Fly {
    public int getWingSpan() {
        return 15;
    }
    public void land() {
        System.out.println("Eagle is diving fast");
    }
}

/** Interface extend another interface */

interface Walk {
    boolean isQuadruped();
    abstract double getMaxSpeed();
}
interface Run extends Walk {
    public abstract boolean canHuntWhileRunning();
    abstract double getMaxSpeed();
}
class Lion1 implements Run {
    public boolean isQuadruped() {
        return true;
    }
    public boolean canHuntWhileRunning() {
        return true;
    }
    public double getMaxSpeed() {
        return 100;
    }
}


/** implement multiple interfaces */

interface Swim {}
interface Hop {}
class Frog implements Swim, Hop {}


/** Introducing Functional Programming | @see page 52  */

@FunctionalInterface
interface Sprint {
    public void sprint(Animal animal);
}
class Tiger implements Sprint {
    public void sprint(Animal animal) {
        System.out.println("Animal is sprinting fast! "+animal.toString());
    }
}

// All three are valid functional interfaces

interface Running extends Sprint {}

interface SprintFaster extends Sprint {
    public void sprint(Animal animal);
}

interface Skip extends Sprint {
    public default int getHopCount() {return 10;}
    public static void skip(int speed) {}
}

/** Implementing Polymorphism | @see page 61 */

interface LivesInOcean { public void makeSound(); }

class Dolphin implements LivesInOcean {
    public void makeSound() { System.out.println("whistle"); }
}
class Whale implements LivesInOcean {
    public void makeSound() { System.out.println("sing"); }
}
class Oceanographer {
    public void checkSound(LivesInOcean animal) {
        animal.makeSound();
    }
    public void main(String[] args) {
        Oceanographer o = new Oceanographer();
        o.checkSound(new Dolphin()); // whistle
        o.checkSound(new Whale()); // sing
    }
}
