package fr.eseo.blox.model;

import java.awt.Color;
import java.util.Random;

/**
 * Classe permettant de creer une Pile dans laquelle vont se trouver les
 * Elements des Pieces detruites lors de leurs chute dans le Pit.
 * 
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class Pile {

	private Pit pit;
	private Element[][] elements;

	/**
	 * Construit une Pile vide dans un Pit.
	 * 
	 * @param pit
	 *            Le pit dans lequel se trouve la pile.
	 */
	public Pile(Pit pit) {
		this.setPit(pit);
		if (getPit() != null) {
			this.elements = new Element[getPit().getWidth()][getPit().getHeight()];
			this.getPit().associatePile(this);
		}
	}

	/**
	 * Construit une Pile dans un Pit contenant deja un certain nombre
	 * d'Elements.
	 * 
	 * @param pit
	 *            Le Pit dans lequel se trouve la Pile.
	 * @param nbElements
	 *            Le nombre d'Elements a disposer aleatoirement dans la pile.
	 */
	public Pile(Pit pit, int nbElements) {
		this(pit, nbElements, (nbElements / pit.getWidth()) + 1);
	}

	/**
	 * Construit une Pile dans un Pit contenant deja un certain nombre
	 * d'Elements dans un certain nombre de lignes.
	 * 
	 * @param pit
	 *            Le Pit dans lequel se trouve la pile.
	 * @param nbElements
	 *            Le nombre d'elements a disposer aleatoirement dans la pile.
	 * @param nbRows
	 *            Le nombre de lignes souhaitees pour repatir les elements.
	 */
	public Pile(Pit pit, int nbElements, int nbRows) {
		this(pit);
		Random randElement = new Random();
		if (nbRows > (getPit().getHeight()))
			nbRows = getPit().getHeight();
		if (nbElements > (nbRows * getPit().getWidth()))
			nbElements = (nbRows * getPit().getWidth());
		int i = 0;
		while (i < nbElements) {
			int j = randElement.nextInt(getPit().getWidth());
			int k = (getPit().getHeight() - 1) - randElement.nextInt(nbRows);
			if (this.elements[j][k] == null) {
				this.elements[j][k] = new Element(j, k, Pile.randColor());
				i++;
			}
		}
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
	 *            Le nouveau Pit.
	 */
	public void setPit(Pit pit) {
		this.pit = pit;
	}

	/**
	 * Accesseur en lecture de la matrice des elements dans la Pile.
	 * 
	 * @return La matrice des elements.
	 */
	public Element[][] getElements() {
		return this.elements;
	}

	/**
	 * Methode statique permettant la creation d'une couleur aleatoire.
	 *
	 * @return Une Couleur aleatoire.
	 */
	public static Color randColor() {
		Random r = new Random();
		return new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
	}

	/**
	 * Methode d'ajout d'element dans la pile.
	 * 
	 * @param currentPiece
	 *            La piece a ajouter dans la pile.
	 */
	public void addElements(Piece currentPiece) {
		for (Element elem : currentPiece.getElements()) {
			if (elem.getX() >= 0 && elem.getX() < this.getPit().getWidth() && elem.getY() >= 0)
				this.getElements()[elem.getX()][elem.getY()] = elem;
		}
	}

	/**
	 * Methode permettant d'obtenir une chaine de caracteres decrivant une Pile.
	 * 
	 * @return La chaine de caracteres decrivant la pile.
	 */
	@Override
	public String toString() {
		String tmp = new String("");
		for (Element[] elem : getElements()) {
			for (Element e : elem) {
				if (e != null) {
					tmp = new String(tmp + "O");
				} else {
					tmp = new String(tmp + "X");
				}
			}
			tmp = new String(tmp + "\n");
		}
		return tmp;
	}

}