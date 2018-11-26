package debugLaicode;

import java.util.HashMap;
import java.util.Map;

public class LongestPathForest {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 0, 2, 3, 6, -1};
        LongestPathForest longestPathForest = new LongestPathForest();
        longestPathForest.getLongestDepth(arr);
        System.out.println(longestPathForest.globalMax);
    }
    int globalMax = -1;
    public int getLongestDepth(int[] roots) {
        // sanity check

        // key: node   value: longest depth starting from this node
        Map<Integer, Integer> cache = new HashMap<>();

        for (int i = 0; i < roots.length; i++) {
            globalMax = Math.max(globalMax, getLongestDepth(i, roots, cache));
        }
        return globalMax;
    }
    // mark visited 2
    private int getLongestDepth(int i, int[] roots, Map<Integer, Integer> cache) {
        // base-case
        if (i == -1) return 0; // it is root

        Integer num = cache.get(i);
        if (num != null && num == 0) throw new IllegalStateException("cycle!");
        if (num != null && num != 0) return num; // visited

        // recursive rule
        cache.put(i, 0); // visiting

        int longest = 1 + getLongestDepth(roots[i], roots, cache);
        cache.put(i, longest);  // mark visited⇒ memo
        return longest;
    }

}
