package debugLaicode;

public class ReOrder {
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

    public void helper(int[] arr, int left, int right) {
        // base-case
        if (left >= right) {
            return;
        }

        // recursive rule
        int index12 = left + (right - left) / 2;
        int index14 = left + (right - left) / 4;
        int index34 = left + (right - left) * 3 / 4;

        // reverse words
        reverse(arr, index14 + 1, index12);
        reverse(arr, index12 + 1, index34);

        // reverse sentences
        reverse(arr, index14 + 1, index34);

        helper(arr, left, index12);
        helper(arr, index12 + 1, right);

    }

    public void reverse(int[] arr, int left, int right) {
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
