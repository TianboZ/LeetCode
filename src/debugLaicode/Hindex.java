package debugLaicode;

import java.util.HashMap;
import java.util.Map;

public class Hindex {
    public int hIndex(int[] citations) {
        // largestSmaller max number
        // Map<at least -> max, # of elements>
        // iterate map
        // check k, v
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : citations) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int atLeast = min; atLeast <= max; atLeast++ ) {
            for (int j : citations) {
                if (j >= atLeast) {
                    if (!map.containsKey(atLeast)) {
                        map.put(atLeast, 1);
                    } else {
                        map.put(atLeast, map.get(atLeast) + 1);
                    }
                }
            }
        }
        max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("key: "+entry.getKey() + "value: "+entry.getValue());
            if (entry.getKey() == entry.getValue()) {
                System.out.println(entry.getKey());
                System.out.println("aaa");
                max = Math.max(max, entry.getKey());
            }
        }
        return max;
    }
}
