package debugLaicode;

public class FindBottomLeftTreeValue {
    int res;
    int maxHeight = -1;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    // traverse tree
    private void dfs(TreeNode root, int height) {
        // base=case
        if (root == null) {
            return;
        }
        // recursive rule
        if (height > maxHeight) {
            res = root.key;
            maxHeight = height;
        }
        dfs(root.left, height + 1);
        dfs(root.right, height + 1);
    }
}
