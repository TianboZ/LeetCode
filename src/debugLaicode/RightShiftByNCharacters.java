package debugLaicode;

public class RightShiftByNCharacters {
    public String rightShift(String input, int n) {
        // Write your solution here
        // sanity check
        if (input == null || input.length() == 0) {
            return input;
        }

        int shift = n % input.length();
        char[] arr = input.toCharArray();
        reverse(arr, 0, arr.length - 1 - shift);
        reverse(arr, arr.length  - shift, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
        return new String(arr);

    }
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char tmpt = arr[left];
            arr[left] = arr[right];
            arr[right] = tmpt;
            left++;
            right--;
        }
    }
}
