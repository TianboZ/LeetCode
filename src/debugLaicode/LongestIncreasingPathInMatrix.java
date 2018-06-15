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
    public int dfs(int[][] matrix, int x, int y, int[][] cache) {
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
}
