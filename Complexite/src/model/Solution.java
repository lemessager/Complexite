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
        binList = new ArrayList<>();
    }

    public void getSolution() throws modelException {
        // if (rectangles.size() > 0) {
        Collections.sort(rectangles, new Sort());
        Bin b1 = new Bin(binHeight, binWidth);
        binList.add(b1);

        for (Rectangle rectangle : rectangles) {
            for (Bin bin : binList) {
                if (bin.validRectangle(rectangle)) {
                    bin.placeRec(rectangle);
                    break;
                } else {
                    b1 = new Bin(binHeight, binWidth);
                    binList.add(b1);
                    b1.placeRec(rectangle);
                }
            }
            
        }
        // }
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
