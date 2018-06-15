package debugLaicode;

import java.util.HashMap;
import java.util.Map;

public class CopyTreeWithRandomPointer {
    public TreeNode cloneTree(TreeNode tree){
        Map<TreeNode, TreeNode> map = new HashMap<>();
        return helper(tree, map);
    }

    // 传入一个node，传出一个node
    private TreeNode helper(TreeNode root, Map<TreeNode, TreeNode> map){
        // add code here.
        // base-case
        if (root == null) {
            return null;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }

        // recursive rule
        TreeNode copy = new TreeNode(root.data);
        map.put(root, copy);
        // case1: left
        copy.left = helper(root.left, map);
        // case2: right
        copy.right = helper(root.right, map);
        // case3: random
        copy.random = helper(root.random, map);

        return copy;
    }

    static class TreeNode {
        // fields
        int data;
        TreeNode left,right,random;

        // constructor
        TreeNode(int d){
            data = d;
            left = null;
            right = null;
            random = null;
        }
    }

    public static void main(String[] args) {

    }
}
