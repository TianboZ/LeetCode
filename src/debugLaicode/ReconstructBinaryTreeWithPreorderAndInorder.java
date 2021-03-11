package debugLaicode;

import java.util.HashMap;
import java.util.Map;

public class ReconstructBinaryTreeWithPreorderAndInorder {
    // 2020
    public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
        // Write your solution here
        Map<Integer, Integer> map = new HashMap<>(); // key: inorder treenode's value, key: index
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }

        return  helper(map, inOrder, 0, inOrder.length - 1, preOrder, 0, preOrder.length- 1);
    }

    // return root of reconstructed tree
    private TreeNode helper(Map<Integer, Integer> map, int[] in, int inL, int inR, int[] pre, int preL, int preR) {
        // basecase
        if (inL > inR) {
            return null;
        }
        // recursive rule
        TreeNode root = new TreeNode(pre[preL]);
        int inorderIdx = map.get(pre[preL]);
        int inorderLeftSize = inorderIdx - inL;

        root.left = helper(map, in, inL, inL + inorderLeftSize - 1, pre, preL + 1, preL + inorderLeftSize);
        root.right = helper(map, in, inorderIdx + 1, inR, pre, preL + inorderLeftSize + 1, preR);
        return root;
    }



    // 2018
//    public TreeNode reconstruct(int[] in, int[] pre) {
//        // key: in[index]    value: index
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < in.length; i++) {
//            map.put(in[i], i);
//        }
//        return reconstruct(in, 0, in.length - 1, pre, 0, pre.length - 1, map);
//    }
//    // input inorder and preorder array, return reconstructed tree's root
//    private TreeNode reconstruct(int[] in, int inL, int inR, int[] pre, int preL, int preR, Map<Integer, Integer> map) {
//        // base-case
//        if (inL > inR) {
//            return null;
//        }
//        // recursive rule
//        int index = map.get(pre[preL]);
//        int leftSize = index - inL;
//
//        TreeNode root = new TreeNode(pre[preL]);
//        root.left = reconstruct(in, inL, index - 1, pre, preL + 1, preL + leftSize, map);
//        root.right = reconstruct(in, index + 1, inR, pre, preL + leftSize + 1, preR, map);
//        return root;
//    }
}
