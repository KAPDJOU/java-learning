package chap21_Generics;

public class MethGen {
    public static void main(String args[]) {
        
    }
}

/** page 636 | Méthodes Gnériques*/

// Exemple de méthode générique à un seul argument
class MethGen1 {
	static <T> T hasard(T[] valeurs) {
		int n = valeurs.length;
		if (n == 0)
			return null;
		int i = (int) (n * Math.random());
		return valeurs[i];
	}

	public static void main(String args[]) {
		Integer[] tabi = { 1, 5, 8, 4, 9 };
		System.out.println("hasard sur tabi = " + hasard(tabi)); // ex : hasard sur tabi = 4
		String[] tabs = { "bonjour", "salut", "hello" }; 
		System.out.println("hasard sur tabs = " + hasard(tabs)); // ex : hasard sur tabs = bonjour
	}
}

// Exemple de méthode générique à deux arguments
class MethGen2 {
    static <T> T hasard(T e1, T e2) {
        double x = Math.random();
        if (x < 0.5)
            return e1;
        else
            return e2;
    }

    public static void main(String args[]) {
        Integer n1 = 2;
        Integer n2 = 5;
        int n = hasard(n1, n2);
        System.out.println("hasard (n1, n2) = " + n); // hasard (n1, n2) = 2

        Double x1 = 2.5;
        Number v = hasard(n1, x1);
        System.out.println("hasard (n1, x1) = " + v); // hasard (n1, x1) = 2.5

        Number w = MethGen2.<Number> hasard(n1, x1);
        System.out.println("hasard 'n1, x1) = " + v); // hasard (n1, x1) = 2

        // imposer le type voulu pour T lors de l'appel de la méthode
        // Number z = MethGen2.<Double>hasard (n1, x1) ; // rejet en compilation
        Number z = MethGen2.<Number> hasard(n1, x1) ;
    }
}

