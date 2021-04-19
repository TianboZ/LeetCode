package debugLaicode;

import java.util.*;

public class GetPostorderByPreorderAndInorder {
    List<Integer> post = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>(); // key: tree value, value: index of inorder
    public int[] postOrder(int[] preorder, int[] inorder) {
        // Write your solution here
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);

        // reverse post;  left/right/root
        Collections.reverse(post);
        int[] res = new int[post.size()];
        for (int i = 0; i < post.size(); i++) {
            res[i] = post.get(i);
        }
        return res;
    }

    // input, preorder, inorder array, and boundary
    private void dfs(int[] pre, int[] in, int prel, int prer, int inl, int inr) {
        // base ase
        if (inl > inr) return;

        // recursive rule
        int root = pre[prel];
        post.add(root);

        int len = map.get(root) - inl;  // inorder array left part length, they are left subtree nodes
        int len2 = in.length - 1 - len;  // inorder array right part length, they are right subtree nodes

        // start from right subtree, then left. we want post order
        dfs(pre, in, prel + len + 1, prer, inl + 1 + len, inr);
        dfs(pre, in, prel + 1, prel + len, inl, inl + len - 1);
    }
}
