package debugLaicode;

public class LongestPalindromeSubsequence {
    public int longest(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];
        // dp[i][j] represnets the length of longest palindrome sub-sequence from i to j index

        // base-case
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 2 : 1;
        }

        // inductive rule
        // check length >= 3
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
