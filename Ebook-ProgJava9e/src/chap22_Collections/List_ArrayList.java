package chap22_Collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class List_ArrayList {
    public static void main(String args[]) {
    }
}


class Array1 {
	public static void main(String args[]) {
		ArrayList<Integer> v = new ArrayList<Integer>();
		// ArrayList v = new ArrayList () ; <-- avant JDK5.0
		System.out.println("En A : taille de v = " + v.size());

		/* on ajoute 10 objets de type Integer */
		for (int i = 0; i < 10; i++)
			v.add(new Integer(i));
		System.out.println("En B : taille de v = " + v.size());

		/* affichage du contenu, par acces direct (get) a chaque element */
		System.out.println("En B : contenu de v = ");
		for (Integer e : v) // for (int i = 0 ; i<v.size() ; i++) <-- avant
							// JDK5.0
			System.out.print(e + " "); // System.out.print (v.get(i)+" ") ; <--
		System.out.println();

		/* suppression des elements de position donnee */
		v.remove(3);
		v.remove(5);
		v.remove(5);
		System.out.println("En C : contenu de v = " + v);

		/* ajout d'elements a une position donnee */
		v.add(2, new Integer(100));
		v.add(2, new Integer(200));
		System.out.println("En D : contenu de v = " + v);

		/* modification d'elements de position donnee */
		v.set(2, new Integer(1000)); // modification element de rang 2
		v.set(5, new Integer(2000)); // modification element de rang 5
		System.out.println("En D : contenu de v = " + v);
	}
}

class Array2 {
    public static void main(String args[]) {
        ArrayList v = new ArrayList();
        /* on introduit 10 elements de type Integer */
        for (int i = 0; i < 10; i++)
            v.add(new Integer(i));
        /* puis 4 elements de type String */
        v.add(2, "AAA"); // en position 2
        v.add(4, "BBB"); // en position 4
        v.add(8, "CCC"); // en position 8
        v.add(5, "DDD"); // en position 5
        System.out.println("En I   : contenu de v = " + v);
        /* on remplace tous les objets de type chaine par la reference null */
        for (int i = 0; i < v.size(); i++)
            if (v.get(i) instanceof String)
                v.set(i, null);
        System.out.println("En II  : contenu de v = " + v);

        /* on cree une nouvelle collection (ici une liste) contenant deux */
        /*
         * elements : une reference a un objet Integer (5), une reference null
         */
        LinkedList l = new LinkedList();
        l.add(new Integer(5));
        l.add(null);
        v.removeAll(l);
        System.out.println("En III : contenu de v = " + v);
    }
}

/*
 * En I : contenu de v = [0, 1, AAA, 2, BBB, DDD, 3, 4, 5, CCC, 6, 7, 8, 9] En
 * II : contenu de v = [0, 1, null, 2, null, null, 3, 4, 5, null, 6, 7, 8, 9] En
 * III : contenu de v = [0, 1, 2, 3, 4, 6, 7, 8, 9]
 */
