package fr.eseo.blox.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import fr.eseo.blox.model.Pit;
import fr.eseo.blox.view.PitPanel;

/**
 * Classe de gestion du GravityTimer
 *
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class GravityTimer implements ActionListener {

	private Pit pit;
	private PitPanel pitPanel;
	private Timer timer;
	private int timerInterval;

	/**
	 * Construit un GravityTimer.
	 *
	 * @param pitPanel
	 *            Le PitPanel dans lequel est instancie l'objet.
	 * @param timerInterval
	 *            Le temps du timer.
	 */
	public GravityTimer(PitPanel pitPanel, int timerInterval) {
		if (pitPanel != null) {
			this.pit = pitPanel.getPit();
			this.pitPanel = pitPanel;
			this.timerInterval = timerInterval;
			this.timer = new Timer(this.timerInterval, this);
			this.timer.start();
		}
	}

	/**
	 * Accesseur en lecture du TimerInterval.
	 *
	 * @return nbMillisec Le TimerInterval du GravityTimer.
	 */
	public int getTimerInterval() {
		return this.timerInterval;
	}

	/**
	 * Accesseur en ecriture du TimerInterval.
	 *
	 * @param nbMillisec
	 *            Le nouveau TimerInterval du GravityTimer.
	 */
	public void setTimerInterval(int nbMillisec) {
		this.timerInterval = nbMillisec;
		timer.setDelay(timerInterval);
	}

	/**
	 * Active la gravite lors d'un ActionEvent et force l'affichage.
	 *
	 * @param event
	 *            L'ActionEvent recupere.
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		this.pit.gravity();
		this.pitPanel.repaint();
	}

}