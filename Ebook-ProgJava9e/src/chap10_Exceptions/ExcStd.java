package chap10_Exceptions;

import Annexe_Utils.Clavier;

/** 5 Les exceptions standards | page 329 */
public class ExcStd {
    public static void main(String args[]) {

    }
}

/**
 * exemple de programme qui détecte les exceptions standards NegativeArruySizeException et ArraylndexOutOfBomdsException
 * et qui utilise la méthode getMessage pour afficher le message correspondant
 */
class ExcStd1 {
    public static void main(String args[]) {
        try {
            int t[];
            System.out.print("taille voulue : ");
            int n = Clavier.lireInt();
            t = new int[n];
            System.out.print("indice : ");
            int i = Clavier.lireInt();
            t[i] = 12;
            System.out.println("*** fin normale");
        } catch (NegativeArraySizeException e) {
            System.out.println("Exception taille tableau negative : " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception indice tableau : " + e.getMessage());
        }
    }

    // taille voulue : -2
    // Exception taille tableau negative :
}

/** le programme précédent sans détection d'exceptions */
class ExcStd2 {
    public static void main(String args[]) {
        int t[];
        System.out.print("taille voulue : ");
        int n = Clavier.lireInt();
        t = new int[n];
        System.out.print("indice : ");
        int i = Clavier.lireInt();
        t[i] = 12;
        System.out.println("*** fin normale");
    }
}
