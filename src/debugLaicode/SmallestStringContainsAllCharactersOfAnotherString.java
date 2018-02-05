package debugLaicode;


import java.util.HashMap;
import java.util.Map;

public class SmallestStringContainsAllCharactersOfAnotherString {
    public static void main(String[] args) {
        SmallestStringContainsAllCharactersOfAnotherString smallestStringContainsAllCharactersOfAnotherString = new SmallestStringContainsAllCharactersOfAnotherString();
        smallestStringContainsAllCharactersOfAnotherString.smallest("The given test strings", "itsst");
    }
    public String smallest(String s1, String s2) {
        // Write your solution here.
        char[] arr = s1.toCharArray();
        Map<Character,Integer> pattern = getPattern(s2);
        Map<Character,Integer> window = new HashMap<>();
        int min = 999;
        int left = 0;
        int[] index = new int[2];
        int match = 0;
        for (int i = 0; i < arr.length; i++) {
            // handle right most character
            if (pattern.containsKey(arr[i])) {
                // e.g.      a : 4  then count == 4 in the pattern
                int count = pattern.get(arr[i]);
                if (window.containsKey(arr[i])) {
                    window.put(arr[i], window.get(arr[i]) + 1);
                    if (window.get(arr[i]) == count) {
                        match++;
                    }
                } else {
                    window.put(arr[i], 1);
                    if (window.get(arr[i]) == count) {
                        match++;
                    }
                }
            }

            // handle left most character, try to minimum the size of the sliding window
            while (match == pattern.size() && left <= i) {
                // update window size
                if (i - left + 1 < min) {
                    min = i - left + 1;
                    index[0] = left;
                    index[1] = i;
                }

                if (window.containsKey(arr[left])) {
                    window.put(arr[left], window.get(arr[left]) - 1);
                    int shouldBe = pattern.get(arr[left]);
                    if (window.get(arr[left]) < shouldBe) {
                        match--;
                        left++;
                        System.out.println(left);
                        break;
                    }
                }
                left++;
            }
        }
        System.out.println(s1.substring(index[0], index[1] + 1));
        return s1.substring(index[0], index[1] + 1);
    }
    public Map<Character,Integer> getPattern(String s) {
        Map<Character ,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        return map;
    }
}
