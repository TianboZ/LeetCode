package debugLaicode;

import java.util.HashMap;
import java.util.Map;

public class ReconstructBinaryTreeWithPostorderAndInorder {
    public TreeNode reconstruct(int[] in, int[] post) {
        // key: in[index]    value: index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return reconstruct(in, 0, in.length - 1, post, 0, post.length - 1, map);
    }
    // input inorder and preorder array, return reconstructed tree's root
    private TreeNode reconstruct(int[] in, int inL, int inR, int[] post, int postL, int postR, Map<Integer, Integer> map) {
        // base-case
        if (inL > inR) {
            return null;
        }
        // recursive rule
        int index = map.get(post[postR]);
        int leftSize = index - inL;

        TreeNode root = new TreeNode(post[postR]);
        root.left = reconstruct(in, inL, index - 1, post, postL, postL + leftSize - 1, map);
        root.right = reconstruct(in, index + 1, inR, post, postL + leftSize, postR - 1, map);
        return root;
    }
}
