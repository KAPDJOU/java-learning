package Decorateur.example1;

import Decorateur.example1.dec.Chocolat;
import Decorateur.example1.dec.Lait;

public class App {

	public static void main(String[] args) {

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
