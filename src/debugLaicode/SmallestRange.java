package debugLaicode;


import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SmallestRange {
    // sol1:
    /*
     * 这道题还有一种使用priority_queue来做的，优先队列默认情况是最大堆，但是这道题我们需要使用最小堆，
     * 我们可以重新写一下comparator就行了。解题的主要思路很上面的解法很相似，只是具体的数据结构的使用上略有不同，
     * 这curMax表示当前遇到的最大数字，用一个idx数组表示每个list中遍历到的位置，然后就是我们的优先队列了，里面放一个pair，
     * 是数字和其所属list组成的对儿。然后我们遍历所有的list，将每个list的首元素和该list序号组成pair放入队列中，然后idx数
     * 组中每个位置都赋值为1，因为0的位置已经放入队列了，所以指针向后移一个位置，还要更新当前最大值curMax。此时我们的queue中
     * 是每个list各有一个数字，由于是最小堆，所以最小的数字就在队首，再加上最大值curMax，就可以初始化结果res了。然后我们进行
     * 循环，注意这里循环的条件不是队列不为空，而是当某个list的数字遍历完了就结束循环，因为我们的范围要cover每个list至少一个
     * 数字。所以我们的while循环条件即是队首数字所在的list的遍历位置小于该list的总个数，在循环中，取出队首数字所在的list
     * 序号t，然后将该list中下一个位置的数字和该list序号t组成pair，加入队列中，然后用这个数字更新curMax，同时idx中t对应
     * 的位置也自增1。现在来更新结果res，如果结果res中两数之差大于curMax和队首数字之差，则我们更新结果res
     * */
    public int[] smallestRange(List<List<Integer>> nums) {
        // Write your solution here.
        Queue<Element> minHeap = new PriorityQueue<>(new CP());
        int[] res = new int[2];
        int range = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // initial
        for (int i = 0; i < nums.size(); i++) {
            minHeap.offer(new Element(i, 0, nums.get(i).get(0)));
            max = Math.max(max, nums.get(i).get(0));
        }
        // terminate
        while (!minHeap.isEmpty()) {
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
            } else {
                break;
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

    // sol2:
    // http://www.cnblogs.com/grandyang/p/7200016.html
}


