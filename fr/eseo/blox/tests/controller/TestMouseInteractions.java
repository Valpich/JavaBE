package fr.eseo.blox.tests.controller;

import java.awt.Color;

import fr.eseo.blox.model.IPiece;
import fr.eseo.blox.model.OPiece;
import fr.eseo.blox.model.Pit;
import fr.eseo.blox.view.BloxFrame;
import fr.eseo.blox.view.PitPanel;

/**
 * Classe de test des interactions avec la sourie
 *
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class TestMouseInteractions {

	/**
	 * Methode principale de la classe de test lancant ceux-ci sans utiliser
	 * args.
	 *
	 * @param args
	 *            Les arguments de ligne de commande.
	 */
	public static void main(String[] args) {
		TestMouseInteractions tmi = new TestMouseInteractions();
		tmi.testMouseInteractionPieceO();
		tmi.testMouseInteractionPieceI();
	}

	/**
	 * Methode permettant de tester le deplacement d'une OPiece avec la sourie.
	 */
	private void testMouseInteractionPieceO() {
		BloxFrame bloxFrame = new BloxFrame(new PitPanel(new Pit(10, 10)));
		bloxFrame.getPitPanel().getPit().setCurrentPiece(new OPiece(5, 5, Color.blue));
		bloxFrame.repaint();
	}

	/**
	 * Methode permettant de tester le deplacement d'une IPiece avec la sourie.
	 */
	private void testMouseInteractionPieceI() {
		BloxFrame bloxFrame = new BloxFrame(new PitPanel(new Pit(10, 10)));
		bloxFrame.getPitPanel().getPit().setCurrentPiece(new IPiece(5, 5, Color.red));
		bloxFrame.repaint();
	}

}
