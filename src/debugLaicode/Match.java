package debugLaicode;

public class Match {
    public boolean match(String input, String pattern) {
        // Write your solution here.
        return helper(input, pattern, 0, 0);
    }
    public boolean helper(String input, String pattern, int i, int j) {
        // base case
        if (i == input.length() && j == pattern.length()) {
            return true;
        }
        if (i >= input.length() || j >= pattern.length()) {
            return false;
        }


        // recursive rule
        // case1
        if (pattern.charAt(j) >= '0' && pattern.charAt(j) <= '9') {
            int m = j;
            while (m < pattern.length() - 1 && pattern.charAt(m + 1) >= '0' && pattern.charAt(m + 1) <= '9') {
                m++;
            }
            int number = Integer.parseInt(pattern.substring(j, m + 1));
            int len = input.length() - i;
            if (len < number) {
                return false;
            }
            return helper(input, pattern, i + number, m + 1);

        }
        // case2
        else {
            if (pattern.charAt(j) != input.charAt(i)) {
                return false;
            } else {
                return helper(input, pattern, i + 1, j + 1);
            }
        }
    }
}
