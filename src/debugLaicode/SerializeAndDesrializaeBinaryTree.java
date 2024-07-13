package debugLaicode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class SerializeAndDesrializaeBinaryTree {
  StringBuilder sb = new StringBuilder();

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    dfs(root);
    return sb.toString();
  }

  private void dfs(TreeNode root) {
    if (root == null) {
      sb.append("#").append(",");
      return;
    }
    sb.append(root.val).append(",");
    dfs(root.left);
    dfs(root.right);
  }

  // Decodes your encoded data to tree.
  int pre; // preorder traverse index

  public TreeNode deserialize(String data) {
    String[] strs = data.split(",");
    return build(strs);
  }

  private TreeNode build(String[] pres) {
    if (pre == pres.length)
      return null;
    if (pres[pre].equals("#")) {
      pre++;
      return null;
    }

    TreeNode node = new TreeNode(Integer.parseInt(pres[pre]));
    pre++;

    node.left = build(pres);
    node.right = build(pres);
    return node;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));