package debugLaicode;

import java.util.*;

/*
-4  -1  -1  0   1   2
0   1    2  3   4   5
*/


// find all unique three sum pairs
public class ThreeSum {
    // sol1
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        // sanity check
        if (nums == null || nums.length == 0) return res;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) { // deduplicate
                int left = i + 1;
                int right = nums.length - 1;
                int target = 0 - nums[i];
                while (left < right) {
                    int sum =  nums[left] + nums[right];
                    if (sum == target) {

                        while (left + 1 < right && nums[left] == nums[left + 1]) left++;
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                        left++;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}