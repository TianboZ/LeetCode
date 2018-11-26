package debugLaicode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*

solution2:

n is number of nodes in binary tree

traverse each node of tree, and for each node, serialize the subtree of this node

serialization follows the preorder traverse, use special character # for null nodes. the seralized tree is a string of size n.

time O(n^2)   n is # of nodes of binary tree
space O(n^2)

*/

public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        helper(root, map, res);
        //System.out.println(map);
        return res;
    }
    // return subtree's string
    //  1
    // / \
    // #  #    1,#,#,
    private String helper(TreeNode root, Map<String, Integer> map, List<TreeNode> res) {
        // basecase
        if (root == null) return "#,";

        // rule
        String left = helper(root.left, map, res);
        String right = helper(root.right, map, res);

        StringBuilder sb = new StringBuilder();
        sb.append(root.key +"," + left + right);
        String curr = sb.toString();

        map.put(curr, map.getOrDefault(curr, 0) + 1);
        if (map.get(curr) == 2) res.add(root);

        return curr;
    }

    // solution2
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
