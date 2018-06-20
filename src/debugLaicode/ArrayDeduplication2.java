package debugLaicode;

import java.util.Arrays;

public class ArrayDeduplication2 {
    public int[] dedup(int[] array) {
        if (array.length <= 2) {
            return array;
        }
        int slow = 2;
        for (int fast = 2; fast < array.length; fast++) {
            if (array[fast] == array[slow - 2]) {
                continue;
            } else {
                array[slow]= array[fast];
                slow++;
            }
        }
        return Arrays.copyOf(array, slow);
    }
}
