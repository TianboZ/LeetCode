package debugLaicode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumAllPair2 {
    public List<List<Integer>> allPairs(int[] array, int target) {
        Arrays.sort(array);
        List<List<Integer>> res = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            // only skip all the smaller duplicates!
            while (left > 0 && array[left] == array[left - 1]) {
                left++;
            }

            if (left < right) {
                if (array[left] + array[right] == target) {
                    res.add(Arrays.asList(array[left], array[right]));
                    left++;
                    right--;
                } else if (array[left] + array[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
