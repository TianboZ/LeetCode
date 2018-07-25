package debugLaicode;


public class EditDistence {
    public int editDistance(String one, String two) {
        // Write your solution here.
        if (one.length() == 0 || two.length() == 0) {
            return Math.max(one.length(), two.length());
        }

        int[][] dp = new int[one.length() + 1][two.length() + 1];
        // dp[i][j] represent min operations to transfer first i letters in s1 to first j letters in s2

        // inductive rule
        for (int i = 0; i <= one.length(); i++) {
            for (int j = 0; j <= two.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int case1 = dp[i - 1][j] + 1;
                    int case2 = dp[i][j - 1] + 1;
                    int case3 = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(case1, case2);
                    dp[i][j] = Math.min(case3, dp[i][j]);
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        EditDistence editDistence = new EditDistence();
        int res = editDistence.editDistance("abcd","bcdeee");
        System.out.println(res);
    }
}
