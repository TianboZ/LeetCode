package debugLaicode;

public class ArrayHopper1 {
    public boolean canJump(int[] array) {
        // Write your solution here
        boolean[] dp = new boolean[array.length];
        // dp[i] represent if it is possible to
        // jump from index 0 to index i

        // base-case
        dp[0] = true;

        // inductive rule
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && array[j] >= (i - j)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[array.length - 1];
    }
}
