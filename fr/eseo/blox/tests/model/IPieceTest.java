package fr.eseo.blox.tests.model;

import java.awt.Color;
import java.awt.Point;

import fr.eseo.blox.model.BloxException;
import fr.eseo.blox.model.IPiece;

/**
 * Classe de test des IPiece
 *
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class IPieceTest {

	/**
	 * Methode principale de la classe de test lancant ceux-ci sans utiliser
	 * args.
	 *
	 * @param args
	 *            Les arguments de ligne de commande.
	 */
	public static void main(String[] args) {
		IPieceTest ipt = new IPieceTest();
		ipt.testConstructorIPiecePoint();
		ipt.testConstructorIPieceXY();
		ipt.testConstructorIPiecePointColour();
		ipt.testConstructorIPieceXYColour();
		ipt.testIPieceAccessors();
		ipt.testRotation();
		ipt.testTranslation();
	}

	/**
	 * Methode permettant de tester le constructeur d'une IPiece recevant un
	 * Point en argument.
	 */
	private void testConstructorIPiecePoint() {
		IPiece ipiece = new IPiece(new Point(15, 12));
		System.out.println(ipiece);
	}

	/**
	 * Methode permettant de tester le constructeur d'une IPiece recevant deux
	 * entier x et y en argument.
	 */
	private void testConstructorIPieceXY() {
		IPiece ipiece = new IPiece(0, 0);
		System.out.println(ipiece);
	}

	/**
	 * Methode permettant de tester le constructeur d'une IPiece recevant un
	 * Point et une couleur en argument.
	 */
	private void testConstructorIPiecePointColour() {
		IPiece ipiece = new IPiece(new Point(15, 12), Color.yellow);
		System.out.println(ipiece);
	}

	/**
	 * Methode permettant de tester le constructeur d'une IPiece recevant deux
	 * entier x et y et une couleur en argument.
	 */
	private void testConstructorIPieceXYColour() {
		IPiece ipiece = new IPiece(17, 16, Color.yellow);
		System.out.println(ipiece);
	}

	/**
	 * Methode permettant de tester les accesseurs sur une IPiece.
	 */
	private void testIPieceAccessors() {
		IPiece ipiece = new IPiece(17, 16, Color.yellow);
		System.out.println("Utilisation de toString() utilisant les accesseurs : " + ipiece);
	}

	/**
	 * Methode permettant de tester la rotation d'une IPiece.
	 */
	private void testRotation() {
		IPiece ipiece = new IPiece(0, 0, Color.yellow);
		System.out.println("Avant rotation : " + ipiece);
		try {
			ipiece.rotate(true);
		} catch (BloxException e) {
			e.printStackTrace();
		}
		System.out.println("Après clockwise rotation : " + ipiece);
		try {
			ipiece.rotate(false);
		} catch (BloxException e) {
			e.printStackTrace();
		}
		System.out.println("Après anti-clockwise rotation : " + ipiece);
	}

	/**
	 * Methode permettant de tester la translation d'une IPiece.
	 */
	private void testTranslation() {
		IPiece ipiece = new IPiece(0, 0, Color.yellow);
		System.out.println("Avant deplacement : " + ipiece);
		try {
			ipiece.moveBy(1, 0);
		} catch (IllegalArgumentException | BloxException e) {
			e.printStackTrace();
		}
		System.out.println("Après deplacement de x = 1 : " + ipiece);
		try {
			ipiece.moveBy(0, 1);
		} catch (IllegalArgumentException | BloxException e) {
			e.printStackTrace();
		}
		System.out.println("Après deplacement de y = 1 : " + ipiece);
		try {
			ipiece.moveBy(-1, 0);
		} catch (IllegalArgumentException | BloxException e) {
			e.printStackTrace();
		}
		System.out.println("Après deplacement de x = -1 : " + ipiece);
		try {
			ipiece.moveBy(1, 1);
			System.out.println("Après deplacement de x = 1 et y = 1 : " + ipiece);
		} catch (IllegalArgumentException | BloxException e) {
			e.printStackTrace();
		}
		try {
			ipiece.moveBy(0, 2);
			System.out.println("Après deplacement de x = 0 et y = 2 : " + ipiece);
		} catch (IllegalArgumentException | BloxException e) {
			e.printStackTrace();
		}
		try {
			ipiece.moveBy(2, 0);
			System.out.println("Après deplacement de x = 2 et y = 0 : " + ipiece);
		} catch (IllegalArgumentException | BloxException e) {
			e.printStackTrace();
		}

		try {
			ipiece.moveBy(0, -1);
			System.out.println("Après deplacement de y = -1 : " + ipiece);
		} catch (IllegalArgumentException | BloxException e) {
			e.printStackTrace();
		}
	}

}
