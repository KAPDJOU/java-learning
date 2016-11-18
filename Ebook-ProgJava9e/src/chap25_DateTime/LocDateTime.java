package chap25_DateTime;

import java.time.*;

public class LocDateTime {
    public static void main(String[] args) {
    }
}

/** 4 La classe LocalDateTime | page 766 */

class PbDateLocale {
    public static void main(String[] args) {
        LocalDateTime maintenant = LocalDateTime.of(2014, 3, 26, 15, 30);
        System.out.println("maintenant        = " + maintenant);
        LocalDateTime dansUnMois1 = maintenant.plusMonths(1);
        System.out.println("dans un mois      = " + dansUnMois1);
        LocalDateTime dansUnMois2 = maintenant.plusHours(31 * 24);
        System.out.println("dans 31 fois 24 h = " + dansUnMois2);

        // maintenant = 2014-03-26T15:30
        // dans un mois = 2014-04-26T15:30
        // dans 31 fois 24 h = 2014-04-26T15:30
    }
}