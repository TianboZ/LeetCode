package MianJing.thumbtack;


import java.util.*;

public class SubsetFollowup {
    public static void main(String args[]) {
        Map<String, List<String>> map = new HashMap<>();

        List<String> browsers = new ArrayList<>(Arrays.asList("FireFox", "Chrome", "ie"));
        List<String> systems = new ArrayList<>(Arrays.asList("OSX", "Windows"));
        //List<String> types = new ArrayList<>(Arrays.asList("Mobile", "Laptop"));

        map.put("browsers", browsers);
        map.put("systems", systems);
        //map.put("types", types);

        // my solution 1
        List<Map<String, String>> path = new ArrayList<>(); // path information
        List<List<Map<String, String>>> res = new ArrayList<>(); // result
        List<String> keys = new ArrayList<>(map.keySet());

        subset(map, keys, 0, path, res);

        System.out.println(res);

        // other solution
        List<Map<String, String>> result = findSubset(map);
        System.out.println(result.size());

    }

    // my solution 1
    private static void subset(Map<String, List<String>> map, List<String> keys, int index,
                               List<Map<String, String>> path,
                               List<List<Map<String, String>>> res) {
        // base-case
        if (index == keys.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        // recursive rule
        // case1, use keys.get(index)
        List<String> values = map.get(keys.get(index));
        for (String value : values) {
            Map<String, String> pair  = new HashMap<>();
            pair.put(keys.get(index), value);
            path.add(pair);
            subset(map, keys, index + 1, path, res);
            path.remove(path.size() - 1);
        }

        // case1, not use keys.get(index)
        subset(map, keys, index + 1, path, res);
    }

    // other solution
    private static List<Map<String, String>> findSubset(Map<String, List<String>> map) {
        //把输入的map的key和value拆开，分别装在2个lists里面，他们的index是一一对应的
        List<String> keyList = new ArrayList<>();
        List<List<String>> valueList = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            keyList.add(key);
            valueList.add(value);
        }
        List<Map<String, String>> result = new ArrayList<>();
        dfs2(keyList, valueList, 0, new HashMap<>(), result);
        return result;
    }

    private static void dfs2(List<String> keyList, List<List<String>> valueList, int index,
                             Map<String, String> current, List<Map<String, String>> result) {
        result.add(new HashMap<>(current));
        for (int i = index; i < keyList.size(); i++) {
            for (int j = 0; j < valueList.get(i).size(); j++) {
                current.put(keyList.get(i), valueList.get(i).get(j));
                dfs2(keyList, valueList, i + 1, current, result);
                current.remove(keyList.get(i));
            }
        }
    }
}
