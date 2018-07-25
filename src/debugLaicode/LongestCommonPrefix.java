package debugLaicode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // Write your solution here
        if (strs.length == 1) {
            return strs[0];
        }
        int i = 0;
        outer:
        while (true) {
            for (int j = 0; j + 1 < strs.length; j++) {
                if (i < strs[j].length() && i < strs[j + 1].length()
                        && strs[j].charAt(i) != strs[j + 1].charAt(i) ) {
                    break outer;
                }
                if (i >= strs[j].length() || i >= strs[j + 1].length()) {
                    break outer;
                }
            }
            i++;
        }
        return strs[0].substring(0, i);
    }
}
