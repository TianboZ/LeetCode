package debugLaicode;

// time o(n)
// space o(logn) call stack

public class ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return postorder(nums, 0, nums.length - 1);
    }

    // sol1
    int i;

    private TreeNode preorder(int[] nums, int lo, int hi) {
        // base case
        if (lo > hi) return null;

        // recursive rule
        int mid = (lo + hi) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = preorder(nums, lo, mid - 1);
        root.right = preorder(nums, mid + 1, hi);
        return root;
    }


    private TreeNode inorder(int[] nums, int lo, int hi) {
        // base case
        if (lo > hi) return null;

        // recursive rule
        int mid = (lo + hi) / 2;
        TreeNode left = inorder(nums, lo, mid - 1);
        TreeNode root = new TreeNode(nums[i]);
        i++;
        root.left = left;
        TreeNode right = inorder(nums, mid + 1, hi);
        root.right = right;
        return root;
    }

    private TreeNode postorder(int[] n, int lo, int hi) {
        if (lo > hi) return null;

        int mid = (lo + hi) / 2;
        TreeNode left = postorder(n, lo, mid - 1);
        TreeNode right = postorder(n, mid + 1, hi);

        TreeNode root = new TreeNode(n[mid]);
        root.left = left;
        root.right = right;

        return root;
    }
}
