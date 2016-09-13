package fr.eseo.blox.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import fr.eseo.blox.controller.GravityTimer;
import fr.eseo.blox.controller.PieceMovement;
import fr.eseo.blox.controller.PieceRotation;
import fr.eseo.blox.model.PieceFactory;
import fr.eseo.blox.model.Pit;

/**
 * Classe destinee a etre contenue dans une BloxFrame et permettant de
 * visualiser pit du tetris
 * 
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class PitPanel extends JPanel {

	public final static int DEFAULT_SQUARE_SIZE = 20;
	private Pit pit;
	private int elementSize;
	private BloxFrame bloxFrame;
	private ViewPiece viewPiece;
	private ViewPile viewPile;
	private GravityTimer gravityTimer;

	/**
	 * Construit un PitPanel de base.
	 */
	public PitPanel() {
		this(new Pit());
	}

	/**
	 * Construit un PitPanel avec un Pit donne.
	 * 
	 * @param pit
	 *            Le Pit a visualiser.
	 */
	public PitPanel(Pit pit) {
		this(pit, DEFAULT_SQUARE_SIZE);
	}

	/**
	 * Construit un PitPanel affichant des elements de taille donnee.
	 * 
	 * @param squareSize
	 *            La taille des elements a afficher.
	 */
	public PitPanel(int squareSize) {
		this(new Pit(), squareSize);
	}

	/**
	 * Construit un PitPanel affichant des elements de taille donnee d'un Pit
	 * donne.
	 * 
	 * @param pit
	 *            Le Pit a visualiser.
	 * @param squareSize
	 *            La taille des elements a afficher.
	 */
	public PitPanel(Pit pit, int squareSize) {
		this.setElementSize(squareSize);
		this.setPit(pit);
		this.setViewPiece(new ViewPiece(this));
		this.setViewPile(new ViewPile(this));
		if (getPit().getNextPiece() == null)
			this.getPit().setNextPiece(PieceFactory.newPiece(getPit()));
		PieceMovement pm = new PieceMovement(this);
		this.addMouseMotionListener(pm);
		this.addMouseWheelListener(pm);
		this.addMouseListener(new PieceRotation(this));
		this.gravityTimer = new GravityTimer(this, 100);
	}

	/**
	 * Accesseur en lecture de la BloxFrame.
	 * 
	 * @return La BloxFrame.
	 */
	public BloxFrame getBloxFrame() {
		return this.bloxFrame;
	}

	/**
	 * Accesseur en ecriture de la BloxFrame.
	 * 
	 * @param frame
	 *            La nouvelle BloxFrame.
	 */
	public void setBloxFrame(BloxFrame frame) {
		this.bloxFrame = frame;
	}

	/**
	 * Accesseur en lecture de la taille d'un element.
	 * 
	 * @return La taille d'un element.
	 */
	public int getElementSize() {
		return this.elementSize;
	}

	/**
	 * Accesseur en ecriture de la taille d'un element.
	 * 
	 * @param elSize
	 *            Le nouvelle taille d'un element.
	 */
	public void setElementSize(int elSize) {
		this.elementSize = elSize;
		if (pit != null)
			this.setPreferredSize(new Dimension(this.getPit().getWidth() * this.getElementSize(),
					this.getPit().getHeight() * this.getElementSize()));
	}

	/**
	 * Accesseur en ecriture du Pit.
	 * 
	 * @param pit
	 *            Le nouveau Pit.
	 */
	public void setPit(Pit pit) {
		if (pit != getPit()) {
			this.pit = pit;
			if (pit != null)
				this.setPreferredSize(new Dimension(this.getPit().getWidth() * this.getElementSize(),
						this.getPit().getHeight() * this.getElementSize()));
			if (this.getBloxFrame() != null)
				this.getBloxFrame().associatePitPanel(this);
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
	 * Accesseur en lecture de la viewPiece.
	 * 
	 * @return La viewPiece.
	 */
	public ViewPiece getViewPiece() {
		return this.viewPiece;
	}

	/**
	 * Accesseur en ecriture de la viewPiece.
	 * 
	 * @param viewPiece
	 *            La nouvelle viewPiece
	 */
	public void setViewPiece(ViewPiece viewPiece) {
		this.viewPiece = viewPiece;
	}

	/**
	 * Accesseur en ecriture de la viewPile.
	 * 
	 * @param viewPile
	 *            La nouvelle viewPile.
	 */
	public void setViewPile(ViewPile viewPile) {
		this.viewPile = viewPile;
	}

	/**
	 * Accesseur en lecture de la viewPile.
	 * 
	 * @return La viewPile.
	 */
	public ViewPile getViewPile() {
		return this.viewPile;
	}

	/**
	 * Methode permettant de dessiner le PitPanel.
	 * 
	 * @param g
	 *            Le contexte graphique donne automatiquement par la machine
	 *            virtuelle java.
	 */
	@Override
	public void paintComponent(Graphics g) {
		this.setBackground(Color.white);
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setColor(Color.black);
		for (int i = 0; i < (this.getPit().getHeight()); i++) {
			for (int j = 0; j < (this.getPit().getWidth()); j++) {
				g2.drawRect(j * this.getElementSize(), i * this.getElementSize(), this.getElementSize(),
						this.getElementSize());
			}
		}
		this.getViewPile().display(g2);
		this.getViewPiece().display(g2);
		g2.dispose();
	}

}