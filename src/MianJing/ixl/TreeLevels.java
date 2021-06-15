package MianJing.ixl;

import java.util.*;

class TreeNode2 {
    public String s;
    public List<TreeNode2> children;

    public TreeNode2(String _s) {
        s = _s;
        children = new ArrayList<>();
    }
}

/*
*
*                a
*               /\ \
*               a b c
*               / \  \
*              a  b   a
*                  \
*                   b
*
* return ["a", "b"]   "a" appears on 3 different levels
*
*
* solution:
* 1. pre order traverse tree, for each node with same value, record its appearance of levels
*     - use Map<node value, Set<level>>
* 2. iterate map, find node that appears on the most levels
*
*
* complexity:
* time o(n)
* space o(n)
*
* n is # of nodes
*
* */
public class TreeLevels {
    Map<String, Set<Integer>> map = new HashMap<>();
    int max = 0;

    public List<String> count(TreeNode2 root) {
        dfs(root, 0);
        List<String> res = new ArrayList<>();
        // iterate map
        for (String k : map.keySet()) {
            Set<Integer> v = map.get(k);
            if (v.size() == max) {
                res.add(k);
            }
        }
        System.out.println(res);
        return res;
    }

    private void dfs(TreeNode2 root, int level) {
        // base case
        if (root == null) return;

        // recursive rule
        Set<Integer> levels = map.get(root.s);
        if (levels == null) {
            levels = new HashSet<>();
            map.put(root.s, levels);
        }
        levels.add(level);

        // update max
        max = Math.max(max, levels.size());

        for (TreeNode2 nei : root.children) {
            dfs(nei, level + 1);
        }
    }

    public static void main(String[] args) {

        /*
        *
        *
        * *               a           1
         *               /\ \
         *               a b c       2  3 4
         *               / \  \
         *              a  b   a      5  6  7
         *                  \
         *                   b          8
        *
        *
        *
        * */
        TreeNode2 n1 = new TreeNode2("a");
        TreeNode2 n2 = new TreeNode2("a");
        TreeNode2 n3 = new TreeNode2("b");
        TreeNode2 n4 = new TreeNode2("c");
        TreeNode2 n5 = new TreeNode2("a");
        TreeNode2 n6 = new TreeNode2("b");
        TreeNode2 n7 = new TreeNode2("a");
        TreeNode2 n8 = new TreeNode2("b");

        n1.children.add(n2);
        n1.children.add(n3);
        n1.children.add(n4);

        n2.children.add(n5);
        n3.children.add(n6);
        n4.children.add(n7);

        n6.children.add(n8);

        TreeLevels sol = new TreeLevels();
        sol.count(n1);
    }
}
