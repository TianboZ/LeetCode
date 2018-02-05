package debugLaicode;

import java.util.Arrays;

public class RemoveSpace {
    public static void main(String[] args) {
        RemoveSpace removeSpace = new RemoveSpace();
        String res = removeSpace.removeSpaces(" i  love   yahoo   ");
        System.out.println(res);
    }
    public String removeSpaces(String input) {
        // Write your solution here.
        int slow = 1;
        int fast = 1;
        // [0, slow) is retained
        // [slow, fast] is ignored
        // (fast, input.length() - 1] is unknown
        input = input.trim();
        char[] arr = input.toCharArray();
        while (fast < arr.length) {
            if (arr[fast] != ' ') {
                arr[slow] = arr[fast];
                slow++;
                fast++;
            } else {
                int lessFast = fast;
                while (fast + 1 < arr.length && arr[fast + 1] == arr[fast]) {
                    fast++;
                }
                // case1: only one space, then keep that
                if (fast == lessFast) {
                    arr[slow] = arr[fast];
                    slow++;
                    fast++;
                }
                // case2: multiple spaces, then keep only first space
                else {
                    arr[slow] = arr[lessFast];
                    slow++;
                    fast++;
                }
            }

        }
        //if (arr.length == 0) {
        //    return new String("");
        //} else {
            return new String(Arrays.copyOf(arr, slow));
        //}
    }
}
