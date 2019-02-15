package davidson;

import java.util.Arrays;

/**
<div class="c0142">
    <div class="c0157">
        <div>
            <div>Les supermarchés s’équipent de plus en plus de caisses automatiques. La plupart de ces caisses
                n’acceptent que le paiement par carte bancaire bien qu’une part non négligeable de consommateurs paye
                encore en espèces (avec des billets et des pièces).<br>
                <br>
                Une des problématiques rencontrées avec le paiement en espèces est le rendu de monnaie : comment rendre
                une somme donnée de façon optimale, c'est-à-dire avec le nombre minimal de pièces et billets ? C'est un
                problème qui se pose à chacun de nous quotidiennement, à fortiori aux caisses automatiques.<br>
                <br>
                Dans cet exercice, on vous demande d’essayer de trouver une solution optimale pour rendre la monnaie
                dans un cas précis : quand une caisse automatique ne contient que des pièces de <b>2€</b>, des billets
                de <b>5€</b> et de <b>10€</b>.<br>
                <br>
                Pour simplifier le problème, nous considérerons que toutes ces pièces et billets sont disponibles en <b>quantité
                    illimitée</b>.<br>
                <br>
                Voici quelques exemples de rendu de monnaie :
                <div dir="ltr">
                    <table>
                        <colgroup>
                            <col width="120">
                            <col width="160">
                            <col width="160">
                        </colgroup>
                        <tbody>
                            <tr>
                                <td>
                                    <p><span>Monnaie à rendre</span></p>
                                </td>
                                <td>
                                    <p><span>Solutions possibles</span></p>
                                </td>
                                <td>
                                    <p><span>Solution optimale</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p><span>1</span></p>
                                </td>
                                <td>
                                    <p><span>Impossible</span></p>
                                </td>
                                <td>
                                    <p><span>Impossible</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p><span>6</span></p>
                                </td>
                                <td>
                                    <p><span>2</span> <span> + </span> <span>2</span>
                                        <span> + </span> <span>2</span></p>
                                </td>
                                <td>
                                    <p><span>2</span> <span> + </span> <span>2</span>
                                        <span> + </span> <span>2</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p><span>10</span></p>
                                </td>
                                <td>
                                    <p><span>2</span> <span> + </span> <span>2</span>
                                        <span> + </span> <span>2</span> <span> +
                                        </span> <span>2</span> <span> + </span> <span>2</span></p>

                                    <p><span>5</span> <span> + </span> <span>5</span></p>

                                    <p><span>10</span></p>
                                </td>
                                <td>
                                    <p><span>10</span></p>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p><span>9223372036854775807</span></p>
                                </td>
                                <td>
                                    <p>...</p>
                                </td>
                                <td>
                                    <p>(<span>10</span> * 922337203685477580) <span> +
                                        </span> <span>5</span> <span> + </span> <span>2</span></p>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <br>
                Le rendu de monnaie est exprimé par un objet <code>Change</code>. Cet objet a 3 propriétés : <code>coin2</code>,
                <code>bill5</code> et <code>bill10</code> qui, respectivement, stockent le nombre de pièces de 2€, de
                billets de 5€ et de billets de 10€.<br>
                <br>
                Par exemple, si on reprend l’exemple n°2 du tableau (6€), on devrait obtenir un objet <code>Change</code>
                avec :

                <ul>
                    <li><code>coin2</code> vaut 3 (3 pièces de 2€)</li>
                    <li><code>bill5</code> vaut 0 (pas de billet de 5€)</li>
                    <li><code>bill10</code> vaut 0 (pas de billet de 10€)</li>
                </ul>
                Implémentez la méthode <code>optimalChange(long s)</code> qui retourne un objet <code>Change</code>&nbsp;contenant
                les pièces et billets dont la somme vaut <code>s</code>. S’il est impossible de rendre la monnaie
                (comme dans l’exemple n°1), retournez <code>null</code>.<br>
                <br>
                Pour obtenir un maximum de points votre solution devra toujours rendre la monnaie quand c’est possible
                et avec le nombre minimal de pièces et billets.<br>
                <br>
                Données : <code>s</code> est toujours un entier (<code>long</code>) strictement positif inférieur ou
                égal à 9223372036854775807</div>
        </div>
    </div>
</div>
 * 
 * @author davisson coding game, give back change monaie, exact change
 * @author dell
 * @link https://medium.freecodecamp.org/exact-solution-for-exact-change-81e1d23bfe58
 * @link TODO https://coderanch.com/t/662767/java/Java-program-calculating-equivalent-change
 *       TODO to improve
 * @link TODO https://stackoverflow.com/questions/25796079/java-class-to-break-down-change-into-coins
 */
public class supermarket {

    public static void main(String[] args) {
	// Arrays to perform tests
	long[] tests = { 1, 17, 16, 6 };
	long[] tests2 = { 1, 2};

	for (long s : tests2) {
	    Change m = Solution2.optimalChange2(s);
	    Solution2.printResult(m, s);
	}
    }
}

// Do not modify Change
class Change {
    long coin2 = 0;
    long bill5 = 0;
    long bill10 = 0;
}

class Solution2 {

    static void printResult(Change m, long s) {
	// Change m = Solution2.optimalChange(s);

	System.out.println();
	if (m == null)
	    System.out.println("given money " + s + " return null");
	else {
	    System.out.println("Coin(s)  2€: " + m.coin2);
	    System.out.println("Bill(s)  5€: " + m.bill5);
	    System.out.println("Bill(s) 10€: " + m.bill10);
	}
    }

    // Do not modify this method​​​​​​​‌‌‌‌‌​​‌‌​‌‌‌‌​​‌​‌​​‌‌‌ signature
    static Change optimalChange(long s) {

	// Integral values
	long remaining = 0;
	long NbrOfBill10 = 0;
	long NbrOfBill5 = 0;
	long NbrOfCoin2 = 0;

	NbrOfBill10 = s / 10;
	remaining = s % 10;

	NbrOfBill5 = remaining / 5;
	remaining = remaining % 5;

	if (remaining < 2) {
	    // (NbrOfBill5 * 5) + 1
	} else {
	    NbrOfCoin2 = remaining / 2;
	    remaining = remaining % 2;
	}

	System.out.println();
	System.out.println("amount to change = " + s);
	System.out.println("____________________________");
	System.out.println("NbrOfCoin2  2€: " + NbrOfCoin2);
	System.out.println("NbrOfBill5  5€: " + NbrOfBill5);
	System.out.println("NbrOfBill10 10€: " + NbrOfBill10);

	System.out.println("remaining : " + remaining);

	// return null if change cannot be rendered
	if (remaining != 0)
	    return null;

	Change change = new Change();
	change.coin2 = NbrOfCoin2;
	change.bill5 = NbrOfBill5;
	change.bill10 = NbrOfBill10;
	return change;
    }

    static Change optimalChange2(long changeDue) {

	// Integral values
	long NbrOfBill10 = 0;
	long NbrOfBill5 = 0;
	long NbrOfCoin2 = 0;

	long remaining = changeDue;

	NbrOfBill10 = Math.round(remaining / 10);
	remaining = remaining % 10;

	NbrOfBill5 = Math.round(remaining / 5);
	remaining = remaining % 5;

	if (remaining < 2) {
	    remaining = (NbrOfBill5 * 5) + 1;
	    if (remaining % 2 == 0) {
		NbrOfBill5 = 0;
		NbrOfCoin2 = Math.round(remaining / 2);
	    }
	} else {
	    NbrOfCoin2 = Math.round(remaining / 2);
	}
	remaining = remaining % 2;
	
	System.out.println();
	System.out.println("changeDue = " + changeDue);
	System.out.println("____________________________");
	System.out.println("NbrOfCoin2  2€: " + NbrOfCoin2);
	System.out.println("NbrOfBill5  5€: " + NbrOfBill5);
	System.out.println("NbrOfBill10 10€: " + NbrOfBill10);

	System.out.println("remaining : " + remaining);

	// return null if change cannot be rendered
	if (remaining != 0)
	    return null;

	Change change = new Change();
	change.coin2 = NbrOfCoin2;
	change.bill5 = NbrOfBill5;
	change.bill10 = NbrOfBill10;
	return change;
    }
}
