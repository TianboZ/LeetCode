package debugLaicode;

public class ReverseString {
    //sol1: iterative
    public String reverse(String input) {
        // sanity check

        int left  = 0;
        int right = input.length() - 1;
        char[] arr = input.toCharArray();
        while (left < right) {
            swap(left, right, arr);
            left++;
            right--;
        }
        return new String(arr);
    }
    private void swap(int i, int j, char[] arr) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // sol2: recursive
    public String reverse1(String input) {
        // sanity check

        char[] arr = input.toCharArray();
        reverse1(arr, 0, input.length() - 1);
        return new String(arr);
    }

    private void reverse1(char[] arr, int left, int right) {
        // basecase
        if (left == right) {
            return;
        }
        //recursive rule
        swap(left, right, arr);
        reverse1(arr, left + 1, right - 1);

    }


//    public String reverse(String input) {
//        char[] arr = input.toCharArray();
//        reverse(arr, 0, arr.length - 1);
//        return new String(arr, 0, arr.length);
//    }
//    private void reverse(char[] arr, int left, int right) {
//        // base-case
//        if (left >= right) {
//            return;
//        }
//        // recursive rule
//        char tmpt = arr[left];
//        arr[left] = arr[right];
//        arr[right] = tmpt;
//        reverse(arr, left + 1, right - 1);
//    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        String s = reverseString.reverse("abcd");
        System.out.println(s);

        String s2 = reverseString.reverse("abcd");
        System.out.println(s2);

        String s3 = new String("abc");
        System.out.println(s3.substring(0, 1));
    }
}
