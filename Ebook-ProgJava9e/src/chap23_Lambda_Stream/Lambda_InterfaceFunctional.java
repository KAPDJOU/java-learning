package chap23_Lambda_Stream;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class Lambda_InterfaceFunctional {
    public static void main(String args[]) {        
    }
}

/** Chap2 | 1.1 & 1.2 | exemples d’expression lambda | p700 */

@FunctionalInterface
interface Calculateur {
    public int calcul(int n);
}

// implémentation de l'interface avec une classe anonyme
class IntroLambda1 {
	public static void main(String args[]) {
		int n1 = 5, n2 = 3;
		Calculateur carre = new Calculateur() {
			public int calcul(int n) {
				return n * n;
			}
		};
		int res = carre.calcul(n1);
		System.out.println("Carre de " + n1 + " = " + res); // Carre de 5 = 25
		System.out.println("Carre de " + n2 + " = " + carre.calcul(n2)); // Carre de 3 = 9
	}
}

//implémentation de l'interface avec lambda
class IntroLambda2 {
    public static void main(String args[]) {
        int n1 = 5, n2 = 3;
        Calculateur carre = x -> x * x;
        int res = carre.calcul(n1);
        System.out.println("Carre de " + n1 + " = " + res); // Carre de 5 = 25
        System.out.println("Carre de " + n2 + " = " + carre.calcul(n2)); // Carre de 3 = 9
    }
}

class CalculComplique {
    public static void main(String args[]) {
        int n1 = 5, n2 = 4, n3 = -5;
        Calculateur complique = x -> { 
            if (x > 0 && 2 * (x / 2) == x) return x;
            else if (x > 0) return x + 1;
            else return -x;
        };
        int res = complique.calcul(n1);
        System.out.println("Complique de " + n1 + " = " + res); // Complique de 5 = 6
        System.out.println("Complique de " + n2 + " = " + complique.calcul(n2)); // Complique de 4 = 4
        System.out.println("Complique de " + n3 + " = " + complique.calcul(n3)); // Complique de -5 = 5
    }
}

// utiliser une expression lambda pour donner une valeur à une argument transmis à une méthode
class LambdaRappel1 {
    public static void main(String[] args) {
        traite(5, x -> x * x); // calcul (5) = 25
        
        Calculateur polynome = x -> 2 * x * x + 3 * x + 5; 
        traite(12, polynome); // calcul (12) = 329
    }

    public static void traite(int n, Calculateur cal) {
        int res = cal.calcul(n);
        System.out.println("calcul (" + n + ") = " + res);
    }
}

// Utiliser l'interface IntUnaryOperator/UnaryOperator : représente une fonction recevant un int et renvoyant un int
class LambdaRappel2 {
    public static void main(String[] args) {
        traite(5, x -> x * x); // calcul (5) = 25
        traite2(5, x -> x * x); // calcul (5) = 25
        traite(12, x -> 2 * x * x + 3 * x + 5); // calcul (12) = 329
    }

    public static void traite(int n, IntUnaryOperator cal) {
        int res = cal.applyAsInt(n);
        System.out.println("calcul (" + n + ") = " + res);
    }
    
    public static void traite2(int n, UnaryOperator<Integer> cal) {
        int res = cal.apply(n);
        System.out.println("calcul (" + n + ") = " + res);
    }
}

/** Chap2 | 3.2.1 | p707 | Expression lamda dans une instruction return */

class ReturnLambda {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            traite(4, fabriqueStatique());
        }
    }

    public static void traite(int n, Calculateur cal) {
        int res = cal.calcul(n);
        System.out.println("calcul(" + n + ") = " + res);
    }

    public static Calculateur fabriqueStatique() { // tire un calculateur au hasard
        double x = Math.random();
        if (x < 0.5)
            return y -> y * y; // renvoie une expression lambda
        else
            return y -> 2 * y; // renvoie une autre expression lambda
    }
}

/** Chap2 | 3.2.2 | Composition d’expressions lambda */

interface FabriqueCalculateur {
    Calculateur fabrique();
}

class CompositionLambda {
    public static void main(String[] args) {
        FabriqueCalculateur fabriqueCarre = () -> (x -> x * x);
        FabriqueCalculateur fabriqueDouble = () -> (x -> 2 * x);
        traite(12, fabriqueCarre.fabrique()); // calcul(12) = 144
        traite(25, fabriqueDouble.fabrique()); // calcul(25) = 50
    }

    public static void traite(int n, Calculateur cal) {
        int res = cal.calcul(n);
        System.out.println("calcul(" + n + ") = " + res);
    }
}

/** Chap2 | 3.2.3 | Tableau d’expressions lambda */ 

class TableauLambda {
    public static void main(String[] args) {
        Calculateur[] tabCalc = { x -> x * x, x -> 2 * x, x -> (int) Math.sqrt(x) };
        for (Calculateur calc : tabCalc)
            traite(15, calc);
        // ouptut :
        // calcul(15) = 225
        // calcul(15) = 30
        // calcul(15) = 3
    }

    public static void traite(int n, Calculateur cal) {
        int res = cal.calcul(n);
        System.out.println("calcul(" + n + ") = " + res);
    }
}