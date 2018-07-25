package debugLaicode;

public class LongestCommonSubstirngSubsequence {
    public int longestCommonSubsequence(String s, String t) {
        // Write your solution here.
        if (s == null || s.length() == 0) return 0;
        if (t == null || t.length() == 0) return 0;

        int[][] dp = new int[1 + s.length()][1 + t.length()];
        // dp[i][j] represents length of longest
        // subsequence within first i letters in s
        // and j letters in t

        // inductive rule
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }

            }
        }
        return dp[s.length()][t.length()];
    }

    public void print(int i,int j, String A, String  B) {
        System.out.println("A: " + A.substring(0, i + 1));
        System.out.println("B: " + B.substring(0, j + 1));
    }

    public String longestCommonSubstring(String s, String t) {
        // Write your solution here.
        //dp[i][j] represens length of longest substring within first i letters in s
        //and j letters in t, includes index i - 1 and j - 1 elements in two strings
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        String res = "";
        int max = 0;

        // baes-case
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= t.length(); i++) {
            dp[0][i] = 0;
        }

        // inductive rule
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    res = s.substring(i - dp[i][j], i);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LongestCommonSubstirngSubsequence longestCommonSubstirngSubsequence = new LongestCommonSubstirngSubsequence();
        String commonSubstring = longestCommonSubstirngSubsequence.longestCommonSubstring("ababcab","bdfe");
        System.out.println(commonSubstring);

        longestCommonSubstirngSubsequence.longestCommonSubsequence("abccd","ab");
    }

}
