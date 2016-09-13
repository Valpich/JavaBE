package fr.eseo.blox.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import fr.eseo.blox.model.BloxException;
import fr.eseo.blox.model.Pit;
import fr.eseo.blox.view.PitPanel;

/**
 * Classe de gestion de la rotation des pieces
 * 
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class PieceRotation extends MouseAdapter {

	private Pit pit;
	private PitPanel pitPanel;

	/**
	 * Construit un PieceRotation.
	 * 
	 * @param pitPanel
	 *            Le PitPanel dans lequel est instancie l'objet.
	 */
	public PieceRotation(PitPanel pitPanel) {
		this.pitPanel = pitPanel;
		this.pit = pitPanel.getPit();
	}

	/**
	 * Effectue une rotation dans le sens anti-horaire de la piece actuelle si
	 * un clic gauche est effectue, si c'est un clic droit, la rotation est
	 * alors effectuee dans le sens horaire. L'affichage est mis a jour.
	 * 
	 * @param event
	 *            Le MouseEvent recupere.
	 */
	@Override
	public void mouseClicked(MouseEvent event) {
		try {
			if (SwingUtilities.isLeftMouseButton(event)) {
				this.pit.getCurrentPiece().rotate(false);
			}
			if (SwingUtilities.isRightMouseButton(event)) {
				this.pit.getCurrentPiece().rotate(true);
			}
		} catch (BloxException e) {
			e.printStackTrace();
		} finally {
			this.pitPanel.repaint();
		}
	}

}