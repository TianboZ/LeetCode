package debugLaicode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryTreePathSumToTargetIII {
    boolean found = false;
    public boolean exist(TreeNode root, int target) {
        // Write your solution here
        Set<Integer> prefixSum = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        prefixSum.add(0);
        helper(prefixSum, path, 0, root, target);
        return found;
    }
    // start from the root, record the path from root to current node
    private void helper(Set<Integer> prefixSum, List<Integer> path, int prevSum, TreeNode curr, int target) {
        // base-case
        if (found) return;
        if (curr == null) return;

        // recursive rule
        path.add(curr.key);
        int sum = prevSum + curr.key;
        if (prefixSum.contains(sum - target)) {
            found = true;
            return;
        }
        boolean add = prefixSum.add(sum);
        helper(prefixSum, path, sum, curr.left, target);
        helper(prefixSum, path, sum, curr.right, target);
        // backtracking
        path.remove(path.size() - 1);
        if (add) {
            prefixSum.remove(sum);
        }
    }
}
