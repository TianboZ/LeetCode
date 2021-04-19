package debugLaicode;
import java.util.*;

//33

/*
*               /\ \\\\\\
*              1  2 .... 9
*              /\\\\
*             10 11 .... 19
*            /\\\\\
*           101...
*
* */
public class LexicographicalNumbers {
    private StringBuilder sb = new StringBuilder();
    List<Integer> res = new ArrayList<>();
    int max;
    int len;

    public List<Integer> lexicalOrder(int n) {
        max = n;
        len = (max + "").length();
        dfs();

        System.out.println(res);
        return res;
    }
    private void dfs() {
        // base case
        if (sb.length() == len) return;

        // recursive rule
        for (int i = 0; i <= 9; i++) {
            if (sb.length() == 0 && i == 0) continue;
            sb.append(i);
            int val = Integer.parseInt(sb.toString());
            if (val <= max) {
                res.add(val);
            }
            dfs();
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LexicographicalNumbers sol = new LexicographicalNumbers();
        sol.lexicalOrder(13);
    }
}
