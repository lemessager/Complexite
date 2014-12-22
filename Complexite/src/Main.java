import java.util.ArrayList;

import model.Bin;
import model.Problem;
import model.Rectangle;
import model.modelException;


public class Main {
	public static void main (String [] yolo) throws modelException{
		Rectangle r = new Rectangle(1,3);
		Rectangle r2 = new Rectangle(3,1);
		int heightBin=4;
		int widthBin=4;
		ArrayList<Rectangle> list= new ArrayList<Rectangle>();
		list.add(r);
		list.add(r2);
		
		Problem p = new Problem(list, heightBin, widthBin);
		
		Bin b = new Bin (4,4);
		b.placeRectangle(r2,1,1);
		b.placeRectangle(r,0,0);
		System.out.println(b);
	}
}
