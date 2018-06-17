package debugLaicode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumTuple {
    // get all unique tuple
    public List<List<Integer>> allTriples(int[] array, int target) {
        // Write your solution here.
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int tmp = array[left] + array[right];
                if (tmp + array[i] == target) {
                    result.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;
                    right--;
                    while (left < right && array[left] == array[left - 1]) {
                        left++;
                    }

                } else if (tmp + array[i] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
