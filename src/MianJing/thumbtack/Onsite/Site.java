package MianJing.thumbtack.Onsite;

import java.util.*;

/*
* clarify:
*   if a site dead, then mark all its ancesstor dead
*
* assumption:
* graph is DAG
*
* if a node dead, then this node do not have children
*
* corner case:
* input is not valid, input is null
*
* solution1:
*
* reverse the graph --> build a node to ancesstor relationship, Map<key: node, value: list of parents>
* iterate each dead node, start to traverse the graph, mark all the reachable nodes as dead
*
* time O  ((V + E))   n is number of dead site, V is vertex, E is edges
* space O(V)
*
* solution2:
* iterate each dead node, keep the tack information. if meet a dead node, stop. So all the nodes on the current path
* should be marked as dead
*
* find all the path from root
*
* time O(br ^ v)    br = branching factor   v = vertex
* space O(v)        depth of recursion
*
* */


public class Site {

    // solution1
    public List<Integer> markDead(int[][] input, boolean[] dead) {
        // sanity check
        // TODO: 11/23/18

        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        buildReverseMap(map, input);

        // iterate each dead node
        for (int i = 0; i < dead.length; i++) {
            if (dead[i]) {
                // if this node dead, start to traverse the graph
                dfs(i, visited, list, map);
            }
        }
        return list;
    }

    // input the dead node, start from it traverse the graph, mark all reachable node is visited
    private void dfs(int node, Set<Integer> visited, List<Integer> list, Map<Integer, List<Integer>> map) {
        // base-case
        if (visited.contains(node)) return;

        // recursive rule
        visited.add(node);
        list.add(node);
        if (map.containsKey(node)) {
            for (Integer parent : map.get(node)) {
                dfs(parent, visited, list, map);
            }
        }

    }
    private void buildReverseMap(Map<Integer, List<Integer>> map, int[][] input) {
        for (int i = 0; i < input.length; i++) {
            int parent = i;
            for (int node : input[i]) {
                List<Integer> parents = map.get(node);
                if (parents == null) {
                    parents = new ArrayList<>();
                    map.put(node, parents);
                }
                parents.add(parent);
            }
        }
    }


    // solution2:
    public List<Integer> markDead2(int[][] input, boolean[] dead) {
        //sanity check
        // TODO: 11/23/18

        List<Integer> roots = new ArrayList<>();
        findAllRoots(roots, input);

        Set<Integer> visited = new HashSet<>();
        List<Integer> path = new ArrayList<>();

        // iterate each root
        for (Integer root : roots) {
            backtracking(root, input, dead, visited, path);
        }
        return new ArrayList<>(set);

    }

    private void findAllRoots(List<Integer> roots, int[][] graph) {
        int n = graph.length;
        Set<Integer> notRoots = new HashSet<>();
        for (int[] arr : graph) {
            for (int i : arr) {
                notRoots.add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!notRoots.contains(i)) roots.add(i);
        }

        System.out.println("all the roots: " + roots);
    }


    Set<Integer> set = new HashSet<>(); // store all the dead node, global variable

    // start to traverse the graph from root node, find all the paths to the dead nodes
    // if node dead, stop traversing
    // keep path information
    private void backtracking(int node, int[][] graph, boolean[] dead, Set<Integer> visited, List<Integer> path) {
        // base-case
        if (visited.contains(node)) return;
        if (dead[node]) {
            path.add(node);

            System.out.println("path : " + path);
            set.addAll(path);
            path.remove(path.size() - 1);
            return;
        }

        // recursive rule
        visited.add(node);
        path.add(node);
        int[] children = graph[node];
        for (int child : children) {
            backtracking(child, graph, dead, visited, path);
        }
        visited.remove(node);
        path.remove(path.size() - 1);
    }



    public static void main(String[] args) {
        int[][] input = {{1,2}, {3}, {3,4}, {}, {3}, {}};
        boolean[] dead = {false, false,false,true,true, true};

        Site site = new Site();
        List<Integer> res = site.markDead(input, dead);
        System.out.println(res);

        res = site.markDead2(input, dead);
        System.out.println(res);

    }
}
