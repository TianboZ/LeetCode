package MianJing.thumbtack.Onsite;

import java.util.ArrayList;

import java.util.*;

public class Subset {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "tom");
        map.put("addr", "SF");
        map.put("age", "30");
        //System.out.println(subset(map));

        Map<String, List<String>> map1 = new HashMap<>();
        map1.put("name", Arrays.asList("tom", "jack"));
        map1.put("addr", Arrays.asList("sf", "la", "tx"));
        // should be 3 * 4 = 12 entries

        System.out.println(subset1(map1));
        System.out.println(subset1(map1).size());

    }

    // time O(2 ^n)   n is entries of input map
    // space O(n)    depth of call stack of recursion
    public static List<List<Map<String, String>>> subset(Map<String, String> map) {
        // sanity check
        //todo

        List<String> keys = new ArrayList<>(map.keySet());
        List<List<Map<String, String>>> res = new ArrayList<>();
        List<Map<String, String>> path = new ArrayList<>();

        dfs(res, path, 0, keys, map);
        return res;

    }
    // depth first search
    private static void dfs(List<List<Map<String, String>>> res, List<Map<String, String>> path, int index, List<String> keys, Map<String, String> input) {
        // base-case
        if (index == keys.size()) {
            res.add(new ArrayList<>(path)); // add to result
            return;
        }

        // recursive rule
        // case1: not take keys.get(index)
        dfs(res, path, index + 1, keys, input);


        // case2: take keys.get(index)
        String key = keys.get(index);
        // create new entry
        Map<String, String> entry = new HashMap<>();
        entry.put(key, input.get(key));

        path.add(entry);
        dfs(res, path, index + 1, keys, input);
        path.remove(path.size() - 1); // back tracking
    }

    // follow up
    public static List<List<Map<String, String>>> subset1(Map<String, List<String>> map) {
        // sanity check
        //todo

        List<String> keys = new ArrayList<>(map.keySet());
        List<List<Map<String, String>>> res = new ArrayList<>();
        List<Map<String, String>> path = new ArrayList<>();

        dfs1(res, path, 0, keys, map);
        return res;

    }
    // depth first search
    private static void dfs1(List<List<Map<String, String>>> res, List<Map<String, String>> path, int index,
                             List<String> keys, Map<String, List<String>> input) {
        // base-case
        if (index == keys.size()) {
            res.add(new ArrayList<>(path)); // add to result
            return;
        }

        // recursive rule
        // case1: not take keys.get(index)
        dfs1(res, path, index + 1, keys, input);


        // case2: take keys.get(index)
        String key = keys.get(index);
        // create new entry
        for (String s : input.get(key)) {
            Map<String, String> entry = new HashMap<>();
            entry.put(key, s);

            path.add(entry);
            dfs1(res, path, index + 1, keys, input);
            path.remove(path.size() - 1); // back tracking
        }
    }
}
