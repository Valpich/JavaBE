package fr.eseo.blox.view;

import java.awt.Graphics2D;

import fr.eseo.blox.model.Element;
import fr.eseo.blox.model.Piece;

/**
 * Classe destinee a appele par le PitPanel pour dessiner la Piece actuelle
 * 
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class ViewPiece {

	private PitPanel pitPanel;
	private Piece piece;

	/**
	 * Construit une ViewPiece avec un PitPanel donne.
	 * 
	 * @param pitPanel
	 *            Le PitPanel de la ViewPiece.
	 */
	public ViewPiece(PitPanel pitPanel) {
		this.setPitPanel(pitPanel);
	}

	/**
	 * Methode permettant de dessiner la ViewPiece.
	 * 
	 * @param g2D
	 *            Le contexte graphique 2D donne.
	 */
	public void display(Graphics2D g2D) {
		this.piece = this.getPitPanel().getPit().getCurrentPiece();
		if (piece != null) {
			for (Element elem : this.piece.getElements()) {
				g2D.setColor(elem.getColour());
				g2D.fill3DRect((int) elem.getCoordinate().getX() * this.getPitPanel().getElementSize(),
						(int) elem.getCoordinate().getY() * this.getPitPanel().getElementSize(),
						this.getPitPanel().getElementSize(), this.getPitPanel().getElementSize(), true);
			}
		}
	}

	/**
	 * Accesseur en lecture du PitPanel.
	 * 
	 * @return Le PitPanel.
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

}