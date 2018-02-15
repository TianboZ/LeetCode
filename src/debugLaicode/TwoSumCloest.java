package debugLaicode;

import java.util.*;

public class TwoSumCloest {
    public static void main(String[] args) {

        TwoSumCloest twoSumCloest = new TwoSumCloest();
        int[] arr = {1, 4, 7, 13};
        int  target = 7;
        twoSumCloest.closest(arr, target);
    }
    public List<Integer> closest(int[] array, int target) {

        // Write your solution here
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        int min = 1000000;
        int i = 0;
        int j = 0;
        while (left < right) {
            if (Math.abs(array[i] + array[j] - target) < min) {
                min = Math.abs(array[left] + array[right] - target);
                System.out.println("left: " + left + " right: " + right);
                i = left;
                j = right;
            }
            if (array[left] + array[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(array[i]);
        res.add(array[j]);
        return res;
    }
}
