package debugLaicode;

import java.util.Arrays;

// retain only one duplicate
public class ArrayDeduplication1 {
    public int[] dedup(int[] array) {
        // sanity check
        if (array == null || array.length == 0) {
            return array;
        }

        int slow = 1; // [0, slow): retain    [slow, fast): ignore   [fast, end]: explore
        int fast = 1;

        while (fast < array.length) {
            if (array[fast] == array[slow - 1]) {
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
