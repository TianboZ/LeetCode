package debugLaicode;

import java.util.HashSet;
import java.util.Set;

public class RemoveCertainCharacters {
    public String remove(String input, String t) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        char[] arr = input.toCharArray();
        int slow = 0; // [0, slow): keep
        int fast = 0; // [fast, end]: to explore      [slow, fast): remove
        for (fast = 0; fast < input.length(); fast++) {
            if (set.contains(input.charAt(fast))) {
                continue;
            } else {
                arr[slow] = arr[fast];
                slow++;
            }
        }
        // convert char[] back to string
        return new String(arr, 0, slow);
    }
    // time o(n)
    // space o(n)
}
