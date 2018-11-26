package MianJing.thumbtack.Onsite;

import practice.MaxHeap;

import java.util.*;

/*
* solution
*
* 0     1      2        10
*                        |
*
* 3     4       5       9
* |
*
* 8     9       100     200
* |
*
* range: [0, 8]    initial, range is 8 - 0 = 8
* range: [1, 8]    range = 8 - 1 = 7
* range: [2, 8]    range = 8 - 2 = 6
* range: [3, 10]   update max, find next smallest element, which is 3      range = 10 - 3 = 7
* ...
*
*
*
* need a data structure to know the smallest element efficient
* every time we move pointer, update the max value, update range, range = max - min
*
*
* use minheap to get smallest element efficient, minheap size is k
*
*
* time O(n * logk)   k is number of rows        n is total number of elements in List<List<Integer>>
* space O(k)
*
* */
public class SmallestRange {
    public int smallest(Map<String, List<Integer>> dict, List<String> words) {

        //sanity check
        // TODO: 11/23/18

        List<List<Integer>> input = new ArrayList<>();
        for (String s : words) {
            if (!dict.containsKey(s)) {
                return -1;
            }
            input.add(dict.get(s));
        }


        int k = input.size();

        Queue<Cell> minheap = new PriorityQueue<>(new CP());
        int start = -1;
        int end = -1;

        System.out.println(input);

        // initial
        int max = Integer.MIN_VALUE;
        int range = Integer.MAX_VALUE;

        int i = 0;
        for (List<Integer> list : input) {
            max = Math.max(max, list.get(0));
            minheap.offer(new Cell(i, 0, input.get(i).get(0)));
            i++;
        }

        // terminate condition
        while (minheap.size() == k) {
            // expand rule
            Cell curr = minheap.poll();
            int x = curr.x;
            int y = curr.y;
            int val = curr.val; // min element in queue

            System.out.println(val);

            // update range
            if (max - val < range) {
                range = max - val;
                start = val;
                end = max;
            }

            // generate rule
            if (y + 1 < input.get(x).size()) {
                minheap.offer(new Cell(x, y + 1, input.get(x).get(y + 1)));
                max = Math.max(max, input.get(x).get(y + 1));
            }
        }
        System.out.println("start: " + start + " end: " + end);
        return range;
    }

    private static class CP implements Comparator<Cell> {
        @Override
        public int compare (Cell c1, Cell c2) {
            if (c1.val == c2.val) return  0;
            return c1.val < c2.val ? -1: 1; // increasing order
        }
    }

    private static class Cell{
        int x;
        int y;
        int val;
        Cell(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        SmallestRange smallestRange = new SmallestRange();
        List<Integer> list1 = new ArrayList<>(Arrays.asList(4, 10, 15, 24, 26));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(0, 9, 12, 20));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(5, 18, 22, 30));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(7, 9, 11, 12, 31));

        Map<String, List<Integer>> dict = new HashMap<>();
        dict.put("aaa", list1);
        dict.put("bbbb", list2);
        dict.put("ccc", list3);
        dict.put("dddd", list4);

        List<String> words = new ArrayList<>(Arrays.asList("aaa", "bbbb", "ccc"));

        int res = smallestRange.smallest(dict, words);
        System.out.println(res);
    }
}
