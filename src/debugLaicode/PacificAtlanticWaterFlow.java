package debugLaicode;

import java.util.*;


/*
solution:
this is a graph problem

high level:
- from pacific, run BFS, find all reachable cells
- from altlantic, run BFS, find all reachable cells
- the overlap cells are our solution

use a int[][] to record what cells are both reachable from P and L


*/
public class PacificAtlanticWaterFlow {
    boolean[][] visit;
    int[][] overlap; // overlap[i][j] == 2, means overlap; initial is 0
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int m;
    int n;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        visit = new boolean[m][n];
        overlap = new int[m][n];

        // traverse from P
        for (int i = 0; i < n; i++) {
            dfs(0, i, matrix);
        }
        for (int i = 1 ; i < m; i++) {
            dfs(i, 0, matrix);
        }
        visit = new boolean[m][n];

        // traverse from A
        for (int i = 0; i < n; i++) {
            dfs(m - 1, i, matrix);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, matrix);
        }

        // find overlap cells
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0;  i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (overlap[i][j] == 2) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, int[][] matrix) {
        if(visit[i][j]) return;

        visit[i][j] = true;
        overlap[i][j] += 1;
        for (int k = 0; k < 4; k++) {
            int ii = i + dx[k];
            int jj = j + dy[k];

            boolean inBound = ii >= 0 && jj >= 0 && ii < m && jj < n;
            if (inBound && !visit[ii][jj]
                    && matrix[i][j] <= matrix[ii][jj] ) {
                dfs(ii ,jj, matrix);
            }
        }
    }

    public static void main(String[] args) {
        int[][]  heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        PacificAtlanticWaterFlow p = new PacificAtlanticWaterFlow();
        p.pacificAtlantic(heights);
    }

}
