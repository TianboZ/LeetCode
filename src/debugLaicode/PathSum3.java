package debugLaicode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-O(n)-java-Prefix-sum-method
public class PathSum3 {
    Map<Integer, Integer> map = new HashMap<>(); // key: sum, value: frequency
    int count = 0;

    public int pathSum(TreeNode root, int sum) {
        map.put(0, 1);
        helper(root, sum, 0);
        return count;
    }

    // preorder traverse tree
    private void helper(TreeNode root, int target, int prevSum) {
        if (root == null) return;

        int currSum = prevSum + root.val;
        Integer i = map.get(currSum - target);
        if (i != null) {
            count += i;
        }

        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        helper(root.left, target, currSum);
        helper(root.right, target, currSum);

        // backtracking
        map.put(currSum, map.get(currSum) - 1);
    }
}
