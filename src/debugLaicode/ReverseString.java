package debugLaicode;

public class ReverseString {
    public String reverse(String input) {
        char[] arr = input.toCharArray();
        reverse(arr, 0, arr.length - 1);
        return new String(arr, 0, arr.length);
    }
    private void reverse(char[] arr, int left, int right) {
        // base-case
        if (left >= right) {
            return;
        }
        // recursive rule
        char tmpt = arr[left];
        arr[left] = arr[right];
        arr[right] = tmpt;
        reverse(arr, left + 1, right - 1);
    }
}
