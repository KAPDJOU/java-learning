package davidson;

/**
 * Improve code to get same result
 * Do it with Replacement of abstract class by interface interface
 * 
 * @author dell
 */
public class ImproveAbstractToInterface {

    public static void main(String[] args) {
	Dog sammy = new Dog("Sammy");
	Cat smokey = new Cat("Smokey");

	System.out.println(Application.getAnimalName(sammy));
	System.out.println(Application.getAnimalName(smokey));
    }
}

// abstract class Animal {
interface Animal {
    public String getName();
}

// class Dog extends Animal {
class Dog implements Animal {
    String name;

    /**
     * Creates a new dog with the given name.
     */
    Dog(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }
}

// class Cat extends Animal {
class Cat implements Animal {
    String name;

    /**
     * Creates a new cat with the given name.
     */
    Cat(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }
}

class Application {

    /**
     * @return the name of the given​​​​​​​‌‌‌‌‌​​‌‌​‌‌‌‌​​‌​‌​​‌‌‌ animal
     */
    static String getAnimalName(Animal a) {
	// String name = null;
	// if (a instanceof Dog) {
	// name = ((Dog) a.getName();
	// } else if (a instanceof Cat) {
	// name = ((Cat) a).getName();
	// }

	return a.getName();
    }
}
