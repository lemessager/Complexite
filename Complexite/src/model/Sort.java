package model;

import java.util.Comparator;

public class Sort implements Comparator<Rectangle> {

    public Sort() {
    }

    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        int compare = o1.compareTo(o2);
        if (compare > 0) {
            return 1;
        } else if (compare == 0) {
            return 0;
        } else {
            return -1;
        }
    }

}
