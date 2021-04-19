package MianJing.ixl.onsite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
