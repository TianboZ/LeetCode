package debugLaicode;

import java.util.HashSet;
import java.util.Set;

public class BinaryTreeTargetSum {

    public static void main(String[] args) {
        BinaryTreeTargetSum binaryTreeTargetSum = new BinaryTreeTargetSum();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(-8);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(10);
        TreeNode node6 = new TreeNode(2);
        TreeNode node7 = new TreeNode(-5);
        TreeNode node8 = new TreeNode(1);
        TreeNode node9 = new TreeNode(-2);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;

        binaryTreeTargetSum.exist(node1, 7);
    }

    boolean found;

    public boolean exist(TreeNode root, int target) {
        // Write your solution here.

        Set<Integer> set = new HashSet<>();
        set.add(0);
        helper(root, set, 0, target);
        System.out.println(found);
        return found;
    }
    public void helper(TreeNode root, Set<Integer> set, int sum, int target) {
        // base-case
        if (root == null) {
            return;
        }
        // recursive rule
        int tmp = sum + root.key;

        // go left
        boolean needReomve = set.add(tmp);
        if (set.contains(tmp - target)) {
            found = true;
        }
        helper(root.left, set, tmp, target);
        if (needReomve) {
            set.remove(tmp);
        }


        // go right
        needReomve = set.add(tmp);
        if (set.contains(tmp - target)) {
            found = true;
        }
        helper(root.right, set, tmp, target);
        if (needReomve) {
            set.remove(tmp);
        }
    }
}
