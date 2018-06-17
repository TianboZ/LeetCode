package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class ReconstructBinaryTreeWithLevelorderAndInorder {
    public TreeNode reconstruct(int[] level) {
        // Write your solution here.
        List<Integer> list = new ArrayList<>();
        for (int i : level) {
            list.add(i);
        }

        return helper(list);
    }

    // give level order, return the root of constructed tree
    private TreeNode helper(List<Integer> level) {
        // base-case
        if (level.size() == 0) {
            return null;
        }

        // recursive rule
        TreeNode newRoot = new TreeNode(level.get(0));
        List<Integer> leftLevel = new ArrayList<>();
        List<Integer> rightLevel = new ArrayList<>();
        for (int i = 1; i < level.size(); i++) {
            if (level.get(i) < level.get(0)) {
                leftLevel.add(level.get(i));
            } else {
                rightLevel.add(level.get(i));
            }
        }
        newRoot.left = helper(leftLevel);
        newRoot.right = helper(rightLevel);
        return newRoot;
    }
}
