package debugLaicode;

public class TreeNode {
    // fields
    public int key;
    public int val;
    public TreeNode left;
    public TreeNode right;

    // constructor
    public TreeNode(int x) {
        key = x;
        val = x;
    }
    public TreeNode() {}
    public TreeNode(int v, TreeNode l, TreeNode r) {
        val = v;
        key = v;
        left = l;
        right = r;
    }
}