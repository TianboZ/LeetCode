package debugLaicode;


/*

[0, slow) : keep
[slow, fast] : not keep
[fast, end]: unknow area

*/
public class RemoveDuplicatesFromSoretedArrays2 {
    public int removeDuplicates(int[] nums) {
        int slow = 2;
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}