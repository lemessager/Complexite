package model;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    private ArrayList<Bin> binList;
    private int binHeight;
    private int binWidth;
    private ArrayList<Rectangle> rectangles;

    public Solution(Problem p) {
        rectangles = p.getListOfRectangles();
        binHeight = p.getHeight();
        binWidth = p.getWidth();
    }

    public void getSolution() throws modelException {
        Collections.sort(rectangles, new Sort());
        Bin b1 = new Bin(binHeight, binWidth);
        /*for (Rectangle rec : rectangles) {
            if (b1.validRectangle(rec)) {
                b1.placeRectangle(rec, 0, 0);
            } else {
                b1 = new Bin(binHeight, binHeight);
            }
        }*/
    }

    public ArrayList<Bin> getBinList() {
        return binList;
    }

    /**
     * @param binList
     */
    public void setBinList(ArrayList<Bin> binList) {
        this.binList = binList;
    }

}
