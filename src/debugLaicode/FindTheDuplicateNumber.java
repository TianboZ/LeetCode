package debugLaicode;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }

            if (nums[i] != i + 1 && nums[i] == nums[nums[i] - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
