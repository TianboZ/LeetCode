package debugLaicode;

import java.util.*;

public class IntersectionOfTwoArrays {
    // sol1: naive
    public int[] intersect(int[] nums1, int[] nums2) {
        // Write your solution here
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }
    // time o(nlogn + mlogm)   space o(m + n)

    // sol2:
    // use hashmap, time o(n + m)  space o(n + m)
    /*
    find the common elements in two arrays
    use map<key: integer, value: frequency> to record each elements in array
    */
    public int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();

        count(map1, nums1);
        count(map2, nums2);

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                int count = Math.min(entry.getValue(), map2.get(entry.getKey()));
                for (int i = 0; i < count; i++) {
                    res.add(entry.getKey());
                }
            }
        }
        int sol[] = new int[res.size()];
        int i = 0;
        for (Integer e : res) {
            sol[i] = e;
            i++;
        }

        return sol;
    }
    private void count(Map<Integer, Integer> map, int[] nums) {
        for (int i : nums) {
            Integer count = map.get(i);
            if (count == null) {
                map.put(i, 1);
            } else {
                map.put(i, 1 + count);
            }
        }
    }
}
