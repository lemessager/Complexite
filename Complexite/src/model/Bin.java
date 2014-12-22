package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author Benjamin
 *
 * Modelise les boites (bins) dans lesquelles il faut inserer les rectangles
 */
public class Bin {
	private int height,width;
	private Rectangle[][] grid;
	private HashMap<Rectangle,String> map=new HashMap<Rectangle, String>();
	
	/**
	 * cree une boite
	 * @param h hauteur de la boite
	 * @param w largeur de la boite
	 */
	public Bin (int h,int w){
		this.height=h;
		this.width=w;
		grid  = new Rectangle[height][width];
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
	
	
	/**
	 * Verifie si un rectangle peut s'inserer dans la boite
	 * @param rectangle le rectangle dont ont chercher a verifier la validite
	 * @return
	 */
	boolean validRectangle (Rectangle rectangle){
		return rectangle.getHeight()<=this.height&& rectangle.getWidth()<=this.getWidth();
	}
	
	/**
	 * Place un rectange a la position h,w de la boite en partant d'en haut a gauche
	 * @param r rectange
	 * @param h ordonnee
	 * @param w abscisse
	 * @throws modelException envoit une exception si on ne peut pas placer de rectangle a cet endroit
	 */
	public void placeRectangle (Rectangle r, int h,int w) throws modelException{
		
		// on place l'objet rectangle r dans toutes les cases de la grille ou il apparait
		for (int i=0;i<r.getHeight();i++){
			for (int j=0;j<r.getWidth();j++){
				int ord=i+h,abs=j+w;

				// On verifie si la case est dans la grille
				if (validCase(ord,abs)){

					//On verifie si la case est vide
					if (emptyCase(i,j)){	
						grid[ord][abs]=r;
						map.put(r,"r("+ord+","+abs+")");
					}
					else //case non vide
						throw new modelException("\n Impossible de placer un rectangle ("+r.getHeight()+","+r.getWidth()+")"
								+ "a cet endroit, case non vide \n");	
				}
				else // debordement de la grille
					throw new modelException("\n Vous essayez de placer un rectangle a l'exterieur de la boite \n");
					
			}
		}
	}
	
	/**
	 * Retirer le rectangle r de la boite
	 * @param r
	 */
	public void removeRectangle (Rectangle r){
		map.remove(r);
		for (int i=0;i<height;i++){
			for (int j=0;j<width;j++){
				if (grid[i][j]==r)
					grid[i][j]=null;
			}
		}
	}
	
	/**
	 * Verifie si la case h,w est vide
	 * @param h
	 * @param w
	 * @return
	 */
	public boolean emptyCase (int h,int w){
		return grid[h][w]==null;
	}
	
	
	/**
	 * Verifie si la boite contient une case h w
	 * @param h
	 * @param w
	 * @return
	 */
	public boolean validCase(int h,int w){
		return h<height&&w<width;
	}
	
	/**
	 * Renvoi une chaine de charactere pour modeliser la boite
	 */
	public String toString(){
		String retour ="";
			for (int i=0;i<height;i++){
				for (int j=0;j<width;j++){
					retour+="[	"+map.get(grid[i][j])+"	]";
			}
				retour+="\n";
		}
		return retour;
	}
	
}
