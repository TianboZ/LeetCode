package debugLaicode;

import java.util.Arrays;

public class ABCequalsD {
    public boolean exist(int[] array) {
        // Write your solution here.
        Arrays.sort(array); // o(n log n)
        for (int i = 0; i < array.length; i++) {
            if (sumThree(array, array[i], i)) {
                return true;
            }
        }
        // total time: o(n log n + n ^ 3)
        // space : o(n)  used for the mergesort
        return false;
    }

    // index a can not be used
    // sumThree: o(n ^ 2)
    private boolean sumThree(int[] array, int target, int a) {
        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            if (i == a) {
                continue;
            }
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                if (left == a) {
                    left++;
                    continue;
                }
                if (right == a) {
                    right--;
                    continue;
                }
                int tmp = array[left] + array[right];
                if (tmp + array[i] == target) {
                    return true;
                } else if (tmp + array[i] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }
}
