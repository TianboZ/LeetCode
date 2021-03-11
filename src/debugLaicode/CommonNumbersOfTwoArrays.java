package debugLaicode;

import java.util.*;


/*
* assumptions:
* 1. no dup
* 2. size(a) < size(b)
* */
public class CommonNumbersOfTwoArrays {
    public List<Integer> common(int[] a, int[] b) {
        // Write your solution here
        Set<Integer> set = new HashSet<>();
        for (int e: a) {
            set.add(e);
        }

        List<Integer> res = new ArrayList<>();
        for (int e : b) {
            if (set.contains(e)) {
                res.add(e);
            }
        }
        Collections.sort(res);
        return res;
    }
}
