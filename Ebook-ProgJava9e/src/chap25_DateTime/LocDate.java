package chap25_DateTime;

import java.time.*;
import java.time.temporal.*; // Pour les constantes de ChronoUnit

public class LocDate {
	public static void main(String[] args) {
	    
		LocalDate aujourdhui = LocalDate.now(); // date du jour
		System.out.println("Aujourd'hui     : " + aujourdhui);
		System.out.println("Nous sommes un  : " + aujourdhui.getDayOfWeek());
		System.out.println("Nous sommes le  : " + aujourdhui.getDayOfYear() + "eme Jour de l'annee");
		
		LocalDate unJour = LocalDate.of(2009, 6, 13); // annee, mois, jour
		System.out.println("Un jour         : " + unJour);
		LocalDate leMemeJour = LocalDate.of(2009, Month.JUNE, 13); // avec nom de mois
		System.out.println("Le meme jour    : " + leMemeJour);
		
		LocalDate dansTroisMois = aujourdhui.plusMonths(3);
		System.out.println("Dans trois mois : " + dansTroisMois);
		System.out.println("Nous serons en  : " + dansTroisMois.getMonth());
		
		// calcul ecart entre aujourdhui et unJour et differents affichages
		Period ecart = unJour.until(aujourdhui);
		System.out.println("Ecart           : " + ecart.getYears() + " annees " + ecart.getMonths() + " mois "
				+ ecart.getDays() + " jours");
		System.out.println("Ecart en mois   : " + ecart.toTotalMonths());
		
		long nbJours = unJour.until(aujourdhui, ChronoUnit.DAYS);
		System.out.println("Ecart en jours  : " + nbJours);
		
		Period onAjoute = Period.of(1, 2, 3); // 1 an, 2 mois, 3 jours
		LocalDate plusTard = aujourdhui.plus(onAjoute);
		System.out.println("Plus tard       : " + plusTard);
	}
}

/** 2.3 Ajustement de date | page 763 */

class AjustDate {
    public static void main(String[] args) {

        LocalDate aujourdhui = LocalDate.now();
        LocalDate prochainLundi = aujourdhui.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        System.out.println("Le prochain lundi est : " + prochainLundi);

        int annee = 2015;
        LocalDate debut2015 = LocalDate.of(annee, 1, 1);
        LocalDate cinqDimanche = debut2015.with(TemporalAdjusters.dayOfWeekInMonth(5, DayOfWeek.SUNDAY));
        System.out.println("Le cinqui�me dimanche de " + annee + " est le : " + cinqDimanche.getDayOfMonth() + " "
                + cinqDimanche.getMonth());
        
        LocalDate premJourMois = aujourdhui.with(TemporalAdjusters.firstDayOfMonth());
        // remplace LocalDate premJourMois1 = aujourdhui.withDayOfMonth(1) ;
        System.out.println("Premier jour de ce mois : " + premJourMois);
        
        LocalDate vendredi4 = aujourdhui.with(TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.WEDNESDAY));
        System.out.println("Quatrieme vendredi de ce mois : " + vendredi4);
        
        LocalDate vendredi5 = aujourdhui.with(TemporalAdjusters.dayOfWeekInMonth(5, DayOfWeek.WEDNESDAY));
        System.out.println("Cinquieme vendredi de ce mois : " + vendredi5);
    }
}