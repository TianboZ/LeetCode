package debugLaicode;
import java.util.*;

public class AllNodesDistanceKinBinaryTree {
    Map<TreeNode, TreeNode> map = new HashMap<>();
    List<Integer>  res = new ArrayList<>();
    Set<Integer> visit = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        dfs(root, null);
        dfs2(target, 0, K);
        return res;
    }
    private void dfs(TreeNode root, TreeNode prev) {
        if (root == null) return;

        map.put(root, prev);
        dfs(root.left, root);
        dfs(root.right, root);
    }

    private void dfs2(TreeNode root, int level, int k) {
        if (root == null) return;
        if (visit.contains(root.val)) return;

        visit.add(root.val);

        if (level == k) {
            res.add(root.val);
            return;
        }

        dfs2(root.left, level + 1, k);
        dfs2(root.right, level + 1, k);
        dfs2(map.get(root), level + 1, k);
    }
}
