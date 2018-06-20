package debugLaicode;

public class RemoveAdjacentRepeatedCharacters1 {
    // “aaaabbbc” is transferred to “abc”
    public String deDup(String input) {
        // write your solution here
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] arr = input.toCharArray();
        int slow = 1;  // [0, slow) : keep    [slow, fast): delete  [fast, end] : to explore

        for (int fast = 1; fast < arr.length; fast++) {
            if (arr[fast] == arr[slow - 1]) {
                continue;
            } else {
                arr[slow] = arr[fast];
                slow++;
            }
        }
        return new String(arr, 0, slow);
    }

    public static void main(String[] args) {
        RemoveAdjacentRepeatedCharacters1 removeAdjacentRepeatedCharacters1 = new RemoveAdjacentRepeatedCharacters1();
        String res = removeAdjacentRepeatedCharacters1.deDup("aaaaa");
        System.out.println(res);
    }
}
