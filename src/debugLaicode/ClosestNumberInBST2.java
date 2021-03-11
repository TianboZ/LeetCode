package debugLaicode;


import java.util.*;

/*
* assumption
*
* k << # of nodes
*
* solution
* traverse tree node, for each node, put it into maxheap
*
* use maxheap, size = k, compare each node by  abs(target - node.val)
*
* complexity
* time o(n * logk )
* space o(n + k)
*
*
* */
public class ClosestNumberInBST2 {
    public int[] closestKValues(TreeNode root, double target, int k) {
        // Write your solution here
        if (root == null) {
            return new int[]{};
        }
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1 - target) == Math.abs(o2 - target)) {
                    return 0;
                }
                return Math.abs(o1 - target) < Math.abs(o2 - target) ? 1 : -1;
            }
        }); // pq is max heap

        traverse(root, pq, k, target);
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = pq.poll();
        }
        return arr;
    }
    private void traverse(TreeNode root,  Queue<Integer> pq, int k, double target) {
        if (root == null) return;

        // smart!
        if (pq.size() < k) {
            pq.offer(root.key);
        } else {
            pq.offer(root.key);
            pq.poll();
        }

        traverse(root.left, pq, k, target);
        traverse(root.right, pq, k, target);

    }
}
