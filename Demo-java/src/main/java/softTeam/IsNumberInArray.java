package softTeam;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * We can find the largest number in an array in java by sorting the array and returning the largest number.
 * 
 * @author citizendiop
 *         <div class="c0142"><div class="c0157"><div><div>Le but de cet exercice est de vérifier la présence d’un
 *         nombre dans un tableau.<br>
 *         <br>
 *         Spécifications :
 *         <ul>
 *         <li>Les éléments sont des nombres entiers classés du plus petit au plus grand</li>
 *         <li>Le tableau peut contenir jusqu’à 1 million d’éléments</li>
 *         <li>Le tableau n’est jamais <code>null</code></li>
 *         </ul>
 *         Implémentez la méthode <code>boolean A.exists(int[] ints, int k)</code> afin qu’elle retourne
 *         <code>true</code> si <code>k</code> est présent dans&nbsp;<code>ints</code>, sinon la méthode devra retourner
 *         <code>false</code>.<br>
 *         <br>
 *         Important : Essayez de privilégier le temps d'exécution.<br>
 *         <br>
 *         Exemple :<br>
 *         <code>int[] ints = {-9, 14, 37, 102};</code><br>
 *         <code>A.exists(ints, 102)</code> retourne <code>true</code><br>
 *         <code>A.exists(ints, 36)</code> retourne <code>false</code></div>
 *         </div></div></div>
 */
public class IsNumberInArray {

    public static void main(String args[]) {
	int ints[] = { -9, 14, 37, 102 };
	System.out.println("Using contains Int ");
	System.out.println(exist(ints, 14)); // true
	System.out.println(exist(ints, 36)); // false
	System.out.println();
	System.out.println("Using contains Integer");
	System.out.println(exist2(ints, 14)); // true
	System.out.println(exist2(ints, 36)); // false
	System.out.println();
	System.out.println("Using Streams ");
	System.out.println(exist2(ints, 102)); // true
	System.out.println(exist2(ints, 36)); // false
    }

    /**
     * Using contains
     * Wrong way, returns true if this list contains the specified element.
     * not work with primitive
     * When you pass an array of primitives (int[] in your case) to Arrays.asList, it creates a List<int[]> with a
     * single element - the array itself. Therefore contains(3) returns false. contains(array) would return true.
     * 
     * @link https://stackoverflow.com/questions/31422025/arrays-aslistint-not-working/31422046
     */
    public static boolean exist(int[] ints, int k) {
	return Arrays.asList(ints).contains(k);
    }

    /**
     * If you'll use Integer[] instead of int[], it will work.
     */
    public static boolean exist1(int[] ints, Integer k) {
	return Arrays.asList(ints).contains(k);
    }

    /**
     * Using Streams
     * Arrays.stream(values).anyMatch("s"::equals);
     * don't need to convert the array at all;
     * It's equivalent as Arrays.asList. Arrays and lists run in O(n) to find a single element.
     */
    public static boolean exist2(int[] ints, int k) {
	return IntStream.of(ints).anyMatch(x -> x == k);
    }
    
    /**
     * Test with exist2
     * La solution fonctionne avec un 'petit' tableau
Résolution de problèmes : +52pts | OK 

La solution fonctionne avec un tableau vide
Fiabilité: +13pts | OK

La solution fonctionne en un temps raisonnable avec 1 million d'items
Résolution de problèmes : +183pts | NOK

La solution utilise l'api J2SE pour effectuer la recherche dichotomique.

Connaissance du langage : +52pts | | NOK

*/

}