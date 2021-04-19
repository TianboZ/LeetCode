package debugLaicode;

import java.util.*;

public class SecondLargestInBST {
    List<TreeNode> list;

    public int secondLargest(TreeNode root) {
        // Write your solution here
        list = new ArrayList<>();
        helper(root);
        if (list.size() <2) return Integer.MIN_VALUE;
        return list.get(1).key;
    }

    private void helper(TreeNode root) {
        if (root == null) return;

        helper(root.right);

        list.add(root);
        if (list.size() == 2) return;

        helper(root.left);
    }
}
