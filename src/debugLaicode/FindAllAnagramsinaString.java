package debugLaicode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < p.length(); i++) {
            if (map.containsKey(p.charAt(i))) {
                map.put(p.charAt(i), map.get(p.charAt(i)) + 1);
            } else {
                map.put(p.charAt(i), 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length() - p.length(); i++) {

            //
            /*for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                int value = entry.getValue();
                System.out.println("value=" + value);
            }*/
            //

            if (isValid(i, s, p, map)) {
                System.out.println("aaa");
                result.add(i);
                //System.out.println(i);
            }
        }
        return result;
    }
    public boolean isValid(int i, String s, String p, Map<Character, Integer> map) {
        Map<Character, Integer> map2 = new HashMap<Character, Integer>(map);
        int length = p.length();
        for (int j = i; j < i + length; j++) {
            if (map2.containsKey(s.charAt(j))) {
                map2.put(s.charAt(j), map2.get(s.charAt(j)) - 1);
            } else {
                return false;
            }
        }

        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            int value = entry.getValue();
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}


