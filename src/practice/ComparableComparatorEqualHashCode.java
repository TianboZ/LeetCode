package practice;

import debugLaicode.ListNode;

import java.util.*;

public class ComparableComparatorEqualHashCode {
    // customize a class
    static class Cell implements Comparable<Cell> {
        int x;
        int y;
        int val;

        public Cell(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Cell another) {
            if (this.val == another.val) {
                return 0;
            }
            // ascending order
            return this.val < another.val ? -1 : 1;

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return x == cell.x &&
                    y == cell.y &&
                    val == cell.val;
        }

        @Override
        public int hashCode() {
            return 31 * 31 * this.x + 31 * this.y + this.val;
        }
    }

    // if E already implements Comparable<E> class, but still I provide a Comparator, PQ will chose the order
    // that specified in Comparator
    static class MyComparator implements Comparator<Cell> {
        @Override
        public int compare(Cell c1, Cell c2) {
            if (c1.val == c2.val) {
                return 0;
            }
            // ascending order
            //return c1.val < c2.val ? -1 : 1;

            // descending order
            return c1.val < c2.val ? 1 : -1;
        }
    }

    public static void main(String[] args) {
        // Arrays
        Cell[] cells = new Cell[3];
        cells[0] = new Cell(2, 2, 4);
        cells[1] = new Cell(1, 1, 40);
        cells[2] = new Cell(-2, 2, -1);

        // ascending order
        Arrays.sort(cells);

        // descending order
        Arrays.sort(cells, new MyComparator());


        // Collections
        List<Cell> list = new ArrayList<>();
        list.add(new Cell(2, 2, 4));
        list.add(new Cell(1, 1, 40));
        list.add(new Cell(-2, 2, -1));

        // ascending order
        Collections.sort(list);
        for (Cell e : list) {
            System.out.println(e.val);
        }

        // descending order
        System.out.println();
        Collections.sort(list, new MyComparator());
        for (Cell e : list) {
            System.out.println(e.val);
        }





        Set<Cell> set = new HashSet<>();
        set.add(new Cell(2, 2, 4));
        set.add(new Cell(1, 1, 40));
        set.add(new Cell(-2, 2, -1));
        set.add(new Cell(-2, 2, -1));
        set.add(new Cell(-2, 2, -1));
        System.out.println();
        System.out.println("set size: " + set.size()); // 3





        // min heap
        Queue<Cell> pq = new PriorityQueue<>();
        pq.offer(new Cell(2, 2, 4));
        pq.offer(new Cell(1, 1, 40));
        pq.offer(new Cell(-2, 2, -1));
        System.out.println();
        System.out.println("min heap: ");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll().val);
        }

        // max heap
        Queue<Cell> pq1 = new PriorityQueue<>(16, new MyComparator());
        pq1.offer(new Cell(2, 2, 4));
        pq1.offer(new Cell(1, 1, 40));
        pq1.offer(new Cell(-2, 2, -1));
        System.out.println();
        System.out.println("max heap: ");
        while (!pq1.isEmpty()) {
            System.out.println(pq1.poll().val);
        }
    }
}
