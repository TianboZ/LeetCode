package debugLaicode;

import java.util.*;

public class HashCodeAndEquals {
    public static void main(String[] args) {
        HashCodeAndEquals test = new HashCodeAndEquals();
        test.test();
    }
    public void test() {
        Set<Cell> set = new HashSet<>();
        //List<Integer> list = new ArrayList<>();
        //list.add(1);
        set.add(new Cell(1,2));
        set.add(new Cell(2,3));
        set.add(new Cell(1,2));
        set.add(new Cell(2,3));
        if (set.contains(new Cell(1,2))) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        System.out.println(set);
    }
    class Cell {
        int x;
        int y;
        public Cell (int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Cell cell = (Cell) obj;
            return cell.x == this.x && cell.y == this.y;
        }
        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }
}
