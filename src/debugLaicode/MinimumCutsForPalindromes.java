package debugLaicode;

public class MinimumCutsForPalindromes {
    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        // step1:
        int n = s.length();

        boolean[][] isP = new boolean[n][n]; // substring (i, j) is palindrome or not

        // base-case
        // palindrome length is 1
        for (int i =0; i < n; i++) {
            isP[i][i] = true;
        }

        // palindrome length = 2
        for (int i = 0; i < n - 1; i++) {
            isP[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }

        // inductive rule
        // palindrome length >= 3
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && isP[i + 1][j - 1]) {
                    isP[i][j] = true;
                } else {
                    isP[i][j] = false;
                }
            }
        }

        // step2:
        int[] dp = new int[n];
        // dp[i] represents min cuts needed to get palindrome from 0 to i index

        // inductive rule
        for (int i = 0; i < n; i++) {
            if (isP[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (isP[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }

        }
        return dp[n - 1];
    }
}
