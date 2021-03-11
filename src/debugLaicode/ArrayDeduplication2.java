package debugLaicode;

import java.util.Arrays;

public class ArrayDeduplication2 {
    public int[] dedup(int[] array) {
        // sanity check
        if (array == null || array.length <= 2) {
            return array;
        }

        int slow = 2; // [0, slow): retain    [slow, fast): ignore   [fast, end]: explore
        int fast = 2;

        while (fast < array.length) {
            if (array[fast] == array[slow - 2]) {
                fast++;
            } else {
                array[slow] = array[fast];
                slow++;
                fast++;
            }
        }

        return Arrays.copyOf(array, slow);
    }
}
