package debugLaicode;

public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = null;
        int left = 0, maxLen = 1;

        // dp[i][j] represents whether substring Si, Sj is palindrome
        boolean[][] dp = new boolean[n][n];

        // base-case
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // check for sub-string of length 2.
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (dp[i][i + 1]) {
                maxLen = 2;
            }
        }


        // inductive rule
        // check all length >= 3
        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i < s.length() - len; i++) {
                int j = i + len - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];

                // update max
                if (dp[i][j] && len > maxLen) {
                    maxLen = len;
                    left = i;
                }
            }
        }
        return s.substring(left, left + maxLen);
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring longestPalindromeSubstring = new LongestPalindromeSubstring();
        String res = longestPalindromeSubstring.longestPalindrome( "abcbcbd");
        System.out.println(res);
    }
}
