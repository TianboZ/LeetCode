package debugLaicode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {

    /*
    for each string, convert it to original string by change each char
    e.g. bcdd, offset is b - a = 1, so bcdd --> abcc

    HashMap<key: original string: value: set of string>

    */

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String original = convert(s);
            List<String> list = map.get(original);
            if (list == null) {
                list = new ArrayList<>();
                map.put(original, list);
            }
            list.add(s);
        }
        List<List<String>> res = new ArrayList<>(map.values());
        return res;
    }

    private String convert(String s) {
        int shift = s.charAt(0) - 'a';
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            arr[i] = (char)(s.charAt(i) - shift);
            if (s.charAt(i) - shift < 'a') {
                arr[i] = (char)(s.charAt(i) - shift + 26);
            } else {
                arr[i] = (char)(s.charAt(i) - shift);
            }
        }
        return new String(arr);
    }
}
// time o(mn)  m = strings.length   n = each string length
// space o(mn)