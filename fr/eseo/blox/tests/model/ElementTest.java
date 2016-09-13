package fr.eseo.blox.tests.model;

import java.awt.Color;
import java.awt.Point;

import fr.eseo.blox.model.Element;

/**
 * Classe de test des Elements
 *
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class ElementTest {

	/**
	 * Methode principale de la classe de test lancant ceux-ci sans utiliser
	 * args.
	 *
	 * @param args
	 *            Les arguments de ligne de commande.
	 */
	public static void main(String[] args) {
		ElementTest et = new ElementTest();
		et.testConstructorPoint();
		et.testConstructorXY();
		et.testConstructorPointColour();
		et.testConstructorXYColour();
		et.testCoordAccessors();
		et.testXYAccessors();
		et.testColourAccessors();
	}

	/**
	 * Methode permettant de tester le constructeur d'Element prennant en
	 * parametre un point.
	 */
	private void testConstructorPoint() {
		Element element = new Element(new Point(10, 10));
		System.out.println("Element created at coordinate : " + element.toString());
		System.out.println("\t Element Colour = " + element.getColour());
		System.out.println();
	}

	/**
	 * Methode permettant de tester le constructeur d'Element prennant en
	 * parametre sa position en x et en y.
	 */
	private void testConstructorXY() {
		Element element = new Element(10, 10);
		System.out.println("Element created at coordinate : " + element.toString());
		System.out.println("\t Element Colour = " + element.getColour());
		System.out.println();
	}

	/**
	 * Methode permettant de tester le constructeur d'Element prennant en
	 * parametre une couleur.
	 */
	private void testConstructorPointColour() {
		Element element = new Element(new Point(10, 10), Color.green);
		System.out.println("Element created at coordinate : " + element.toString());
		System.out.println("\t Element Colour = " + element.getColour());
		System.out.println();
	}

	/**
	 * Methode permettant de tester le constructeur d'Element prennant en
	 * parametre sa position en x et en y ainsi qu'une couleur.
	 */
	private void testConstructorXYColour() {
		Element element = new Element(10, 10, Color.green);
		System.out.println("Element created at coordinate : " + element.toString());
		System.out.println("\t Element Colour = " + element.getColour());
		System.out.println();
	}

	/**
	 * Methode permettant de tester les accesseurs de la coordonnee de la classe
	 * Element.
	 */
	private void testCoordAccessors() {
		Element element = new Element(10, 10, Color.green);
		System.out.println("Element created at coordinate : " + element.getCoordinate());
		element.setCoordinate(new Point(8, 9));
		System.out.println("Element change at coordinate : " + element.getCoordinate());
		element.setCoordinate(1, 2);
		System.out.println("Element change at coordinate : " + element.getCoordinate());
	}

	/**
	 * Methode permettant de tester les accesseurs de la couleur de la classe
	 * Element.
	 */
	private void testColourAccessors() {
		Element element = new Element(11, 11, Color.green);
		System.out.println("Element Colour = " + element.getColour());
		element.setColour(Color.pink);
		System.out.println("Element Colour = " + element.getColour());
	}

	/**
	 * Methode permettant de tester les accesseurs de la coordonnee en (x,y) de
	 * la classe Element.
	 */
	private void testXYAccessors() {
		Element element = new Element(12, 12, Color.green);
		System.out.println("Element created at coordinate : " + element.getX() + " " + element.getY());
		element.setX(3);
		element.setY(4);
		System.out.println("Element change at coordinate : " + element.getX() + " " + element.getY());
	}

}
