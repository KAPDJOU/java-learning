package OCP.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chap2_DesignPatterns {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}

//@formatter:off

/** Singleton Pattern | @see page 76 */

class HayStorage {
    private int quantity = 0;

    private HayStorage() {
    }

    private static final HayStorage instance = new HayStorage();

    public static HayStorage getInstance() {
        return instance;
    }

    public synchronized void addHay(int amount) {
        quantity += amount;
    }

    public synchronized boolean removeHay(int amount) {
        if (quantity < amount)
            return false;
        quantity -= amount;
        return true;
    }

    public synchronized int getHayQuantity() {
        return quantity;
    }
}

class LlamaTrainer {
    public boolean feedLlamas(int numberOfLlamas) {
        int amountNeeded = 5 * numberOfLlamas;
        HayStorage hayStorage = HayStorage.getInstance();
        if(hayStorage.getHayQuantity() < amountNeeded) {
            hayStorage.addHay(amountNeeded + 10);
        }
        boolean fed = hayStorage.removeHay(amountNeeded);
        if(fed) System.out.println("Llamas have been fed");
        return fed;
    }
}

// Instantiation using a static block
class StaffRegister {
    private static final StaffRegister instance;
    static {
        instance = new StaffRegister();
        // Perform additional steps
    }

    private StaffRegister() {
    }

    public static StaffRegister getInstance() {
        return instance;
    }
    // Data access methods
    // ...
}
 

// Lazy instantiation and thread-safe
class VisitorTicketTracker {
    private static VisitorTicketTracker instance;

    private VisitorTicketTracker() {
    }

    public static synchronized VisitorTicketTracker getInstance() {
        if (instance == null) {
            instance = new VisitorTicketTracker();
        }
        return instance;
    }
    // Data access methods
    // ...
}

//Lazy instantiation and thread-safe and Double‐Checked locking
class VisitorTicketTracker2 {
    private static volatile VisitorTicketTracker2 instance;

    private VisitorTicketTracker2() {
    }

    public static VisitorTicketTracker2 getInstance() {
        if (instance == null) {
            synchronized(VisitorTicketTracker2.class) {
                if (instance == null) {
                    instance = new VisitorTicketTracker2();
                }
            }
        }
        return instance;
    }
    // Data access methods
    // ...
}



/** Immutable Objects | @see page 82 */

final class Animal1 {
    private final String species;
    private final int age;
    private final List<String> favoriteFoods;

    public Animal1(String species, int age, List<String> favoriteFoods) {
        this.species = species;
        this.age = age;
        if (favoriteFoods == null) {
            throw new RuntimeException("favoriteFoods is required");
        }
        this.favoriteFoods = new ArrayList<String>(favoriteFoods);
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public int getFavoriteFoodsCount() {
        return favoriteFoods.size();
    }

    public String getFavoriteFood(int index) {
        return favoriteFoods.get(index);
    }

    public List<String> getCopyOfFavoriteFood() {
        List<String> copyOfFavoriteFoods = new ArrayList<String>();
        for (int i = 0; i < this.getFavoriteFoodsCount(); i++) {
            favoriteFoods.add(this.getFavoriteFood(i));
        }
        return copyOfFavoriteFoods;
    }
}

class PlayAnimal1 {
    public static void main(String[] args) {
        // Create a new immutable Animal instance
        Animal1 lion = new Animal1("lion", 5, Arrays.asList("meat", "more meat"));

        // Create a new Animal instance using data from the first instance
        List<String> favoriteFoods = lion.getCopyOfFavoriteFood();
        Animal1 updatedLion = new Animal1(lion.getSpecies(), lion.getAge() + 1, favoriteFoods);
    }
}

/** Builder Pattern | @see page 86 */

class Animal1Builder {
    private String species;
    private int age;
    private List<String> favoriteFoods;

    public Animal1Builder setAge(int age) {
        this.age = age;
        return this;
    }

    public Animal1Builder setSpecies(String species) {
        this.species = species;
        return this;
    }

    public Animal1Builder setFavoriteFoods(List<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
        return this;
    }

    public Animal1 build() {
        return new Animal1(species, age, favoriteFoods);
    }
}

class PlayAnimal1Builder {
    public static void main(String[] args) {
        Animal1Builder duckBuilder = new Animal1Builder();
        duckBuilder.setAge(4).setFavoriteFoods(Arrays.asList("grass", "fish")).setSpecies("duck");
        Animal1 duck = duckBuilder.build();
        
        Animal1 flamingo = new Animal1Builder().setFavoriteFoods(Arrays.asList("algae", "insects"))
                .setSpecies("flamingo").build();
    }
}


/** Factory Pattern | @see page 89 */

abstract class Food {
    private int quantity;

    public Food(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract void consumed();
}

class Hay extends Food {
    public Hay(int quantity) {
        super(quantity);
    }

    public void consumed() {
        System.out.println("Hay eaten: " + getQuantity());
    }
}

class Pellets extends Food {
    public Pellets(int quantity) {
        super(quantity);
    }

    public void consumed() {
        System.out.println("Pellets eaten: " + getQuantity());
    }
}

class Fish extends Food {
    public Fish(int quantity) {
        super(quantity);
    }

    public void consumed() {
        System.out.println("Fish eaten: " + getQuantity());
    }
}

class FoodFactory {
    public static Food getFood(String animalName) {
        switch (animalName) {
            case "zebra": return new Hay(100);
            case "rabbit": return new Pellets(5);
            case "goat": return new Pellets(30);
            case "polar bear": return new Fish(10);
        }
        // Good practice to throw an exception if no matching subclass could be found
        throw new UnsupportedOperationException("Unsupported animal: " + animalName);
    }
}

class ZooKeeper {
    public static void main(String[] args) {
        final Food food = FoodFactory.getFood("polar bear");
        food.consumed();
    }
}

//@formatter:on