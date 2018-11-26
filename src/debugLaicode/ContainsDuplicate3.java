package debugLaicode;

import java.util.TreeSet;

public class ContainsDuplicate3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int fast = 0; fast < nums.length; fast++) {
            // handle right most pointer
            int n = nums[fast];

            Integer larger = set.ceiling(n);
            Integer smaller = set.floor(n);

            if (larger != null && Math.abs(n - larger) <= t) return true;
            if (smaller != null && Math.abs(n - smaller) <= t) return true;

            set.add(n);

            // handle lseft most pointer
            int slow = fast - k;
            if (slow >= 0) {
                set.remove(nums[slow]);
            }
        }



        return false;
    }
}
