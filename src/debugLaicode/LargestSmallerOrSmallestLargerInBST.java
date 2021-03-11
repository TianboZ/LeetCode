package debugLaicode;


// geeksforgeeks
// smallest number in BST which is >= target
// https://www.geeksforgeeks.org/smallest-number-in-bst-which-is-greater-than-or-equal-to-n/

// largest number in BST which is <= target
// https://www.geeksforgeeks.org/largest-number-bst-less-equal-n/
public class LargestSmallerOrSmallestLargerInBST {
    // sol1:
    int max = Integer.MIN_VALUE;
    public int largestSmaller(TreeNode root, int target) {
        traverse(root, target);
        return max;
    }
    // 直上直下 void
    private void traverse(TreeNode root, int target) {
        // baes-cae
        if (root == null) {
            return;
        }
        // rule
        if (target > root.key) {
            max = root.key;
            traverse(root.right, target);
        } else {
            traverse(root.left, target);
        }

    }

    // sol2, iterative
    public int largestSmaller1(TreeNode root, int target) {
        int res = Integer.MIN_VALUE;
        while (root != null) {
            if (root.key < target) {
                res = root.key;
                root = root.right;

            } else {
                root = root.left;
            }
        }
        return res;
    }

//                    4
//                  /   \
//                 2     7
//                / \      \
//               1   3     10
//                         /  \
//                       9.9  11
//          target = 9

    public int smallestLarger(TreeNode root, int target) {
        int res = Integer.MAX_VALUE;
        while (root != null) {
            if (root.key > target) {
                res = root.key;
                root = root.left;

            } else {
                // target >= root.key
                root = root.right;
            }
        }
        return res;
    }

    // find smallest larger or equal than target
     public int smallestLarger3(TreeNode root, int n) {
        int diff = Integer.MAX_VALUE;
        int res = -1;
        while (root != null) {
            if (root.key >= n) {
                // not necessary
//                if (root.key - n < diff) {
//                    res = root.key;
//                    diff = root.key - n;
//                }

                res = root.key;
                root = root.left;
            }  else {
                root = root.right;
            }
        }
        return res;
     }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(19);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(21);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(11);
        TreeNode n6 = new TreeNode(9);
        TreeNode n7 = new TreeNode(14);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.left = n6;
        n5.right = n7;

        LargestSmallerOrSmallestLargerInBST sol = new LargestSmallerOrSmallestLargerInBST();
        System.out.println(sol.smallestLarger3(n1, 18));
    }
}
