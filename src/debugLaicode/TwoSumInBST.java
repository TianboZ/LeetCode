package debugLaicode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumInBST {
    /*
    * solution1
    * haseset + tree traversal
    *
    *
    * solution2
    * - inorder traversal to record all elements in tree, they are increasing order
    * -
    *
    *
    *
    * */
    boolean isFound;

    public boolean existSumBST(TreeNode root, int target) {
        // Write your solution here
        helper(root, target, new HashSet<>());
        return isFound;
    }

    // preorder traverse the tree
    private void helper(TreeNode root, int t, Set<Integer> set) {
        // base case
        if (isFound )return;
        if (root == null) return;

        // recursive rule
        if (set.contains(t - root.key)) {
            isFound = true;
            return;
        }
        set.add(root.key);

        helper(root.left, t, set);
        helper(root.right, t, set);
    }
}
