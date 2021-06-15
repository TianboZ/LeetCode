package debugLaicode;

public class SquaresofASortedArray {
    public int[] sortedSquares(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        int[] res = new int[nums.length];
        int i = res.length - 1;

        while (lo <= hi) {
            if (Math.abs(nums[lo]) >= Math.abs(nums[hi])) {
                res[i] = nums[lo] * nums[lo];
                lo++;
            } else {
                res[i] = nums[hi] * nums[hi];
                hi--;
            }
            i--;
        }

        return res;
    }
}
