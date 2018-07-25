package debugLaicode;

import java.util.*;

public class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int tmp = dfs(matrix, i, j, cache);
                if (max < tmp) {
                    max = tmp;
                }
            }
        }
        return max;
    }

    // largestSmaller the longest increasing path length from (x, y) point
    private int dfs(int[][] matrix, int x, int y, int[][] cache) {
        // base-case
        if (cache[x][y] > 0) {
            return cache[x][y];
        }
        // recursive rule
        // there are 4 branches
        cache[x][y] = 1;
        if (x + 1 < matrix.length && matrix[x + 1][y] > matrix[x][y]) {
            cache[x][y] = Math.max(cache[x][y], 1 + dfs(matrix, x + 1, y, cache));
        }
        if (x - 1 >= 0 && matrix[x - 1][y] > matrix[x][y]) {
            cache[x][y] = Math.max(cache[x][y], 1 + dfs(matrix, x - 1, y, cache));
        }
        if (y + 1 < matrix[0].length && matrix[x][y + 1] > matrix[x][y]) {
            cache[x][y] = Math.max(cache[x][y], 1 + dfs(matrix, x, y + 1, cache));
        }
        if (y - 1 >= 0 && matrix[x][y - 1] > matrix[x][y]) {
            cache[x][y] = Math.max(cache[x][y], 1 + dfs(matrix, x, y - 1, cache));
        }
        return cache[x][y];
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int longestIncreasingPath1(int[][] matrix) {
        // Write your solution here
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] path = new int[matrix.length][matrix[0].length];
        // path[i][j] represents the length of longest path stars from (i, j)

        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(dfs(matrix, i, j, visited, path), max);
            }
        }
        return max;
    }

    // find the length of longest path from
    private int dfs(int[][] m, int i, int j,
                    boolean[][] visited,
                    int[][] path) {
        // base-case
        if (visited[i][j]) {
            return 0;
        }

        if (path[i][j] > 0) {
            return path[i][j];
        }

        // recursive rule
        int max = 1;
        for (int k = 0; k < 4; k++) {
            int newI = dx[k] + i;
            int newJ = dy[k] + j;
            if (newI >= 0 && newJ >= 0 && newI < m.length && newJ < m[0].length && m[i][j] < m[newI][newJ]) {
                visited[i][j] = true;
                max = Math.max(max, dfs(m, newI, newJ, visited, path) + 1);
                visited[i][j] = false;
            }
        }
        path[i][j] = max;
        return max;
    }
}
