package debugLaicode;

public class ArrayHopper2 {
    public int minJump(int[] array) {
        // Write your solution here.
        int[] dp = new int[array.length];
        // opt[i] represents that the min jumps needed
        // from 0-th to i-th index

        // base-case
        dp[0] = 0;

        // initial
        for (int i = 1; i < array.length; i++) {
            dp[i] = -1;
        }

        // inductive rule
        for (int i = 1; i < array.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (dp[j] != -1 && array[j] >= (i - j)) {
                    min = Math.min(min, dp[j]);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min + 1;
        }

        // solution
        return dp[dp.length - 1];
    }
}
