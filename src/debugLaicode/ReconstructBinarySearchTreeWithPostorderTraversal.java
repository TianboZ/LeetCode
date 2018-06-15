package debugLaicode;

import java.util.*;

public class ReconstructBinarySearchTreeWithPostorderTraversal {
    public TreeNode reconstruct(int[] post) {

        return helper(post, 0, post.length - 1);

    }

    private TreeNode helper(int[] post, int start, int end) {
        // base-case
        if (start > end) {
            return null;
        }


        // recursive rule
        TreeNode root = new TreeNode(post[end]);
        // [start, index]: < root.key  [index + 1, end - 1]: > root.key
        int index = -1;
        // find the last element's index that is smaller then root.key
        for (int i = start; i <= end - 1; i++) {
            if (post[i] < root.key) {
                index = i;
            }
        }
        if (index == -1) {
            index = start - 1;
        }

        root.left = helper(post, start, index);
        root.right = helper(post, index + 1, end - 1);
        return root;
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(-1);
        list.add(-4);
        list.add(-5);
        list.add(6);

        // heapify
        Queue<Integer> minHeap = new PriorityQueue<>(list);

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }

}
