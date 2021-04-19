package MianJing.ixl.onsite;

import java.util.Random;

class Rec {
    int x1;   // x1, y1: bottom left; x2, y2, top right
    int x2;
    int y1;
    int y2;
    Rec(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
}
class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
// https://www.careercup.com/question?id=5657048330010624
public class Rectangle {
    public void randomRec(Rec rec) {
        Random ran = new Random();
        Point p1 = new Point(rec.x1 + ran.nextInt(rec.x2 - rec.x1 + 1), rec.y1 + ran.nextInt(rec.y2 - rec.y1 + 1));
        Point p2 = new Point(rec.x1 + ran.nextInt(rec.x2 - rec.x1 + 1), rec.y1 + ran.nextInt(rec.y2 - rec.y1 + 1));

        while (p1.x == p2.x  || p1.y == p2.y) {
            p2 = new Point(rec.x1 + ran.nextInt(rec.x2 - rec.x1 + 1), rec.y1 + ran.nextInt(rec.y2 - rec.y1 + 1));
        }

        System.out.println(p1.x + "," + p1.y);
        System.out.println(p2.x + "," + p2.y);
    }

    public static void main(String[] str) {
        Rectangle sol = new Rectangle();

        Rec rec = new Rec(1,1,10,10);
        sol.randomRec(rec);
    }
}
