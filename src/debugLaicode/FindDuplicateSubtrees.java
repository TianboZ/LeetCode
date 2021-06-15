package debugLaicode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*

sol2:
- traverse the tree, record all subtree, serial them. e.g. `1,2,#,`   means
             1
            / \
           2  null

- store this serialized subtree to map: <subtree string, frequency>


complexity:
time O(n ^ 2)
space O(n)



*/

public class FindDuplicateSubtrees {
    // 2021
    List<TreeNode> res = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>(); // key: subtree string  value: frequency

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }
    private String dfs(TreeNode root) {
        // base case
        if (root == null) return "#,";

        // recrusive rule
        String left = dfs(root.left);
        String right = dfs(root.right);

        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");
        sb.append(left).append(right);

        String s = sb.toString();

        map.put(s, map.getOrDefault(s, 0) + 1);
        if (map.get(s) == 2) {
            res.add(root);
        }
        return s;
    }


    // solution1
    // 2018
    public List<TreeNode> findDuplicateSubtrees1(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        traverse(root, res, map);
        return res;
    }
    private void traverse(TreeNode root, List<TreeNode> res, Map<String, Integer> map) {
        if (root == null) return;

        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        String s = sb.toString();

        map.put(s, map.getOrDefault(s, 0) + 1);
        if (map.get(s) == 2) res.add(root);

        traverse(root.left, res, map);
        traverse(root.right, res, map);
    }
    private void serialize(TreeNode root, StringBuilder sb) {
        // base-case
        if (root == null) {
            sb.append("#" + ",");
            return;
        }
        // rule
        sb.append(root.key + ",");
        serialize(root.left, sb);
        serialize(root.right,sb);
    }
}
