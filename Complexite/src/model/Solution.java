package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * 
 * Classe generique modelisant la solution d'un probleme donne
 * 
 * @author  YZ
 *
 */
public abstract class Solution {

    protected ArrayList<Bin> binList;
    protected int binHeight;
    protected int binWidth;
    protected ArrayList<Rectangle> rectangles;

    public Solution(Problem p) {
        rectangles = p.getListOfRectangles();
        binHeight = p.getHeight();
        binWidth = p.getWidth();
        binList = new ArrayList<>();
    }

  
    public abstract void getSolution() throws modelException;

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
