package MianJing.thumbtack.Onsite;


import java.util.*;

/*
*
*   8   5   12   3    4
*   i
*                j
*
* */
public class TopSumPair {
    public static List<Integer> top(int[] arr, int l, int k) {
        // sanity check
        // TODO: 11/25/18

        Queue<Integer> minheap1 = new PriorityQueue<>();
        Queue<Integer> minheap2 = new PriorityQueue<>();

        for (int j = l + 1; j < arr.length; j++) {
            // find the largest k arr[i]
            int i = j - l - 1;
            if (minheap1.size() < k) {
                minheap1.offer(arr[i]);
            } else {
                if (arr[i] > minheap1.peek()) {
                    minheap1.poll();
                    minheap1.offer(arr[i]);
                }
            }

            // find the largest k pair arr[i] + arr[j]
            Iterator iter = minheap1.iterator();
            while (iter.hasNext()) {
                int e = (int)iter.next(); // e is arr[i]
                int sum = e + arr[j];

                if (minheap2.size() < k) {
                    minheap2.offer(sum);
                } else {
                    if (sum > minheap2.peek()) {
                        minheap2.poll();
                        minheap2.offer(sum);
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!minheap2.isEmpty()) {
            res.add(minheap2.poll());
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr =  {8, 5, 12, 3, 4, 5, 10, 10};
        int k = 3;
        int l = 2;
        top(arr, l, k);

    }
}
