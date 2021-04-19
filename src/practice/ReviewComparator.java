package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class ReviewComparator {
    class Cell {
        int x;
        int y;
        String z;
        Cell(int _x, int _y, String _z) {
            x = _x;
            y = _y;
            z = _z;
        }
    }

    public void sort() {
        List<Cell> list = new ArrayList<>();
        list.add(new Cell(2,1,"c"));
        list.add(new Cell(2,1,"a"));
        list.add(new Cell(3,2,"a"));
        list.add(new Cell(1,1,"ff"));
        list.add(new Cell(3,1,"4"));
        list.add(new Cell(0,1,"a"));

        // compare x, then y, then z
        // < java 8
//        Collections.sort(list, (c1, c2) -> {
//            if (c1.x == c2.x) {
//                if (c1.y == c2.y) {
//                    return c1.z.compareTo(c2.z);
//                }
//                return c1.y - c2.y;
//            }
//            return c1.x - c2.x;
//        });

        // java 8 lambda function
        list.sort((c1, c2) -> {
            if (c1.x == c2.x) {
                if (c1.y == c2.y) {
                    return c1.z.compareTo(c2.z);
                }
                return c1.y - c2.y;
            }
            return c1.x - c2.x;
        });

        System.out.println(list);
    }


    public void sort2() {
        List<Integer> list = Arrays.asList(1,2,4,0,0,-1);
        list.sort((a, b) -> a - b);
        list.sort((a, b) -> b - a);
        Collections.sort(list);
        System.out.println(list);
    }
    public static void main(String[] args) {
        ReviewComparator sol = new ReviewComparator();
        sol.sort();
        sol.sort2();
    }
}
