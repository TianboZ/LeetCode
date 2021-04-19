package MianJing.ixl.onsite;

import java.util.*;


/*
 *
 * solution:
 *
 * this is topological sort problem, we can use Depth first search to find one valid topological order if graph is DAG
 *
 * steps:
 * - build dependency graph, we can use a Map<id, list of dependency>
 * - sort dependency by their weight
 * - use DFS find one valid topological order if it is DAG. (detect cycle)
 *
 *
 * complexity:
 * two apis:
 * - add()
 * time O(1)
 *
 * - topoSort()
 * time O(n * logn + (V + E)) --> O(nlogn )
 *
 * */

class Task {
    int id;
    int w;
    int[] dep;
    Task(int id, int w, int[] dep) {
        this.id = id;
        this.w = w;
        this.dep = dep;
    }
}
public class TopoSort {
    // fields
    private List<Task> tasks;
    private Map<Integer, Integer> map;  // key: id  value: weight
    private Map<Integer, List<Integer>> graph;  // dependency graph, key: id  value: dependency task ids

    private boolean cycle;
    private Map<Integer, Integer> state;  // key: node  value: node state, 1 represent visiting, 0 represent visited
    private List<Integer> topoOrder = new ArrayList<>();

    // constructor
    public TopoSort() {
        tasks = new ArrayList<>();
        map = new HashMap<>();
        graph = new HashMap<>();
        state = new HashMap<>();
    }

    // APIs
    public void add(Task t) {
        tasks.add(t);
        map.put(t.id, t.w);
    }

    public void sort() {
        // build graph
        buildGraph();
        for (Task t : tasks) {
            dfs(t.id);
        }
        if (!cycle) {
            System.out.println(topoOrder);
        }

    }

    private void dfs(int node) {
        // base case
        Integer i = state.get(node);
        if (i != null) {
            if (i == 1) {
                cycle = true;
                return;
            }
            if (i == 0) return;
        }
        if (cycle) {
            System.out.println("cycle! no topological order");
            return;
        }

        // recursive rule
        state.put(node, 1);
        for (Integer nei : graph.get(node)) {
            dfs(nei);
        }
        state.put(node, 0);
        topoOrder.add(node);
    }

    private void buildGraph() {
        tasks.sort((t1, t2) -> t2.w - t1.w);

        for (Task t : tasks) {
            int id = t.id;
            List<Integer> neis = graph.get(id);
            if (neis == null) {
                neis = new ArrayList<>();
                graph.put(id, neis);
            }

            for (int nei : t.dep) {
                neis.add(nei);
            }

            // sort tasks by weight
            neis.sort((t1, t2) -> map.get(t2) - map.get(t1)); // decreasing order
        }
    }

    public static void main(String[] strs) {
        //  [[1, 5, [2]], [2,  10, []], [3,  20, [1,2]], [4, 0, [2]]]
        Task t3 = new Task(3, 20, new int[]{1, 2});
        Task t4 = new Task(4, 0, new int[]{2});
        Task t1 = new Task(1, 5, new int[]{2});
        Task t2 = new Task(2, 10, new int[]{});


        TopoSort sol = new TopoSort();
        sol.add(t1);
        sol.add(t2);
        sol.add(t3);
        sol.add(t4);

        // add cycle
        Task t5 = new Task(2, 10, new int[]{1});
        sol.add(t5);

        sol.sort();
    }
}
