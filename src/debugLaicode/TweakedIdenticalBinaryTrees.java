package debugLaicode;


public class TweakedIdenticalBinaryTrees {
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        // Write your solution here
        // base-case
        if (one == null && two == null) {
            return true;
        }

        // rule
        if (one == null || two == null) {
            return false;
        }

        if (one.key != two.key) {
            return false;
        }

        return isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left) ||
                isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right);

    }
}


// space o(height)
// time o(4 ^ logn) = O（2^(2logn)）= o(n^2)