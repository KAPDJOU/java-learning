package davidson;

import java.util.Arrays;

/**
 * <div class="c0142"><div class="c0157"><div>Le jumeau (twin) d'un mot est un mot écrit avec exactement les mêmes
 * lettres (indépendamment de la casse), mais pas nécessairement dans le même ordre.<br>
 * <br>
 * Par exemple <code>Marion</code> est le jumeau de <code>Romain</code>.<br>
 * <br>
 * La méthode <code>isTwin(a, b)</code> retourne <code>true</code> si <code>b</code> est le jumeau de <code>a</code> ou
 * <code>false</code> si ce n'est pas le cas. <code>a</code> et <code>b</code> sont deux chaînes de caractères non
 * null.<br>
 * <br>
 * <b>Écrivez le corps de la méthode </b><code>isTwin(a, b)</code><b>.</b></div></div></div>
 * 
 * @author dell
 * davidson
 */
public class IsTwin {

    public static void main(String[] args) {

	System.out.println(Solution.isTwin("Hello", "world")); // false
	System.out.println(Solution.isTwin("acb", "bca")); // true
	System.out.println(Solution.isTwin("Lookout", "Outlook")); // true
    }

}

class Solution {
    public static boolean isTwin(String a, String b) {
	    char[] first = a.toLowerCase().toCharArray();
	    char[] second = b.toLowerCase().toCharArray();
	    Arrays.sort(first);
	    Arrays.sort(second);
    return Arrays.equals(first, second);
	}
    public static boolean isTwin1(String a, String b) {
	String s1 = a.replaceAll("\\s", "");
	String s2 = b.replaceAll("\\s", "");
	boolean status = true;
	if (s1.length() != s2.length()) {
	    status = false;
	} else {
	    char[] ArrayS1 = s1.toLowerCase().toCharArray();
	    char[] ArrayS2 = s2.toLowerCase().toCharArray();
	    Arrays.sort(ArrayS1);
	    Arrays.sort(ArrayS2);
	    status = Arrays.equals(ArrayS1, ArrayS2);
	}
	if (status) {
	    System.out.println(s1 + " and " + s2 + " are anagrams");
	} else {
	    System.out.println(s1 + " and " + s2 + " are not anagrams");
	}

	return false;
    }
}


