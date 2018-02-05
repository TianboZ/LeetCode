package debugLaicode;

public class LongestCommonSubstirngSequence {
    public int longestCommonSubsequence(String A, String B) {
        if (A == null || A.length() == 0) return 0;
        if (B == null || B.length() == 0) return 0;
        int lenA = A.length();
        int lenB = B.length();
        // dp[i][j] represents length of longest subsequence within first i letters in s and j letters in t
        // do not need to end with index i - 1 and j - 1
        int[][] dp = new int[1 + lenA][1 + lenB];

        // inductive rule
        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }

            }
        }
        return dp[lenA][lenB];
    }
    public void print(int i,int j, String A, String  B) {
        System.out.println("A: " + A.substring(0, i + 1));
        System.out.println("B: " + B.substring(0, j + 1));
    }

    public String longestCommonSubstring(String s, String t) {
        // Write your solution here.
        // dp[i][j] represens length of longest substring within first i letters in s and j letters in t,
        // ends with index i - 1 and j - 1 in two strings
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        String res = "";
        int max = -1;
        // baes-case
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < t.length(); i++) {
            dp[0][i] = 0;
        }
        // inductive rule
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = 0;
                }
                if (dp[i + 1][j + 1] > max) {
                    max = dp[i + 1][j + 1];
                    res = s.substring(i - dp[i + 1][j + 1] + 1, i + 1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LongestCommonSubstirngSequence longestCommonSubstirngSequence = new LongestCommonSubstirngSequence();
        String commonSubstring = longestCommonSubstirngSequence.longestCommonSubstring("ababcab","bdfe");
        System.out.println(commonSubstring);

        longestCommonSubstirngSequence.longestCommonSubsequence("abccd","ab");
    }

}
