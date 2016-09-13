package fr.eseo.blox.model;

import java.awt.Color;
import java.awt.Point;

/**
 * Classe heritant de piece permettant la creation d'une IPiece
 * 
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class IPiece extends Piece {

	private static final Point[] RELATIVE_ELEMENTS_COORDS = { new Point(0, 0), new Point(0, -2), new Point(0, -1),
			new Point(0, 1) };

	/**
	 * Construit une IPiece dont l'element caracteristique se trouve a la
	 * position donnee.
	 * 
	 * @param coordinate
	 *            La coordonnee de l'element caracteristique.
	 */
	public IPiece(Point coordinate) {
		super(coordinate);
	}

	/**
	 * Construit une IPiece dont l'element caracteristique se trouve a la
	 * position donnee.
	 * 
	 * @param x
	 *            La coordonnee en x de l'element caracteristique.
	 * @param y
	 *            La coordonnee en y de l'element caracteristique.
	 */
	public IPiece(int x, int y) {
		super(x, y);
	}

	/**
	 * Construit une IPiece dont l'element caracteristique se trouve a la
	 * position donnee et de couleur donnee.
	 * 
	 * @param coordinate
	 *            La coordonnée de l'element caracteristique.
	 * @param colour
	 *            La couleur de la IPiece.
	 */
	public IPiece(Point coordinate, Color colour) {
		super(coordinate, colour);
	}

	/**
	 * Construit une IPiece dont l'element caracteristique se trouve a la
	 * position donnee et de couleur donnee.
	 * 
	 * @param x
	 *            La coordonnee en x de l'element caracteristique.
	 * @param y
	 *            La coordonnee en y de l'element caracteristique.
	 * @param colour
	 *            La couleur de la IPiece.
	 */
	public IPiece(int x, int y, Color colour) {
		super(x, y, colour);
	}

	/**
	 * Construit une IPiece dont l'element caracteristique se trouve a la
	 * position donnee et de couleur donnee.
	 * 
	 * @param x
	 *            La coordonnee en x de l'element caracteristique.
	 * @param y
	 *            La coordonnee en y de l'element caracteristique.
	 * @param pit
	 *            Le Pit de la IPiece.
	 */
	public IPiece(int x, int y, Pit pit) {
		this(x, y, Color.red);
		this.setPit(pit);
	}

	/**
	 * Methode d'ajout d'element a la IPiece.
	 * 
	 * @param coordinate
	 *            La coordonnee de l'element caracteristique
	 * @param colour
	 *            La couleur de la IPiece.
	 */
	protected void setElements(Point coordinate, Color colour) {
		for (int i = 0; i < 4; i++) {
			super.getElements()
					.add(new Element(new Point((int) (coordinate.getX() + RELATIVE_ELEMENTS_COORDS[i].getX()),
							(int) (coordinate.getY() + (RELATIVE_ELEMENTS_COORDS[i].getY()))), colour));
		}
	}

}