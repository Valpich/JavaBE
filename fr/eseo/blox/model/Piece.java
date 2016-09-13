package fr.eseo.blox.model;

import static java.lang.Math.cos;
import static java.lang.Math.round;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite servant de base aux Pieces du jeu de tetris
 * 
 * @author Valentin Pichavant
 * @version BE 2015
 */
public abstract class Piece {

	private List<Element> elements;
	private Pit pit;

	/**
	 * Construit une Piece dont l'element caracteristique se trouve a la
	 * position donnee.
	 * 
	 * @param coordinate
	 *            La coordonnee de l'element caracteristique.
	 */
	public Piece(Point coordinate) {
		this(coordinate, Element.DEFAULT_ELEMENT_COLOUR);
	}

	/**
	 * Construit une Piece dont l'element caracteristique se trouve a la
	 * position donnee.
	 * 
	 * @param x
	 *            La coordonnee en x de l'element caracteristique.
	 * @param y
	 *            La coordonnee en y de l'element caracteristique.
	 */
	public Piece(int x, int y) {
		this(new Point(x, y));
	}

	/**
	 * Construit une Piece dont l'element caracteristique se trouve a la
	 * position donnee et de couleur donnee.
	 * 
	 * @param coordinate
	 *            La coordonnee de l'element caracteristique.
	 * @param colour
	 *            La couleur de la Piece.
	 */
	public Piece(Point coordinate, Color colour) {
		this.elements = new ArrayList<Element>();
		this.setElements(coordinate, colour);
	}

	/**
	 * Construit une Piece dont l'element caracteristique se trouve a la
	 * position donnee et de couleur donnee.
	 * 
	 * @param x
	 *            La coordonnee en x de l'element caracteristique.
	 * @param y
	 *            La coordonnee en y de l'element caracteristique.
	 * @param colour
	 *            La couleur de la Piece.
	 */
	public Piece(int x, int y, Color colour) {
		this(new Point(x, y), colour);
	}

	/**
	 * Methode d'ajout d'element que devront implementer les classes filles de
	 * celle-ci.
	 * 
	 * @param coordinate
	 *            La coordonnee de l'element caracteristique.
	 * @param colour
	 *            La couleur de la Piece.
	 */
	abstract protected void setElements(Point coordinate, Color colour);

	/**
	 * Accesseur en lecture de la liste des elements de la Piece.
	 * 
	 * @return La liste des elements de la Piece.
	 */
	public List<Element> getElements() {
		return this.elements;
	}

	/**
	 * Accesseur en lecture du Pit.
	 * 
	 * @return Le Pit.
	 */
	public Pit getPit() {
		return this.pit;
	}

	/**
	 * Accesseur en ecriture du Pit.
	 * 
	 * @param pit
	 *            Le nouveau Pit
	 */
	public void setPit(Pit pit) {
		this.pit = pit;
	}

	/**
	 * Methode effectuant si possible le rotation de 90 degres d'une piece dans
	 * le sens horaire ou anti-horaire.
	 * 
	 * @param clockwise
	 *            Le sens de la rotation a effectuer.
	 * @throws BloxException
	 *             L'exception signifiant une rotation impossible.
	 */
	public void rotate(boolean clockwise) throws BloxException {
		int signe = 1;
		if (clockwise == true)
			signe = -1;
		int posX = this.getElements().get(0).getX();
		int posY = this.getElements().get(0).getY();
		for (Element elem : this.getElements()) {
			int x = elem.getX() - posX;
			int y = elem.getY() - posY;
			int tmpx = (int) round(signe * y * sin(toRadians(90)) + x * cos(toRadians(90)));
			int tmpy = (int) round(y * cos(toRadians(90)) - signe * x * sin(toRadians(90)));
			if (this.getPit() != null) {
				if (tmpy + this.getElements().get(0).getY() >= this.getPit().getHeight())
					throw new BloxException("La piece est en collision en bas du pit !", BloxException.BLOX_COLLISION);
				if (getPit().getPile() != null) {
					int i = 0;
					if (tmpy >= 0) {
						while (i < (this.getPit().getPile().getElements()).length) {
							if (this.getPit().getPile().getElements()[i][elem.getY() + tmpy] != null) {
								if (i == elem.getX() + tmpx) {
									throw new BloxException("La piece est entrée en collision lors du déplacement",
											BloxException.BLOX_COLLISION);
								}
							}
							i++;
						}
					}
				}
				if (tmpx + getElements().get(0).getX() < 0
						|| tmpx + getElements().get(0).getX() >= this.getPit().getWidth())
					throw new BloxException("La piece est sortie du pit !", BloxException.BLOX_EXIT_PIT);
			}
		}
		for (Element elem : this.getElements()) {
			int x = elem.getX() - posX;
			int y = elem.getY() - posY;
			int tmpx = (int) round(signe * y * sin(toRadians(90)) + x * cos(toRadians(90)));
			int tmpy = (int) round(y * cos(toRadians(90)) - signe * x * sin(toRadians(90)));
			elem.setX(tmpx + elements.get(0).getX());
			elem.setY(tmpy + elements.get(0).getY());
		}
	}

	/**
	 * Methode effectuant si possible la translation d'une piece suivant un
	 * vecteur (dx,dy).
	 * 
	 * @param dx
	 *            La valeur de translation suivant x.
	 * @param dy
	 *            La valeur de translation suivant y.
	 * @throws IllegalArgumentException
	 *             Le valeur du deplacement demande n'est pas valide.
	 * @throws BloxException
	 *             L'exception signifiant une translation impossible.
	 */
	public void moveBy(int dx, int dy) throws IllegalArgumentException, BloxException {
		if (dy < 0 || dx > 1 || dx < -1 || dy > 1 || (dx * dy) != 0) {
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
			for (Element elem : this.getElements()) {
				if (this.getPit() != null) {
					if (elem.getY() + dy >= getPit().getHeight())
						throw new BloxException("La piece est en collision en bas du pit !",
								BloxException.BLOX_COLLISION);
					if (this.getPit().getPile() != null) {
						if (elem.getY() + dy >= 0) {
							int i = 0;
							while (i < (this.getPit().getPile().getElements()).length) {
								if (this.getPit().getPile().getElements()[i][elem.getY() + dy] != null) {
									if (i == elem.getX() + dx) {
										throw new BloxException("La piece est entrée en collision lors du déplacement",
												BloxException.BLOX_COLLISION);
									}
								}
								i++;
							}
						}
					}
					if (elem.getX() + dx < 0 || elem.getX() + dx >= this.getPit().getWidth())
						throw new BloxException("La piece est sortie du pit !", BloxException.BLOX_EXIT_PIT);
				}
			}
		}
		for (Element elem : this.getElements()) {
			elem.moveBy(dx, dy);
		}
	}

	/**
	 * Methode permettant d'obtenir une chaine de caracteres decrivant une
	 * Piece.
	 * 
	 * @return La chaine de caracteres decrivant la piece.
	 */
	@Override
	public String toString() {
		String tmp = new String(getClass().getSimpleName() + " :");
		int i = 1;
		for (Element elem : getElements()) {
			tmp = new String(tmp + " " + elem.toString());
			if (i < 4) {
				tmp = new String(tmp + " ,");
			}
			i++;
		}
		return tmp;
	}

}