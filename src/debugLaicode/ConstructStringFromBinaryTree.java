package debugLaicode;

public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        String res = helper(t);
        return res.substring(1, res.length() - 1);
    }

    // return e.g.   (a(b)(c))
    private String helper(TreeNode root) {
        if (root == null) return "()";

        StringBuilder sb = new StringBuilder();
        sb.append("(" + root.key);

        if (root.left == null && root.right == null) {
            return sb.append(")").toString();
        }
        if (root.left == null) {
            String right = helper(root.right);
            return sb.append("()" + right + ")").toString();
        }
        if (root.right == null) {
            String left = helper(root.left);
            return sb.append(left + ")").toString();
        }
        String left = helper(root.left);
        String right = helper(root.right);
        sb.append(left + right + ")");

        return sb.toString();
    }


}
