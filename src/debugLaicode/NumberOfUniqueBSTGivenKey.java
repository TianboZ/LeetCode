package debugLaicode;

public class NumberOfUniqueBSTGivenKey {
    public int number(int n) {
        int[] dp = new int[n + 1];
        // dp[i] represents use i number, total number unique BST

        // base-case
        dp[0] = 1;

        // inductive rule
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[i] +  dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        NumberOfUniqueBSTGivenKey numberOfUniqueBSTGivenKey = new NumberOfUniqueBSTGivenKey();
        int res = numberOfUniqueBSTGivenKey.number(3);
        System.out.println(res);
    }
}
