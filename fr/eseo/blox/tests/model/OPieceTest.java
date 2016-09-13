package fr.eseo.blox.tests.model;

import java.awt.Color;
import java.awt.Point;

import fr.eseo.blox.model.BloxException;
import fr.eseo.blox.model.OPiece;

/**
 * Classe de test des OPiece
 *
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class OPieceTest {

	/**
	 * Methode principale de la classe de test lancant ceux-ci sans utiliser
	 * args.
	 *
	 * @param args
	 *            Les arguments de ligne de commande.
	 */
	public static void main(String[] args) {
		OPieceTest opt = new OPieceTest();
		opt.testConstructorOPiecePoint();
		opt.testConstructorOPieceXY();
		opt.testConstructorOPiecePointColour();
		opt.testConstructorOPieceXYColour();
		opt.testOPieceAccessors();
		opt.testRotation();
		opt.testTranslation();
	}

	/**
	 * Methode permettant de tester le constructeur d'une OPiece recevant un
	 * Point en argument.
	 */
	private void testConstructorOPiecePoint() {
		OPiece opiece = new OPiece(new Point(15, 12));
		System.out.println(opiece);
	}

	/**
	 * Methode permettant de tester le constructeur d'une OPiece recevant deux
	 * entier x et y en argument.
	 */
	private void testConstructorOPieceXY() {
		OPiece opiece = new OPiece(0, 0);
		System.out.println(opiece);
	}

	/**
	 * Methode permettant de tester le constructeur d'une OPiece recevant un
	 * Point et une couleur en argument.
	 */
	private void testConstructorOPiecePointColour() {
		OPiece opiece = new OPiece(new Point(15, 12), Color.yellow);
		System.out.println(opiece);
	}

	/**
	 * Methode permettant de tester le constructeur d'une OPiece recevant deux
	 * entier x et y et une couleur en argument.
	 */
	private void testConstructorOPieceXYColour() {
		OPiece opiece = new OPiece(17, 16, Color.yellow);
		System.out.println(opiece);
	}

	/**
	 * Methode permettant de tester les accesseurs sur une OPiece.
	 */
	private void testOPieceAccessors() {
		OPiece opiece = new OPiece(17, 16, Color.yellow);
		System.out.println("Utilisation de toString() utilisant les accesseurs : " + opiece);
	}

	/**
	 * Methode permettant de tester la rotation d'une OPiece.
	 */
	private void testRotation() {
		OPiece opiece = new OPiece(0, 0, Color.yellow);
		System.out.println("Avant rotation : " + opiece);
		try {
			opiece.rotate(true);
		} catch (BloxException e) {
			e.printStackTrace();
		}
		System.out.println("Après clockwise rotation : " + opiece);
		try {
			opiece.rotate(false);
		} catch (BloxException e) {
			e.printStackTrace();
		}
		System.out.println("Après anti-clockwise rotation : " + opiece);
	}

	/**
	 * Methode permettant de tester la rotation d'une OPiece.
	 */
	private void testTranslation() {
		OPiece opiece = new OPiece(10, 8, Color.yellow);
		System.out.println("Avant deplacement : " + opiece);
		try {
			opiece.moveBy(1, 0);
		} catch (IllegalArgumentException | BloxException e) {
			e.printStackTrace();
		}
		System.out.println("Après deplacement de x = 1 : " + opiece);
		try {
			opiece.moveBy(0, 1);
		} catch (IllegalArgumentException | BloxException e) {
			e.printStackTrace();
		}
		System.out.println("Après deplacement de y = 1 : " + opiece);
		try {
			opiece.moveBy(-1, 0);
		} catch (IllegalArgumentException | BloxException e) {
			e.printStackTrace();
		}
		System.out.println("Après deplacement de x = -1 : " + opiece);
		try {
			opiece.moveBy(1, 1);
			System.out.println("Après deplacement de x = 1 et y = 1 : " + opiece);
		} catch (IllegalArgumentException | BloxException e) {
			e.printStackTrace();
		}
		try {
			opiece.moveBy(0, 2);
			System.out.println("Après deplacement de x = 0 et y = 2 : " + opiece);
		} catch (IllegalArgumentException | BloxException e) {
			e.printStackTrace();
		}
		try {
			opiece.moveBy(2, 0);
			System.out.println("Après deplacement de x = 2 et y = 0 : " + opiece);
		} catch (IllegalArgumentException | BloxException e) {
			e.printStackTrace();
		}
		try {
			opiece.moveBy(0, -1);
			System.out.println("Après deplacement de y = -1 : " + opiece);
		} catch (IllegalArgumentException | BloxException e) {
			e.printStackTrace();
		}
	}

}
