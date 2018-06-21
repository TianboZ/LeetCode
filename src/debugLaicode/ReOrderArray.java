package debugLaicode;

public class ReOrderArray {
    public int[] reorder(int[] array) {
        // Write your solution here.
        if (array.length % 2 == 0) {
            helper(array, 0, array.length - 1);
        } else {
            helper(array, 0, array.length - 2);
        }
        for (int i : array) {
            System.out.println(i);
        }
        return array;
    }

    private void helper(int[] arr, int left, int right) {
        // base-case
        if (left >= right) {
            return;
        }

        // recursive rule
        int size = right - left + 1;
        int mid = left + size / 2;
        int leftMid = left + size / 4;
        int rightMid = left + size * 3 / 4;

        // i love yahoo trick
        reverse(arr, leftMid, mid - 1);
        reverse(arr, mid, rightMid - 1);
        reverse(arr, leftMid, rightMid - 1);

        helper(arr, left, mid - 1);
        helper(arr, mid, right);
    }

    private void reverse(int[] arr, int left, int right) {
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
