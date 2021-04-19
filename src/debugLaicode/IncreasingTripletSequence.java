package debugLaicode;

public class IncreasingTripletSequence {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

//        int n = nums.length;
//        //  dp[i] represents as from index somewhere to index i, max LIS
//        int[] dp = new int[n];
//
//        // base-case
//        dp[0] = 1;
//
//        // inductive rule
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i]) {
//                    dp[i] = Math.max(dp[j] + 1, dp[i]);
//                    if (dp[i] == 3) return true;
//                }
//            }
//        }
//
//        return false;
        int num1 = Integer.MAX_VALUE; // smallest
        int num2 = Integer.MAX_VALUE; // 2nd smallest
        int num3 = Integer.MAX_VALUE; // 3rd smallest
        for (int n : nums) {
            if (n <= num1) {
                num1 = n;
            } else if (n <= num2) {
                num2 = n;
            } else {
                // now n > num2 > num1
                return true;
            }
        }
        return false;
    }
}
