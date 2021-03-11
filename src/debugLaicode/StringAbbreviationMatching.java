package debugLaicode;

public class StringAbbreviationMatching {
    // pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.

    // iterative
    public boolean match(String input, String pattern) {
        // Write your solution here
        int i = 0; // input index
        int j = 0; // pattern index

        while (i < input.length() && j < pattern.length()) {
            if (Character.isLetter(pattern.charAt(j))) {
                if (pattern.charAt(j) != input.charAt(i)) {
                    return false;
                } else {
                    i++;
                    j++;
                }
            } else {
                int k = j;
                int num = 0;
                while (k < pattern.length() && Character.isDigit(pattern.charAt(k))) {
                    num = 10 * num + pattern.charAt(k) - '0';
                    k++;
                }
                j = k;
                i = i + num;
            }
        }

        return i == input.length() && j == pattern.length();
    }

    // recursive
    // compare input and pattern from i and j index, if rest is matched, return true, otherwise return false
    public boolean match1(String input, String pattern, int i, int j) {
        // base-case
        if (i == input.length() && j == pattern.length()) {
            return true;
        }
        if (i >= input.length() || j >= pattern.length()) {
            return false;
        }
        // recursive rule
        if (pattern.charAt(j) >= 'a' &&  pattern.charAt(j) <= 'z') {
            if (pattern.charAt(j) != input.charAt(i)) {
                return false;
            } else {
                return match1(input, pattern, i + 1, j + 1);
            }
        } else {
            int curr = j;
            while (curr < pattern.length() && pattern.charAt(curr) >= '0' && pattern.charAt(curr) <= '9') {
                curr++;
            }
            int num = Integer.parseInt(pattern.substring(j, curr));
            return match1(input, pattern, i + num, curr);
        }
    }
    public static void main(String[] args) {
        StringAbbreviationMatching stringAbbreviationMatching = new StringAbbreviationMatching();
        boolean res = stringAbbreviationMatching.match1("sophisticated", "s11d", 0, 0);
        System.out.println(res);
    }
}
