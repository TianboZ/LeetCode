package MianJing;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Google2019InterOA {
    public int[] solutions(int[] stores, int[] houses) {
        if (stores == null || houses == null) return stores;
        if (stores.length == 0 || houses.length == 0) return stores;

        Set<Integer> storeLocs = new TreeSet<>();
        for (Integer storeLoc : stores) {
            storeLocs.add(storeLoc);
        }

        List<Integer> res = new ArrayList<>();
        for (int houseLoc: houses) {
            Integer smallestLargerOrEqual = ((TreeSet<Integer>) storeLocs).ceiling(houseLoc);
            Integer largestSmallerOrEqual = ((TreeSet<Integer>) storeLocs).floor(houseLoc);
            if (smallestLargerOrEqual != null && largestSmallerOrEqual != null) {
                if (Math.abs(smallestLargerOrEqual - houseLoc) <= Math.abs(largestSmallerOrEqual - houseLoc)) {
                    res.add(smallestLargerOrEqual);
                } else {
                    res.add(largestSmallerOrEqual);
                }
            } else if (smallestLargerOrEqual == null && largestSmallerOrEqual == null){
                res.add(Integer.MAX_VALUE);
            } else if (smallestLargerOrEqual != null){
                res.add(smallestLargerOrEqual);
            } else {
                res.add(largestSmallerOrEqual);
            }
        }
        // final solution
        int[] sol = new int[houses.length];
        int i = 0;
        for (Integer e : res) {
            sol[i] = e;
            i++;
        }
        return sol;
    }
}