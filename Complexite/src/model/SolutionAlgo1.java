package model;

import java.util.Collections;

public class SolutionAlgo1 extends Solution {

	public SolutionAlgo1(Problem p) {
		super(p);

	}

	public void getSolution() throws modelException {

		Collections.sort(rectangles, new Sort());
		Bin b1 = new Bin(binHeight, binWidth);
		binList.add(b1);
		boolean ok = false;
		for (Rectangle rectangle : rectangles) {
			System.out.println(rectangle);
			for (int i = 0; i < binList.size(); i++) {

				Bin bin = binList.get(i);
				ok = false;
				if (bin.validRectangle(rectangle) && bin.placeRec(rectangle)) {

					ok = true;
					break;
				}

			}
			if (!ok) {
				
				b1 = new Bin(binHeight, binWidth);
				binList.add(b1);
				b1.placeRec(rectangle);
				System.out.println("done");
				ok = true;
			}

		}

	}

}
