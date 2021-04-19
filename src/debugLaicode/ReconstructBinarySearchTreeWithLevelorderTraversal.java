package debugLaicode;

import java.util.*;

public class ReconstructBinarySearchTreeWithLevelorderTraversal {
    public TreeNode reconstruct(int[] level) {
        // Write your solution here
        List<Integer> le = new ArrayList<>();
        for (int l: level) le.add(l);

        return dfs(le);
    }
    private TreeNode dfs(List<Integer> le) {
        if (le.size() == 0) return null;

        int rootVal = le.get(0);
        List<Integer> left = new ArrayList<>();  // store root.left subtree's level order traverse nodes
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < le.size(); i++) {
            if (le.get(i) < rootVal) {
                left.add(le.get(i));
            } else {
                right.add(le.get(i));
            }
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = dfs(left);
        root.right = dfs(right);
        return root;
    }

    public static void main(String[] args) {

    }
}
