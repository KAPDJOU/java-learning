package chap25_DateTime;

import java.time.*;

public class Instant_Duration {
    public static void main(String[] args) {
    }
}

/** 1.2.1 Calcul d’une durée d’exécution - page 758 */

class CalculDuree {
    public static void main(String[] args) {
        Instant debut = Instant.now();
        // traitement fictif
        for (long i = 0; i < 100_000_000; i++) {
            double x = Math.random();
        }
        Instant fin = Instant.now();
        Duration duree = Duration.between(debut, fin);
        long duree_ms = duree.toMillis(); // duree totale en ms
        long duree_ns = duree.toNanos(); // duree totale en ns
        System.out.println("duree en ms   : " + duree_ms);
        System.out.println("duree en ns   : " + duree_ns);
        long nb_nanos = duree.getNano(); // partie en ns de la duree
        long nb_sec = duree.getSeconds(); // partie en s de la duree
        System.out.println("duree en s ns : " + nb_sec + "s " + nb_nanos + "ns");

        // duree en ITS : 2933
        // duree en ns : 2933000000
        // duree en s ns : 2s 933000ûûûns
    }
}

/** 1.2.2 Réalisation d'une boucle de durée déterminée */

class BoucleDuree {
    public static void main(String[] args) {
        final int DUREE_BOUCLE_MS = 2500; // ou long
        // .....
        Instant maintenant = Instant.now();
        System.out.println("Debute a : " + maintenant);
        Instant fin = maintenant.plusMillis(DUREE_BOUCLE_MS);
        do { // traitement
            maintenant = Instant.now();
        } while (fin.isAfter(maintenant));
        System.out.println("Fini a :   " + maintenant);
    }
}