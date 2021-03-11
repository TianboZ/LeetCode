package debugLaicode;

import java.util.*;

public class ReconstructBinarySearchTreeWithPostorderTraversal {
    // sol1:
    // step1, since it is BST, in-order traversal is increasing order, get inorder array
    // step2, use inorder and postorder array to reconstruct
    //
    // sort postorder array takes o(nlogn) space o(n)  (merge-sort)
    // recursively reconstruct takes o(n) time, o(n ) space

    // time: o(nlogn)
    // space: o(n)
    public TreeNode reconstruct(int[] post) {
        // Write your solution here
        int[] in = Arrays.copyOf(post, post.length);
        Arrays.sort(in);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return helper(in, 0, in.length - 1, post, 0, post.length - 1, map);
    }

    private TreeNode helper(int[] in, int inL, int inR, int[] post, int postL, int postR, Map<Integer, Integer> map) {
        // base case
        if (inL > inR) return null;

        // recursive rule
        TreeNode root = new TreeNode(post[postR]);
        int index = map.get(post[postR]);
        int size = index - inL; // # of nodes smaller than root.val

        root.left = helper(in, inL, inL + size - 1, post, postL, postL + size - 1, map);
        root.right = helper(in, index + 1, inR, post, postL + size, postR - 1, map);
        return root;
    }

    // sol2:
    // time: o(n ^ 2)
    // space o(n)
    public TreeNode reconstruct2(int[] post) {
        return helper2(post, 0, post.length - 1);
    }

    private TreeNode helper2(int[] post, int start, int end) {
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

        root.left = helper2(post, start, index);
        root.right = helper2(post, index + 1, end - 1);
        return root;
    }
}
