package MianJing.thumbtack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Site1 {
    public void markDeadSite(int[][] input, boolean[] dead) {
        int n = input.length;
        Set<Integer> visited = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, input, dead, visited, path);

        System.out.println("dead nodes: " +  deadNodes);
    }

    Set<Integer> deadNodes = new HashSet<>();

    // time O(br ^ V)      br = branch factor    V = number of vertex
    // space O(V)
    private void dfs(int node, int[][] input, boolean[] dead, Set<Integer> visited, List<Integer> path) {
        // base-case
        if (visited.contains(node)) return;

        // current node dead
        if (dead[node]) {
            for (Integer i : path) {
                deadNodes.add(i);
            }
            return;
        }

        // current node is the last one on the path
        if (input[node].length == 0) {
            path.add(node);
            System.out.println(path);
            path.remove(path.size() - 1);
            return;
        }
        // recursive rule
        visited.add(node);
        path.add(node);

        int[] children = input[node];

        for (int i = 0; i < children.length; i++) {
            int child = children[i];
            dfs(child, input, dead, visited, path);
        }

        visited.remove(node);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int[][] input = {{1,2}, {3}, {3,4}, {}, {3,0}};
        boolean[] dead = {false, false,false,false,true};

        Site1 site1 = new Site1();
        site1.markDeadSite(input, dead);
    }
}
