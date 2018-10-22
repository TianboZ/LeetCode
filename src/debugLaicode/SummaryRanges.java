package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int prev = nums[0];

        for (int i  = 0; i < nums.length; i++) {
            int j = i;
            while (j + 1 < nums.length && nums[j] + 1 == nums[j + 1]) {
                j++;
            }
            if (i == j) {

                res.add(nums[i]+"");
            } else {

                res.add(nums[i]+"->"+nums[j]);
            }
            i = j;
        }

        return res;
    }
}
