package debugLaicode;

public class PositiveNegtiveInterleave {
    public static void main(String[] args) {
        PositiveNegtiveInterleave positiveNegtiveInterleave = new PositiveNegtiveInterleave();
        int[] arr = {-1,-1,-1,1,1,1};
        positiveNegtiveInterleave.interleave(arr);
    }
    int firstnegtive;
    public int[] interleave(int[] array) {
        // Write your solution here.
        partition(array);
        int left = 0;
        int right = array.length - 1;
        int i = 1;
        int j = firstnegtive;
        while (i < j && j < array.length && array[j] < 0) {
            swap(array, i, j);
            i = i + 2;
            j++;
        }
        //Helper.printIntArray(array);
        return array;
    }
    // ++++++++++-----
    public void partition(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int i = 0;
        while (left <= right) {
            if (arr[left] > 0) {
                left++;
            } else if (arr[right] < 0) {
                right--;
            } else {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        Helper.printIntArray(arr);
        firstnegtive = left;
        System.out.println("first negative index: " + firstnegtive);
    }
    public void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
