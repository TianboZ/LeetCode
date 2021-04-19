package MianJing.ixl;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeString {

    String DE = "a#a";  // delimiter
    String ORI = "##"; // replace original "#"  to "##"

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            s = s.replace("#", ORI);
            sb.append(s).append(DE);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        String[] arr = s.split(DE, -1);
        for (int i = 0; i < arr.length - 1; i++) {
            // we want to escapge last ""
            res.add(arr[i].replace(ORI, "#"));
        }
        return res;
    }


//    String de = "#!";
//    String ori = "##"; // original "#"
//    // Encodes a list of strings to a single string.
//    public String encode(List<String> strs) {
//        StringBuilder sb = new StringBuilder();
//        for (String s : strs) {
//            s.replace("#", ori);
//            sb.append(de);
//        }
//        return sb.toString();
//    }
//
//    // Decodes a single string to a list of strings.
//    public List<String> decode(String s) {
//        List<String> res = new ArrayList<>();
//
//        int i = 0;
//        char[] chars = s.toCharArray();
//
//        while (i < chars.length) {
//            StringBuilder sb  = new StringBuilder();
//            for (int j = i; j < chars.length; j++) {
//                if (chars[j] != '#') {
//                    sb.append(chars[j]);
//                } else {
//                    if (chars[j + 1] == '#') {
//                        sb.append('#');
//                        j++;
//                    } else {
//                        // meet delimiter
//                        i = j + 2;
//                        break;
//                    }
//                }
//            }
//
//            res.add(sb.toString());
//        }
//        return res;
//    }
}
