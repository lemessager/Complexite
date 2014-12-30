import java.util.ArrayList;
import model.Bin;
import model.Problem;
import model.Rectangle;
import model.Solution;
import model.modelException;

public class Main {
    public static void main(String[] yolo) throws modelException {
        Rectangle r = new Rectangle(1, 3);
        Rectangle r2 = new Rectangle(3, 1);
        Rectangle r3 = new Rectangle(4, 4);
        Rectangle r4 = new Rectangle(2, 3);
        int heightBin = 4;
        int widthBin = 4;
        ArrayList<Rectangle> list = new ArrayList<Rectangle>();
        list.add(r);
        list.add(r2);
        list.add(r3);
        list.add(r4);
        
        Problem p = new Problem(list, heightBin, widthBin);
        Solution s = new Solution(p);
        s.getSolution();

        for (Rectangle rectangle : list) {
            System.out.println(rectangle.toString());
        }
        
        Bin b = new Bin(4, 4);
        b.placeRec(r2);
        b.placeRec(r);
        System.out.println(b);
    }
}
