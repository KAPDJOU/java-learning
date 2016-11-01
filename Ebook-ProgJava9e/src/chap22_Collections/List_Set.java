package chap22_Collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import Annexe_Utils.Clavier;

public class List_Set {
    public static void main(String args[]) {
    }
}

class Ens1 {
	public static void main(String args[]) {
		int t[] = { 2, 5, -6, 2, -8, 9, 5 };
		HashSet<Integer> ens = new HashSet<Integer>();
		// HashSet ens = new HashSet() ; <-- avant JDK5.0
		/* on ajoute des objets de type Integer */
		for (int v : t) // for (int i=0 ; i< t.length ; i++) <-- avant JDK5.0
		{
			boolean ajoute = ens.add(v);
			// boolean ajoute = ens.add (new Integer (t[i])) ; <-- avant JDK5.0
			if (ajoute)
				System.out.println("  On ajoute " + v);
			// if(ajoute) System.out.println(" On ajoute "+t[i]) ; <-- avant
			// JDK5.0
			else
				System.out.println("  " + v + " est deja present");
			// else System.out.println (" " + t[i] + " est deja present") ; <--
		}
		System.out.print("Ensemble en A = ");
		affiche(ens);
		/* on supprime un eventuel objet de valeur Integer(5) */
		Integer cinq = 5; // Integer cinq = new Integer (5) ; <-- avant JDK5.0
		boolean enleve = ens.remove(cinq);
		if (enleve)
			System.out.println("  On a supprime 5");
		System.out.print("Ensemble en B = ");
		affiche(ens);
		/* on teste la presence de Integer(5) */
		boolean existe = ens.contains(cinq);
		if (!existe)
			System.out.println("  On ne trouve pas 5");
	}

	public static <E> void affiche(HashSet<E> ens)
	// public static void affiche (HashSet ens) <-- avant JDK5.0
	{
		Iterator<E> iter = ens.iterator(); // Iterator iter = ens.iterator () ;
											// <--
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
	}
}



class Ens2 {
    public static void main(String args[]) {
        String phrase = "je me figure ce zouave qui joue";
        String voy = "aeiouy";
        HashSet<String> lettres = new HashSet<String>();
        // HashSet lettres = new HashSet() ; <-- avant JDK5.0
        for (int i = 0; i < phrase.length(); i++)
            lettres.add(phrase.substring(i, i + 1));
        System.out.println("lettres presentes : " + lettres);

        HashSet<String> voyelles = new HashSet<String>();
        // HashSet voyelles = new HashSet() ; <-- avant JDK5.0
        for (int i = 0; i < voy.length(); i++)
            voyelles.add(voy.substring(i, i + 1));
        lettres.removeAll(voyelles);
        System.out.println("lettres sans les voyelles : " + lettres);
    }
}



class Ens1a {
    public static void main(String args[]) {
        int t[] = { 2, 5, -6, 2, -8, 9, 5 };
        TreeSet ens = new TreeSet();
        /* on ajoute des objets de type Integer */
        for (int i = 0; i < t.length; i++) {
            boolean ajoute = ens.add(new Integer(t[i]));
            if (ajoute)
                System.out.println("  On ajoute " + t[i]);
            else
                System.out.println("  " + t[i] + " est deja present");
        }
        System.out.print("Ensemble en A = ");
        affiche(ens);
        /* on supprime un eventuel objet de valeur Integer(5) */
        Integer cinq = new Integer(5);
        boolean enleve = ens.remove(cinq);
        if (enleve)
            System.out.println("  On a supprime 5");
        System.out.print("Ensemble en B = ");
        affiche(ens);
        /* on teste la presence de Integer(5) */
        boolean existe = ens.contains(cinq);
        if (!existe)
            System.out.println("  On ne trouve pas 5");
        Clavier.lireInt();
    }

    public static void affiche(Set ens) {
        Iterator iter = ens.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }
}

/*
 * On ajoute 2 On ajoute 5 On ajoute -6 2 est deja present On ajoute -8 On
 * ajoute 9 5 est deja present Ensemble en A = -8 -6 2 5 9 On a supprime 5
 * Ensemble en B = -8 -6 2 9 On ne trouve pas 5
 */
