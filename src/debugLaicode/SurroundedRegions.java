package debugLaicode;

import java.util.*;

public class SurroundedRegions {
    int[] dx = {1,-1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public void solve(char[][] board) {
        bfs(board);
        flip(board);
    }

    // find regions that are not surrounded by X, mark them to '1', flip them back later
    private void bfs(char[][] b) {
        Queue<int[]> q = new LinkedList<>();
        int m = b.length;
        int n  = b[0].length;

        for (int col = 0; col < n; col++) {
            if (b[0][col] == 'O') {
                q.offer(new int[]{0, col});
                b[0][col] = '1';

            }
            if (b[m - 1][col] == 'O') {
                q.offer(new int[]{m - 1, col});
                b[m - 1][col] = '1';
            }
        }

        for (int row = 0; row < m; row++) {
            if (b[row][0] == 'O') {
                q.offer(new int[]{row, 0});
                b[row][0] = '1';
            }
            if (b[row][n - 1] == 'O') {
                q.offer(new int[]{row, n - 1});
                b[row][n - 1] = '1';
            }
        }

        while (!q.isEmpty()) {
            int[] curr= q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = curr[0] + dx[k];
                int ny = curr[1] + dy[k];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && b[nx][ny] == 'O') {
                    b[nx][ny] = '1';
                    q.offer(new int[]{nx, ny});
                }
            }
        }

    }

    // flip '1' to  original 'O', flip 'O' to 'X'
    private void flip(char[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                if (b[i][j] == '1')
                    b[i][j] = 'O';
                else if (b[i][j] == 'O')
                    b[i][j] = 'X';
            }
        }
    }
}
