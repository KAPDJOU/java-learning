package OCP.chap2;

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
 
// @formatter:on

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
