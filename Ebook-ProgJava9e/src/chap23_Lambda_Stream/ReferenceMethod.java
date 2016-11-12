package chap23_Lambda_Stream;


/** Chap23 | 4 - Références de méthodes */

public class ReferenceMethod {
    public static void main(String[] args) {        
    }
}

/** chap23 | 4.1 | p710 | Référence à une méthode statique */

class RefMethStat {
	public static void main(String[] args) {
		traite(5, RefMethStat::carre); // référence à la méthode carre de la classe ReJStat // au lieu de : traite (5, x -> x*x) ;
		traite(12, RefMethStat::trinome); // au lieu de : traite (12, x -> 2*x*x + 3*x +5)
		
		// output : 
		// calcul (5) = 25
		// calcul (12) = 329
	}

	public static void traite(int n, Calculateur cal) {
		int res = cal.calcul(n);
		System.out.println("calcul (" + n + ") = " + res);
	}

	public static int carre(int n) { return n * n; } // meme types que calcul
	public static int trinome(int n) { return 2 * n * n + 3 * n + 5; } // idem
}

/** chap23 | 4.2 | p711 | Référence à une méthode de classe */

class Point {
    private int x, y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distance_a(Point p) { return p.x - this.x; }
    public int distance1(Point p) { return p.x - this.x; }
    public int distance2(Point p) { return p.y - this.y; }
    
    public int getX() { return this.x; }
    public int getY() { return this.y; }

}

@FunctionalInterface
interface Distanciable {
    public int distance(Point p1, Point p2);
}

class RefMethClassse {
    public static void main(String[] args) {
        Point p1 = new Point(1, 3), p2 = new Point(3, 8);
        
        Distanciable dlamb = (pp1, pp2) -> pp2.getX() - pp1.getX(); // implémentation avec un expression lambda classique
        System.out.println("distance entre p1 et p2 =  " + dlamb.distance(p1, p2)); // distance entre p1 et p2 =  2
        
        Distanciable d1 = Point::distance1; // référence à la méthode distanceI de la classe Point
        System.out.println("distance1 entre p1 et p2 = " + d1.distance(p1, p2)); // distance1 entre p1 et p2 = 2
        
        Distanciable d2 = Point::distance2; // référence à la méthode distance2 de la classe Point
        System.out.println("distance2 entre p1 et p2 = " + d2.distance(p1, p2)); // distance2 entre p1 et p2 = 5
    }
}

/** chap23 | 4.3 | p712 | Référence à une méthode associée à un objet */

interface DistanciableDe {
    public int distance_a(Point p);
}

class RefMethInst {
    public static void main(String[] args) {
        Point p1 = new Point(1, 3), p2 = new Point(3, 8), origine = new Point(0, 0), p = new Point(1, 2);
        
        DistanciableDe distOrig = origine::distance_a; // référence à la méthode distanee_a appliquée à l'objet origine 
        // equivalent a : distOrig = pp -> origine.distance_a (pp) ;
        System.out.println("Distance de p1 a origine = " + distOrig.distance_a(p1)); // Distance de pl a origine = 1
        
        DistanciableDe dist_p = p::distance_a;
        System.out.println("Distance de p1 a p = " + dist_p.distance_a(p2)); // Distance de pl a p = 2
    }
}

/** chap23 | 4.4 | p713 | Références à un constructeur */

