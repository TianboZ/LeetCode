package debugLaicode;

import java.util.*;

public class ReconstructBinarySearchTreeWithLevelorderTraversal {
    public TreeNode reconstruct(int[] in, int[] level) {
        // Write your solution here.
        // key: in[i] value: i
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int j : level) {
            list.add(j);
        }
        return helper(map, in, 0, in.length - 1, list);
    }
    private TreeNode helper(Map<Integer, Integer> map, int[] in, int inL, int inR, List<Integer> level) {
        // baes-caes
        if(inL > inR) {
            return null;
        }
        // recursive rule
        TreeNode newRoot = new TreeNode(level.get(0));
        int index = map.get(level.get(0));

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int j = 1; j < level.size(); j++) {
            if (map.get(level.get(j)) < index) {
                left.add(level.get(j));
            } else {
                right.add(level.get(j));
            }
        }

        newRoot.left = helper(map, in, inL, index - 1, left);
        newRoot.right = helper(map, in, index + 1, inR, right);

        return newRoot;
    }

    public static void main(String[] args) {

    }
}
