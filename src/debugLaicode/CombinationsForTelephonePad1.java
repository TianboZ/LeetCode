package debugLaicode;

import java.util.*;

public class CombinationsForTelephonePad1 {
    Map<Character, String> map;

    public String[] combinations(int number) {
        // Write your solution here
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> list = new ArrayList<>();
        String s = Integer.toString(number);

        dfs(list, s, 0, new StringBuilder());

        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        //System.out.println(list);
        return res;
    }
    private void dfs(List<String> list, String s, int i, StringBuilder sb) {
        // base case
        //System.out.println("i: " + i);
        if (i == s.length()) {
            System.out.println("----");
            list.add(sb.toString());
            return;
        }
        // recursive rule
        char c = s.charAt(i);
        System.out.println(c);
        String str = map.get(c);
        if (str != null) {
            for (int j = 0; j < str.length(); j++) {
                sb.append(str.charAt(j));
                //System.out.println(sb.toString());
                dfs(list, s, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            dfs(list, s, i + 1, sb);
        }
    }

    public static void main(String[] args) {
       CombinationsForTelephonePad1 sol = new CombinationsForTelephonePad1();
        sol.combinations(231);
    }

}
