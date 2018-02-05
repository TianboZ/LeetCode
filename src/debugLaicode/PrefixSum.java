package debugLaicode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrefixSum {
    boolean helper1(List<Integer> list, int target) {
        int[] prefixSum = new int[list.size()];
        prefixSum[0] = list.get(0);
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + list.get(i);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < prefixSum.length; i++) {
            if (prefixSum[i] == target) {
                return true;
            }
            if (set.contains(target - prefixSum[i])) {
                return true;
            } else {
                set.add(prefixSum[i]);
            }
        }
        return false;
    }
}
