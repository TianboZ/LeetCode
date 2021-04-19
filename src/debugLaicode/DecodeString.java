package debugLaicode;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<String> str = new Stack<>();
        Stack<Integer> count = new Stack<>();

        StringBuilder res = new StringBuilder();
        int idx = 0;
        int num = 0;

        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                num = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    num = num * 10 + (s.charAt(idx) - '0');
                    idx++;
                }

            } else if (s.charAt(idx) == '[') {
                count.push(num);

                str.push(res.toString());
                res = new StringBuilder();
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder(str.pop());
                int c = count.pop();

                for (int i = 0; i < c; i++) {
                    temp.append(res);
                }

                res = temp;
                idx++;
            } else {
                res.append(s.charAt(idx));
                idx++;
            }
        }
        return res.toString();
    }
}
