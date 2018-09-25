package debugLaicode;

import java.util.*;

public class FindTheCelebrity {
    // sol1: brute force
    public int findCelebrity(int n) {
        // key: people    value: the people he knows
        Map<Integer, Set<Integer>> map = new HashMap<>();
        // for each people, ask if he or she know the rest of people
        for (int i = 0; i < n; i++) {
            for (int j =0; j < n; j++) {
                if (i != j) {
                    if (knows(i, j)) {
                        Set<Integer> set = map.get(i);
                        if (set == null) {
                            set = new HashSet<>();
                            set.add(j);
                            map.put(i, set);
                        } else {
                            set.add(j);
                            map.put(i, set);
                        }
                    }
                }
            }
        }

        // iterate the map, if the number is not in the map, then this number might be the celeberity
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(i)) {
                int count = 0;
                boolean know = true;
                for (Map.Entry<Integer, Set<Integer>> entry: map.entrySet()) {
                    if (entry.getKey() != i) {
                        if (!entry.getValue().contains(i)) know = false;
                    }
                    count++;
                }
                if (know && count == n - 1) return i;
            }
        }
        return -1;
    }

    // dummy API
    private boolean knows(int a, int b) {
        return true;
    }
}
