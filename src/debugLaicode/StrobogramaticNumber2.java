package debugLaicode;


    /*
        use deapth first search to get all solutions
        the digits we can use is 1, 6 ,8, 9, 0(can not be first or last one)

        we just generate n/2 length, then the right part is the upside down part of left, e.g.  left: 169, right: 691      169691

        time o(5^(n/2))   branch factor : 5    deapth of recursion tree: n / 2


        */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*
*       1 6 9 0 0  n = 5
*             3
*           index
*
*       1 5 9 0
*           2
*         index
*
* */

public class StrobogramaticNumber2 {

    public List<String> findStrobogrammatic(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(6, 9);
        map.put(9, 6);
        map.put(0, 0);
        map.put(8, 8);
        List<String> res = new ArrayList<>();
        boolean even = false;
        if (n % 2 == 0) even = true;

        StringBuilder sb = new StringBuilder();
        dfs(res, 0, n , even, sb, map);
        return res;

    }
    private void dfs(List<String> res, int index, int len, boolean even, StringBuilder sb, Map<Integer, Integer> map) {
        // base-case
        if (index == (len + 1) / 2) {

            if (even) {
                String right = findRight(sb, map);
                res.add(sb.toString() + right);
            } else {
                StringBuilder tmpt = new StringBuilder(sb);
                tmpt.deleteCharAt(tmpt.length() - 1);
                String right = findRight(tmpt, map);
                res.add(sb.toString() + right);
            }

            return;
        }
        // recursive rule
        for (Integer i : map.keySet()) {
            if (len > 1 && index == 0 && i == 0) continue;
            if (!even && index == len / 2 && (i == 6 || i == 9)) continue;
            sb.append(i + "");
            dfs(res, index + 1, len, even, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
    private String findRight(StringBuilder sb, Map<Integer, Integer> map) {
        sb.reverse();
        StringBuilder s = new StringBuilder();
        for (int i = 0;i < sb.length(); i++) {
            int digit = map.get(sb.charAt(i) - '0');
            s.append(digit);
        }
        return s.toString();
    }
}