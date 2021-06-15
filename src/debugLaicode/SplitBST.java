package debugLaicode;
import java.util.*;

public class SplitBST {
    List<Integer>  list1 = new ArrayList<>(); // <= V
    List<Integer>  list2 = new ArrayList<>();  // > V
    int i; // preorder index of BST

    public TreeNode[] splitBST(TreeNode root, int V) {
        dfs(root, V);
        TreeNode[] res = new TreeNode[2];
        res[0] = build(list1, -10000, 10000);
        i = 0;
        res[1] = build(list2,  -10000, 10000);
        return res;
    }

    private void dfs(TreeNode root, int v) {
        if (root == null) return;

        if (root.val <= v) {
            list1.add(root.val);
        } else {
            list2.add(root.val);
        }

        dfs(root.left, v);
        dfs(root.right, v);
    }

    private TreeNode build(List<Integer> pre, int min, int max) {
        if (i == pre.size()) return null;
        int val = pre.get(i);
        if (val <= min || val >= max) return null;

        TreeNode root = new TreeNode(val);
        i++;

        root.left = build(pre, min, val);
        root.right = build(pre, val, max);
        return root;
    }
}
