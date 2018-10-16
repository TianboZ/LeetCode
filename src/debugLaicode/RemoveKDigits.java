package debugLaicode;

public class RemoveKDigits {
    //sol1: dfs
    int min = Integer.MAX_VALUE;
    String res = null;
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) return num;
        StringBuilder sb = new StringBuilder();
        dfs(0, sb, k, num);
        return res;
    }
    private void dfs(int i, StringBuilder sb, int k, String num) {
        // base-case
        if (i == num.length()) {
            if (k == 0 ) {
                if (sb.length() == 0) {
                    min = 0;
                    res = "0";
                } else if(Integer.parseInt(sb.toString()) < min) {
                    min = Integer.parseInt(sb.toString());
                    res = Integer.toString(min);
                }
            }
            return;
        }
        // recursive rule
        char c = num.charAt(i);
        // case1: keep num.charAt(i)
        sb.append(c);
        dfs(i + 1, sb, k, num);
        sb.deleteCharAt(sb.length() - 1);

        // case2: not keep num.charAt(i)
        if (k > 0) {
            dfs(i + 1, sb, k - 1, num);
        }
    }
    // time o(2^n)
    // space o(n)
}
