package xiaoban;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {
    private int getHeight(Integer root, Map<Integer, Set<Integer>> map) {
        // base-case
        if (root == null) return 0;

        // recursive rule
        int height = 0;
        if (map.containsKey(root)) {
            for (Integer nei : map.get(root)) {
                height = Math.max(height, getHeight(nei, map));
            }
        }

        return height + 1;
    }

    public static void main(String[] args) {
        /*
        *                0
        *              /
        *            1
        *        /   \    \
        *       3    4     5
        *                   \
        *                    2
        *
        *  longest path length = 3
        *
        * */

        Map<Integer, Set<Integer>> map = new HashMap<>();
        map.put(0, new HashSet<>());
        map.put(1, new HashSet<>());
        map.put(5, new HashSet<>());

        map.get(0).add(1);
        map.get(1).add(3);
        map.get(1).add(4);
        map.get(1).add(5);
        map.get(5).add(2);

        Test test = new Test();
        int res = test.getHeight(0, map);
        System.out.println(res);
    }
}
