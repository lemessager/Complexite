package visual;

import model.Bin;
import model.Problem;
import model.Rectangle;
import model.Solution;

public class TextualDisplay {


	public static void displayProblem(Problem p) {
		System.out.println("\n------------Probleme--------------");
		System.out.println("| Bins dimensions : ");
		System.out.println("| 		height :	"+p.getHeight());
		System.out.println("| 		width :		"+p.getWidth());
		System.out.println("| Rectangles : ");
		for (Rectangle r:p.getListOfRectangles()){
			System.out.println("|"+r);
		}
		System.out.println("----------------------------------\n");
	}

	public static void displaySolution(Solution s) {
		System.out.println("\n------------Solution--------------\n");	
		for (Bin b:s.getBinList()){
			System.out.println(b);
		}
		System.out.println("----------------------------------\n");
	}

}
