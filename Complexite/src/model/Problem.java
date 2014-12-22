package model;

import java.util.ArrayList;

public class Problem {

	
	// Rectangles to fit in the bins
	private ArrayList<Rectangle> listOfRectangles= new ArrayList<Rectangle>();
	
	// Dimension of the bins
	private int height,width;
	
	
	/**
	 * 
	 *  Modelise un probleme, a savoir , une liste de rectangles et un format de boite
	 * 
	 * @param list
	 * @param height
	 * @param width
	 * @throws modelException
	 */
	public Problem (ArrayList<Rectangle> list,int height,int width) throws modelException{
		Bin b = new Bin(height,width);
		for (Rectangle r : list){
			if (!b.validRectangle(r))
				throw new modelException("Probleme non instantiable : un des rectangles a une dimension invalide");
		}
	}

	/**
	 * Ajoute un rectangle au probleme
	 * @param r
	 */
	public void addRectangle (Rectangle r){
		listOfRectangles.add(r);
	}
	
	/**
	 * Retire un rectangle du probleme
	 * @param r
	 */
	public void removeRectangle (Rectangle r){
		listOfRectangles.remove(r);
	}
	
	public ArrayList<Rectangle> getListOfRectangles() {
		return listOfRectangles;
	}


	public void setListOfRectangles(ArrayList<Rectangle> listOfRectangles) {
		this.listOfRectangles = listOfRectangles;
	}

	
}
