package debugLaicode;

/*
[1,        2,       3,       4]
[2*3*4,  1*3*4    1*2*4    1*2*3]

create pre-product array from left and right
pre1[n]: from index 0 to index n, total product
pre2[n]: from index nums.length - 1 to index n, total product

res[i] = pre1[i - 1] * pre2[i + 1]

time o(n)
space o(n)
*/
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        int[] pre1 = new int[nums.length];
        int[] pre2 = new int[nums.length];

        pre1[0] = nums[0];
        pre2[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            pre1[i] = pre1[i - 1] * nums[i];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            pre2[i] = pre2[i + 1] * nums[i];
        }

        int[] res = new int[nums.length];
        res[0] = pre2[1];
        res[nums.length - 1] = pre1[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = pre1[i - 1] * pre2[i + 1];
        }
        return res;
    }
}