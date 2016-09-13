package fr.eseo.blox.model;

import java.util.Random;

/**
 * Classe permettant a l'aide de sa methode statique de fabriquer aleatoirement
 * des Pieces pour le jeu de tetris.
 * 
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class PieceFactory {

	/**
	 * Construit une PieceFactory.
	 */
	private PieceFactory() {
	}

	/**
	 * Construit une Piece de facon aleatoire dans le pit.
	 * 
	 * @param pit
	 *            Le pit dans lequel doit se trouver la nouvelle piece.
	 * @return Une piece creee aleatoirement.
	 */
	public static Piece newPiece(Pit pit) {
		Random r = new Random();
		int valeur = r.nextInt(2);
		Piece tmp = null;
		switch (valeur) {
		case 0:
			tmp = new OPiece((int) pit.getWidth() / 2, -1, Pile.randColor());
			break;
		case 1:
			tmp = new IPiece((int) pit.getWidth() / 2, -2, Pile.randColor());
			break;
		default:
			System.err.println("Erreur de création de la piece");
			System.exit(2);
			break;
		}
		if (tmp != null)
			tmp.setPit(pit);
		return tmp;
	}

}