package debugLaicode;

import java.util.*;

public class TwoSumAllPair1 {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // sanity check
        if (array == null || array.length == 0) return res;

        Map<Integer, List<Integer>> map = new HashMap<>(); // key: array[i]   value: list of all possible indices

        for (int i = 0; i < array.length; i++) {
            int num = target - array[i];
            if (map.containsKey(num)) {
                List<Integer> indices = map.get(num);
                List<Integer> list = new ArrayList<>();
                for (Integer j : indices) {
                    res.add(Arrays.asList(i, j));
                }
                res.add(list);
            }


            if (!map.containsKey(array[i])) {
                map.put(array[i], new ArrayList<>());
            }
            map.get(array[i]).add(i);
        }

        return res;
    }



//    public List<List<Integer>> allPairs(int[] array, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        // Key: number   value: path of index that array[index] == number
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < array.length; i++) {
//            // if target - array[i] is in the map, we can get all the pair (j, i), with i as larger index
//            List<Integer> index = map.get(target - array[i]);
//            if (index != null) {
//                for (Integer j : index) {
//                    res.add(Arrays.asList(j, i));
//                }
//            }
//
//            // add index i to map where key is array[i]
//            if (!map.containsKey(array[i])) {
//                map.put(array[i], new ArrayList<>());
//            }
//            map.get(array[i]).add(i);
//        }
//        return res;
//    }
}
