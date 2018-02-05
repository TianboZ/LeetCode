package debugLaicode;

public class CutWood {
    public static void main(String[] args) {
        CutWood cutWood = new CutWood();

        int L = 10;
        int[] A = {2, 4, 7};
        cutWood.minCost(A, L);
    }
    public int minCost(int[] cuts, int length) {
        // Write your solution here.
        int[] m = new int[cuts.length + 2];
        m[0] = 0;
        for (int i = 0; i < cuts.length; i++) {
            m[i + 1] = cuts[i];
        }
        m[m.length - 1] = length;

        // dp[i][j] represents from index i to index j, min cost
        int[][] dp = new int[m.length][m.length];

        // base-case
        for (int i = 0; i < dp.length - 1; i++) {
            dp[i][i + 1] = 0;
        }

        // inductive rule
        for (int size = 2; size < m.length; size++) {
            for (int i = 0; i + size < dp.length; i++) {
                int min = 100;
                for (int k = i + 1; k <= size + i - 1; k++) {
                    if (size == 2) {
                        dp[i][i + 2] = dp[i][k] + dp[k][i + 2] + m[i + 2] - m[i];
                        System.out.println("i: " + i + " j : "+ (i + 2) + "   dp: " + dp[i][i + 2]);
                    } else {
                        min = Math.min(min, dp[i][k] + dp[k][i + size]);
                        dp[i][i + size] = min + m[i + size] - m[i];
                        //System.out.println(dp[i][i + size]);
                        System.out.println("i: " + i + " j : "+ (i + size) + "   dp: " + dp[i][i + size]);
                    }
                }
            }
        }
        System.out.println(dp[0][dp.length - 1]);
        return dp[0][dp.length - 1];
    }
}
