package debugLaicode;

import java.util.*;

public class PacificAtlanticWaterFlow {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }

        int n = matrix.length, m = matrix[0].length;

        //One visited map for each ocean
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        // from Vertical border traverse
        for(int i = 0; i < n; i++){
            bfs(matrix, pacific, i, 0);
            bfs(matrix, atlantic, i, m - 1);

            // dfs
//            dfs(matrix, pacific, i, 0);
//            dfs(matrix, atlantic, i, m - 1);
        }

        // from Horizontal border traverse
        for(int i = 0; i < m; i++){
            bfs(matrix, pacific, 0, i);
            bfs(matrix, atlantic, n - 1, i);

            // dfs
//            dfs(matrix, pacific, 0, i);
//            dfs(matrix, atlantic, n - 1, i);
        }

        // find the cordinates that belongs to both pacifc and atlantic
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(pacific[i][j] && atlantic[i][j])
                    res.add(new int[]{i,j});
            }
        }

        return res;
    }

    // start from the given point, find all connected points that value is larger of equal than
    // current point value, follow the BFS order
    private void bfs(int[][]matrix, boolean[][] visited, int x, int y) {
        if (visited[x][y]) return;
        Queue<Cell> q = new LinkedList<>();
        // initial
        q.offer(new Cell(x, y));
        visited[x][y] = true;

        // terminate condition
        while (!q.isEmpty()) {
            // expand
            Cell curr = q.poll();

            // generate
            for (int i = 0; i < 4; i++) {
                int newX = curr.x + dx[i];
                int newY = curr.y + dy[i];
                if (newX >= 0 && newY >= 0 && newX < visited.length && newY < visited[0].length && matrix[newX][newY] >= matrix[curr.x][curr.y] && !visited[newX][newY]) {
                    q.offer(new Cell(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }
    class Cell {
        int x;
        int y;
        Cell (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    // start from the given point, find all connected points that value is larger of equal than
    // current point value, follow the DFS order
    public void dfs(int[][]matrix, boolean[][] visited, int x, int y) {
        // base-case
        if (visited[x][y]) return;

        // recursive rule
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newY >= 0 && newX < visited.length && newY < visited[0].length && matrix[newX][newY] >= matrix[x][y]) {
                dfs(matrix, visited, newX, newY);
            }
        }
    }
}
