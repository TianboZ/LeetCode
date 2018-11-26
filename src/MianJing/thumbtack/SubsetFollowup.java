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
}
