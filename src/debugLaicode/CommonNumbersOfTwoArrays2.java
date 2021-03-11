package debugLaicode;

import practice.MaxHeap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonNumbersOfTwoArrays2 {
    public List<Integer> common(int[] A, int[] B) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>();  // key : element value: frequency
        Map<Integer, Integer> map2 = new HashMap<>();
        countFreq(A, map1);
        countFreq(B, map2);

        for (Map.Entry<Integer, Integer> e : map1.entrySet()) {
            int n = e.getKey();
            if (map2.containsKey(n)) {
                int count = Math.min(e.getValue(), map2.get(n));
                for (int i = 0; i < count; i++) {
                    res.add(n);
                }
            }
        }
        return res;
    }
    private void countFreq(int[] arr, Map<Integer, Integer> map) {
        for (int e : arr) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
    }
}
