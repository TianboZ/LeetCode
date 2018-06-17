package debugLaicode;

import java.util.*;

public class TwoSumAllPair1 {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // Key: number   value: list of index that array[index] == number
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            // if target - array[i] is in the map, we can get all the pair (j, i), with i as larger index
            List<Integer> index = map.get(target - array[i]);
            if (index != null) {
                for (Integer j : index) {
                    res.add(Arrays.asList(j, i));
                }
            }

            // add index i to map where key is array[i]
            if (!map.containsKey(array[i])) {
                map.put(array[i], new ArrayList<>());
            }
            map.get(array[i]).add(i);
        }
        return res;
    }
}
