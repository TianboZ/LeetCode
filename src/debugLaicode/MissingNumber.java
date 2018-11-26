package debugLaicode;

/*
soluiton
sum = (a1 + an) * n / 2
*/
public class MissingNumber {
    public int missingNumber(int[] nums) {
        // sanity check
        //todo

        int size = nums.length + 1;
        int sum = (0 + nums.length) * size / 2;
        for (int i : nums) {
            sum = sum - i;
        }
        return sum;
    }
}