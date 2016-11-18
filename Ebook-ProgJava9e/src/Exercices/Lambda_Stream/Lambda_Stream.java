package Exercices.Lambda_Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Programmez en java - 175 exercices corrigés - Eyrolles Juin 2014 - Claude delannoy
 * 
 * @author Malick
 */
public class Lambda_Stream {
    public static void main(String[] args) {
    }
}

/** EXO 169 | Lambda et interfaces prédéfinies */

class Exo169 {
    public static void main(String[] args) {
        int[] tab = { 1, 4, -2, 9, -3, 5, -3 };
        System.out.println("— Les positifs de tab : ");
        affichage_selectif_1(tab, ee -> ee > 0);
        affichage_selectif_2(tab, ee -> ee > 0);
    }

    private static void affichage_selectif_1(int[] tab, Filtrage checker) {
        System.out.print("Sol 1 | interface personnalisée : ");
        for (int element : tab) {
            if (checker.filtre(element))
                System.out.print(element + " ");
        }
        System.out.println();
    }

    private static void affichage_selectif_2(int[] tab, IntPredicate checker) {
        System.out.print("Sol 2 | interface prédéfinie : ");
        for (int element : tab) {
            if (checker.test(element))
                System.out.print(element + " ");
        }
        System.out.println();
    }
}

@FunctionalInterface
interface Filtrage {
    boolean filtre(int a);
}

/** Exo 170 | Lambda et références */

class Exo170 {
    public static void main(String[] args) {
        int[] tab = { 1, 4, -2, 9, -3, 5, -3, 12, 7, -11, 0, 6 };

        System.out.println("Sol 1 | lambda : ");
        {
            System.out.print("— Les positifs : ");
            affichage_selectif(tab, x -> x > 0);
            System.out.print("— Les négatifs : ");
            affichage_selectif(tab, x -> x < 0);
            System.out.print("— Les pairs : ");
            affichage_selectif(tab, x -> 2*(x/2) == x);
        }

        System.out.println();
        
        System.out.println("Sol 2 | Method Reference : ");
        {
            System.out.print("— Les positifs : ");
            affichage_selectif(tab, Exo170::filtragePositifs);
            System.out.print("— Les négatifs : ");  
            affichage_selectif(tab, Exo170::filtrageNegatifs);
            System.out.print("— Les pairs : ");
            affichage_selectif(tab, Exo170::filtragePairs);
        }
    }

    public static void affichage_selectif(int[] tab, IntPredicate checker) {
        for (int val : tab) {
            if (checker.test(val))
                System.out.print(val + " ");
        }
        System.out.println();
    }
    
    public static Boolean filtrageNegatifs (int n) { return n < 0 ; }
    public static Boolean filtragePositifs (int n) { return n > 0 ; }
    public static Boolean filtragePairs (int n) { return 2*(n/2)==n ; }
}

/** Exo 171 | L’interface Comparator */

class Point {
    private int x, y ;
    
    public Point (int x, int y) { 
      this.x = x ; this.y = y; 
    }
    
    public int getX() { return x ; }
    public int getY() { return y ; }
    
    public void affiche () { 
        System.out.print(" [ " + x + ", " + y + " ] " ) ; 
    }
}

class Exo171 {
    public static void main(String[] args) {
    
        Point tab[] = { new Point(2, 5), new Point(-2, 3), new Point(6, -3), new Point(-3, -2) };
        
        ArrayList<Point> liste = new ArrayList<>();
        for (Point p : tab) liste.add(p);
        System.out.print("Liste Avant tri : ");
        liste.forEach(Point::affiche);  
  
        System.out.println("\n1 - sélection des points d'abscisse positive, tri sur l'abscisse");
        Predicate<Point> pred = p -> p.getX() > 0;
        Comparator<Point> compA = Comparator.comparing(Point::getX); // methode de référene
        Comparator<Point> compB = (pl, p2) -> ((Integer)(pl.getX())).compareTo(((Integer)(p2.getX()))); // comparateur sous forme d'expression lambda
        Comparator<Point> compC = (p1, p2) -> p2.getX() - p1.getX();
        // Consumer<Point> affichage1 = p -> p.affiche();
        Consumer<Point> aff = Point::affiche;
        
        traiteListe(liste, pred, compA, aff);
                        
        System.out.println("\n2 - Tri de tous les points suivant la somme de leurs coordonnées");
        traiteListe(liste, 
                p -> true, 
                Comparator.comparing(p -> p.getX() + p.getY()),
                (xx -> System.out.print("(abs = " + xx.getX() + ", ord = " + xx.getY() + ")")));
    }
    
    public static void traiteListe(ArrayList<Point> liste, Predicate<Point> select, Comparator<Point> comp, Consumer<Point> aff) {
        // selection
        List<Point> listeSelectionee = new ArrayList<Point>();
        liste.forEach( p -> { if (select.test(p)) listeSelectionee.add(p); });
        // Tri
        listeSelectionee.sort(comp); // ou  Collections.sort(listeSelectionee, tri);
        // affichage
        listeSelectionee.forEach(aff::accept);
    }
}

/** Exo 173 | Traitement de liste avec un stream */

class Exo173 {
    public static void main (String args[]) { 
        
        Point tab[] = { new Point(2, 5), new Point(-2, 3), new Point(6, -3), new Point(-3, -2) };
        ArrayList<Point> liste = new ArrayList<>();
        for (Point p : tab) liste.add(p);
        System.out.print("Liste Avant tri : ");
        liste.forEach(p -> p.affiche());

        System.out.println("\n\n1 - sélection des points d'abscisse positive, tri sur l'abscisse");
        liste.stream().filter(p -> p.getX() > 0)
            .sorted(Comparator.comparing(Point::getX))
            .forEach(Point::affiche);
        
        System.out.println("\n\n2 - Tri de tous les points suivant la somme de leurs coordonnées");
        liste.stream()
                .sorted(Comparator.comparing(p -> p.getX() + p.getY()))
                .forEach(xx -> System.out.print("(abs = " + xx.getX() + ", ord = " + xx.getY() + ")"));
    }

    public static void traiteListe(ArrayList<Point> liste, Predicate<Point> select, Comparator<Point> comp,
            Consumer<Point> aff) {
        liste.stream().filter(select).sorted(comp).forEach(aff);
    }
}
    
/** Exo 172 | Les méthodes usuelles des streams */

class Exo172 {
    public static void main (String args[]) { 
        
        int[] tab = { 3, 5, -3, 8, 12, 4, 7, 4, 8, 3 };

        // Instruction 1 
        // crée un stream à partir du tableau d’entiers Tab. La méthode filter filtre les
        // éléments positifs et ceux-ci sont comptabilisés par la méthode terminale count.
        long nb = IntStream.of(tab).filter(x -> x > 0).count();
        System.out.println("nb = " + nb);

        // Instruction 2 
        // crée le même stream, en sélectionnant cette fois les éléments de valeur
        // supérieure à 3, en les triant suivant l’ordre naturel et en les affichant.
        IntStream.of(tab).filter(x -> x > 3).sorted().forEach(xx -> System.out.print(xx + " "));

        // Instruction 3 
        // fait la même chose que l’instruction 2 avec cette différence que, après le tri, on
        // évite de conserv er des valeurs en double, grace à la méthode distinct.
        System.out.println();
        IntStream.of(tab).filter(xx -> xx > 3).sorted().distinct().forEach(xx -> System.out.print(xx + " "));

        // Instruction 4 
        // effectue une première transformation associant à chaque nombre sa
        // valeur absolue, puis une seconde transformation associant à chaque élément son carré (notez
        // qu'ici on obtiendrait le même résultat, en supprimant la méthode map ). Enfin, la méthode
        // terminale sum effectue la somme de ces derniers.
        int s = IntStream.of(tab).map(xx -> Math.abs(xx)).map(xx -> xx * xx).sum();
        System.out.println("\nresultat = " + s);
    }
}


/** Exo 174 et 175 | Répertoire */

class Exo174 {
    public static void main (String args[]) { 

        Personne[] tab = { new Personne("thibault","Rougier", 2001),
                            new Personne ("thomas", "Niesseron", 1987),
                            new Personne ("thifaine", "Mitenne", 1959),
                            new Personne ("maxime", "Forest", 1995),
                            new Personne ("jules", "Forest", 1995) };
        Arrays.asList(tab).forEach(p -> System.out.println(p.getPrenom() + ", " + p.getNom() + ", " + p.getAnnee()));
        
        // le nom des personnes nées après 1985
        System.out.println("\n\n1 - Nés apres 1985 : ");
        Stream.of(tab).filter(p -> p.getAnnee() > 1985)
                      .forEach(p -> System.out.print(p.getPrenom() + ", "));
        
        // le nom des personnes nées avant 2000, triés par ordre alphabétique sur leur nom, et afficher leur nombre ;
        System.out.println ("\n\n2 - Nés avant 2000");
        long nombre = Stream.of(tab).filter(p -> p.getAnnee() < 2000)
                                    .sorted(Comparator.comparing(Personne::getNom))
                                    .peek(p -> System.out.print(p.getNom() + ", "))
                                    .count();
        System.out.println("\n Ils sont " + nombre) ;
        
        // les noms et prénoms, triés par ordre alphabétique sur leur nom et leur prénom.
        System.out.println("\n\n3 - Tous tries sur non + prénom ! ") ;
        Stream.of(tab).sorted(Comparator.comparing(p -> p.getNom() + p.getPrenom()))
                      .forEach(p -> System.out.println("(" + p.getNom() + ", "+ p.getPrenom() + ")" ));
    }
}


class Exo175 {
    public static void main (String args[]) { 
        Personne[] tab = { new Personne("thibault","Rougier", 2001),
                new Personne ("thomas", "Niesseron", 1987),
                new Personne ("thifaine", "Mitenne", 1959),
                new Personne ("maxime", "Forest", 1995),
                new Personne ("jules", "Forest", 1995) };
        List<Personne> liste = Arrays.asList(tab);
        liste.forEach(p -> System.out.println(p.getPrenom() + ", " + p.getNom() + ", " + p.getAnnee()));

        // utilisation d' un Stream<Personne> transformé par map en IntStream
        OptionalInt anneeJeune = liste.stream().mapToInt(p -> p.getAnnee()).max();
        if (anneeJeune.isPresent()) 
            System.out.println("Méthode 1 - Le plus jeune est né en : " + anneeJeune.getAsInt());
        else 
            System.out.println("Liste vide");
        
        // recherche de min sur un Stream<Peraonne>
        Optional<Personne> personneJeune = liste.stream( ).max(Comparator.comparing(Personne::getAnnee));
        if (personneJeune.isPresent()) { 
            Personne pj = personneJeune.get();
            System.out.println ("Méthode 2 - Le plus jeune est : " 
                    + pj.getNom ( ) + " " + pj.getPrenom( ) + " " + pj.getAnnee() ) ;
        } else 
            System.out.println("Liste vide"); 
    }
}

class Personne { 
    private String nom, prénom ;
    private int annee_naissance ;
    
    public Personne(String prenom, String nom, int annee) { 
        this.nom = nom ; this.prénom = prenom ; this.annee_naissance = annee ; }
    
    public String getNom() { return this.nom ; }
    public String getPrenom() { return this.prénom ; }
    public int getAnnee() { return annee_naissance ; }
}



/** Exo 176 | Reduce */
class Exo176 {
    public static void main (String args[]) { 
        
    }
}

/** Exo 177 | Collect et Collectors */
class Exo177 {
    public static void main (String args[]) { 
        
    }
}
