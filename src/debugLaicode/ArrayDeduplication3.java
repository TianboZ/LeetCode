package debugLaicode;

import java.util.Arrays;

// delete all duplicates
public class ArrayDeduplication3 {
    public int[] dedup(int[] array) {
        int slow = 0;
        // [0, slow) : retain
        // [fast, end] : unknow
        for (int fast = 0; fast < array.length; fast++) {
            int tmp = fast;
            while (tmp + 1 < array.length && array[tmp] == array[tmp + 1]) {
                tmp++;
            }
            // tmp is last index that arr[tmp] == arr[fast]
            if (tmp == fast) {
                // no duplicate
                array[slow] = array[fast];
                slow++;
            } else {
                // duplicate
                fast = tmp;
            }
        }
        return Arrays.copyOf(array, slow);
    }
}
