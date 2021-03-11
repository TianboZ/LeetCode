package debugLaicode;

public class ClosestInSortedArray {
    public int closest(int[] array, int target) {
        // Write your solution here
        // sanity check
        int lo = 0;
        int hi = array.length - 1;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] == target) return mid;
            if (array[mid] < target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        // post process, two elements left
        return Math.abs(array[lo] - target) < Math.abs(array[hi] - target) ? lo : hi;
    }
}
