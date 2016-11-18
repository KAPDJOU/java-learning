package chap10_Exceptions;

import Annexe_Utils.Clavier;

public class Except {
    public static void main(String args[]) {        
    }
}

class Point {

    private int x, y;

    public Point(int x, int y) throws ErrConst {
        if ((x < 0) || (y < 0))
            throw new ErrConst();
        this.x = x;
        this.y = y;
    }

    public void deplace(int dx, int dy) throws ErrDepl {
        if (((x + dx) < 0) || ((y + dy) < 0))
            throw new ErrDepl();
        x += dx;
        y += dy;
    }
    
    public void f1() throws ErrConst {
        try {
            Point p = new Point(-3, 2);
        } catch (ErrConst e) {
            System.out.println("dans catch (ErrConst) de f");
            throw e; // on repasse l'exception � un niveau superieur
        }
    }
    
    public void f2() throws ErrConst, ErrBidon {
        try {
            Point p = new Point(-3, 2);
        } catch (ErrConst e) {
            System.out.println("dans catch (ErrConst7) de f");
            throw new ErrBidon(); // on lance une nouvelle exception
        }
    }
    
    public void affiche() {
        System.out.println("coordonnees : " + x + " " + y);
    }

}

class ErrConst extends Exception {
    private static final long serialVersionUID = 1L;
}

class ErrDepl extends Exception {
    private static final long serialVersionUID = 1L;
}

class ErrBidon extends Exception {
}

/** 1 Premier exemple d’exception | page 90 */

class Except1 {
    public static void main(String args[]) {
        try {
            Point a = new Point(1, 4);
            a.affiche();
            a = new Point(-3, 5);
            a.affiche();
        } catch (ErrConst e) {
            System.out.println("Erreur construction ");
            System.exit(-1);
        }

        // Output :
        // coordonnées : 1 4
        // Erreur construction
    }
}


/** 2 Gestion de plusieurs exceptions | page 316 */

class Except2 {
    public static void main(String args[]) {
        System.out.println ("avant bloc try") ;
        try {
            Point a = new Point(1, 4);
            a.affiche();
            a.deplace(-3, 5);
            a = new Point(-3, 5);
            a.affiche();
        } catch (ErrConst e) {
            System.out.println("Erreur construction ");
            System.exit(-1);
        } catch (ErrDepl e) {
            System.out.println("Erreur deplacement ");
            System.exit(-1);
        }
        System.out.println ("apres bloc try") ;

    }
}

/** 4.1 Poursuite de l’exécution | page 321 */

class SuiteExcept {
    public static void main(String args[]) {
        System.out.println ("avant bloc try") ;
        try {
            Point a = new Point(1, 4);
            a.affiche();
            a.deplace(-3, 5);
            a = new Point(-3, 5);
            a.affiche();
        } catch (ErrConst e) {
            System.out.println("Erreur construction ");
        } catch (ErrDepl e) {
            System.out.println("Erreur deplacement ");
        }
        System.out.println ("apres bloc try") ; // l’exécution se poursuit simplement avec les instructions suivant le bloc try
    }
    
    // OutPut :
    // avant bloc try
    // coordonnees : 1 4
    // Erreur deplacement
    // apres bloc try
}

/** 4.5 Redéclenchement d’une exception | page 324 */

class Redecl {
    public static void main(String args[]) {
        try {
            Point a = new Point(1, 4);
            a.f1();
        } catch (ErrConst e) {
            System.out.println("dans catch (ErrConst) de main");
        }
        System.out.println("apres bloc try main");
    }
    
    // OutPut
    //
    // dans catch (ErrConst ) de f
    // dans catch (ErrCcnst ) de main
    // apres bloc try main
}


/** Une exception peut en déclencher une autre */

class Redecl1 {
    public static void main(String args[]) {
        try {
            Point a = new Point(1, 4);
            a.f2();
        } catch (ErrConst e) {
            System.out.println("dans catch (ErrConst7) de main");
        } catch (ErrBidon e) {
            System.out.println("dans catch (ErrBidon) de main");
        }
        System.out.println("apres bloc try main");
    }
}

/** 4.6 Le bloc finally | page 327 */ 

class Finally {
    public static void main(String args[]) {
        try {
            System.out.println("debut bloc try du main");
            System.out.print("donnez un entier : ");
            int n = Clavier.lireInt();
            Point a = new Point(n, n);
            System.out.println("fin bloc try du main");
        } catch (ErrConst e) {
            System.out.println("dans catch (ErrConst4) de main");
        } finally {
            System.out.println("execution du bloc finally");
        }
        System.out.println("apres bloc try main");
    }
    
    // output
    // debut bloc try du main
    // ..
    // execution du bloc finally
    // apres bloc try main
}