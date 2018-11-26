package MianJing.thumbtack;

import java.util.*;

/*

        8, 5, 12, 3, 4, 5, 10, 10
                  j-->
        i


        for each j, find largest m arr[i]
                for each arr[i], compute the sum arr[i] + arr[j]


        use two data-structures:
        minheap1:  find the top m largest elements before index i, including i
        minheap2:  find the top m largest sum pair arr[i] + arr[j]


        time o(n *  mlgm)   n is array length


*/


public class TopSumPair {

    public static List<Integer> topMSum(int[] arr, int l, int m) {
        Queue<Integer> minHeap1 = new PriorityQueue<>();
        Queue<Integer> minHeap2 = new PriorityQueue<>();

        for (int j = l + 1; j < arr.length; j++) {
            int i = j - l - 1;
            // find the top m largest elements before index i, including i
            if (minHeap1.size() < m ) {
                minHeap1.offer(arr[i]);
            } else {
                if (arr[i] > minHeap1.peek()) {
                    minHeap1.poll();
                    minHeap1.offer(arr[i]);
                }
            }

            Iterator iter = minHeap1.iterator();
            while (iter.hasNext()) {
                int sum = (int)iter.next() + arr[j];
                System.out.println(sum);
                if (minHeap2.size() < m) {
                    minHeap2.offer(sum);
                } else {
                    if (sum > minHeap2.peek()) {
                        minHeap2.poll();
                        minHeap2.offer(sum);
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!minHeap2.isEmpty()) {
            res.add(minHeap2.poll());
        }
        System.out.println(res);
        return res;
    }


    public static void main(String[] args) {
        int[] arr =  {8, 5, 12, 3, 4, 5, 10, 10};
        int k = 3;
        int l = 2;
        topMSum(arr, l, k);
    }
}
