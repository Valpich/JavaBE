package fr.eseo.blox.tests.model;

import fr.eseo.blox.model.Pile;
import fr.eseo.blox.model.Pit;

/**
 * Classe de test de la Pile
 *
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class PileTest {

	/**
	 * Methode principale de la classe de test lancant ceux-ci sans utiliser
	 * args.
	 *
	 * @param args
	 *            Les arguments de ligne de commande.
	 */
	public static void main(String[] args) {
		PileTest pt = new PileTest();
		pt.testConstructor();
		pt.testConstructorNbElements();
		pt.testConstructorNbElementsNbRows();
	}

	/**
	 * Methode de test du constructeur de pile sans argument.
	 */
	private void testConstructor() {
		Pit pit = new Pit(10, 24);
		Pile p = new Pile(pit);
		pit.associatePile(p);
		System.out.println(pit + "\n" + p + "\n");
	}

	/**
	 * Methode de test du constructeur de pile prennant un nombre d'Element a
	 * repatir.
	 */
	private void testConstructorNbElements() {
		Pit pit = new Pit(10, 24);
		Pile p = new Pile(pit, 30);
		pit.associatePile(p);
		System.out.println(pit + "\n" + p + "\n");
	}

	/**
	 * Methode de test du constructeur de pile prennant un nombre d'Element a
	 * repatir sur un nombre de ligne donnee.
	 */
	private void testConstructorNbElementsNbRows() {
		Pit pit = new Pit(10, 24);
		Pile p = new Pile(pit, 15, 2);
		pit.associatePile(p);
		System.out.println(pit + "\n" + p + "\n");
	}

}
