package debugLaicode;

import java.util.HashMap;
import java.util.Map;

public class PartitionEqualSubsetSum {
    Map<String, Boolean> map = new HashMap<>();
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum = sum + i;
        }
        if (sum % 2 != 0) {
            return false;
        } else {
            return dfs(nums, 0,  sum / 2);
        }
    }

    private boolean dfs(int[] arr, int i,  int target) {
        // base-case
        if (target == 0) {
            return true;
        }

        if (target < 0 )return false;

        if (i == arr.length) {
            return false;
        }

        if (map.get(i+","+target) != null) return map.get(i+","+target);

        // recursive rule
        int num = arr[i];

        if (dfs(arr, i + 1, target - num)) {
            map.put(i + "," + target, true);
            return true;
        }
        if (dfs(arr, i + 1, target)) {
            map.put(i + "," + target, true);
            return true;
        }

        map.put(i + "," + target, false);
        return false;
    }
}
