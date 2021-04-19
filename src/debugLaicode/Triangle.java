package debugLaicode;

import java.util.*;

// LC120
/*
* solution:

* sol1:
DFS3, find all paths, backtracking
time O(2 ^ n)
space O(n)

n is trangle list length

sol2:
memo + DFS

*
*
* */
public class Triangle {


    Map<String, Integer> map = new HashMap<>(); // key: "level,col"   value: min path sum from key position to bottom
    public int minimumTotal(List<List<Integer>> triangle) {
        return dfs(0, 0, triangle);
    }

    // return min path sum from current position <level, col> to bottom
    private int dfs(int level, int col, List<List<Integer>> tri) {
        // baes case
        String curr = level + "," + col;
        if (map.containsKey(curr)) {
            return map.get(curr);
        }
        if (level == tri.size()) return 0;

        int min = tri.get(level).get(col);
        int path1 = dfs(level + 1, col + 1, tri);
        int path2 = dfs(level + 1, col, tri);
        min += Math.min(path1, path2);

        map.put(curr, min);
        return min;
    }

    // sol1:
    // TLE
    int min  = Integer.MAX_VALUE;

    public int minimumTotal2(List<List<Integer>> triangle) {
        dfs(triangle, 0, 0, 0);
        return min;
    }
    private void dfs(List<List<Integer>> list, int level, int col, int sum) {
        // base case
        if (level == list.size()) {
            min = Math.min(min, sum);
            return;
        }

        // recursive rule
        List<Integer> curr = list.get(level);

        dfs(list, level + 1, col, sum + (curr.get(col)));

        if (col + 1 < curr.size()) {
            dfs(list, level + 1, col + 1, sum + (curr.get(col + 1)));
        }

    }

}
