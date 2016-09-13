package fr.eseo.blox.tests.view;

import java.awt.Color;

import fr.eseo.blox.model.BloxException;
import fr.eseo.blox.model.Element;
import fr.eseo.blox.model.IPiece;
import fr.eseo.blox.model.OPiece;
import fr.eseo.blox.model.Pile;
import fr.eseo.blox.model.Pit;
import fr.eseo.blox.view.BloxFrame;
import fr.eseo.blox.view.PitPanel;
import fr.eseo.blox.view.ViewPile;

/**
 * Classe de test du PitPanel
 *
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class PitPanelTest {

	/**
	 * Methode principale de la classe de test lancant ceux-ci sans utiliser
	 * args.
	 *
	 * @param args
	 *            Les arguments de ligne de commande.
	 */
	public static void main(String[] args) {
		PitPanelTest ppt = new PitPanelTest();
		ppt.testConstructor();
		ppt.testConstructorPit();
		ppt.testConstructorDimension();
		ppt.testConstructorPitDimension();
		ppt.testAccessors();
		ppt.testDisplayPieceO();
		ppt.testDisplayPieceI();
		ppt.testViewPile();
		ppt.testViewPileDeux();
	}

	/**
	 * Methode de test de construction d'un PitPanel par defaut.
	 */
	private void testConstructor() {
		PitPanel pitPanel = new PitPanel();
		System.out.println(pitPanel);
	}

	/**
	 * Methode de test de construction d'un PitPanel avec un Pit donnee.
	 */
	private void testConstructorPit() {
		PitPanel pitPanel = new PitPanel(new Pit(10, 24));
		System.out.println(pitPanel);
		System.out.println(pitPanel.getPreferredSize());
	}

	/**
	 * Methode de test de construction d'un PitPanel en lui donnant sa
	 * Dimension.
	 */
	private void testConstructorDimension() {
		PitPanel pitPanel = new PitPanel(20);
		System.out.println(pitPanel);
	}

	/**
	 * Methode de test de construction d'un PitPanel en lui donnant son Pit et
	 * sa Dimension.
	 */
	private void testConstructorPitDimension() {
		PitPanel pitPanel = new PitPanel(new Pit(20, 48), 30);
		System.out.println(pitPanel);
	}

	/**
	 * Methode de test des accesseurs du PitPanel.
	 */
	private void testAccessors() {
		PitPanel pitPanel = new PitPanel(new Pit(5, 12), 30);
		System.out.println("Ma fenetre est : " + pitPanel.getBloxFrame());
		pitPanel.setBloxFrame(new BloxFrame());
		System.out.println("Ma fenetre est : " + pitPanel.getBloxFrame());
	}

	/**
	 * Methode de test d'affichage d'une OPiece dans un PitPanel.
	 */
	private void testDisplayPieceO() {
		BloxFrame bloxFrame = new BloxFrame(new PitPanel(new Pit(10, 10)));
		bloxFrame.getPitPanel().getPit().setCurrentPiece(new OPiece(5, 5, Color.blue));
		bloxFrame.repaint();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			bloxFrame.getPitPanel().getPit().getCurrentPiece().rotate(true);
		} catch (BloxException e) {
			e.printStackTrace();
		}
		bloxFrame.repaint();
	}

	/**
	 * Methode de test d'affichage d'une IPiece dans un PitPanel.
	 */
	private void testDisplayPieceI() {
		BloxFrame bloxFrame = new BloxFrame(new PitPanel(new Pit(10, 10)));
		bloxFrame.getPitPanel().getPit().setCurrentPiece(new IPiece(5, 5, Color.red));
		System.out.println(bloxFrame.getPitPanel().getPit());
		bloxFrame.repaint();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			bloxFrame.getPitPanel().getPit().getCurrentPiece().moveBy(1, 0);
		} catch (IllegalArgumentException | BloxException e) {
			e.printStackTrace();
		}
		bloxFrame.repaint();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			bloxFrame.getPitPanel().getPit().getCurrentPiece().moveBy(0, 1);
		} catch (IllegalArgumentException | BloxException e) {
			e.printStackTrace();
		}
		bloxFrame.repaint();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			bloxFrame.getPitPanel().getPit().getCurrentPiece().moveBy(-1, 0);
		} catch (IllegalArgumentException | BloxException e) {
			e.printStackTrace();
		}
		bloxFrame.repaint();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			bloxFrame.getPitPanel().getPit().getCurrentPiece().moveBy(0, -1);
		} catch (IllegalArgumentException | BloxException e) {
			e.printStackTrace();
		}
		bloxFrame.repaint();
	}

	/**
	 * Methode de test d'affichage de la Pile avec un nombre d'Element dans un
	 * PitPanel.
	 */
	private void testViewPile() {
		Pit pit = new Pit(10, 24);
		Pile pile = new Pile(pit, 30);
		pit.setPile(pile);
		PitPanel pp = new PitPanel(pit);
		pp.setViewPile(new ViewPile(pp));
		BloxFrame bloxFrame = new BloxFrame(pp);
		bloxFrame.getPitPanel().getPit().setCurrentPiece(new OPiece(5, 5, Color.blue));
		for (Element elem : bloxFrame.getPitPanel().getPit().getCurrentPiece().getElements()) {
			elem.setColour(Pile.randColor());
		}
		System.out.println(bloxFrame.getPitPanel().getPit());
		bloxFrame.repaint();
	}

	/**
	 * Methode de test d'affichage de la Pile avec un nombre d'Element sur un
	 * nombre de lignes dans un PitPanel.
	 */
	private void testViewPileDeux() {
		Pit pit = new Pit(10, 24);
		Pile pile = new Pile(pit, 30, 2);
		pit.setPile(pile);
		PitPanel pp = new PitPanel(pit);
		pp.setViewPile(new ViewPile(pp));
		BloxFrame bloxFrame = new BloxFrame(pp);
		bloxFrame.getPitPanel().getPit().setCurrentPiece(new IPiece(5, 5, Color.blue));
		for (Element elem : bloxFrame.getPitPanel().getPit().getCurrentPiece().getElements()) {
			elem.setColour(Pile.randColor());
		}
		System.out.println(bloxFrame.getPitPanel().getPit());
		bloxFrame.repaint();
	}

}
