package debugLaicode;

// eliminate all duplicates
public class RemoveAdjacentRepeatedCharacters3 {
    public String deDup(String input) {

        // Write your solution here
        int slow = 0;
        // [0, slow) : retain
        // [fast, end] : unknow
        char[] arr = input.toCharArray();
        for (int fast = 0; fast < arr.length; fast++) {
            int tmp = fast;
            while (tmp + 1 < arr.length && arr[tmp] == arr[tmp + 1]) {
                tmp++;
            }
            // tmp is last index that arr[tmp] == arr[fast]
            if (tmp == fast) {
                // no duplicate
                arr[slow] = arr[fast];
                slow++;
            } else {
                // duplicate
                fast = tmp;
            }
        }
        return new String(arr, 0, slow);
    }
}
