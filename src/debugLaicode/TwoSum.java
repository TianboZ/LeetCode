package debugLaicode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;



/*
*
* sol1:
* assumptions:
* optimise time complexity
*
* solution:
* iterate each number, for each iteration
*       use hashset to record element that we traversed
*       1. if hashset already contains target - arr[i], which means we find the solution, return
*       2. add current element to hashset
*
*
* complexity:
* time o(n)
* space o(n)
*
*
* sol2:
* assumptions:
*
*
* solution:
* - sort
* - two pointers, left and right points to arr[0] and arr[end]. compare arr[left] + arr[right] and target
*       if sum < target, left++
*       if sum > target, right--
*       if sum == target, return
*
*
*
* complexity:
* space o(n)
* time o(nlogn)
*
* */
public class TwoSum {
    public boolean existSum(int[] array, int target) {
        // Write your solution here.
        // use hashset to record the previous traversed values
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (set.contains(target - num)) {
                return true;
            }
            set.add(num);
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
}
