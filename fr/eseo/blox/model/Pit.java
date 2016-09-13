package fr.eseo.blox.model;

/**
 * Classe decrivant la zone dans laquelle les pieces du jeu de tetris se deplacent
 * 
 * @author Valentin Pichavant
 * @version BE 2015
 */
public class Pit {

	public final static int DEFAULT_WIDTH = 10;
	public final static int DEFAULT_HEIGHT = 24;
	private int height;
	private int width;
	private Piece currentPiece;
	private Piece nextPiece;
	private Pile pile;

	/**
	 * Construit le Pit de base.
	 */
	public Pit() {
		this.setHeight(DEFAULT_HEIGHT);
		this.setWidth(DEFAULT_WIDTH);
		this.setPile(new Pile(this));
		this.setCurrentPiece(PieceFactory.newPiece(this));
		this.setNextPiece(PieceFactory.newPiece(this));
	}

	/**
	 * Construit un Pit de largueur et de longueur definies.
	 * 
	 * @param width
	 *            La largueur voulue pour le nouveau Pit.
	 * @param height
	 *            La hauteur voulue pour le nouveau Pit.
	 */
	public Pit(int width, int height) {
		this();
		this.setWidth(width);
		this.setHeight(height);
	}

	/**
	 * Accesseur en lecture de la piece actuelle.
	 * 
	 * @return La Piece actuelle.
	 */
	public Piece getCurrentPiece() {
		return this.currentPiece;
	}

	/**
	 * Accesseur en ecriture de la piece actuelle.
	 * 
	 * @param piece
	 *            La nouvelle Piece actuelle.
	 */
	public void setCurrentPiece(Piece piece) {
		this.currentPiece = piece;
		if (piece != null)
			this.getCurrentPiece().setPit(this);
	}

	/**
	 * Accesseur en lecture de la piece suivante.
	 * 
	 * @return La Piece suivante.
	 */
	public Piece getNextPiece() {
		return this.nextPiece;
	}

	/**
	 * Accesseur en ecriture de la piece suivante.
	 * 
	 * @param newPiece
	 *            La nouvelle Piece suivante.
	 */
	public void setNextPiece(Piece newPiece) {
		this.nextPiece = newPiece;
		if (newPiece != null)
			this.getNextPiece().setPit(this);
	}

	/**
	 * Accesseur en lecture de la largueur du Pit.
	 * 
	 * @return La largueur du Pit.
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Accesseur en ecriture de la largueur du Pit.
	 * 
	 * @param width
	 *            La nouvelle largueur du Pit.
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Accesseur en lecture de la hauteur du Pit.
	 * 
	 * @return La hauteur du Pit.
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Accesseur en ecriture de la piece suivante.
	 * 
	 * @param height
	 *            La nouvelle hauteur du Pit.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Accesseur en lecture de la pile.
	 * 
	 * @return La pile.
	 */
	public Pile getPile() {
		return this.pile;
	}

	/**
	 * Accesseur en ecriture de la pile.
	 * 
	 * @param pile
	 *            La nouvelle pile.
	 */
	public void setPile(Pile pile) {
		this.pile = pile;
	}

	/**
	 * Methode d'association d'une pile avec le pit.
	 * 
	 * @param pile
	 *            La nouvelle Pile a associer.
	 */
	public void associatePile(Pile pile) {
		this.setPile(pile);
		this.getPile().setPit(this);
	}

	/**
	 * Methode permettant de simuler la gravite dans le Pit.
	 */
	public void gravity() {
		try {
			this.getCurrentPiece().moveBy(0, 1);
		} catch (BloxException e) {
			handleCollision();
		} catch (IllegalArgumentException e2) {
			e2.printStackTrace();
		}
	}

	/**
	 * Methode permettant de gerer une collision dans le Pit.
	 */
	public void handleCollision() {
		this.getPile().addElements(this.getCurrentPiece());
		if (this.getNextPiece() != null) {
			this.setCurrentPiece(this.getNextPiece());
			this.setNextPiece(PieceFactory.newPiece(this));
		} else {
			this.setCurrentPiece(PieceFactory.newPiece(this));
			this.setNextPiece(PieceFactory.newPiece(this));
		}
	}

	/**
	 * Methode permettant d'obtenir une chaine de caracteres decrivant un Pit.
	 * 
	 * @return La chaine de caracteres decrivant le Pit.
	 */
	@Override
	public String toString() {
		if (getCurrentPiece() == null) {
			if (getNextPiece() == null) {
				return new String("Pit : Dimension (" + getWidth() + "," + getHeight()
						+ "), current piece : none, next piece : none");
			}
			return new String("Pit : Dimension (" + getWidth() + "," + getHeight()
					+ "), current piece : none, next piece : " + getNextPiece());
		} else {
			if (getNextPiece() == null) {
				return new String("Pit : Dimension (" + getWidth() + "," + getHeight() + "), current piece : "
						+ getCurrentPiece() + ", next piece : none");
			} else {
				return new String("Pit : Dimension (" + getWidth() + "," + getHeight() + "), current piece : "
						+ getCurrentPiece() + ", next piece : " + getNextPiece());
			}
		}
	}

}