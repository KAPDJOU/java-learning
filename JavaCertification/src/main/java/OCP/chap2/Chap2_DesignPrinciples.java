package OCP.chap2;

public class Chap2_DesignPrinciples {
    public static void main(String[] args) {
    }
}


/** Encapsulating Data | page 66 */

class Animal {
    // design requirements 
    // Each animal has a non‐null, non‐empty species field
    // Each animal has an age field that is greater than or equal to zero
    // for name field, we have a requirement to treat empty strings or those containing only whitespace characters as null values

    // fields 
    
    private String species;
    private int age;
    private String name;

    // Constructors
    
    public Animal(String species) {
        this.setSpecies(species);
    }

    // Getters and setters
    
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        if (species == null || species.trim().length() == 0) {
            throw new IllegalArgumentException("Species is required");
        }
        this.species = species;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be a negative number");
        }
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = (name == null || name.trim().length()==0) ? null: name;
    }
}
/** Composing Objects | page 74 */

class Flippers {
    public void flap() {
        System.out.println("The flippers flap back and forth");
    }
}

class WebbedFeet {
    public void kick() {
        System.out.println("The webbed feet kick to and fro");
    }
}

class Penguin {
    private final Flippers flippers;
    private final WebbedFeet webbedFeet;

    public Penguin() {
        this.flippers = new Flippers();
        this.webbedFeet = new WebbedFeet();
    }

    public void flap() {
        this.flippers.flap();
    }

    public void kick() {
        this.webbedFeet.kick();
    }
}
