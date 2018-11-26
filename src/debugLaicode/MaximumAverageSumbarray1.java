package debugLaicode;


/*
solution1:
prefix sum

time O（n）
space O(n)


solution2:
fix size sliding window
time O(n)
space O(1)

*/
public class MaximumAverageSumbarray1 {
    public double findMaxAverage1(int[] nums, int k) {
        int[] ps = new int[nums.length];
        ps[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ps[i] = ps[i - 1] + nums[i];
        }

        double max = -Double.MAX_VALUE;
        System.out.println(max);

        for (int j = 0; j < nums.length; j++) {
            int i = j + 1 - k;
            if (i >= 0) {
                // compute subarray sum[i, j]
                int sum = ps[j] - ps[i] + nums[i];
                max = Math.max(max, sum * 1.0 / k);
            }

        }
        return max;
    }

    public double findMaxAverage(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int fast = 0; fast < k; fast++) {
            sum = sum + nums[fast];
        }
        max = Math.max(max, sum);

        for (int fast = k;  fast < nums.length; fast++) {
            sum = sum + nums[fast];

            int slow = fast - k;
            if (slow >= 0) {
                sum = sum - nums[slow];
            }

            // current window
            max = Math.max(max, sum);
        }
        return max * 1.0 / k;
    }
}
