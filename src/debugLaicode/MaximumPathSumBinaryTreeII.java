package debugLaicode;

public class MaximumPathSumBinaryTreeII {
    // 2021
    int max2 = Integer.MIN_VALUE;
    public int maxPathSum3(TreeNode root) {
        // Write your solution here
        helper(root);
        return max;
    }
    // return path sum from root to any node
    private int helper(TreeNode root) {
        // basecase
        if (root == null) {
            return 0;
        }

        // recursive rule
        int left = helper(root.left);
        int right = helper(root.right);

        // update global max
        max = Math.max(max, getMax(new int[]{
                root.key,
                root.key + left,
                root.key + right,
                root.key + left + right
        }));

        // return value
        return getMax(new int[]{
                root.key,
                root.key + left,
                root.key + right
        });
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }


    // 2020
    public int maxPathSum2(TreeNode root) {
        // Write your solution here
        int[] max = new int[]{Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }
    // return path sum from root to any node
    private int helper(TreeNode root, int[] max) {
        // basecase
        if (root == null) {
            return 0;
        }

        // recursive rule
        int left = helper(root.left, max);
        int right = helper(root.right, max);

        // update global max
        max[0] = Math.max(max[0], findMax(new int[]{
                root.key,
                root.key + left,
                root.key + right,
                root.key + left + right
        }));

        return findMax(new int[]{
                root.key,
                root.key + left,
                root.key + right
        });
    }
    private int findMax(int[] arr) {
        int max = arr[0];
        for (int ele : arr) {
            max = Math.max(max, ele);
        }
        return max;
    }

    // 2018
    int max = Integer.MIN_VALUE;
    //    Find the maximum possible sum from any node to any node.
    public int maxPathSum(TreeNode root) {
        findPathSum(root);
        return max;
    }
    // largestSmaller the max single path  sum（从root开始，到某个点结束） from tree
    private int findPathSum(TreeNode root) {
        // base-case
        if (root == null) {
            return 0;
        }
        // recursive rule
        int left = findPathSum(root.left);
        int right = findPathSum(root.right);

        // update max
        max = Math.max(max, left + right + root.key);
        max = Math.max(max, right + root.key);
        max = Math.max(max, left + root.key);
        max = Math.max(max, root.key);

        int tmp = Integer.MIN_VALUE;
        tmp = Math.max(tmp, left + root.key);
        tmp = Math.max(tmp, right + root.key);
        tmp = Math.max(tmp, root.key);

        return tmp;
    }
}
