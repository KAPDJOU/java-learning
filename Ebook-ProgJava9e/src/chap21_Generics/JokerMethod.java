package chap21_Generics;

public class JokerMethod {
	public static void main(String args[]) {
		Object o1 = null;
		Integer i1 = 5;
		Object o2 = null;
		Integer i2 = 3;
		Couple1<Object> co = new Couple1<>(o1, o2);
		Couple1<Integer> ci = new Couple1<>(i1, i2);
		Couple1<Double> cd = new Couple1<>(2.5, 3.5);;
		
		// JOKER simple
		Couple1<?> cq; // cq désigne un couple d'éléments d'un type quelconque
		
		cq = ci;
		cq = cd; // CK : affectation d'un Couplel<Double> à un Couplel<?>
		         // inverse DOES not compile
		
		
		// DOES NOT COMPILE, call not allowed t method with parameter type "?"
		// Double premier = cq.getPremier();
		// cq.setPremier(5.0); 
		//cq.compare(i1);
		
		// Joker et limitation
		Couple1 <? extends Number> cqn ; // ? représente un type quelconque dérivé de Nuirber
		cqn = ci ; // C K : Integer dérive bien de Nuirber
        // cqn = co ; // erreur de compilation : Object ne dérive pas de Number
		
		Couple1 <? super PointCol> cqn2 ; // ? représente une classe quelconque ascendante de Pointcol (ou Pointcol elle-même)
		Point p = new Point();
		Couple1<Point> cp = new Couple1<>(p, p);
		cqn2 = cp ; // OK : Paint est classe ascendante de Pointcol
        // cqn2 = ci ; // erreur de compilation : Nurrber n'est pas claisse ascendante de Pointcol

		
	}
}

class Couple1<T> {
	private T x, y;

	public Couple1(T premier, T second) {
		x = premier;
		y = second;
	}

	public T getPremier() { return x; }
	public void setPremier(T premier) { x = premier; }
	
	public boolean comparePremier(T tiers) {
		return x==tiers? true : false;
	}

	public void affiche() {
		System.out.println("premiere valeur : " + x + " - deuxieme valeur : " + y);
	}
}

class Point { }
class PointCol extends Point {}
