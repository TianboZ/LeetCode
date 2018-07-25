package debugLaicode;

public class LongestAscendingSubSequence {
    public int longest(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[] dp = new int[arr.length];
        //dp[i] represents the length of longest ascending sub-sequence that includes index i;

        int max = 1;

        // base-case
        dp[0] = 1;

        // inductive rule
        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestAscendingSubSequence longestAscendingSubSequence = new LongestAscendingSubSequence();
        int res = longestAscendingSubSequence.longest(new int[] {1,2,3,4,2,2,2,4,5});
        System.out.println(res);
    }
}
