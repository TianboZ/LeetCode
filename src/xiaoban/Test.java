package xiaoban;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Cell c1 = new Cell(1, 2);
        Cell c2 = new Cell(1, 2);
        Cell c22 = new Cell(1, 3);
        Cell c3 = new Cell(2, 2);
        Cell c4 = new Cell(3, 2);

        TreeSet<Cell> treeset = new TreeSet<>(new CP());

        treeset.add(c1);
        treeset.add(c2);
        treeset.add(c22);
        treeset.add(c3);
        treeset.add(c4);

        HashSet<Cell> hashset = new HashSet<>();
        hashset.add(c1);
        hashset.add(c2);
        hashset.add(c3);
        hashset.add(c4);
        hashset.add(c22);
        System.out.println('a');
    }

    static class Cell {
        int val;
        int i;
        Cell(int val, int i) {
            this.val = val;
            this.i = i;
        }
    }
    static class CP implements Comparator<Cell> {
        @Override
        public int compare(Cell c1, Cell c2) {
            return  c1.val - c2.val;
        }
    }




}
