package debugLaicode;

public class StringReplace {
    public String replace(String input, String s, String t) {
        // Write your solution here
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == s.charAt(0)) {
                // first character matches
                int j = i;
                int k = 0;
                // we want to know if the rest of string still matches
                while (j < input.length() && k < s.length()) {
                    if (input.charAt(j) != s.charAt(k)) {
                        break;
                    }
                    j++;
                    k++;
                }
                if (k == s.length()) {
                    // found the sub-string that needs to be replaced
                    sb.append(t);
                    i = j - 1;
                } else {
                    // only some characters match
                    sb.append(input.charAt(i));
                }
            } else {
                // first character does not match, then just append
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }
}
