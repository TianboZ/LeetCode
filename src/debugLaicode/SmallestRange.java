package debugLaicode;


import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*

    [4,10,15,24,26],
        i

    [0,9,12,20],
       j

    [5,18,22,30]
       k

     ...

    ranges: [0, 5]   [4,9]     [5,10]    [9, 18] ....

    use minheap to store one pointer of each list, minheap size is k  (k is # of rows)

    each time we poll  the smallest value from minheap, then range is max - min, update min-range
    each time we offer new element into minheap, we update the max

    time o(m logk)    (k is # of rows, m is total number of elements in List<List<Integer>> nums)
    space o(k)

*/
public class SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {
        // Write your solution here.
        int[] res = new int[2];

        // santity check
        if (nums == null) return res;

        Queue<Element> minHeap = new PriorityQueue<>(new CP());
        int range = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // initial
        for (int i = 0; i < nums.size(); i++) {
            minHeap.offer(new Element(i, 0, nums.get(i).get(0)));
            max = Math.max(max, nums.get(i).get(0));
        }
        // terminate
        while (minHeap.size() == nums.size()) {
            // expand
            Element curr = minHeap.poll();

            // update min range
            if (Math.abs(curr.val - max) < range) {
                range = Math.abs(curr.val - max);
                res[0] = curr.val;
                res[1] = max;
            }
            // generate
            if (curr.col + 1 < nums.get(curr.row).size()) {
                minHeap.offer(new Element(curr.row, curr.col + 1, nums.get(curr.row).get(curr.col + 1)));
                if (nums.get(curr.row).get(curr.col + 1) > max) {
                    max = nums.get(curr.row).get(curr.col + 1);
                }
            }
        }
        return res;
    }
    class Element {
        int row;
        int col;
        int val;
        public Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    class CP implements Comparator<Element> {
        @Override
        public int compare(Element e1, Element e2) {
            return e1.val - e2.val;
        }
    }

}
