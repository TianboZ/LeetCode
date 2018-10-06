package debugLaicode;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        // key： char   value: index
        Map<Character, Integer> map = new LinkedHashMap<>();

        // store all unique characters
        Set<Character> set = new HashSet<>();
        // iterate each charcter of string
        // case1, it is first time appear, store it into map and set
        // case2, it is not first time appear, delete it from the map
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                if (map.get(s.charAt(i)) != null) {
                    map.remove(s.charAt(i));
                }
            } else {
                map.put(s.charAt(i), i);
                set.add(s.charAt(i));
            }
        }

        // use iterator to find the first entry in the map
        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
    }
}
