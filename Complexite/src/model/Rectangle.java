package model;

/**
 * Represente les rectangles a inserer dans les Bins (boites)
 * 
 * @author Benjamin
 * 
 */
public class Rectangle {

    private int height, width, square;

    /**
     * Cree un rectangle de hauteur i et de largeur j
     * 
     * @param i
     *            hauteur du rectangle
     * @param j
     *            largeur du rectangle
     */
    public Rectangle(int i, int j) {
        this.height = i;
        this.width = j;
        this.setSquare(i * j);
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

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }
    
    public int compareTo(Rectangle rectangle) {
        int square1 = this.getSquare();
        int square2 = rectangle.getSquare();
        if (square1 < square2) {
            return 1;
        } else if (square1 == square2) {
            return 0;
        } else {
            return -1;
        }
    }

    public String toString() {
        return "Rectangle : Height " + this.height + " Width " + this.width;
    }

    
}
