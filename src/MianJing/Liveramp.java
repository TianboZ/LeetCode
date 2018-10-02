package MianJing;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Liveramp {
    // helper class
    private class Node {
        String val;
        Set<Node> neighbors;
        Node (String s) {
            this.val = s;
            this.neighbors = new HashSet<>();
        }
    }

    // fields
    private Map<String, Node> graph;

    // constructor
    private Liveramp() {
        this.graph = new HashMap<>();
    }

    //API
    public void addLink(String id1, String id2) {
        System.out.println();
        Node node1 = graph.get(id1);
        Node node2 = graph.get(id2);

        if (node1 == null) {
            graph.put(id1, new Node(id1));
        }

        if (node2 == null) {
            graph.put(id2, new Node(id2));
        }

        // now node1 and node2 in the HashMap
        node1 = graph.get(id1);
        node2 = graph.get(id2);

        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
    }
    public boolean isLinked(String id1, String id2) {
        // id1 or id2 is not created yet
        Node node1 = graph.get(id1);
        Node node2 = graph.get(id2);
        if (node1 == null || node2 == null || node1 == node2) return false;

        Set<Node> visited = new HashSet<>();
        return dfs(node1, node2, visited);
    }

    // return true if node and target node is connected
    private boolean dfs(Node node, Node target, Set<Node> visited) {
        // base-case
        if (visited.contains(node)) return false;

        // recursive rule
        visited.add(node);
        if (node == target) return true;
        for (Node nei : node.neighbors) {
            if (dfs(nei, target, visited)) return true;
        }
        return false;
    }
    public void removeID(String id) {
        Node node = graph.get(id);
        // node not even exist
        if (node == null) return;

        // node exist
        //System.out.println(node.val);
        graph.remove(id);
        //printGraph();
        for (Map.Entry<String, Node> entry : graph.entrySet()) {
            entry.getValue().neighbors.remove(node);
        }
    }

    private void printGraph() {
        for (Map.Entry<String, Node> entry : graph.entrySet()) {
            System.out.println("-----------");
            System.out.println(entry.getValue().val);
            System.out.println("neighbors: ");
            for (Node nei : entry.getValue().neighbors) {
                System.out.println(nei.val);
            }
        }
    }

    public static void main(String[] args) {
        Liveramp liveramp = new Liveramp();
        liveramp.addLink("1","2");
        liveramp.addLink("3","4");
        liveramp.addLink("2","3");
        liveramp.addLink("5","6");
        //boolean res = liveramp.isLinked("5","5");
        //System.out.println(res);
        liveramp.removeID("3");
        liveramp.removeID("2");
        System.out.println("----------------------------");
        liveramp.printGraph();
    }
}