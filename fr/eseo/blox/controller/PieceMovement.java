package fr.eseo.blox.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import fr.eseo.blox.model.BloxException;
import fr.eseo.blox.model.Pit;
import fr.eseo.blox.view.PitPanel;

/**
 * Classe de gestion du mouvement des pieces
 * 
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class PieceMovement implements MouseMotionListener, MouseWheelListener {

	private Pit pit;
	private PitPanel pitPanel;
	private Integer lastColumn;

	/**
	 * Construit un PieceMovement.
	 * 
	 * @param pitPanel
	 *            Le PitPanel dans lequel est instancie l'objet.
	 */
	public PieceMovement(PitPanel pitPanel) {
		this.pitPanel = pitPanel;
		this.pit = pitPanel.getPit();
	}

	/**
	 * Compare a chaque MouseEvent la colonne dans laquelle se trouve le curseur
	 * pour deplacer la piece a gauche si la colonne actuelle est plus petite
	 * que celle precedente et a droite dans le cas ou celle-ci serait plus a
	 * droite. Si la colonne est identique, rien n'est effectue. L'affichage est
	 * mis a jour apres le déplacement de la piece et la colonne actuelle du
	 * curseur est mise à jour.
	 * 
	 * @param event
	 *            Le MouseEvent recupere.
	 */
	@Override
	public void mouseMoved(MouseEvent event) {
		Integer currentColumn = (int) event.getPoint().getX() / this.pitPanel.getElementSize();
		if (lastColumn == null) {
			this.lastColumn = currentColumn;
		} else {
			try {
				if (currentColumn > lastColumn) {
					this.pit.getCurrentPiece().moveBy(1, 0);
				}
				if (currentColumn < lastColumn) {
					this.pit.getCurrentPiece().moveBy(-1, 0);
				}
			} catch (IllegalArgumentException e1) {
				e1.printStackTrace();
			} catch (BloxException e2) {
				e2.printStackTrace();
			} finally {
				this.pitPanel.repaint();
			}
		}
		this.lastColumn = currentColumn;
	}

	/**
	 * Ne fait rien.
	 * 
	 * @param event
	 *            Le MouseEvent recupere.
	 */
	@Override
	public void mouseDragged(MouseEvent event) {
	}

	/**
	 * Regarde la rotation actuelle de la sourie, si celle-ci est superieure a
	 * 0, elle deplace la piece vers le bas et met a jour l'affichage.
	 * 
	 * @param event
	 *            Le MouseEventWheel recupere.
	 */
	@Override
	public void mouseWheelMoved(MouseWheelEvent event) {
		int currentRotation = event.getWheelRotation();
		if (currentRotation > 0) {
			try {
				this.pit.getCurrentPiece().moveBy(0, 1);
				pitPanel.repaint();
			} catch (IllegalArgumentException e1) {
				e1.printStackTrace();
			} catch (BloxException e2) {
				this.pit.handleCollision();
			} finally {
				this.pitPanel.repaint();
			}
		}
	}

}