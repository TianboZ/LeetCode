package debugLaicode;

/*
solution1:
    for each treenode, run    isBST(root), getSize(root)
    time O(n ^ 2)
    space O(n)

solution2:
    work with return type
    class Return {
        int size;
        int min;
        int max;
    }

    time O(n)
    space O(n)
*/
public class LargestBSTSubtree {
    int maxSize = 0;
    public int largestBSTSubtree(TreeNode root) {
        helper(root);
        return maxSize;
    }
    private Return helper(TreeNode root) {
        // base-case
        if (root == null) return new Return(0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        // recurive rule
        Return left = helper(root.left);
        Return right = helper(root.right);

        if (left.size == -1 || right.size == -1 || root.key <= left.max || root.key >= right.min) {
            return new Return(-1, 0, 0); // return size = -1 if it is not BST
        }
        int size = left.size + right.size + 1;
        maxSize = Math.max(maxSize, size);

        return new Return(size, Math.min(left.min, root.key),Math.max(root.key, right.max)); // handle leaf nodes

    }
    class Return {
        int size;
        int min;
        int max;
        Return (int size, int min, int max) {
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
}
