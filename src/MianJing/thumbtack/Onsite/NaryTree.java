package MianJing.thumbtack.Onsite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// time O(n)    n is total number of nodes in tree
// space O(n)   worst case, call-stack space
public class NaryTree {
    private static class Node {
        int id;
        List<Node> children;
        boolean isEnd; // follow up

        Node(int id, boolean isEnd) {
            this.isEnd = isEnd;
            this.id = id;
            children = new ArrayList<>();
        }
    }

    // map: key: id  value: price
    public int getSum(Map<Integer, Integer> map, Node root) {
        // sanity check
        // TODO: 11/23/18

        dfs(root, map);
        return sum;
    }

    private int sum = 0;

    // depth first search, input root, traverse the n-ary tree from root
    private void dfs(Node root, Map<Integer, Integer>  map) {
        // base-case
        if (root == null) return;

        // recursive rule
        Integer price = map.get(root.id);
        if (price != null) {
            sum = sum + price;
        }

        if (root.isEnd) return; // pruning

        for (Node child : root.children) {
            dfs(child, map);
        }
    }

    public static void main(String[] args) {
        Node node0 = new Node(0, false);
        Node node1 = new Node(1, false);
        Node node2 = new Node(2, true);
        Node node3 = new Node(3, false);
        Node node4 = new Node(4, false);

        node0.children.add(node1);
        node0.children.add(node2);
        node0.children.add(node3);
        node2.children.add(node4);

        NaryTree naryTree = new NaryTree();

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 10);
        map.put(3, 5);
        map.put(4, 1);

        int res = naryTree.getSum(map, node0);
        System.out.println(res);
    }
}
