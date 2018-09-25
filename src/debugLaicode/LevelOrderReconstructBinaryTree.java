package debugLaicode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderReconstructBinaryTree {
    public TreeNode reconstruct(String[] pre) {
        Queue<TreeNode> q = new LinkedList<>();
        int index = 0;
        TreeNode root = new TreeNode(Integer.valueOf(pre[index]));
        index++;

        // initial
        q.offer(root);

        // terminate
        while (!q.isEmpty()) {
            // expand
            TreeNode curr = q.poll();

            // generate
            if (!pre[index].equals("#")) {
                TreeNode left = new TreeNode(Integer.valueOf(pre[index]));
                index++;
                curr.left = left;
                q.offer(left);
            } else {
                index++;
            }
            if (!pre[index].equals("#")) {
                TreeNode right = new TreeNode(Integer.valueOf(pre[index]));
                index++;
                curr.right = right;
                q.offer(right);
            } else {
                index++;
            }
        }
        return root;


    }

    public static void main(String[] args) {
        LevelOrderReconstructBinaryTree levelOrderReconstructBinaryTree = new LevelOrderReconstructBinaryTree();
        TreeNode root = levelOrderReconstructBinaryTree.reconstruct(new String[] {"5", "33", "#", "#", "2", "6", "7", "#", "#", "#", "#"});
        System.out.println(root.key);

        System.out.println(Integer.parseInt("-99"));
    }
}
