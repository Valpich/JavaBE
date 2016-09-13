package fr.eseo.blox.model;

import java.awt.Color;
import java.awt.Point;

/**
 * Classe heritant de piece permettant la creation d'une OPiece
 * 
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class OPiece extends Piece {

	private static final Point[] RELATIVE_ELEMENTS_COORDS = { new Point(0, 0), new Point(0, -1), new Point(1, -1),
			new Point(1, 0) };

	/**
	 * Construit une OPiece dont l'element caracteristique se trouve a la
	 * position donnee.
	 * 
	 * @param coordinate
	 *            La coordonnee de l'element caracteristique.
	 */
	public OPiece(Point coordinate) {
		super(coordinate);
	}

	/**
	 * Construit une OPiece dont l'element caracteristique se trouve a la
	 * position donnee.
	 * 
	 * @param x
	 *            La coordonnee en x de l'element caracteristique.
	 * @param y
	 *            La coordonnee en y de l'element caracteristique.
	 */
	public OPiece(int x, int y) {
		super(x, y);
	}

	/**
	 * Construit une OPiece dont l'element caracteristique se trouve a la
	 * position donnee et de couleur donnee.
	 * 
	 * @param coordinate
	 *            La coordonnee de l'element caracteristique.
	 * @param colour
	 *            La couleur de la OPiece.
	 */
	public OPiece(Point coordinate, Color colour) {
		super(coordinate, colour);
	}

	/**
	 * Construit une OPiece dont l'element caracteristique se trouve a la
	 * position donnee et de couleur donnee.
	 * 
	 * @param x
	 *            La coordonnee en x de l'element caracteristique.
	 * @param y
	 *            La coordonnee en y de l'element caracteristique.
	 * @param colour
	 *            La couleur de la OPiece.
	 */
	public OPiece(int x, int y, Color colour) {
		super(x, y, colour);
	}

	/**
	 * Construit une OPiece dont l'element caracteristique se trouve à la
	 * position donnee et de couleur donnee.
	 * 
	 * @param x
	 *            La coordonnee en x de l'element caracteristique.
	 * @param y
	 *            La coordonnee en y de l'element caracteristique.
	 * @param pit
	 *            Le pit de la OPiece.
	 */
	public OPiece(int x, int y, Pit pit) {
		this(x, y, Color.blue);
		this.setPit(pit);
	}

	/**
	 * Methode d'ajout d'element à la OPiece.
	 * 
	 * @param coordinate
	 *            La coordonnee de l'element caracteristique.
	 * @param colour
	 *            La couleur de la OPiece.
	 */
	protected void setElements(Point coordinate, Color colour) {
		for (int i = 0; i < 4; i++) {
			super.getElements()
					.add(new Element(new Point((int) (coordinate.getX() + RELATIVE_ELEMENTS_COORDS[i].getX()),
							(int) (coordinate.getY() + (RELATIVE_ELEMENTS_COORDS[i].getY()))), colour));
		}
	}

	/**
	 * Redefinition de la methode rotate pour empecher la rotation de la OPiece.
	 * 
	 * @param clockwise
	 *            Le sens de la rotation.
	 */
	@Override
	public void rotate(boolean clockwise) throws BloxException {
	}

}