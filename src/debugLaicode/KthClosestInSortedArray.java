package debugLaicode;

import java.util.Map;
import java.util.TreeMap;

public class KthClosestInSortedArray {
    public int[] kClosest(int[] array, int target, int k) {
        // Write your solution here
        int[] result = new int[k];
        if (k == 0) {
            return result;
        }
        //int index = classicBinarySearch(array, target);

        int left = classicBinarySearch(array, target);
        int right = left + 1;
        for (int i = 0; i < k; i++) {
            if (right >= array.length || (left >= 0
                    && target - array[left] <= array[right] - target)) {
                result[i] = array[left];
                System.out.println(array[left]);
                left--;
            } else {
                result[i] = array[right];
                System.out.println(array[right]);
                right++;
            }
        }



        return result;
    }

    public int classicBinarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid;
            } else if (array[mid] > target) {
                right = mid;
            }
        }


    if (array[left] <= target) {
        //System.out.println("1");

        return left;
    }

    if (array[right] <= target) {
        //System.out.println("2");

        return right;
    }

        System.out.println("not found");
        return -1;
    }
}
