import java.util.ArrayList;

import reder.TextReader;
import visual.GraphicalDisplay;
import visual.TextualDisplay;
import model.Bin;
import model.Problem;
import model.Rectangle;
import model.Solution;
import model.SolutionAlgo1;
import model.modelException;

public class Main {
    public static void main(String[] yolo) throws modelException {
        

    	
    	Problem p= TextReader.createProblem("exemples/exempleDeBase");
    	TextualDisplay.displayProblem(p);
    	
    	Solution s = new SolutionAlgo1(p);
        s.getSolution();

        TextualDisplay.displaySolution(s);
        GraphicalDisplay.displayProblemAndSolution(p,s);
    }
}
