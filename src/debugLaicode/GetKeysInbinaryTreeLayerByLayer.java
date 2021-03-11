package debugLaicode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GetKeysInbinaryTreeLayerByLayer {
    public List<List<Integer>> layerByLayer(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();

        // initial
        q.offer(root);

        // terminate
        while (!q.isEmpty()) {
            int size = q.size(); // # of nodes on current layer
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                // expand
                TreeNode curr = q.poll();
                tmp.add(curr.key);
                // generate
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node3.right = node4;
        node4.left = node5;
        node4.right = node6;

        GetKeysInbinaryTreeLayerByLayer getKeysInbinaryTreeLayerByLayer = new GetKeysInbinaryTreeLayerByLayer();
        getKeysInbinaryTreeLayerByLayer.layerByLayer(node1);
    }
}
