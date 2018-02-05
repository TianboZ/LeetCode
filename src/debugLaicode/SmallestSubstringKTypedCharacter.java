package debugLaicode;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringKTypedCharacter {

    public static void main(String[] args) {
        SmallestSubstringKTypedCharacter smallestSubstringKTypedCharacter = new SmallestSubstringKTypedCharacter();
        smallestSubstringKTypedCharacter.shortest("aaabbbbbbbccccccccccc",3);
    }

    public String shortest(String input, int k) {
        // Write your solution here.
        if (input == null || input.length() == 0) {
            return "";
        }
        char[] arr = input.toCharArray();
        Map<Character,Integer> window = new HashMap<>();
        int min = 999;
        int left = 0;
        int[] index = new int[2];
        int match = 0;
        for (int i = 0; i < arr.length; i++) {
            // handle right most character
            if (window.containsKey(arr[i])) {
                window.put(arr[i], window.get(arr[i]) + 1);
            } else {
                window.put(arr[i], 1);
            }

            // handle left most character, try to minimum the size of the sliding window
            while (k == window.size() && left <= i) {
                // update window size
                if (i - left + 1 < min) {
                    min = i - left + 1;
                    index[0] = left;
                    index[1] = i;
                }

                if (window.containsKey(arr[left])) {
                    window.put(arr[left], window.get(arr[left]) - 1);

                    if (window.get(arr[left]) == 0) {
                        window.remove(arr[left]);
                        match--;
                        left++; // do not forget!!!
                        break;
                    }
                }
                left++;
            }
        }
        System.out.println(input.substring(index[0], index[1] + 1));
        return input.substring(index[0], index[1] + 1);
    }
}
