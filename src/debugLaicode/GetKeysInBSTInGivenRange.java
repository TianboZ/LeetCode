package debugLaicode;

import java.util.*;

public class GetKeysInBSTInGivenRange {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        // Write your solution here.
        List<Integer> res = new ArrayList<>();
        getRange(res, root, min, max);
        return res;
    }
    private void getRange(List<Integer> res, TreeNode root, int min, int max) {
        // base-case
        if (root == null) {
            return;
        }
        // recursive rule
        getRange(res, root.left, min, max);
        if (root.key >= min && root.key <= max) {
            res.add(root.key);
        }
        getRange(res, root.right, min, max);
    }
}
