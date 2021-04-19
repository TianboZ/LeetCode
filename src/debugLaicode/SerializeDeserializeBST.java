package debugLaicode;

public class SerializeDeserializeBST {
    StringBuilder sb = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        return sb.toString();
    }
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        sb.append(root.val).append(",");
        dfs(root.left);
        dfs(root.right);
    }

    int i = 0; // pre order index
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        String[] pre = data.split(",");
        //System.out.println(pre.length);

        return build(-100000, 1000000, pre);
    }
    private TreeNode build(int min, int max, String[] pre) {
        if (i == pre.length) return null;

        int val = Integer.parseInt(pre[i]);
        if (val <= min || val >= max) return null;

        TreeNode root = new TreeNode(val);
        i++;
        root.left = build(min, root.val, pre);
        root.right = build(root.val, max, pre);
        return root;
    }
}
