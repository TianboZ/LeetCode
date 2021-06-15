package debugLaicode;

import java.util.TreeSet;

public class Find132Pattern {
    public boolean find132pattern(int[] nums) {
        int len  = nums.length;
        int[] min = new int[len];  // min[i] is the smallest element from [0, i]

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                min[0] = nums[0];
            } else {
                min[i] = Math.min(min[i - 1], nums[i]);
            }
        }

        TreeSet<Integer> set  = new TreeSet<>();

        for (int j = len - 2; j > 0; j--) {
            if (j + 1 < len) {
                set.add(nums[j + 1]);
            }

            if (min[j] < nums[j]) {
                Integer mid = set.lower(nums[j]);
                if ( mid != null && mid > min[j]) return true;
            }
        }

        return false;
    }
}
