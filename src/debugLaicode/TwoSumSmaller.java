package debugLaicode;

import java.util.Arrays;

public class TwoSumSmaller {
    public int smallerPairs(int[] array, int target) {
        // Write your solution here
        // sanity check
        // todo

        int lo = 0; int hi = array.length - 1;

        Arrays.sort(array);
        int count  = 0;

        while (lo < hi) {
            if (array[lo] + array[hi] >= target) {
                hi--;
            } else {
                count = count + hi - lo;
                lo++;
            }
        }

        return count;

    }
}
