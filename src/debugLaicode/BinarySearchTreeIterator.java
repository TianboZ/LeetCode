package debugLaicode;
import java.util.*;

public class BinarySearchTreeIterator {
    List<Integer> in = new ArrayList<>(); // inorder traverse    nodes
    int i = 0;
    public BinarySearchTreeIterator(TreeNode root) {
        dfs(root);

    }
    // inorder traverse
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        in.add(root.val);
        dfs(root.right);
    }

    public int next() {
        if (i < in.size()) {
            int res = in.get(i);
            i++;
            return res;
        }
        return -1;
    }

    public boolean hasNext() {
        return i < in.size();
    }
}
