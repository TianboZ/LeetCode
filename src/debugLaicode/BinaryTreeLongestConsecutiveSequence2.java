package debugLaicode;
/*
solution:
    1
  /  \
      2
     / \
    3   1
       /
      0

     time O（n）
     space O(0)

*/
public class BinaryTreeLongestConsecutiveSequence2 {
    int len = 0;
    public int longestConsecutive(TreeNode root) {
        longestLength(root);
        return len;
    }
    // return the longest increasing sequence length and longest decreasing sequence length
    private Return longestLength(TreeNode root) {
        // base-case
        if (root == null) return new Return(0, 0);

        // rule
        int in = 1;
        int de = 1;
        if (root.left != null) {
            Return left = longestLength(root.left);
            if (root.left.key + 1 == root.key) {
                de = left.de + 1;
            } else if (root.left.key - 1 == root.key) {
                in = left.in + 1;
            }
        }

        if (root.right != null) {
            Return right = longestLength(root.right);
            if (root.right.key + 1 == root.key) {
                de = Math.max(de, right.de + 1);
            } else if (root.right.key - 1 == root.key) {
                in = Math.max(in, right.in + 1);
            }
        }
        //System.out.println(" root.val: " + root.val + " in: " + in + " de: " + de);
        len = Math.max(len, in + de - 1);
        return new Return(in, de);
    }

    class Return {
        int in; // increasing sequence length
        int de; // decreasing sequence length
        Return (int in, int de) {
            this.in = in;
            this.de = de;
        }
    }
}
