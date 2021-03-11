package debugLaicode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public List<String> Restore(String ip) {
        // Write your solution here
        List<String>  res = new ArrayList<>();
        List<String> tmpt = new ArrayList<>(); // store '111', '222', ....

        dfs(res, tmpt, 0, ip);
        return res;
    }

    // tmpt: store ip chunks, e.g. ['111', '222']
    private void dfs(List<String> res, List<String> tmpt, int i, String ip) {
        // base case
        if (tmpt.size() == 4) {
            if (i == ip.length()) {
                res.add(format(tmpt));
            }
            return;
        }
        if (i >= ip.length()) return;
        // recursive rule
        for (int len = 1; len <= 3; len++) {
            if (i + len <= ip.length()) {
                String chunk = ip.substring(i, i + len);
                if (isValid(chunk)) {
                    tmpt.add(chunk);
                    dfs( res, tmpt, i + len, ip);
                    tmpt.remove(tmpt.size() - 1);
                }
            }
        }
    }

    private boolean isValid(String s) {
        int num = Integer.parseInt(s);
        if (num == 0 && s.length() != 1) return false;
        if (s.charAt(0) == '0' && num != 0) return false;
        return num >= 0 && num <= 255;
    }

    private String format(List<String> tmpt) {
        StringBuilder sb = new StringBuilder();
        for (String s : tmpt) {
            sb.append(s).append(".");
        }

        sb.deleteCharAt(sb.length() - 1); // remove last .
        return sb.toString();
    }

    public static void main(String[] args) {
        RestoreIpAddresses sol = new RestoreIpAddresses();
        System.out.println(sol.Restore("0000"));
        System.out.println("abc".substring(0, 3));
    }
}
