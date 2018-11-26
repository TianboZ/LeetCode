package debugLaicode;

/*
solution:
find the left bound and right bonund of array, recursively check subarray
all elements in left bound, should smaller than root value
all element in right bound, should larger than root value

time O(n^2)
space O(n)


solution2:
reconstruc BST follow preorder, while traverse BST follow inorder
if it is valid BST, then inorder traverse value is increasing
*/

public class VerifyPreorderSequenceInBinarySearchTree {
    int preIndex = 0;
    boolean flag = true;
    TreeNode prev = null;

    public boolean verifyPreorder(int[] preorder) {

        construct(preorder, Integer.MAX_VALUE);
        return flag;
    }


    // return the root of constructed tree, val is next preorder traverse value
    private TreeNode construct(int[] pre, int val) {
        if (preIndex == pre.length || pre[preIndex] > val) return null;

        TreeNode root = new TreeNode(pre[preIndex]);
        preIndex++;

        root.left = construct(pre, root.key);
        // inorder traverse
        if (prev == null) {
            prev = root;
        } else {
            if (prev.key >= root.key) {
                flag = false;
            }
            prev = root;
        }
        root.right = construct(pre, val);
        return root;
    }
}