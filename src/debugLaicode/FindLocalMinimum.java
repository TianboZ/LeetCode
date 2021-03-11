package debugLaicode;

/*
*
* assumptions:
* - no duplicates
* - if array is monotonically increasing or decreasing, return smallest
*
* */
public class FindLocalMinimum {

    public int localMinimum(int[] array) {
        // Write your solution here
        int lo = 0;
        int hi = array.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] > array[mid + 1]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return array[lo] < array[hi] ? lo : hi;
    }
}
