package debugLaicode;

import java.util.*;

/**
 * solution1:
 * 11111abbbb4 -> 1#5,a#1,b#4,4#1
 *
 * solution2:
 *
 *   # --> ##   real splitter
 *   # --> #$   original #
 */

// 2021
class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            StringBuilder tmpt = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == '#') {
                    tmpt.append("#$");
                } else {
                    tmpt.append(c);
                }
            }
            tmpt.append("##"); // delimiter
            sb.append(tmpt.toString());
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();

        int i = 0;
        while (i < s.length()) {
            StringBuilder tmpt = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '#') {
                    if (s.charAt(j + 1) == '#') {
                        // splitter
                        i = j + 2;
                        break;
                    } else {
                        tmpt.append(s.charAt(j));
                        j++;
                    }
                } else {
                    tmpt.append(s.charAt(j));
                }
            }

            res.add(tmpt.toString());
        }

        return res;
    }
}


public class EncodeAndDecodeString {
    public String encode(String s) {
        StringBuilder sb = new StringBuilder();
        // 11111abbbb4 -> 1#5,a#1,b#4,4#1
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            int count = 1;
            while (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) {
                j++;
                count++;
            }
            // j is last index of same character

            sb.append(s.charAt(i));
            sb.append('#');
            sb.append(count);
            sb.append(',');

            i = j; // i skip to last same element's index
        }

        System.out.println(sb.toString());
        return sb.toString();
    }


    public String decode(String s) {
        StringBuilder sb = new StringBuilder();
        // 1#5,a#1,b#4,4#1  ->   11111abbbb4
        for (int i = 0; i < s.length(); i++) {
            int j = i + 2; // first index of digit
            int num = 0;
            while (j < s.length() && Character.isDigit(s.charAt(j))) {
                num = num * 10 + Character.getNumericValue(s.charAt(j));
                j++;
            }
            // j is index of ','
            for (int k = 0; k < num; k++) {
                sb.append(s.charAt(i));
            }
            i = j;
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    private List<String> decode1(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                if (s.charAt(i + 1) == '#') {
                    list.add("[");
                } else {
                    sb.append(s.charAt(i));
                }
                i++;
            } else if (s.charAt(i) == ']') {
                if (s.charAt(i + 1) == '#') {
                    list.add(sb.toString());
                    sb.setLength(0); // clear stringbuilder sb
                    list.add("]");
                } else {
                    sb.append(s.charAt(i));
                }
                i++;
            } else {
                sb.append(s.charAt(i));
            }
        }
        for (String s1 : list) {
            System.out.println(s1);
        }
        return list;
    }


    public static void main(String[] args) {
        EncodeAndDecodeString encodeAndDecodeString = new EncodeAndDecodeString();
        String encoded = encodeAndDecodeString.encode("111111abbbb551");
        //String decoded = encodeAndDecodeString.decode("1#6,a#1,b#4,5#2,1#1,a#0,");
        List<String> res = encodeAndDecodeString.decode1("[#[[#892sldjfl@]]]#");
        //System.out.println(res);
    }
}
