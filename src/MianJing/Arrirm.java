package MianJing;

public class Arrirm {

    public int count(int[] nums) {
        // dp[i][j] represnets the number of increasing sub-sequence of length j that ends at index i
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][1] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i][2] = dp[j][1] + dp[i][2];
                    dp[i][3] = dp[j][2] + dp[i][3];
                }
            }
        }

        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            count = count + dp[i][3];
        }
        System.out.println(count);
        return count;

    }

    public static void main(String[] args) {
        Arrirm arrirm = new Arrirm();
        int[] test = {8,7,1,10,15,5};
        arrirm.count(test);
    }

}
