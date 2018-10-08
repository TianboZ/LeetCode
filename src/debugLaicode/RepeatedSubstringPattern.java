package debugLaicode;

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        for (int len = 1; len <= s.length() / 2; len++) {
            if (s.length() % len != 0) continue;
            String prev = "";
            boolean found = true;
            for (int i = 0; i < s.length(); i = i + len) {
                if (prev == "") {
                    prev = s.substring(i, i + len);
                } else {

                    if (!prev.equals(s.substring(i, i + len))) {
                        found = false;
                        break;
                    }
                }
            }
            if (found) return true;
        }
        return false;
    }
}
// time o(n^2)