package debugLaicode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public boolean existSum(int[] array, int target) {
        // Write your solution here.
        // use hashset to record the previous traversed values
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (set.contains(target - num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
    public boolean existSum1(int[] array, int target) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] == target) {
                return true;
            } else if (array[left] + array[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
    // time o(n log n)  space o(log n)  Arrays.sort is using quickSort(unstable sorting) for primitive type
}
