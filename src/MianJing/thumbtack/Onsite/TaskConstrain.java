package MianJing.thumbtack.Onsite;

import java.util.*;

/*
*
*
*
* */
public class TaskConstrain {
    public boolean canFinish(List<List<Integer>> input) {
        // sanity check
        // TODO: 11/23/18

        System.out.println("graph: " + input);

        Deque<Integer> stack = new LinkedList<>(); // store the topological order nodes

        // key: node  value: state     0: unvisited    1: visiting    2: visited
        Map<Integer, Integer> visited = new HashMap<>();

        // iterate each node, graph can be not connected
        for (int i = 0; i < input.size(); i++) {
            if (hasCycle(i, input, visited, stack)) return false;
        }

        System.out.println("one of topological sort order is ");
        while (!stack.isEmpty()) {
            System.out.println(stack.pollFirst());
        }

        return true;
    }

    private boolean hasCycle(int node, List<List<Integer>> graph, Map<Integer, Integer> visited, Deque<Integer> stack) {
        // base-case
        Integer state = visited.get(node);
        if (state != null) {
            if (state == 2) return  false;
            if (state == 1) return true;
        }

        // recursive rule
        visited.put(node, 1);
        List<Integer> children = graph.get(node);
        for (Integer child : children) {
            if (hasCycle(child, graph, visited, stack)) return true;
        }
        stack.offerFirst(node);
        visited.put(node, 2);
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(1,2,3))); // 0: 1,2,3
        input.add(new ArrayList<>(Arrays.asList(3))); // 1: 3
        input.add(new ArrayList<>(Arrays.asList(3))); // 2: 3
        input.add(new ArrayList<>(Arrays.asList())); // 3: null

        input.add(new ArrayList<>(Arrays.asList())); // 4: null

        TaskConstrain taskConstrain = new TaskConstrain();
        System.out.println(taskConstrain.canFinish(input));
    }
}
