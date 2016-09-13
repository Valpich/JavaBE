package fr.eseo.blox.tests.view;

import java.awt.EventQueue;

import fr.eseo.blox.model.Pit;
import fr.eseo.blox.view.BloxFrame;
import fr.eseo.blox.view.PitPanel;

/**
 * Classe de test de la BloxFrame
 *
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class BloxFrameTest {

	/**
	 * Methode principale de la classe de test lancant ceux-ci sans utiliser
	 * args.
	 *
	 * @param args
	 *            Les arguments de ligne de commande.
	 */
	public static void main(String[] args) {
		BloxFrameTest bft = new BloxFrameTest();
		bft.testConstructor();
		bft.testConstructorPitPanel();
		bft.testConstructorStringPitPanel();
		bft.testAccessors();
		bft.testAssociation();
	}

	/**
	 * Methode de test de construction d'une BloxFrame de base par creation
	 * d'une classe anonyme.
	 */
	private void testConstructor() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					BloxFrame bloxFrame = new BloxFrame();
					System.out.println(bloxFrame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Methode de test de construction d'une BloxFrame utilisant un PitPanel
	 * donnee par creation d'une classe anonyme.
	 */
	private void testConstructorPitPanel() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					BloxFrame bloxFrame = new BloxFrame(new PitPanel(25));
					System.out.println(bloxFrame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Methode de test de construction d'une BloxFrame utilisant un PitPanel
	 * donnee et un nom pour la fenetre par creation d'une classe anonyme.
	 */
	private void testConstructorStringPitPanel() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					BloxFrame bloxFrame = new BloxFrame("Coucou", new PitPanel(15));
					System.out.println(bloxFrame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Methode de test des acesseurs de la BloxFrame.
	 */
	private void testAccessors() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					BloxFrame bloxFrame = new BloxFrame("Coucou", new PitPanel(10));
					System.out.println(bloxFrame + "\n");
					bloxFrame.setPitPanel(new PitPanel());
					System.out.println(bloxFrame.getPitPanel() + "\n");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Methode de test de l'association entre un PitPanel et une BloxFrame.
	 */
	private void testAssociation() {
		PitPanel tmp = new PitPanel(20);
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PitPanel tmp = new PitPanel(20);
					BloxFrame bloxFrame = new BloxFrame(tmp);
					System.out.println("Le pit panel est : \n" + bloxFrame.getPitPanel()
							+ "\n et la blox frame est : \n" + bloxFrame);
					bloxFrame.getContentPane().remove(tmp);
					PitPanel test = new PitPanel(new Pit(10, 10), 40);
					bloxFrame.associatePitPanel(test);
					System.out.println("Le pit panel est : \n" + bloxFrame.getPitPanel()
							+ "\n et la blox frame est : \n" + bloxFrame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
