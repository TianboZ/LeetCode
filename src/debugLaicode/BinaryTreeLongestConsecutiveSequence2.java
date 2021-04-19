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
    class Res {
        int in;
        int de;
        Res(int in, int de) {
            this.in = in;
            this.de = de;
        }
    }
    int len = 1;

    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return len;
    }

    private Res dfs(TreeNode root) {
        if (root == null) return null;

        int in = 1; // increasing
        int de = 1; // decreasing

        if (root.left != null) {
            Res left = dfs(root.left);
            if (root.val == root.left.val + 1) {
                de = 1  + left.de;
            }
            if (root.val + 1 == root.left.val) {
                in = 1 + left.in;
            }
        }

        if (root.right != null) {
            Res right = dfs(root.right);
            if (root.val == root.right.val + 1) {
                de = Math.max(de, 1 + right.de);
            }
            if (root.val + 1 == root.right.val) {
                in = Math.max(in, 1 + right.in);
            }
        }

        // update global max
        len = Math.max(len, in + de - 1);

        return new Res(in, de);
    }
}
