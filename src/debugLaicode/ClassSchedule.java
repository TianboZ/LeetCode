package debugLaicode;

import java.util.*;

public class ClassSchedule {
    public static void main(String[] args) {
        ClassSchedule classSchedule = new ClassSchedule();
        int[][] prerequisites = {{0, 1}};
        classSchedule.canFinish(2, prerequisites);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (map.containsKey(prerequisites[i][1])) {
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                List<Integer> nei = new ArrayList<>();
                nei.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], nei);
            }
        }

        Map<Integer, Integer> visit = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
//        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
//            visit.put(entry.getKey(), null);
//        }

        System.out.println(map);
        System.out.println(visit);

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.println("node: " + entry.getKey());
            if (!dfs(map, visit, stack, entry.getKey())) {
                return false;
            }

        }

        return true;
    }
    public boolean dfs(Map<Integer, List<Integer>> map, Map<Integer, Integer> visit, Stack<Integer> stack, int node) {
        // base-case
        // 0: visited
        // 1: visiting, means detect cycle!

        System.out.println("dfs, visit: " + visit);

        if (visit.containsKey(node)) {
            if (visit.get(node) == 0) {
                return true;
            }
            if (visit.get(node) == 1) {
                return false;
            }
        }

        // recursive rule
        visit.put(node, 1);
        if (map.containsKey(node)) {
            for (Integer nei: map.get(node)) {
                if (dfs(map, visit, stack, nei)) {
                    return false;
                }
            }
        }

        stack.push(node);
        visit.put(node, 0);
        return true;
    }

}