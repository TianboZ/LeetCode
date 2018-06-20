package debugLaicode;

import java.util.Arrays;

// keep only one duplicate
public class ArrayDeduplication1 {
    public int[] dedup(int[] array) {
        // Write your solution here
        if (array.length <= 1) {
            return array;
        }
        int slow = 1;  // [0, slow) : keep    [slow, fast): delete  [fast, end] : to explore
        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] == array[slow - 1]) {
                continue;
            } else {
                array[slow] = array[fast];
                slow++;
            }
        }
        return Arrays.copyOf(array, slow);
    }
}
