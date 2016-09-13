package fr.eseo.blox.view;

import java.awt.Color;

import javax.swing.JFrame;

/**
 * Classe servant de fenetre d'affichage du jeu tetris
 * 
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class BloxFrame extends JFrame {

	public final static String DEFAULT_TITLE = new String("Falling Blox");
	private PitPanel pitPanel;

	/**
	 * Construit une BloxFrame de base.
	 */
	public BloxFrame() {
		this(new PitPanel());
	}

	/**
	 * Construit une BloxFrame avec un PitPanel donne.
	 * 
	 * @param pitPanel
	 *            Le PitPanel de la fenetre.
	 */
	public BloxFrame(PitPanel pitPanel) {
		this(DEFAULT_TITLE, pitPanel);
	}

	/**
	 * Construit une BloxFrame avec un PitPanel donne et un nom donne.
	 * 
	 * @param title
	 *            Le titre de la fenetre.
	 * @param pitPanel
	 *            Le PitPanel de la fenetre.
	 */
	public BloxFrame(String title, PitPanel pitPanel) {
		this.setTitle(title);
		this.associatePitPanel(pitPanel);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * Accesseur en lecture du PitPanel.
	 * 
	 * @return Le PitPanel
	 */
	public PitPanel getPitPanel() {
		return this.pitPanel;
	}

	/**
	 * Accesseur en ecriture du PitPanel.
	 * 
	 * @param pitPanel
	 *            Le nouveau PitPanel.
	 */
	public void setPitPanel(PitPanel pitPanel) {
		this.pitPanel = pitPanel;
	}

	/**
	 * Methode permettant d'associer un PitPanel a une BloxFrame.
	 * 
	 * @param pitPanel
	 *            Le PitPanel a associer a la BloxFrame.
	 */
	public void associatePitPanel(PitPanel pitPanel) {
		this.setPitPanel(pitPanel);
		this.setBackground(Color.white);
		this.getPitPanel().setBloxFrame(this);
		this.getContentPane().add(getPitPanel());
		this.pack();
		this.validate();
	}

}