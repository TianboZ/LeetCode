package debugLaicode;

import java.util.*;

// This class represents a directed graph using adjacency
// path representation
public class TopologySort {
    private static class Node {
        int val;
        Set<Node> neighbors;
        Node(int val) {
            this.val = val;
            this.neighbors = new HashSet<>();
        }
    }

    private boolean topologySort(Node node, Deque<Node> stack, Map<Node, Integer> state) {
        // base-case
        if (state.containsKey(node)) {
            if (state.get(node) == 0) return true;
            if (state.get(node) == 1) return false;
        }

        // recursive rule
        state.put(node, 1); // visiting a node
        for (Node nei: node.neighbors) {
            if (!topologySort(nei, stack, state)) return false;
        }
        stack.offerFirst(node);
        state.put(node, 0); // finished visiting a ndoe
        return true;
    }

    // get only one valid topology sort
    public List<Node> tpSort(List<Node> nodes) {
        Deque<Node> stack = new LinkedList<>();
        Map<Node, Integer> state = new HashMap<>();
        for (Node node: nodes) {
            System.out.println("node is " + node.val);
            if (!topologySort(node, stack, state)) {
                System.out.println("cycle detected!");
            }
        }
        List<Node> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        for (Node node : res) {
            System.out.println(node.val);
        }
        return res;
    }

    // get all the valid topology sort
//    public List<List<Node>> tpSort1(List<Node> nodes) {
//
//    }

    public static void main(String[] args) {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node2.neighbors.add(node3);
        node3.neighbors.add(node1);
        node5.neighbors.add(node2);
        node5.neighbors.add(node0);
        node4.neighbors.add(node0);
        node4.neighbors.add(node1);

        List<Node> nodes = new ArrayList<>();
        nodes.add(node0);
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);

        TopologySort topologySort = new TopologySort();
        topologySort.tpSort(nodes);
    }
}
