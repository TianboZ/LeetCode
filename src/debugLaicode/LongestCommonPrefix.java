package debugLaicode;

class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) return strs[0];

        String prefix = common(strs[0], strs[1]);
        for (int i = 2; i < strs.length; i++) {
            prefix = common(prefix, strs[i]);
        }
        return prefix;
    }
    private String common(String s1, String s2) {
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                sb.append(s1.charAt(i));
                i++; j++;
            } else {
                break;
            }

        }
        return sb.toString();
    }
    public static void main(String[] strs) {
        LongestCommonPrefix sol = new LongestCommonPrefix();
        String[] input = {"aaa", "aa", "b"};

        sol.longestCommonPrefix(input);
    }
}