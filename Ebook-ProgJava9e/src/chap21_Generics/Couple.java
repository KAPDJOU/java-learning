package chap21_Generics;

/** page 630 | classe générique à un seul paramètres */

public class Couple<T> {
	private T x, y; // les deux elements du couple
	static int compte ; // champs statique
	
	public Couple(T premier, T second) {
		x = premier;
		y = second;
		compte++; 
		 
	}

	public T getPremier() {
		return x;
	}

	public void affiche() {
		System.out.println("premiere valeur : " + x + " - deuxieme valeur : " + y);
	}
}

class PlayCouple {
    public static void main(String args[]) {
        
        Integer oi1 = 3; 
        Integer oi2 = 5;
        Couple<Integer> ci = new Couple<>(oi1, oi2);
        ci.affiche(); // premiere valeur : 3 - deuxieme valeur : 5
        
        Couple<Double> cd = new Couple<>(2.0, 12.0);
        cd.affiche(); // premiere valeur : 2.0 - deuxieme valeur : 12.0       
        Double p = cd.getPremier();
        System.out.println("premier element du couple cd = " + p); // premier element du couple cd = 2.0

        System.out.println ("compte Couple = " + Couple.compte) ; // compte Couple = 2
        
        // Seul le type brut est connu lors de l’exécution
        System.out.println(ci instanceof Couple); // true
        System.out.println(cd instanceof Couple); // true
        System.out.println(cd instanceof Couple<?>); // true
        System.out.println(cd instanceof Couple<?>);  // true
    }
}



/** page 632 | classe générique à plusieurs paramètres de type*/

class CoupleM<T, U> {
    private T x; 
    private U y;

    public CoupleM(T premier, U second) {
        x = premier;
        y = second;
    }

    public T getPremier() {
        return x;
    }

    public void affiche() {
        System.out.println("première valeur : " + x + " - deuxième valeur : " + y);
    }
}

class PlayCoupleM {
    public static void main(String args[]) {
        Integer oi1 = 3;
        Double od1 = 2.5;
        CoupleM<Integer, Double> ch1 = new CoupleM<>(oi1, od1);
        ch1.affiche();

        Integer oi2 = 4;
        CoupleM<Integer, Integer> ch2 = new CoupleM<>(oi1, oi2);
        ch2.affiche();

        Integer n = ch1.getPremier();
        System.out.println("premier element du couple ch1 = " + n);
        
        /*
         * premi�re valeur : 3 - deuxi�me valeur : 2.5 premi�re valeur : 3 - deuxi�me
         * valeur : 4 premier element du couple ch1 = 3
         */
    }
}

