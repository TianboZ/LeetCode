package debugLaicode;

import java.util.HashMap;
import java.util.Map;

public class FourSum2 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // key: sum  value: frequency
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        sumPair(map1, A, B);
        sumPair(map2, C, D);
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int target = 0 - entry.getKey();
            if (map2.containsKey(target)) {
                count = count + entry.getValue() * map2.get(target);
            }
        }
        return count;
    }

    private void sumPair(Map<Integer, Integer> map, int[] a, int[] b) {
        for (int i : a) {
            for (int j : b) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }
    }
}
