package MianJing.tiktok;

import java.util.ArrayList;
import java.util.List;

public class LongestPathInMatrix {
    boolean[][] visit;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    static int max = 1;
    List<Integer> path = new ArrayList<>();

    public int longest(int[][] m) {
        visit = new boolean[m.length][m[0].length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                dfs(m, i, j, 1, true);
                dfs(m, i, j, 1, false);
            }
        }
        return max;
    }

    private void dfs(int[][] m, int i, int j, int len, boolean needLarger) {
        if (visit[i][j]) return;

        visit[i][j] = true;
        max = Math.max(len, max);
        path.add(m[i][j]);
        System.out.println(path);

        for (int k = 0; k < 4; k++) {
            int ii = i + dx[k];
            int jj = j + dy[k];
            boolean isInBound = ii >= 0 && jj >= 0 && ii < m.length && jj < m[0].length;
            if (isInBound && !visit[ii][jj]) {
                if (needLarger && m[ii][jj] > m[i][j]) {
                    dfs(m, ii, jj, len + 1, false);
                } else if (!needLarger &&  m[ii][jj] < m[i][j]){
                    dfs(m, ii, jj, len + 1, true);
                }
            }
        }
        visit[i][j] = false;
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        LongestPathInMatrix sol = new LongestPathInMatrix();
        int[][] m = {{3,4,5}, {3,2,6}, {1,2,1}};

        sol.longest(m);
        System.out.println(max);
    }
}
