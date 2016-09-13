package fr.eseo.blox.model;

import java.awt.Color;
import java.awt.Point;

/**
 * Classe de gestion d'un element
 * 
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class Element {

	public final static Color DEFAULT_ELEMENT_COLOUR = Color.black;
	private Point coordinate;
	private Color colour;

	/**
	 * Construit un Element.
	 * 
	 * @param coordinate
	 *            La coordonnee de l'element.
	 */
	public Element(Point coordinate) {
		this.setColour(DEFAULT_ELEMENT_COLOUR);
		this.setCoordinate(coordinate);
	}

	/**
	 * Construit un Element.
	 * 
	 * @param x
	 *            La coordonnee de l'element en x.
	 * @param y
	 *            La coordonnee de l'element en y.
	 */
	public Element(int x, int y) {
		this(new Point(x, y));
	}

	/**
	 * Construit un Element.
	 * 
	 * @param coordinate
	 *            La coordonnee de l'element.
	 * @param colour
	 *            La couleur de l'element.
	 */
	public Element(Point coordinate, Color colour) {
		this(coordinate);
		this.setColour(colour);
	}

	/**
	 * Construit un Element.
	 * 
	 * @param x
	 *            La coordonnee de l'element en x.
	 * @param y
	 *            La coordonnee de l'element en y.
	 * @param colour
	 *            La couleur de l'element.
	 */
	public Element(int x, int y, Color colour) {
		this(new Point(x, y), colour);
	}

	/**
	 * Accesseur en ecriture de la coordonnee de l'element.
	 * 
	 * @param coordinate
	 *            Les nouvelles coordonnees.
	 */
	public void setCoordinate(Point coordinate) {
		this.coordinate = coordinate;
	}

	/**
	 * Accesseur en ecriture de la coordonnee de l'element.
	 * 
	 * @param x
	 *            La nouvelle coordonnee en x.
	 * @param y
	 *            La nouvelle coordonnee en y.
	 */
	public void setCoordinate(int x, int y) {
		this.setCoordinate(new Point(x, y));
	}

	/**
	 * Accesseur en lecture de la coordonnee de l'element.
	 * 
	 * @return Les coordonnees de l'element.
	 */
	public Point getCoordinate() {
		return this.coordinate;
	}

	/**
	 * Accesseur en ecriture de la coordonnee de l'element.
	 * 
	 * @param x
	 *            La nouvelle coordonnee en x.
	 */
	public void setX(int x) {
		this.setCoordinate(new Point(x, this.getY()));
	}

	/**
	 * Accesseur en ecriture de la coordonnee de l'element.
	 * 
	 * @param y
	 *            La nouvelle coordonnee en y.
	 */
	public void setY(int y) {
		this.setCoordinate(new Point(this.getX(), y));
	}

	/**
	 * Accesseur en lecture de la coordonnee en x de l'element.
	 * 
	 * @return La coordonnee en x.
	 */
	public int getX() {
		return (int) this.getCoordinate().getX();
	}

	/**
	 * Accesseur en lecture de la coordonnee en y de l'element.
	 * 
	 * @return La coordonnee en y.
	 */
	public int getY() {
		return (int) this.getCoordinate().getY();
	}

	/**
	 * Accesseur en ecriture de la couleur de l'element.
	 * 
	 * @param colour
	 *            La nouvelle couleur de l'element.
	 */
	public void setColour(Color colour) {
		this.colour = colour;
	}

	/**
	 * Accesseur en lecture de la couleur de l'element.
	 * 
	 * @return La couleur de l'element.
	 */
	public Color getColour() {
		return this.colour;
	}

	/**
	 * Methode permettant de translater un element suivant un vecteur (dx,dy).
	 * 
	 * @param dx
	 *            La valeur de translation suivant x.
	 * @param dy
	 *            La valeur de translation suivant y.
	 * @throws IllegalArgumentException
	 *             Le valeur du deplacement demande n'est pas valide.
	 */
	public void moveBy(int dx, int dy) throws IllegalArgumentException {
		if (dy < 0 || dx > 1 || dx < -1 || dy > 1 || dy < -1) {
			if (dy < 0)
				throw new IllegalArgumentException("Tentative de deplacement vers le haut");
			if (dx > 1)
				throw new IllegalArgumentException("Le dx est >1");
			if (dx < -1)
				throw new IllegalArgumentException("Le dx est <-1");
			if (dy > 1)
				throw new IllegalArgumentException("Le dy est >1");
			if ((dx * dy) != 0)
				throw new IllegalArgumentException("Tentative suivant dx et dy");
		} else {
			this.getCoordinate().setLocation(this.getX() + dx, this.getY() + dy);
		}
	}

	/**
	 * Methode permettant d'obtenir une chaine de caracteres decrivant un
	 * element.
	 * 
	 * @return La chaine de caractere decrivant l'element.
	 */
	@Override
	public String toString() {
		return new String("(" + getX() + "," + getY() + ")");
	}

}
