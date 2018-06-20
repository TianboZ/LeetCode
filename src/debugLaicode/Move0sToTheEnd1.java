package debugLaicode;

// 两个pointer相向而行
public class Move0sToTheEnd1 {
    public int[] moveZero(int[] array) {
        // Write your solution here.
        int left = 0;  // [0, left) : not 0    (right, end] : 0
        int right = array.length - 1;
        while (left <= right) {
            if (array[left] != 0) {
                left++;
            }
            else if (array[right] == 0) {
                right--;
            } else {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return array;
    }
    public void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
