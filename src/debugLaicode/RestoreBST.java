package debugLaicode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestoreBST {
    public TreeNode recover(TreeNode root) {
        // Write your solution here
        dfs(root);
        swap();
        return root;
    }
    TreeNode prev;
    TreeNode i;
    TreeNode j;

    private void swap() {
        int val = i.key;
        i.key = j.key;
        j.key = val;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (prev == null) {
            prev = root;
        } else {
            if (prev.key > root.key) {
                if (i == null) {
                    i = prev;
                }
                j = root;
            }
            prev = root;
        }
        dfs(root.right);
    }
}