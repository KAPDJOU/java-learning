package chap10_Exceptions;

public class ExceptInfo {
    public static void main(String args[]) {

    }
}

/** 3 Transmission d’information au gestionnaire d’exception | page 318 */

class ErrConst2 extends Exception {

    private static final long serialVersionUID = 1L;
    public int abs, ord;

    ErrConst2(int abs, int ord) {
        this.abs = abs;
        this.ord = ord;
    }

    ErrConst2(String mes) {
        super(mes);
    }
}

/** 3.1 Par l’objet fourni à l’instruction throw */

class Point2 {
    private int x, y;

    public Point2(int x, int y) throws ErrConst2 {
        if ((x < 0) || (y < 0))
            throw new ErrConst2(x, y);
        this.x = x;
        this.y = y;
    }

    public void affiche() {
        System.out.println("coordonnees : " + x + " " + y);
    }
}

class PlayExceptionPoint2 {
    public static void main(String args[]) {
        try {
            Point2 a = new Point2(1, 4);
            a.affiche();
            a = new Point2(-3, 5);
            a.affiche();
        } catch (ErrConst2 e) {
            System.out.println("Erreur construction Point2");
            System.out.println("  coordonnees souhaitees : " + e.abs + " " + e.ord);
            System.exit(-1);
        }

        // output
        // coordonnees : 1 4
        // Erreur construction Point2
        // coordonnees souhaitees : -3 5
    }
}

/** 3.2 Par le constructeur de la classe exception */

class Point3 {
    private int x, y;

    public Point3(int x, int y) throws ErrConst2 {
        if ((x < 0) || (y < 0))
            throw new ErrConst2("Erreur construction avec coordonnees " + x + " " + y);
        this.x = x;
        this.y = y;
    }

    public void affiche() {
        System.out.println("coordonnees : " + x + " " + y);
    }

}

class PlayExceptionPoint3 {
    public static void main(String args[]) {
        try {
            Point3 a = new Point3(1, 4);
            a.affiche();
            a = new Point3(-3, 5);
            a.affiche();
        } catch (ErrConst2 e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }

        // output
        // coordonnees : 1 4
        // Erreur construction avec coordonnees -3 5
    }
}
