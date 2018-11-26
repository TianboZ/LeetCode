package debugLaicode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
solution:
find the largest smaller element than x, its index is i
then index i and index i + 1 is two cloest elements index to target x

move these two cloeset index pointer, find the k cloeset elements

time O(logn + k)
space O(k)
*/
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // find the cloest element first, binary search
        // sanity check
        // todo

        int left = binarySearch(arr, x);
        int right = left + 1;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (left >= 0 && right < arr.length) {
                if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                    res.add(arr[left]);
                    left--;
                } else {
                    res.add(arr[right]);
                    right++;
                }
            } else if (left < 0 && right < arr.length) {
                res.add(arr[right]);
                right++;
            } else if (right >= arr.length && left >= 0) {
                res.add(arr[left]);
                left--;
            }
        }
        Collections.sort(res);
        return res;
    }
    // find the largest smaller or equal element than x
    private int binarySearch(int[] arr, int x) {

        // return index of it
        int left = 0;
        int right = arr.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (arr[right] <= x) {
            return right;
        }
        if (arr[left] <= x) {
            return left;
        }
        return -1; // does not exsit
    }
}
