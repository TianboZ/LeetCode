package debugLaicode;

/*
* sol:
*
* find the largest smaller element than target, if there are multiple ones, then find
* the last one
*
* */

public class SearchInsertPosition {
    public int searchInsert(int[] input, int target) {
        // sanity check
        if (input == null || input.length == 0) return -1;

        int lo = 0;
        int hi = input.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (input[mid] == target) {
                hi = mid;
            } else if (input[mid] < target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        // post process
        if (input[hi] < target) return hi + 1;
        if (input[lo] < target) return lo + 1;

        return 0;
    }
}
