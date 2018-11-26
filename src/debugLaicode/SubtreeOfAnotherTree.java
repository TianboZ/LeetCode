package debugLaicode;

/*
solution1:
traverse each node in s, use it as root, compare the subtree of this node with target tree

time O(m * n)   m is number nodes in s, n is number of nodes in t
space O(max(m, n))   we used recursion, call stack space


solution2:
serialize binary tree to string
    detail: pre-order traverse + special character # for null node

we can get string s1 and string s2 after serialization
check if s2 is substring of s1

time O(m * n)
space O(max(m, n))

*/
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return helper(s, t);
    }
    private boolean helper(TreeNode root, TreeNode t) {
        if (root == null) return false;

        if (isSame(root, t)) return true;

        if (helper(root.left, t)) return true;
        if (helper(root.right, t)) return true;

        return false;
    }
    private boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 != null && root2 == null) return false;
        if (root1 == null && root2 != null) return false;
        if (root1.key != root2.key) return false;

        boolean left = isSame(root1.left, root2.left);
        boolean right = isSame(root1.right, root2.right);

        return root1.key == root2.key &&  left && right;
    }

    // solution2
    public boolean isSubtree1(TreeNode s, TreeNode t) {
        //Set<String> set = new HashSet<>();
        //serialization(s, set);
        StringBuilder sb = new StringBuilder();
        preorder(t, sb);
        sb.deleteCharAt(sb.length() - 1);
        String s1 = sb.toString();

        sb = new StringBuilder();
        preorder(s, sb);
        String s2 = sb.toString();

        //System.out.println(s1);
        //System.out.println(s2);
        return s2.indexOf(s1) != -1;
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        // base-case
        if (root == null) {
            sb.append("#" + ",");
            return;
        }
        // rule
        sb.append("," + root.key + ",");
        preorder(root.left, sb);
        preorder(root.right,sb);
    }

    public static void main(String[] args) {
        String s1 = "4,1,#,#,2,#,#";
        String s2 = "3,4,1,#,#,2,#,#,5,#,#,";
        System.out.println(s2.contains(s1));
        System.out.println(s2.indexOf(s1));
    }

}