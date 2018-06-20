package debugLaicode;

// “aaaabbbc” is transferred to “aabbc”    keep at most 2 duplicates
public class RemoveAdjacentRepeatedCharacters2 {
    public String deDup(String input) {
        // write your solution here
        if (input == null || input.length() <= 2) {
            return input;
        }
        char[] arr = input.toCharArray();
        int slow = 2;  // [0, slow) : keep    [slow, fast): delete  [fast, end] : to explore

        for (int fast = 2; fast < arr.length; fast++) {
            if (arr[fast] == arr[slow - 2]) {
                continue;
            } else {
                arr[slow] = arr[fast];
                slow++;
            }
        }
        return new String(arr, 0, slow);
    }
}
