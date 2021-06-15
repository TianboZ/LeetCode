package MianJing.tiktok;

public class PathInMatrix {
    StringBuilder sb = new StringBuilder();
    public void printPath(int[][] m) {
        dfs(m, 0, 0);
    }
    private void dfs(int[][] m, int i, int j) {
        // base case
        if (i == m.length - 1 && j == m[0].length - 1) {
            int len = sb.length();
            sb.append(m[i][j]);
            System.out.println(sb.toString());
            sb.setLength(len);
            return;
        }
        // recursive rule
        int len = sb.length();
        sb.append(m[i][j]).append("->");
        if (i + 1 < m.length) {
            dfs(m, i + 1, j);
        }

        if (j + 1 < m[0].length) {
            dfs(m, i, j + 1);
        }
        sb.setLength(len);
    }

    public static void main(String[] args) {
        int[][] m  = {
                {1,2,3},
                {4,5,6},
                {10,20,30}
        };

        PathInMatrix sol = new PathInMatrix();
        sol.printPath(m);
    }
}
