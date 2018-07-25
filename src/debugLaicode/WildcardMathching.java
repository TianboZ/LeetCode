package debugLaicode;

public class WildcardMathching {
    public boolean match(String input, String pattern) {
        // Write your solution here.
        boolean[][] dp = new boolean[input.length() + 1][pattern.length() + 1];

        // base-case
        // empty pattern can match with empty string
        dp[0][0] = true;

        // Only '*' can match with empty string
        for (int j = 1; j <= pattern.length(); j++) {
            if (pattern.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        // inductive rule
        for (int i = 1; i <= input.length(); i++) {
            for (int j = 1; j <= pattern.length(); j++) {
                if (input.charAt(i - 1) == pattern.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (pattern.charAt(j - 1) == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (pattern.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[input.length()][pattern.length()];
    }
}
