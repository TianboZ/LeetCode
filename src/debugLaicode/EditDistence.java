package debugLaicode;


public class EditDistence {
    public static void main(String[] args) {
        EditDistence editDistence = new EditDistence();
        editDistence.editDistance("abcd","bcdeee");
    }
    public int editDistance(String one, String two) {
        // Write your solution here.
        if (one.length() == 0 || two.length() == 0) {
            return Math.max(one.length(), two.length());
        }

        int[][] dp = new int[one.length() + 1][two.length() + 1];

        // initial
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        // inductive rule
        for (int i = 0; i < one.length(); i++) {
            for (int j = 0; j < two.length(); j++) {
                if (one.charAt(i) == two.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    System.out.println("i: " + i + "  j: " + j);
                    // case1 insert
                    int tmp1 = dp[i + 1][j] + 1;
                    // case2 delete
                    int tmp2 = dp[i][j + 1] + 1;
                    // case3 replace
                    int tmp3 = dp[i][j] + 1;

                    dp[i + 1][j + 1] = Math.min(Math.min(tmp1, tmp2), tmp3);
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
