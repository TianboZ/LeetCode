package debugLaicode;

import java.util.LinkedList;
import java.util.List;

public class SortWith3Stacks {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        // Write your solution here.
        int count = s1.size();
        while (!s1.isEmpty()) {
            int min = Integer.MAX_VALUE;
            while (!s1.isEmpty()) {
                min = Math.min(s1.peekFirst(), min);
                s2.offerFirst(s1.pollFirst());

            }
            int tmpt = count;
            boolean firsttime = true; // tricky
            while (tmpt > 0) {
                if (s2.peekFirst() == min && firsttime) {
                    s2.pollFirst();
                    firsttime = false;
                } else {
                    s1.offerFirst(s2.pollFirst());
                }
                tmpt--;
            }
            count--;
            s2.offerFirst(min);
        }
        while (!s2.isEmpty()) {
            s1.offerFirst(s2.pollFirst());
        }
    }

    public static void main(String[] args) {
        SortWith3Stacks sortWith3Stacks = new SortWith3Stacks();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(-1);
        list.add(2);
        list.add(-3);
        list.add(100);
        sortWith3Stacks.sort(list);
    }
}
