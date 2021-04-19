package debugLaicode;

import java.util.*;

/*
*
* solution, traverse tree, check each node
*
* DFS or BFS
*
*
* */
public class DetermineIfBinaryTreeIsFullTree {

    // bfs
    public boolean isFull(TreeNode root) {
        // Write your solution here
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // expand
            TreeNode cur = queue.poll();
            // generate rule
            if (cur.left != null) {
                queue.offer(cur.left);
                if (cur.right == null){
                    return false;
                }
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                if (cur.left == null){
                    return false;
                }
            }
        }
        return true;
    }

    // dfs, preorder
    public boolean isFull2(TreeNode root) {
        // Write your solution here
        if (root == null) return false;

        return dfs(root);
    }

    // traverse the tree, follow preorder,  check each node
    public boolean dfs(TreeNode root) {
        // Write your solution here
        if(root == null) return true;
        if (root.left == null && root.right != null) return false;
        if (root.right == null && root.left != null) return false;

        if (!dfs(root.left)) return false;
        if (!dfs(root.right)) return false;

        return true;
    }
}
