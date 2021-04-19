package debugLaicode;

import java.util.HashSet;
import java.util.Set;

public class SubarraySumToTarget {

    public boolean sumToTarget2(int[] array, int target) {
        // Write your solution here
        Set<Integer> ps = new HashSet<>();  // prefix sum, from 0-th to i-th element
        ps.add(0);

        int sum = 0;

        for (int e : array) {
            sum += e; // current sum
            if (ps.contains(sum - target)) return true;
            ps.add(sum);
        }
        return false;
    }

    public boolean sumToTarget(int[] array, int target) {
        // Write your solution here.
        if (array == null || array.length == 0) {
            return false;
        }
        int[] ps = new int[array.length];
        ps[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            ps[i] = ps[i - 1] + array[i];
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (ps[i] - ps[j] + array[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
