package debugLaicode;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestSumInTwoSortedArrays {
    public int kthSum(int[] A, int[] B, int k) {
        int len = Math.max(A.length, B.length);
        boolean[][] visited = new boolean[len][len];
        Queue<Element> minHeap = new PriorityQueue<>();
        // initial
        visited[0][0] = true;
        minHeap.offer(new Element(0, 0, A[0] + B[0]));
        int count = 1;
        while (!minHeap.isEmpty() && count <= k - 1) {
            // expand
            Element curr = minHeap.poll();
            count++;
            int i = curr.i;
            int j = curr.j;

            // generate rule
            if (i + 1 < A.length && !visited[i + 1][j]) {
                minHeap.offer(new Element(i + 1, j, A[i + 1] + B[j]));
                visited[i + 1][j] = true;
            }

            if (j + 1 < B.length && !visited[i][j + 1]) {
                minHeap.offer(new Element(i, j + 1, A[i] + B[j + 1]));
                visited[i][j + 1] = true;
            }
        }
        return minHeap.peek().sum;
    }

    class Element implements Comparable<Element> {
        int sum;
        int i;
        int j;

        public Element(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }

        @Override
        public int compareTo(Element another) {
            if (this.sum == another.sum) {
                return 0;
            }
            return this.sum < another.sum ? -1 : 1;
        }
    }
}
