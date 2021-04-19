package debugLaicode;

/*
solution:
find the left bound and right bonund of array, recursively check subarray
all elements in left bound, should smaller than root value
all element in right bound, should larger than root value

time O(n^2)
space O(n)


solution2:
reconstruct BST follow preorder, while traverse BST follow inorder
if it is valid BST, then inorder traverse value is increasing
*/

public class VerifyPreorderSequenceInBinarySearchTree {
    int i= 0; // pre order index
    public boolean verifyPreorder(int[] preorder) {
        return helper(preorder, -10000000, 10000000);
    }


    // return true if is valid BST
    private boolean helper(int[] pre, int min, int rootVal) {
        // base case
        if (i == pre.length || pre[i] > rootVal) return true;
        if (pre[i] <= min) return false;

        int root = pre[i];
        i++;

        if (!helper(pre, min, root)) return false;
        if (!helper(pre, root, rootVal)) return false;

        return true;

    }

    // much more each to understand solution
    public boolean verifyPreorder2(int[] preorder) {
        helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return i == preorder.length;
    }

    private void helper2(int[] pre, int min, int max) {
        // base case
        if (i == pre.length || pre[i] >= max || pre[i] <= min) return;

        int root = pre[i];
        i++;

        helper(pre, min, root);
        helper(pre, root, max);
    }
}