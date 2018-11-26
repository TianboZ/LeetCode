package debugLaicode;

public class ImplementStrstr {
    public int strStr(String haystack, String needle) {
        // snaity check
        if (haystack == null || needle == null || haystack.length() < needle.length()) return -1;
        return haystack.indexOf(needle);
    }
}
