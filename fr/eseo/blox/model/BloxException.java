package fr.eseo.blox.model;

/**
 * Classe de gestion des exceptions lie aux deplacements des pieces
 * 
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class BloxException extends Exception {

	public static final int BLOX_COLLISION = 0;
	public static final int BLOX_EXIT_PIT = 1;
	private int cause;

	/**
	 * Construit une BloxException.
	 * 
	 * @param message
	 *            La chaine de caractère expliquant la cause de l'exception.
	 * @param cause
	 *            L'entier relatif a la cause : Si 0 il y a eu collision, si 1
	 *            la piece est sortie du Pit.
	 */
	public BloxException(String message, int cause) {
		super(message);
		this.cause = cause;
	}

	/**
	 * Donner l'entier relatif a la cause de l'exception.
	 * 
	 * @return L'entier relatif a la cause : Si 0 il y a eu collision, si 1 la
	 *         piece est sortie du Pit.
	 */
	public int getExceptionCause() {
		return cause;
	}

}