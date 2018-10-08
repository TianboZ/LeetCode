package debugLaicode;

import java.util.*;

public class GroupAnagram {
    // sol1: naive
    // time O(nmlogm)   n = strs.length()     m = each string length
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            String key = s;
            char[] chars = key.toCharArray();
            Arrays.sort(chars);
            key = new String(chars);
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(key, list);
            } else {
                map.get(key).add(s);
                //map.put(key, list);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    // sol2:
    // time O(nm)   n = strs.length()     m = each string length
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        // key: string     value: list of  e.g. a3b2c4
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            // key: char  value: frequency
            Map<Character, Integer> string = new HashMap<>();

            StringBuilder sb = new StringBuilder();
            // count each string char frequency
            for (int i = 0; i < s.length(); i++) {
                Integer count = string.get(s.charAt(i));
                if (count == null) {
                    string.put(s.charAt(i), 1);
                } else {
                    string.put(s.charAt(i), count + 1);
                }
            }
            for (int i = 0; i <= 25; i++) {
                char c = (char)('a' + i);
                Integer count = string.get(c);
                if (count != null) {
                    sb.append(c).append(count);
                }
            }
            String str = sb.toString();

            List<String> list = map.get(str);
            if (list == null) {
                list = new ArrayList<>();
                map.put(str, list);
            }
            list.add(s);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}