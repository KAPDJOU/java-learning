package Decorateur;

import Decorateur.example1.Boisson;
import Decorateur.example1.Deca;
import Decorateur.example1.Espresso;
import Decorateur.example1.dec.Chocolat;
import Decorateur.example1.dec.Lait;

public class Main {

	/**
	 * DESIGN PATTERN - DECORATEUR
	 * =======================================================================
	 * Ce design Pattern montre montre comment ajouter dynamiquement des
	 * responsabilit�s suppl�mentaires � un objet.
	 * 
	 * ======================================================================
	 * objectif : attache dynamiquement des responsabilit�s suppl�mentaire � un objet.
	 *  sans cr�er de sous clase sp�cifique pour chaque configuration possible des objets
	 *  il fournit une alternative souple � la d�rivation , pour �tendre les fonctionnalit�
	 *  
	 * ======================================================================
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// on cr�e un boisson
		Boisson expresso = new Espresso();
		System.out.println(expresso.getDescription());
		System.out.println(expresso.cout());

		// on d�core l'objet boisson avec du lait
		expresso = new Lait(expresso);
		System.out.println(expresso.getDescription());
		System.out.println(expresso.cout());

		// on d�core l'objet boisson avec du lait
		expresso = new Chocolat(expresso);
		System.out.println(expresso.getDescription());
		System.out.println(expresso.cout());

		// on cr�e un boisson
		Boisson deca = new Chocolat(new Lait(new Deca()));
		System.out.println(deca.getDescription());
		System.out.println(deca.cout());

	}

}
