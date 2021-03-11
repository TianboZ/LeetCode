package debugLaicode;

import java.util.*;

public class TwoSumCloest {
    public static void main(String[] args) {

        TwoSumCloest twoSumCloest = new TwoSumCloest();
        int[] arr = {1, 4, 7, 13};
        int  target = 7;
        twoSumCloest.closest(arr, target);
    }
    public List<Integer> closest(int[] array, int target) {

        // Write your solution here
        Arrays.sort(array);
        int[] res = new int[2];

        int lo = 0;
        int hi = array.length - 1;
        int diff = Integer.MAX_VALUE;

        while (lo < hi) {
            int sum = array[lo] + array[hi];
            if (sum < target) {
                if (target - sum < diff) {
                    diff = target - sum;
                    res[0] = array[lo];
                    res[1] = array[hi];
                }
                lo++;
            } else if (sum > target) {
                if (sum - target < diff) {
                    diff = sum - target;
                    res[0] = array[lo];
                    res[1] = array[hi];
                }
                hi--;
            } else {
                res[0] = array[lo];
                res[1] = array[hi];
                break;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(res[0]);
        list.add(res[1]);
        return list;
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // write your code here
        List<List<Integer>> range = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                // first element
                if (nums[i] != lower) {
                    range.add(Arrays.asList(lower, nums[i] - 1));
                }
            } else if (i == nums.length - 1) {
                // last element
                if (nums[i] < upper) {
                    range.add(Arrays.asList(nums[i] + 1, upper));
                }
            } else {
                if(nums[i] - nums[i - 1] > 1) {
                    range.add(Arrays.asList(nums[i - 1] + 1, nums[i] - 1));
                }
            }
        }

        return processRes(range);

    }

    private List<String> processRes(List<List<Integer>> range) {
        List<String> res = new ArrayList<>();

        for (List<Integer> list : range) {
            if (list.get(0) == list.get(1)) {
                res.add(String.valueOf(list.get(0)));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(list.get(0)));
                sb.append("->");
                sb.append(String.valueOf(list.get(1)));
            }
        }
        return res;
    }
}
