package debugLaicode;

import java.util.*;

public class TwoSumAllPair2 {
    // sol2
    // time o(n)
    // space o(n)
    public List<List<Integer>> allPairs1(int[] array, int target) {
        // Write your solution here

        Set<List<Integer>> set = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>(); // key: number, value: indices
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target  - array[i])) {
                for (Integer j : map.get(target - array[i])) {
                    List<Integer> tmpt = Arrays.asList(array[i], array[j]);
                    Collections.sort(tmpt);
                    set.add(tmpt);
                }
            }

            // add current element to map
            List<Integer> list = map.get(array[i]);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(array[i], list);
        }

        List<List<Integer>> res = new ArrayList<>(set);

        return res;
    }

    // sol1

    // time o(n logn)
    // space o(n)
    public List<List<Integer>> allPairs(int[] array, int target) {
        Arrays.sort(array);
        List<List<Integer>> res = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            // ignore all consecutive duplicate values when want to determine smaller
            // element of pair
            if (left > 0 && array[left - 1] == array[left]) {
                left++;
                continue;
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

    public static void main(String[] args) {
        TwoSumAllPair2 sol = new TwoSumAllPair2();
        System.out.println(sol.allPairs( new int[]{2, 1, 3, 2, 4, 3, 4, 2}, 6));
    }
}
