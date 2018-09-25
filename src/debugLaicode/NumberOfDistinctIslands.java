package debugLaicode;

import java.util.*;

public class NumberOfDistinctIslands {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int offsetX = 0;
    int offsetY = 0;

    public int numDistinctIslands(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<List<List<Integer>>> islands = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<List<Integer>> points = new ArrayList<>();
                    offsetX = i;
                    offsetY = j;
                    dfs(i, j, grid, visited, points);
                    islands.add(points);
                    //System.out.println(points);
                }
            }
        }
        return islands.size();
    }

    private void dfs(int x, int y, int[][] grid, boolean[][] visited, List<List<Integer>> points) {
        // base-case
        if (visited[x][y]) return;

        // recurisive rule
        visited[x][y] = true;

        List<Integer> point = new ArrayList<>();
        point.add(x - offsetX);
        point.add(y - offsetY);
        points.add(point);

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && grid[newX][newY] == 1) {
                dfs(newX, newY, grid, visited, points);
            }
        }
    }
}
