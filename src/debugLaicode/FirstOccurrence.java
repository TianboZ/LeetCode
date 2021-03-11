package debugLaicode;


/*
*
* 1 2 3 4  4  4 4 6
*       |
* */

public class FirstOccurrence {
    public int firstOccur(int[] array, int target) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        // make sure at least 3 elements can do while loop
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                right = mid; // because of this line, we have to make sure at least 3 elements do while loop, prevent infinite loop
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // post process, there are 2 remaining numbers
        if (array[left] == target) {
            return left;
        }

        if (array[right] == target) {
            return right;
        }

        return -1;
    }
}
