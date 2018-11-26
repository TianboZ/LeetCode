package debugLaicode;

import java.util.Arrays;

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        //sanity check
        if (nums == null || nums.length == 0) return 0;

        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum + nums[i] < target) {
                    count = count + k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return count;
    }
}
