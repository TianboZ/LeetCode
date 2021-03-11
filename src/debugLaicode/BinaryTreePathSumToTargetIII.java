package debugLaicode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryTreePathSumToTargetIII {
    boolean isFound = false;

    public boolean exist(TreeNode root, int target) {
        // Write your solution here
        Set<Integer> prevSums = new HashSet<>();
        prevSums.add(0); // important

        helper(root, 0, prevSums, target);
        return isFound;
    }

    // traverse tree
    private void helper(TreeNode root, int prevSum, Set<Integer> prevSums, int target) {
        // basecase
        if (root == null) return;
        if (isFound) return;

        // recursive rule
        int currSum = prevSum + root.key;
        if (prevSums.contains(currSum - target)) {
            isFound = true;
            return;
        }
        boolean needRemove = prevSums.add(currSum);
        helper(root.left, currSum, prevSums, target);
        helper(root.right, currSum, prevSums, target);
        if (needRemove) {
            prevSums.remove(currSum);
        }
    }
}
