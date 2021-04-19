package debugLaicode;

public class SumRootToLeafNumbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
    // curr is sum of current path
    private void dfs(TreeNode root, int curr) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sum = sum + curr * 10 + root.val;
            return;
        }

        int sum = root.val + curr * 10;
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}
