package debugLaicode;

public class AscendingTriple {
    public boolean existIJK(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return false;
        }

        int[] dp = new int[array.length];
        // dp[i] represents length of longest ascending
        // sub-sequence, including i-th element

        // base-case
        dp[0] = 1;

        // inductive rule
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}


