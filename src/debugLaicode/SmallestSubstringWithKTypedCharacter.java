package debugLaicode;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringWithKTypedCharacter {


    public String shortest(String input, int k) {
        // Write your solution here.
        if (input == null || input.length() == 0) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int min = 1000000;
        int index = -1;

        for (int i = 0; i < input.length(); i++) {
            // handle rightmost char
            char tmp = input.charAt(i);
            Integer count = map.get(tmp);
            if (count != null) {
                map.put(tmp, count + 1);
            } else {
                map.put(tmp, 1);
            }

            // handle leftmost char
            while (map.size() == k) {

                // update
                if (i - j + 1  < min) {
                    min = i - j + 1;
                    index = j;
                }

                tmp = input.charAt(j);
                count = map.get(tmp);
                if (count == 1) {
                    map.remove(tmp);
                } else {
                    map.put(tmp, count - 1);
                }
                j++;
            }

        }
        return input.substring(index, min + index);
    }


    public static void main(String[] args) {
        SmallestSubstringWithKTypedCharacter smallestSubstringWithKTypedCharacter = new SmallestSubstringWithKTypedCharacter();
        String res = smallestSubstringWithKTypedCharacter.shortest("aaabbbbbbbccccccccccc",3);
        System.out.println(res);
    }
}
