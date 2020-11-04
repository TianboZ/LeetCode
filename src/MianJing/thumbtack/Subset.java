package MianJing.thumbtack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subset {
//    public static void main(String args[]) {
//        Map<String, String> map = new HashMap<>();
//        map.put("Name", "Peter");
//        map.put("Age", "27");
//        map.put("Gender", "M");
//
//        List<Map<String, String>> path = new ArrayList<>();
//        List<String> keys = new ArrayList<>(map.keySet());
//        List<List<Map<String, String>>> res = new ArrayList<>();
//
//
//        subset(path, 0, keys, res, map);
//        System.out.println(res);
//        System.out.println(res.size());
//    }
//
//    private static void subset(List<Map<String, String>> path,
//                            int index,
//                            List<String> keys,
//                            List<List<Map<String, String>>> res,
//                            Map<String, String> map) {
//        // base-case
//        if (index == keys.size()) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//
//        // recursive rule
//        // case1, take keys.get(index)
//        Map<String, String> pair = new HashMap<>();
//        pair.put(keys.get(index), map.get(keys.get(index)));
//        path.add(pair);
//        subset(path, index + 1, keys, res, map);
//        path.remove(path.size() - 1);
//
//        // case2, not take keys.get(index)
//        subset(path, index + 1, keys, res, map);
//    }
    ////////////////////////////
    public static void main(String args[]) {
        Map<String, String> map = new HashMap<>();
        map.put("Name", "Peter");
        map.put("Age", "27");
        map.put("Gender", "M");

        List<List<Map<String, String>>> res = new ArrayList<>();
        List<String> keys = new ArrayList<>(map.keySet());
        List<Map<String, String>> path = new ArrayList<>();

        subset(res, keys,0, map, path);
        System.out.println(res);
        System.out.println(res.size());
    }

    private static void subset(List<List<Map<String, String>>> res,
                        List<String> keys,
                        int index,
                        Map<String, String> map,
                        List<Map<String, String>> path) {
        // base-case
        if (index == keys.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        // recursive rule
        // case1:  not take keys.get(index)
        subset(res, keys, index + 1, map, path);

        // case2:  take keys.get(index)
        String key = keys.get(index);
        Map<String, String> entry = new HashMap<>();
        entry.put(key, map.get(key));
        path.add(entry);
        subset(res, keys, index + 1, map, path);
        path.remove(path.size() - 1);
    }
}
