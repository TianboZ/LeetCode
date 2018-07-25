package debugLaicode;

import java.util.HashSet;
import java.util.Set;

public class SmallestNonExistedSubsequenceSum {
    private int max = Integer.MIN_VALUE;
    public int firstMissing(int[] array) {
        // Write your solution here
        Set<Integer> res = new HashSet<>();
        allSum(0, res, array, 0);
        for (int i = 1; i <= max + 1; i++) {
            if (!res.contains(i)) {
                return i;
            }
        }
        return -1;
    }
    private void allSum(int index, Set<Integer> res, int[] array, int sum) {
        // base-case
        if (index == array.length) {
            res.add(sum);
            max = Math.max(max, sum);
            return;
        }
        // recursive rule
        int num = array[index];
        allSum(index + 1, res, array, sum + num);
        allSum(index + 1, res, array, sum);
    }
}
