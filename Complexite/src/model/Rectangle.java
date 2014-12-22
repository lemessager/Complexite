package model;


/**
 * Represente les rectangles a inserer dans les Bins (boites)
 * @author Benjamin
 *
 */
public class Rectangle {

	private int height,width;

	/**
	 * Cree un rectangle de hauteur i et de largeur j
	 * @param i hauteur du rectangle
	 * @param j largeur du rectangle
	 */
	public Rectangle(int i, int j) {
		this.height=i;
		this.width=j;
	}

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
	
}
