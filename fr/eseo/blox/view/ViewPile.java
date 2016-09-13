package fr.eseo.blox.view;

import java.awt.Graphics2D;

import fr.eseo.blox.model.Element;
import fr.eseo.blox.model.Pile;

/**
 * Classe destinee a etre appele par le PitPanel pour dessiner la Pile
 * 
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class ViewPile {

	private Pile pile;
	private PitPanel pitPanel;

	/**
	 * Construit une ViewPile avec un PitPanel donne.
	 * 
	 * @param pp
	 *            Le PitPanel de la Pile.
	 */
	public ViewPile(PitPanel pp) {
		this.setPitPanel(pp);
		this.pile = getPitPanel().getPit().getPile();
	}

	/**
	 * Methode permettant de dessiner la ViewPile.
	 * 
	 * @param g2D
	 *            Le contexte graphique 2D donne.
	 */
	public void display(Graphics2D g2D) {
		if (pile != null) {
			for (Element[] elem : this.pile.getElements()) {
				for (Element e : elem) {
					if (e != null) {
						g2D.setPaint(e.getColour().darker());
						g2D.fill3DRect(e.getX() * this.getPitPanel().getElementSize(),
								e.getY() * this.getPitPanel().getElementSize(), this.getPitPanel().getElementSize(),
								this.getPitPanel().getElementSize(), true);
					}
				}
			}
		}
		this.getPitPanel().repaint();
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