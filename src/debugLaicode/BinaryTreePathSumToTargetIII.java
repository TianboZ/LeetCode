package debugLaicode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryTreePathSumToTargetIII {

    public boolean exist(TreeNode root, int target) {
        // Write your solution here
        Set<Integer> prevSums = new HashSet<>();
        prevSums.add(0); // important

        return helper(root, 0, prevSums, target);
    }

    // traverse tree
    private boolean helper(TreeNode root, int prevSum, Set<Integer> prevSums, int target) {
        // basecase
        if (root == null) return false;

        // recursive rule
        int currSum = prevSum + root.key;
        if (prevSums.contains(currSum - target)) {
            return true;
        }
        boolean added = prevSums.add(currSum);
        if (helper(root.left, currSum, prevSums, target)) return true;
        if (helper(root.right, currSum, prevSums, target)) return true;
        if (added) {
            prevSums.remove(currSum);
        }
        return false;
    }
}
