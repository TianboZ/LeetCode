package debugLaicode;

public class ReverseShiftByNCharacter {
    public String rightShift(String input, int n) {
        // Write your solution here.
        if (input == null || input.length() == 0) {
            return input;
        }

        n = n % input.length();
        // W1W2 -> W2W1
        char[] arr = input.toCharArray();
        reverse(arr, 0, arr.length - n - 1);
        reverse(arr, arr.length - n, arr.length - 1);
        reverse(arr, 0, arr.length - 1);

        return new String(arr);
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseShiftByNCharacter reverseShiftByNCharacter = new ReverseShiftByNCharacter();
        String res = reverseShiftByNCharacter.rightShift("abcde", 3);
        System.out.println(res);
    }
}
