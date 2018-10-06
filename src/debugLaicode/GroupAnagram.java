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
    // each string can be represents as Map<key: char, value: frequency> map, then we can get map.hashcode()
    // use another Map<key: hashcode, value: set of strings> to store
    // time O(mn) n = # of strings, m = each string length
    // space o(mn)
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int code = hashCode(s);
            List<String> set = map.get(code);
            if (set == null) {
                set = new ArrayList<>();
                map.put(code, set);
            }
            set.add(s);
        }
        List<List<String>> res = new ArrayList<>(map.values());
        return res;
    }
    private int hashCode(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = map.get(s.charAt(i));
            if (count == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), count + 1);
            }
        }
        return map.hashCode();
    }
}