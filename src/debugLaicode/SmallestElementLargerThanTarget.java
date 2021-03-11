package debugLaicode;

public class SmallestElementLargerThanTarget {
    public int smallestElementLargerThanTarget(int[] array, int target) {
        // Write your solution here
        // sanity check
        if (array == null || array.length == 0) {
            return -1;
        }

        int lo = 0;
        int hi = array.length - 1;

        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2;
            if (array[mid] == target) {
                lo = mid + 1;
            } else if (array[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        // post process
        if (array[lo] > target) {
            return lo;
        }
        if (array[hi] > target) {
            return hi;
        }

        return -1;
    }
}
