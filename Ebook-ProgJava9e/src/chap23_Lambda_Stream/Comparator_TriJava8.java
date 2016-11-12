package chap23_Lambda_Stream;

import java.util.*;

public class Comparator_TriJava8 {
    public static void main(String args[]) {        
    }
}

/** Chap 23 | page 715 | 7 Les nouvelles méthodes de l’interface Comparator */

class TriJava8 {
    public static void main(String args[]) {

        List<PointXY> liste = new ArrayList<PointXY>();
        PointXY tab[] = { new PointXY(2, 5), new PointXY(-2, 3), new PointXY(6, -3), new PointXY(-3, -2) };
        liste = Arrays.asList(tab); // méthode statique construisant une list a partir d' un tableau
        
        System.out.print("Avant tri : ");
        liste.forEach(p -> p.affiche());
        
        liste.sort((ppl, pp2) -> ((Integer) (ppl.getX())).compareTo((Integer) (pp2.getX())));
        System.out.print("\r Tri abscisses : ");
        liste.forEach(pp -> pp.affiche());
        
        liste.sort(Comparator.comparing(PointXY::getY));
        System.out.print("\r Tri ordonnées : ");
        liste.forEach(pp -> pp.affiche());
        
        liste.sort(Comparator.naturalOrder()); // possible parce que Point implemente Comparable
        System.out.print(" \r Tri ordre naturel : ");
        liste.forEach(pp -> pp.affiche());
        
        liste.sort(Comparator.comparing(PointXY::getY).reversed());
        System.out.print("\r Tri ordonnées inverse : ");
        liste.forEach(pp -> pp.affiche());
    }
}

class PointXY implements Comparable<PointXY> { // Comparable pour naturalOrder
    private int x, y ;
    
    public PointXY ( int x, int y ) { this.x = x ; this.y = y ; }
    public void affiche() { System.out.print ("[ " + x + ", " + y + " ] " ) ; }
    public int getX ( ) { return x ; }
    public int getY ( ) { return y ; }
    
    @Override
    public int compareTo(PointXY p) { 
        return ( ( (Integer)(this.x) ).compareTo( (Integer)(p.x) ) ) ; 
    }

}