package debugLaicode;


import java.util.*;

public  class SumOfDistancesInTree {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        // step1: build tree
        // step2: for each node, find the sum of distance to all the other nodes

        // key: node value  value: set of node's children
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            Set<Integer> set = map.get(edge[0]);
            if (set == null) {
                set = new HashSet<>();
                set.add(edge[1]);
            } else {
                set.add(edge[1]);
            }
            map.put(edge[0], set);
        }
        // System.out.println(map);

        // key: node value   value: node reference
        Map<Integer, TreeNode> map2 = new HashMap<>();

        // build tree, get root node
        TreeNode root = build(map, 0, map2);

        // modify the map, key: node value   value: set of node's neighbor
        for (int[] edge : edges) {
            Set<Integer> set = map.get(edge[1]);
            if (set == null) {
                set = new HashSet<>();
                set.add(edge[0]);
            } else {
                set.add(edge[0]);
            }
            map.put(edge[1], set);
        }
        // System.out.println(map);
        System.out.println(map2);
        int[] res = new int[N - 1];
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if(i != j) {
                    TreeNode s = map2.get(i);
                    TreeNode e = map2.get(j);
                    sum = sum + bfs(s, e);
                }
            }
            res[i] = sum;
        }

        return res;
    }
    // given a root value, build tree, return the root node
    private TreeNode build(Map<Integer, Set<Integer>> map, int rootVal, Map<Integer, TreeNode> map2) {
        // base-case
        if (!map.containsKey(rootVal)) return null;
        // recursive rule
        TreeNode root = new TreeNode(rootVal);
        map2.put(rootVal, root);
        for (Integer child: map.get(rootVal)) {
            root.children.add(build(map, child, map2));
        }
        return root;
    }

    // start from s, end at e, find the distance between them
    private int bfs(TreeNode s, TreeNode e) {
        System.out.println(s.val);
        System.out.println(e.val);
        System.out.println("---------------");
        Queue<TreeNode> q = new LinkedList<>();
        // intial
        int dis = 0;
        q.offer(s);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // expand
                TreeNode curr = q.poll();
                if (curr == e) {
                    return dis;
                }
                System.out.println(curr.val);
                // generate
                for (TreeNode node: curr.children) {
                    q.offer(node);
                }
            }
            dis++;
        }
        return 0;
    }
    class TreeNode {
        Set<TreeNode> children = null;
        int val;
        TreeNode(int val) {
            this.val = val;
            this.children = new HashSet<>();
        }
    }

    public static void main(String[] args) {
        SumOfDistancesInTree sumOfDistancesInTree = new SumOfDistancesInTree();
        sumOfDistancesInTree.sumOfDistancesInTree(6, new int[][]{{0, 1},{0,2},{2,3},{2,4},{2,5}});
    }
}