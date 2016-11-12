package chap23_Lambda_Stream;

import java.util.stream.*;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.*;

public class Streams {
    public static void main(String[] args) {

        // Création à partir d’une liste de valeurs
        // stream d’entiers associé aux valeurs indiquées
        IntStream str_int = IntStream.of(3, 9, 2, 4, 5, 8);
        // stream de Integer associé aux mêmes valeurs
        Stream<Integer> str_Int = Stream.of(3, 9, 2, 4, 5, 8);
        // d’un tableau de valeurs :
        int[] tab = { 4, 8, 2, 9, 12 };
        IntStream str_int2 = IntStream.of(tab);
        PointXY[] tabP = { new PointXY(1, 3), new PointXY(2, 5) };
        Stream<PointXY> strP = Stream.of(tabP);

        // Création avec une fonction génératrice
        Stream.generate(() -> "bonjour"); // on obtiendra un Stream<String> formé d’une suite (a priori infinie) de
                                          // chaînes contenant la valeur "bonjour"
        Stream.generate(Math::random); // ou Stream,generate( () -> Math,randcm())
        // on obtiendra un DoubleStream formé d’une suite de valeurs aléatoires de type double
        Stream.generate(Math::random).limit(8).forEach(ee -> System.out.print(ee + " ")); // affiche 8 nombrestirés au
                                                                                          // hasard :

        // Création avec une méthode itérative
        // générer une suite de 10 entiers successifs, à partir de 5 :
        Stream.iterate(5, (ee -> ee + 1)).limit(10);
        // générer 30 nombres pairs consécutifs, à partir de 0:
        Stream.iterate(0, (ee -> ee + 2)).limit(30);

        // générer une suite de valeurs consécutives dans un intervalle donné
        IntStream.range(20, 30); // génère le suite : 20 21 22 23 24 25 26 27 28 29
        IntStream.rangeClosed(20, 30); // génère la suite : 20 21 22 23 24 25 26 27 28 29 30

        // Création d’un stream parallèle : parallelStream OR parallel
        Stream.of(1, 8, -3, 5, -11, 3, 7, 12, 5).parallel();

    }
}

/** chap23 | page 720 | 9.2 Différentes façons de créer un stream, Les différentes sources d’un stream */

class SourceStreams {
    public static void main(String[] args) {

        Integer tabObj[] = { 3, 8, 2, -4, 0, 12, 8, -5, 3, -4, 15 };
        List<Integer> liste = Arrays.asList(tabObj);

        System.out.println("-- Filtrage des > 0 avec une collection :");
        liste.stream().filter(ee -> ee > 0).forEach(ee -> System.out.print(ee + " "));
        // 3 8 2 12 8 3 15

        System.out.println("\n-- Filtrage des >0 avec une collection, en parallele :");
        liste.parallelStream().filter(ee -> ee > 0).forEach(ee -> System.out.print(ee + " "));
        // 8 12 15 2 8 3 3

        System.out.println("\n-- Filtrage des >0 avec une collection, en parallele, avec forEachOrdered :");
        liste.parallelStream().filter(ee -> ee > 0).forEachOrdered(ee -> System.out.print(ee + " "));
        // 3 8 2 12 8 3 15

        System.out.println("\n-- Filtrage des pairs avec une liste de valeurs");
        Stream.of(1, 8, -3, 5, -11, 3, 7, 12, 5).filter(ee -> 2 * (ee / 2) == ee)
                .forEach(ee -> System.out.print(ee + " "));
        // 8 12

        System.out.println("\n-- Filtrage des >0 avec un tableau");
        Stream.of(tabObj).filter(ee -> ee > 0).forEach(ee -> System.out.print(ee + " ")); // ereur compil si tab de type
                                                                                          // int
        // 3 8 2 12 8 3 15

        System.out.println("\n-- Avec generation valeurs aleatoires entieres entre 0 et 9");
        Stream.generate(Math::random).limit(8).map(ee -> (int) (ee * 10)).forEach(ee -> System.out.print(ee + " "));
        // 8 1 7 2 9 6 0 1

        System.out.println("\n-- Avec methode iterative");
        Stream.iterate(15, (ee -> 2 * ee)).limit(10).forEach(ee -> System.out.print(ee + " "));
        // 15 30 60 120 240 480 960 1920 3840 7680
    }
}

/** chap23 | page 723 | 10 - Les méthodes intermédiaires d’un stream */
class StreamInter {
    public static void main(String[] args) {

        Integer[] tab = { 2, 15, -3, 2, -5, 34, 23, 4, -8, 12 };

        System.out.println("--- Carres des negatifs, double des positifs");
        Stream.of(tab).map(e -> {
            return (e > 0) ? (2 * e) : (e * e);
        }) // ici, on peut aussi utiliser mapToInt
                .forEach(e -> System.out.print(e + " "));
        // 4 30 9 4 25 68 46 8 64 24

        System.out.println("\n--- Valeurs et nombres de negatifs");
        long nb_neg = Stream.of(tab).filter(e -> e < 0).peek(e -> System.out.print(e + " ")).count();
        System.out.println(" ** Nombre de negatifs : " + nb_neg);
        // -3 -5 -8 ** Nombre de negatifs : 3

        System.out.println("--- Valeurs triees ordre naturel :");
        Stream.of(tab).sorted().forEach(e -> System.out.print(e + " "));
        // -8 -5 -3 2 2 4 12 15 23 34

        System.out.println("\n--- Valeurs triees ordre naturel en parallele, avec forEachOrdered :");
        Stream.of(tab).parallel().sorted().forEachOrdered(e -> System.out.print(e + " "));
        // -8 -5 -3 2 2 4 12 15 23 34

        System.out.println("\n--- Valeurs triees ordre inverse, sans doublons :");
        Stream.of(tab).sorted(Comparator.reverseOrder()) // impossible si int[]tab
                .distinct().forEach(e -> System.out.print(e + " "));
        // 34 23 15 12 4 2 -3 -5 -8
    }
}

/** chap23 | page 725 | 11 - Les méthodes terminales d’un stream */

class StreamTer {
    public static void main(String[] args) {

        int[] tab = { 2, 15, -3, 2, -5, 34, 23, 4, -8, 12 };

        // max, min, sum, average sur un IntStream

        OptionalInt max = IntStream.of(tab).max();
        // exploitation de max avec isPresent
        if (max.isPresent())
            System.out.println("Max pos de tab avec isPresent = " + max.getAsInt());
        // exploitation de max avec orElse (par convention ici 0 si valeur absente)
        System.out.println("Max pos de tab avec orElse =    " + max.orElse(0));
        // exploitation de max avec ifPresent
        max.ifPresent(xx -> System.out.println("Max pos de tab avec ifPresent = " + max.getAsInt()));

        int somme = IntStream.of(tab).filter(ee -> ee > 0).sum();
        System.out.println("Somme des positifs de tab : " + somme);

        int somme2 = IntStream.of(tab).filter(ee -> ee < 0).sum();
        System.out.println("Somme des < 0 de tab : " + somme2);

        OptionalDouble moyenne = IntStream.of(tab).filter(ee -> ee < 0).average();
        if (moyenne.isPresent())
            System.out.println("Moyenne des <0 de tab = " + moyenne.getAsDouble());
        else
            System.out.println("Aucun nombre <0 dans tab");

        // max sur un Stream<Integer>
        Integer[] tabObj = { 2, 15, -3, 2, -5, 34, 23, 4, -8, 12 };
        Optional<Integer> maxObj = Stream.of(tabObj).max(Comparator.naturalOrder());
        if (maxObj.isPresent())
            System.out.println("Max des positifs de tabObj = " + maxObj.get());

        // Max pos de tab avec isPresent = 34
        // Max pos de tab avec orElse = 34
        // Max pos de tab avec ifPresent = 34
        // Somme des positifs de tab : 92
        // Somme des <0 de tab : -16
        // Moyenne des <0 de tab = -5.333333333333333
        // Max des positifs de tabObj = 34
    }
}

/** Chap23 | page 727 | 12 - La méthode reduce */

class PlayStreamReduce {
    public static void main(String[] args) {

        int[] tab = { 2, 15, -3, 2, -5, 34, 23, 4, -8, 12 };
        IntStream stri = IntStream.of(tab);
        int x = stri.reduce(0, (xx, yy) -> xx + yy); // somme des éléments du stream
        // initialisation à 0 d’un "accumulateur"
        // pour chaque élément du stream realise l’opération indiquée (de type IntUnaryOperalor) entre l’accumulateur
        // (valeur courante) et cet élément
        System.out.println(x); // 76

        PointXY[] tabP = { new PointXY(1, 3), new PointXY(2, 5) };
        Stream<PointXY> strPoints = Stream.of(tabP);
        // calculer un nouveau point, dont chacune des coordonnées est la somme des coordonnées des points du stream
        PointXY somme2 = strPoints.reduce(new PointXY(0, 0),
                (p, q) -> (new PointXY(p.getX() + q.getX(), p.getY() + q.getY())));
        somme2.affiche(); // [ 3, 8 ]
    }
}

/** Chap23 | page 728 | 12 - La méthode Collect */

class PlayStreamCollect {
    public static void main(String[] args) {
        
        System.out.println("------Collectors.toList()");
        Stream<Integer> strInt = Stream.of(3, 9, 2, 4, 5, 8);
        List<PointXY> listePoint = strInt.map(e -> new PointXY(e, 2 * e)).collect(Collectors.toList());
        listePoint.forEach(p -> p.affiche());

        System.out.println("\n------Collect.toSet()");
        Set<PointXY> ensemble = Stream.of(3, 9, 2, 4, 5, 8)
                                    .map(e -> new PointXY(e, 2 * e))
                                    .collect(Collectors.toSet());
        ensemble.forEach(p -> p.affiche());
        
        System.out.println("\n------Collectors.toMap()");
        // Ici, nous construisons, à partir du même Stream<Integer> un Map où les clés sont les abscisses des points et
        // où les valeurs sont les points eux-mèmes:
        Map<Integer, PointXY> mapPoints = Stream.of(3, 9, 2, 4, 5, 8)
                                            .distinct()
                                            .map(e -> new PointXY(e, 2 * e))
                                            .collect(Collectors.toMap(PointXY::getX, e -> e));
        mapPoints.forEach((k, v) -> v.affiche());

        System.out.println("\n------Collectors.groupingBy()");
        // Collectors.groupingBy permet de créer un map à partir de clés spécifiées
        // à partir du même Stream < Integer>, nous pouvons créer un Map<lnteger, List<Point», où les points de même
        // abscisse sont regroupés dans une liste :
        Map<Integer, List<PointXY>> mapPoints2 = Stream.of(3, 9, 2, 4, 5, 8)
                                                    .map(e -> new PointXY(e , 2*e) )
                                                    .collect (Collectors.groupingBy(PointXY::getX) ) ;
        mapPoints2.forEach((k, v) -> System.out.print(k));
        
        System.out.println("\n------Collectors.joining()");
        // permet de concaténer des éléments de type String
        String ch = Stream.of(3, 9, 2, 4, 5, 8)
                    .map(xx -> new Point (xx, 2*xx) )
                    .map(xx -> " [ "+xx.getX ( ) +" , "+xx.getY ( ) +" ] " )
                    .collect (Collectors.joining ( " ; " ) ) ;

    }
}