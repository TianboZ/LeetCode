package debugLaicode;

public class ShorestPalindrome {
    public String shortest(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String rev = sb.toString();

        for (int i = 0; i < s.length(); i++) {
            if (s.substring(0, n - i) == rev.substring(i))
                return rev.substring(0, i) + s;
        }
        return "";
    }
}
