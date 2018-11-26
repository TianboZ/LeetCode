package debugLaicode;

/*

rainbow sort
[0, i): 0
[i, k): 1
(j, end]: 2

2 pointers, 3 areas

Input: [0, 0, 1, 1, 2, 2]
              i  r

000001111111xxxxxxxx222
     i      k      j

*/
public class SortColor {
    public void sortColors(int[] nums) {
        int i = 0;
        int k = 0;
        int j = nums.length - 1;
        while (k <= j) {
            if (nums[k] == 0) {
                swap(nums, i, k);
                i++;
                k++;
            } else if (nums[k] == 2) {
                swap(nums, k, j);
                j--;
            } else {
                k++;
            }
        }
    }
    private void swap(int[] arr, int i, int j) {
        int tmpt = arr[i];
        arr[i] = arr[j];
        arr[j] = tmpt;
    }
}