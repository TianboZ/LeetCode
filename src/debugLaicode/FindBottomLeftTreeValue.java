package debugLaicode;

public class FindBottomLeftTreeValue {
    int max = -1;
    int val; // bottom left value
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return val;
    }

    // no matter what pre/in/post traverse, must left/right
    private void dfs(TreeNode root, int row) {
        if (root == null) return;


        if (row > max) {
            max  = row;
            val = root.val;
        }

        dfs(root.left, row + 1);
        dfs(root.right, row + 1);

        // wont work! will find right bottom
        // dfs(root.right, row + 1);
        // dfs(root.left, row + 1);

    }
}
