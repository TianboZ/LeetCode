package debugLaicode;

public class ProductofArrayExceptSelf {
    public static void test() {
        int[] nums = {1,2,3,4};
        // since need O(n), create two arrays in advance
        // result[i] = a1[i] * a2[i]
        // a1[1, 1*a1, 1*a1*a2, 1*a1*a2*a3]
        // a2[a2*a3*a4*1 , 1*a4*a3, 1*a4 ,1]
        int[] a1 = new int[nums.length];
        int[] a2 = new int[nums.length];

        a1[0] = 1;
        int product = 1;
        for (int i = 1; i < nums.length; i++) {
            product = product * nums[i-1];
            a1[i] = product;
        }
        for (int i : a1) {
            System.out.println(i);
        }
        //
        a2[nums.length-1] = 1;
        product = 1;
        for (int i = 1; i < nums.length; i++) {
            product = product * nums[nums.length - i];
            a2[nums.length-(i+1)] = product;
        }
        for (int i : a2) {
            System.out.println(i);
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = a1[i] * a2[i];
        }
        for (int i : res) {
            System.out.println(i);
        }
    }
}
