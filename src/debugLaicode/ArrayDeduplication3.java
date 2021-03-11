package debugLaicode;

import java.util.Arrays;

// delete all duplicates
public class ArrayDeduplication3 {
    public int[] dedup(int[] array) {
        // sanity check
        if (array == null || array.length == 0) {
            return array;
        }
        int slow = 0;
        int fast = 0;
        // [0, slow) : retain
        // [slow, fast): ignore
        // [fast, end] : explore
        while (fast < array.length) {
            int fast2 = fast;
            while (fast2 < array.length && array[fast] == array[fast2]) {
                fast2++;
            }
            fast2--;
            if (fast2 == fast) {
                // no duplicate for array[fast]
                array[slow] = array[fast];
                slow++;
                fast++;
            } else {
                fast = fast2 + 1;
            }
        }
        return Arrays.copyOf(array, slow);
    }
}
