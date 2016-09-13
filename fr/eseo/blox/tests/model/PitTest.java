package fr.eseo.blox.tests.model;

import fr.eseo.blox.model.IPiece;
import fr.eseo.blox.model.Pit;

/**
 * Classe de test du Pit
 *
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class PitTest {

	/**
	 * Methode principale de la classe de test lancant ceux-ci sans utiliser
	 * args.
	 *
	 * @param args
	 *            Les arguments de ligne de commande.
	 */
	public static void main(String[] args) {
		PitTest tp = new PitTest();
		tp.testConstructorPitHeightWidth();
		tp.testConstructorPit();
		tp.testAccessorCurrentPiecePit();
		tp.testAccessorNextPiecePit();
		tp.testAccessorWidthPit();
		tp.testAccessorHeightPit();
	}

	/**
	 * Methode de test du constructeur du pit par defaut.
	 */
	private void testConstructorPit() {
		Pit testPit = new Pit();
		System.out.println(testPit);
	}

	/**
	 * Methode de test du constructeur du pit a partir de sa hauteur et de sa
	 * largueur.
	 */
	private void testConstructorPitHeightWidth() {
		Pit testPit = new Pit(150, 300);
		System.out.println(testPit);
	}

	/**
	 * Methode de test de l'accesseur la Piece actuelle du Pit.
	 */
	private void testAccessorCurrentPiecePit() {
		Pit testPit = new Pit(150, 300);
		testPit.setCurrentPiece(new IPiece(30, 30));
		System.out.println(testPit.getCurrentPiece());
	}

	/**
	 * Methode de test de l'accesseur la Piece suivante du Pit.
	 */
	private void testAccessorNextPiecePit() {
		Pit testPit = new Pit(150, 300);
		testPit.setNextPiece(new IPiece(30, 30));
		System.out.println(testPit.getNextPiece());
	}

	/**
	 * Methode de test de l'accesseur la largueur actuelle du Pit.
	 */
	private void testAccessorWidthPit() {
		Pit testPit = new Pit(150, 300);
		testPit.setWidth(2998);
		System.out.println(testPit.getWidth());
	}

	/**
	 * Methode de test de l'accesseur la hauteur actuelle du Pit.
	 */
	private void testAccessorHeightPit() {
		Pit testPit = new Pit(150, 300);
		testPit.setHeight(192);
		System.out.println(testPit.getHeight());
	}

}
