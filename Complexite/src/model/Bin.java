package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author Benjamin
 * 
 *         Modelise les boites (bins) dans lesquelles il faut inserer les
 *         rectangles
 */
public class Bin {
	private int height, width, square;
	private Rectangle[][] grid;
	
	private ArrayList<Rectangle> list = new ArrayList<Rectangle>();

	/**
	 * cree une boite
	 * 
	 * @param h
	 *            hauteur de la boite
	 * @param w
	 *            largeur de la boite
	 */
	public Bin(int h, int w) {
		this.height = h;
		this.width = w;
		this.setSquare(height * width);
		grid = new Rectangle[height][width];
		/*
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				bin[i][j] = 0;
				*/
			
			
		
	}

	/**
	 * 
	 * 
	 * SETTERS AND GETTERS
	 * 
	 * 
	 */

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getSquare() {
		return square;
	}

	public void setSquare(int square) {
		this.square = square;
	}

	/**
	 * Verifie si un rectangle peut s'inserer dans la boite
	 * 
	 * @param rectangle
	 *            le rectangle dont ont chercher a verifier la validite
	 * @return
	 */
	boolean validRectangle(Rectangle rectangle) {
		return rectangle.getHeight() <= height && rectangle.getWidth() <= width;
	}

	/**
	 * Place un rectange a la position h,w de la boite en partant d'en haut a
	 * gauche
	 * 
	 * @param r
	 *            rectange
	 * @param h
	 *            ordonnee
	 * @param w
	 *            abscisse
	 * @throws modelException
	 *             envoit une exception si on ne peut pas placer de rectangle a
	 *             cet endroit
	 */
	private boolean placeRectangle(Rectangle r, int h, int w) throws modelException
			 {

		// on place l'objet rectangle r dans toutes les cases de la grille ou il
		// apparait
		for (int i = 0; i < r.getHeight(); i++) {
			for (int j = 0; j < r.getWidth(); j++) {
				int ord = i + h, abs = j + w;

				// On verifie si la case est dans la grille
				if (validCase(ord, abs)) {

					// On verifie si la case est vide
					if (emptyCase(ord,abs)) {
						grid[ord][abs] = r;
						
						list.add(r);
					} else {
						throw new modelException("erreur placement rectangle \n");
						
						
					}
				} else
					throw new modelException("erreur placement rectangle \n");
						
			}
		}
		return true;
	}

	/**
	 * 
	 * Place le rectangle r dans la grille renvoit true si c'est possible, false
	 * sinon
	 * 
	 * @param r
	 * @throws modelException
	 *             s'il est impossible de placer le rectangle, la methode
	 *             renvoit une exception
	 */
	public boolean placeRec(Rectangle r) throws modelException {
		int[] a = chercherPlace(r);
		if (a != null) {
			int i = a[0];
			int j = a[1];
			placeRectangle(r, i, j);
			return true;
		}

		return false;

	}

	/**
	 * 
	 * Cherche et renvoit les coordonnees dans la boite, d'un endroit ou placer
	 * le rectangle r
	 * 
	 * @param r
	 * @return
	 */
	private int[] chercherPlace(Rectangle r) {
		int[] a = null;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (validPlace(i, j, r)){
					a = new int[2];
					a[0]=i;a[1]=j;
					return a;	
				}
				
				
			}
		}
		return a;
	}

	/**
	 * Verifie si on peut placer le rectangle r a la position i j
	 * 
	 * @param i
	 *            abscisse
	 * @param j
	 *            ordonnee
	 * @param r
	 *            rectangle
	 * @return
	 */
	private boolean validPlace(int i, int j, Rectangle r) {
		
		for (int k=i; k < r.getHeight()+i; k++) {
			for (int l =j; l < r.getWidth()+j; l++) {
				if (!(validCase(k,l) && emptyCase(k,l)))
					return false;
			}
		}
		return true;
	}

	/**
	 * Retirer le rectangle r de la boite
	 * 
	 * @param r
	 */
	public void removeRectangle(Rectangle r) {
		list.remove(r);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (grid[i][j] == r)
					grid[i][j] = null;
			}
		}
	}

	/**
	 * Verifie si la case h,w est vide
	 * 
	 * @param h
	 * @param w
	 * @return
	 */
	public boolean emptyCase(int h, int w) {
		/*
		 * 
		 * System.out.println("emptyCase: h:" + h + "; w:" + w);
		 * System.out.println("bin: " + bin[h][w]); return bin[h][w] == 0;
		 */

		return grid[h][w] == null;
	}

	/**
	 * Verifie si la boite contient une case h w
	 * 
	 * @param h
	 * @param w
	 * @return
	 */
	public boolean validCase(int h, int w) {
		return h < height && w < width;
	}

	/**
	 * Renvoi une chaine de charactere pour modeliser la boite
	 */
	public String toString() {
		String retour = "";
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				retour += "[	R" + list.indexOf(grid[i][j]) + "	]";
			}
			retour += "\n";
		}
		return retour;
	}

}
