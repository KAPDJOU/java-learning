package chap25_DateTime;

import java.time.*;

public class LocTime {
	public static void main(String[] args) {
		
	    LocalTime maintenant = LocalTime.now();
		System.out.println("Il est                        : " + maintenant);
		LocalTime uneHeure = LocalTime.of(23, 35);
		LocalTime uneHeure1 = LocalTime.of(23, 35, 40);
		LocalTime uneHeure2 = LocalTime.of(23, 35, 40, 15000);
		System.out.println("Une heure                     : " + uneHeure);
		System.out.println("Une heure plus precise        : " + uneHeure1);
		System.out.println("Une heure encore plus precise : " + uneHeure2);
		
		LocalTime dansTroisHeures = maintenant.plusHours(3);
		System.out.println("Dans trois heuress, ils sera  : " + dansTroisHeures);
		
		Duration ecart = Duration.between(maintenant, uneHeure);
		System.out.println("Difference entre ces 2 heures : " + ecart);
		System.out.println("Difference entre ces 2 heures : " + ecart.toHours() + "H " + ecart.toMinutes() + "mn ");
		
		// Affiche des horaires de départ de 14 h a 17 h, espacés de 12 mn 
		System.out.println("-- Horaires de depart ----");
		LocalTime courant = LocalTime.of(14, 0);
		LocalTime fin = LocalTime.of(14, 0).plusHours(3);
		Duration increment = Duration.ofMinutes(12);
		do {
			System.out.print(courant.getHour() + ":" + courant.getMinute() + " ");
			courant = courant.plus(increment);
		} while (courant.isBefore(fin));
	}
}