package model;

import java.util.Collections;

public class SolutionAlgo1 extends Solution{

	  public SolutionAlgo1(Problem p) {
		super(p);
		
	}

	public void getSolution() throws modelException {
	        // if (rectangles.size() > 0) {
	        Collections.sort(rectangles, new Sort());
	        Bin b1 = new Bin(binHeight, binWidth);
	        binList.add(b1);

	        for (Rectangle rectangle : rectangles) {
	            for (Bin bin : binList) {
	                if (bin.validRectangle(rectangle) && bin.canFit(rectangle)) {
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
	  
}
