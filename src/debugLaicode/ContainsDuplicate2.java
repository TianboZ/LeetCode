package debugLaicode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
solution1:

map<key: number, value: index of last appear>
for each element, check if it has appeared before and distance to prevous one


time o(n)
space o(n)


*/
public class ContainsDuplicate2 {
    // 2021
    // sliding window


    // 2020
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Write your solution here
        Map<Integer, Integer> map = new HashMap<>(); // key: num  value: index
        for (int i = 0; i< nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                } else {
                    // update index
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) return true;
                // update index
                map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }
        return false;

    }
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int fast = 0; fast < nums.length; fast++) {
            // handle right most pointer
            if (set.contains(nums[fast])) {
                return true;
            } else {
                set.add(nums[fast]);
            }

            // handle lseft most pointer
            int slow = fast - k;
            if (slow >= 0) {
                set.remove(nums[slow]);
            }
        }
        return false;
    }
}