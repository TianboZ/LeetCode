package debugLaicode;

import java.util.HashSet;
import java.util.Set;


/*
*
* assumption:
*
* solution:
* two pointers, slow and fast, divide array into 3 areas
* [0, slow): retain
* [slow, fast): ignore
* [fast, size - 1]: explore
*
* if arr[fast] should be removed, arr[slow] = arr[fast], slow++ fast++
* else fast++
*
* data structure:
* given string, convert to char array for in-place operation
*
* complexity:
* time o(n)
* space o(n)
*
* */
public class RemoveCertainCharacters {
    public String remove(String input, String t) {
        // Write your solution here
        Set<Character> set = buildSet(t);
        char[] arr = input.toCharArray(); // char array, in-place operation
        int slow = 0; // [0, slow): keep
        int fast = 0; // [fast, end]: to explore     [slow, fast): removed

        while (fast < arr.length) {
            char c = input.charAt(fast);
            if (set.contains(c)) {
                fast++;
            } else {
                arr[slow] = arr[fast];
                slow++;
                fast++;
            }
        }

        return new String(arr, 0, slow);
    }

    // make look up operation efficient
    private Set<Character> buildSet(String t) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        return set;
    }
//    public String remove(String input, String t) {
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < t.length(); i++) {
//            set.add(t.charAt(i));
//        }
//        char[] arr = input.toCharArray();
//        int slow = 0; // [0, slow): keep
//        int fast = 0; // [fast, end]: to explore      [slow, fast): remove
//        for (fast = 0; fast < input.length(); fast++) {
//            if (set.contains(input.charAt(fast))) {
//                continue;
//            } else {
//                arr[slow] = arr[fast];
//                slow++;
//            }
//        }
//        // convert char[] back to string
//        return new String(arr, 0, slow);
//    }
    // time o(n)
    // space o(n)
}
